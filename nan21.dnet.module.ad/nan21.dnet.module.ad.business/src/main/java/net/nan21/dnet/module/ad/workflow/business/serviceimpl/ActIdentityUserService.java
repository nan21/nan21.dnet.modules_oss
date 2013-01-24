/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActIdentityUserService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityGroup;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityUser;

/**
 * Repository functionality for {@link ActIdentityUser} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActIdentityUserService
		extends
			AbstractEntityService<ActIdentityUser>
		implements
			IActIdentityUserService {

	public ActIdentityUserService() {
		super();
	}

	public ActIdentityUserService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ActIdentityUser> getEntityClass() {
		return ActIdentityUser.class;
	}

	/**
	 * Find by reference: groups
	 */
	public List<ActIdentityUser> findByGroups(ActIdentityGroup groups) {
		return this.findByGroupsId(groups.getId());
	}

	/**
	 * Find by ID of reference: groups.id
	 */
	public List<ActIdentityUser> findByGroupsId(String groupsId) {
		return (List<ActIdentityUser>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from ActIdentityUser e, IN (e.groups) c where  c.id = :pGroupsId",
						ActIdentityUser.class)
				.setParameter("pGroupsId", groupsId).getResultList();
	}
}
