/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDateFormat;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

/**
 * Repository functionality for {@link User} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class UserService extends AbstractEntityService<User> {

	public UserService() {
		super();
	}

	public UserService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

	/**
	 * Find by unique key
	 */
	public User findByCode(String code) {
		return (User) this.em.createNamedQuery(User.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by reference: dateFormat
	 */
	public List<User> findByDateFormat(SysDateFormat dateFormat) {
		return this.findByDateFormatId(dateFormat.getId());
	}

	/**
	 * Find by ID of reference: dateFormat.id
	 */
	public List<User> findByDateFormatId(Long dateFormatId) {
		return (List<User>) this.em
				.createQuery(
						"select e from User e where e.clientId = :pClientId and e.dateFormat.id = :pDateFormatId",
						User.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDateFormatId", dateFormatId).getResultList();
	}

	/**
	 * Find by reference: accountType
	 */
	public List<User> findByAccountType(UserType accountType) {
		return this.findByAccountTypeId(accountType.getId());
	}

	/**
	 * Find by ID of reference: accountType.id
	 */
	public List<User> findByAccountTypeId(Long accountTypeId) {
		return (List<User>) this.em
				.createQuery(
						"select e from User e where e.clientId = :pClientId and e.accountType.id = :pAccountTypeId",
						User.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccountTypeId", accountTypeId).getResultList();
	}

	/**
	 * Find by reference: roles
	 */
	public List<User> findByRoles(Role roles) {
		return this.findByRolesId(roles.getId());
	}

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<User> findByRolesId(Long rolesId) {
		return (List<User>) this.em
				.createQuery(
						"select distinct e from User e, IN (e.roles) c where e.clientId = :pClientId and c.id = :pRolesId",
						User.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRolesId", rolesId).getResultList();
	}

	/**
	 * Find by reference: groups
	 */
	public List<User> findByGroups(UserGroup groups) {
		return this.findByGroupsId(groups.getId());
	}

	/**
	 * Find by ID of reference: groups.id
	 */
	public List<User> findByGroupsId(Long groupsId) {
		return (List<User>) this.em
				.createQuery(
						"select distinct e from User e, IN (e.groups) c where e.clientId = :pClientId and c.id = :pGroupsId",
						User.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pGroupsId", groupsId).getResultList();
	}
}
