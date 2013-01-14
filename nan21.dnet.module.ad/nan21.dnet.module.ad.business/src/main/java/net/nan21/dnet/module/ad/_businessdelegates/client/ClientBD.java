package net.nan21.dnet.module.ad._businessdelegates.client;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.ad.client.domain.entity.Client;
import net.nan21.dnet.module.ad.impex.business.service.IImportJobService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

public class ClientBD extends AbstractBusinessDelegate {

	public static final String ROLE_ADMIN = "ROLE_DNET_ADMIN";
	public static final String ROLE_USER = "ROLE_DNET_USER";

	/**
	 * Create a clone of the given import job in the specified client.
	 * 
	 * @param client
	 * @param importJobId
	 * @return the newly created ImportJob
	 * @throws BusinessException
	 */
	public ImportJob createImportJob(Client client, Long importJobId)
			throws BusinessException {

		IImportJobService impJobSrv = (IImportJobService) this
				.findEntityService(ImportJob.class);

		ImportJob sourceJob = impJobSrv.findById(importJobId);
		ImportJob targetJob = new ImportJob();

		targetJob.setActive(true);
		targetJob.setDescription(sourceJob.getDescription());
		targetJob.setName(sourceJob.getName());

		for (ImportJobItem sourceJobItem : sourceJob.getItems()) {

			ImportJobItem targetJobItem = new ImportJobItem();
			targetJobItem.setJob(targetJob);
			targetJobItem.setActive(sourceJobItem.getActive());
			targetJobItem.setSequenceNo(sourceJobItem.getSequenceNo());

			ImportMap sourceMap = sourceJobItem.getMap();
			ImportMap targetMap = new ImportMap();
			targetMap.setActive(sourceMap.getActive());
			targetMap.setDescription(sourceMap.getDescription());
			targetMap.setName(sourceMap.getName());
			targetMap.setPath(sourceMap.getPath());

			for (ImportMapItem sourceMapItem : sourceMap.getItems()) {

				ImportMapItem targetMapItem = new ImportMapItem();
				targetMapItem.setActive(sourceMapItem.getActive());
				targetMapItem.setDataSourceName(sourceMapItem
						.getDataSourceName());
				targetMapItem.setFileName(sourceMapItem.getFileName());
				targetMapItem.setImportMap(targetMap);
				targetMapItem.setPath(sourceMapItem.getPath());
				targetMapItem.setSequenceNo(sourceMapItem.getSequenceNo());
				targetMapItem.setUkFieldName(sourceMapItem.getUkFieldName());
				targetMap.addToItems(targetMapItem);
			}

			targetJobItem.setMap(targetMap);
			targetJob.addToItems(targetJobItem);
		}

		net.nan21.dnet.core.api.session.User su = Session.user.get();
		net.nan21.dnet.core.api.session.User newUser = new net.nan21.dnet.core.api.session.User(
				su.getUsername(), su.getUsername(), "", false, false, false,
				true, client.getCode(), client.getId(), null, null, null, null,
				null);

		try {

			Session.user.set(newUser);
			for (ImportJobItem jobItem : targetJob.getItems()) {
				this.getEntityManager().persist(jobItem.getMap());
			}

			this.getEntityManager().persist(targetJob);
			this.getEntityManager().flush();
		} finally {
			Session.user.set(su);
		}
		return targetJob;
	}

	/**
	 * Create an administrator user for a new client.
	 * 
	 * 
	 * @param client
	 * @param userCode
	 * @param userName
	 * @param password
	 * @throws BusinessException
	 */
	public void createAdminUser(Client client, String userCode,
			String userName, String password) throws BusinessException {

		client.setAdminRole(ClientBD.ROLE_ADMIN);
		this.getEntityManager().persist(client);

		net.nan21.dnet.core.api.session.User su = Session.user.get();
		net.nan21.dnet.core.api.session.User newUser = new net.nan21.dnet.core.api.session.User(
				su.getUsername(), su.getUsername(), "", false, false, false,
				true, client.getCode(), client.getId(), null, null, null, null,
				null);

		try {
			Role radmin = new Role();
			radmin.setName(ROLE_ADMIN);
			radmin.setActive(true);
			radmin.setDescription("Administrator role for un-restricted access to business functions.");
			this.getEntityManager().persist(radmin);

			Role ruser = new Role();
			ruser.setName(ROLE_USER);
			ruser.setActive(true);
			ruser.setDescription("Application role which allows a user to use the application.");
			this.getEntityManager().persist(ruser);

			UserType t = new UserType();
			t.setName("Default");
			t.setActive(true);
			this.getEntityManager().persist(t);

			Collection<Role> roles = new ArrayList<Role>();
			roles.add(radmin);
			roles.add(ruser);

			User u = new User();

			u.setCode(userCode);
			u.setName(userName);
			u.setActive(true);
			MessageDigest messageDigest;
			try {
				messageDigest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				throw new BusinessException(
						"No MD5 algrorithm available to encode user password.");
			}
			messageDigest.update(password.getBytes(), 0, password.length());
			String hashedPass = new BigInteger(1, messageDigest.digest())
					.toString(16);
			if (hashedPass.length() < 32) {
				hashedPass = "0" + hashedPass;
			}

			u.setPassword(hashedPass);
			u.setRoles(roles);
			this.getEntityManager().persist(u);
			Session.user.set(newUser);
			this.getEntityManager().flush();
		} finally {
			Session.user.set(su);
		}
	}
}
