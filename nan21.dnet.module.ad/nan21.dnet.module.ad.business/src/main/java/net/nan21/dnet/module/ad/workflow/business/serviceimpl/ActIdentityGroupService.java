/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActIdentityGroupService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityGroup;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityUser;

/**
 * Repository functionality for {@link ActIdentityGroup} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActIdentityGroupService
		extends
			AbstractEntityService<ActIdentityGroup>
		implements
			IActIdentityGroupService {

	public ActIdentityGroupService() {
		super();
	}

	public ActIdentityGroupService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ActIdentityGroup> getEntityClass() {
		return ActIdentityGroup.class;
	}

	/**
	 * Find by reference: users
	 */
	public List<ActIdentityGroup> findByUsers(ActIdentityUser users) {
		return this.findByUsersId(users.getId());
	}

	/**
	 * Find by ID of reference: users.id
	 */
	public List<ActIdentityGroup> findByUsersId(String usersId) {
		return (List<ActIdentityGroup>) this.em
				.createQuery(
						"select distinct e from ActIdentityGroup e, IN (e.users) c where  c.id = :pUsersId",
						ActIdentityGroup.class)
				.setParameter("pUsersId", usersId).getResultList();
	}
}
