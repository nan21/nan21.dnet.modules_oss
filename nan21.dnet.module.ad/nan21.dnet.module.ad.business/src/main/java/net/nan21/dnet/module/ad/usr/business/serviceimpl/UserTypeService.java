/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IUserTypeService;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

/**
 * Repository functionality for {@link UserType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class UserTypeService extends AbstractEntityService<UserType>
		implements
			IUserTypeService {

	public UserTypeService() {
		super();
	}

	public UserTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<UserType> getEntityClass() {
		return UserType.class;
	}

	/**
	 * Find by unique key
	 */
	public UserType findByName(String name) {
		return (UserType) this.getEntityManager()
				.createNamedQuery(UserType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
