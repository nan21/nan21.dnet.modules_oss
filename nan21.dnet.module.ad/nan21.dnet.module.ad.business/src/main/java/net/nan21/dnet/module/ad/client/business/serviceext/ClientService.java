/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.client.business.serviceext;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.session.Params;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.api.session.User;
import net.nan21.dnet.module.ad._businessdelegates.client.ClientBD;
import net.nan21.dnet.module.ad.client.business.service.IClientService;
import net.nan21.dnet.module.ad.client.domain.entity.Client;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;

/**
 * Business extensions specific for {@link Client} domain entity.
 * 
 */
public class ClientService extends
		net.nan21.dnet.module.ad.client.business.serviceimpl.ClientService
		implements IClientService {

	@Override
	public void doInsertWithUserAccounts(Client client, String userCode,
			String userName, String password) throws BusinessException {

		ClientBD delegate = this.getBusinessDelegate(ClientBD.class);
		delegate.createAdminUser(client, userCode, userName, password);

	}

	@Override
	public void doInsertWithUserAccountsAndSetup(Client client,
			String userCode, String userName, String password, Long importJobId)
			throws BusinessException {

		ClientBD delegate = this.getBusinessDelegate(ClientBD.class);
		delegate.createAdminUser(client, userCode, userName, password);
		ImportJob targetJob = delegate.createImportJob(client, importJobId);
		

		// TODO: run the import then delete the targetjob
		
		User currentUser = Session.user.get();
		User newUser = new User(currentUser.getUsername(), currentUser.getUsername(), "", false,
				false, false, true, client.getCode(), client.getId(), null,
				null, null, null, null);

		try {

			Session.user.set(newUser);
			//
			this.sendMessage("ImportFromJobPD-importByJobId", targetJob.getId());
			this.getEntityManager().flush();
		} finally {
			Session.user.set(currentUser);
		}
		
	}

}
