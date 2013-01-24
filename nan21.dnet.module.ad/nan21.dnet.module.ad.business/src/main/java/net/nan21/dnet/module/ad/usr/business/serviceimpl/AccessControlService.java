/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IAccessControlService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.DsAccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

/**
 * Repository functionality for {@link AccessControl} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccessControlService extends AbstractEntityService<AccessControl>
		implements
			IAccessControlService {

	public AccessControlService() {
		super();
	}

	public AccessControlService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AccessControl> getEntityClass() {
		return AccessControl.class;
	}

	/**
	 * Find by unique key
	 */
	public AccessControl findByName(String name) {
		return (AccessControl) this.getEntityManager()
				.createNamedQuery(AccessControl.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: dsRules
	 */
	public List<AccessControl> findByDsRules(DsAccessControl dsRules) {
		return this.findByDsRulesId(dsRules.getId());
	}

	/**
	 * Find by ID of reference: dsRules.id
	 */
	public List<AccessControl> findByDsRulesId(Long dsRulesId) {
		return (List<AccessControl>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from AccessControl e, IN (e.dsRules) c where e.clientId = :pClientId and c.id = :pDsRulesId",
						AccessControl.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDsRulesId", dsRulesId).getResultList();
	}

	/**
	 * Find by reference: roles
	 */
	public List<AccessControl> findByRoles(Role roles) {
		return this.findByRolesId(roles.getId());
	}

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<AccessControl> findByRolesId(Long rolesId) {
		return (List<AccessControl>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from AccessControl e, IN (e.roles) c where e.clientId = :pClientId and c.id = :pRolesId",
						AccessControl.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRolesId", rolesId).getResultList();
	}
}
