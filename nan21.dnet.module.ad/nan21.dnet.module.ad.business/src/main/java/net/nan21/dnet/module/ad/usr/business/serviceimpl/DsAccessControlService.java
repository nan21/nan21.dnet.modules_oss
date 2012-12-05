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
import net.nan21.dnet.module.ad.usr.business.service.IDsAccessControlService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.DsAccessControl;

/**
 * Repository functionality for {@link DsAccessControl} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DsAccessControlService
		extends
			AbstractEntityService<DsAccessControl>
		implements
			IDsAccessControlService {

	public DsAccessControlService() {
		super();
	}

	public DsAccessControlService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DsAccessControl> getEntityClass() {
		return DsAccessControl.class;
	}

	/**
	 * Find by unique key
	 */
	public DsAccessControl findByUnique(AccessControl accessControl,
			String dsName) {
		return (DsAccessControl) this.getEntityManager()
				.createNamedQuery(DsAccessControl.NQ_FIND_BY_UNIQUE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccessControl", accessControl)
				.setParameter("pDsName", dsName).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public DsAccessControl findByUnique(Long accessControlId, String dsName) {
		return (DsAccessControl) this.getEntityManager()
				.createNamedQuery(DsAccessControl.NQ_FIND_BY_UNIQUE_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccessControlId", accessControlId)
				.setParameter("pDsName", dsName).getSingleResult();
	}

	/**
	 * Find by reference: accessControl
	 */
	public List<DsAccessControl> findByAccessControl(AccessControl accessControl) {
		return this.findByAccessControlId(accessControl.getId());
	}

	/**
	 * Find by ID of reference: accessControl.id
	 */
	public List<DsAccessControl> findByAccessControlId(Long accessControlId) {
		return (List<DsAccessControl>) this
				.getEntityManager()
				.createQuery(
						"select e from DsAccessControl e where e.clientId = :pClientId and e.accessControl.id = :pAccessControlId",
						DsAccessControl.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccessControlId", accessControlId)
				.getResultList();
	}
}
