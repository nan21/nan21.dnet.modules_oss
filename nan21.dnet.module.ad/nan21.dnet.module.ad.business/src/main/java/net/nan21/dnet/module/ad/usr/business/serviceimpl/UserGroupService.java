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
import net.nan21.dnet.module.ad.usr.business.service.IUserGroupService;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;

/**
 * Repository functionality for {@link UserGroup} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class UserGroupService extends AbstractEntityService<UserGroup>
		implements
			IUserGroupService {

	public UserGroupService() {
		super();
	}

	public UserGroupService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<UserGroup> getEntityClass() {
		return UserGroup.class;
	}

	/**
	 * Find by unique key
	 */
	public UserGroup findByName(String name) {
		return (UserGroup) this.getEntityManager()
				.createNamedQuery(UserGroup.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: users
	 */
	public List<UserGroup> findByUsers(User users) {
		return this.findByUsersId(users.getId());
	}

	/**
	 * Find by ID of reference: users.id
	 */
	public List<UserGroup> findByUsersId(Long usersId) {
		return (List<UserGroup>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from UserGroup e, IN (e.users) c where e.clientId = :pClientId and c.id = :pUsersId",
						UserGroup.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pUsersId", usersId).getResultList();
	}
}
