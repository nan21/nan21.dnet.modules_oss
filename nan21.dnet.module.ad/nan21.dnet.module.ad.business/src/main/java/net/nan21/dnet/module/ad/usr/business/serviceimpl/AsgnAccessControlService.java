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
import net.nan21.dnet.module.ad.usr.business.service.IAsgnAccessControlService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.AsgnAccessControl;

/**
 * Repository functionality for {@link AsgnAccessControl} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AsgnAccessControlService
		extends
			AbstractEntityService<AsgnAccessControl>
		implements
			IAsgnAccessControlService {

	public AsgnAccessControlService() {
		super();
	}

	public AsgnAccessControlService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AsgnAccessControl> getEntityClass() {
		return AsgnAccessControl.class;
	}

	/**
	 * Find by unique key
	 */
	public AsgnAccessControl findByUnique(AccessControl accessControl,
			String dsName) {
		return (AsgnAccessControl) this.getEntityManager()
				.createNamedQuery(AsgnAccessControl.NQ_FIND_BY_UNIQUE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccessControl", accessControl)
				.setParameter("pDsName", dsName).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public AsgnAccessControl findByUnique(Long accessControlId, String dsName) {
		return (AsgnAccessControl) this
				.getEntityManager()
				.createNamedQuery(AsgnAccessControl.NQ_FIND_BY_UNIQUE_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccessControlId", accessControlId)
				.setParameter("pDsName", dsName).getSingleResult();
	}

	/**
	 * Find by reference: accessControl
	 */
	public List<AsgnAccessControl> findByAccessControl(
			AccessControl accessControl) {
		return this.findByAccessControlId(accessControl.getId());
	}

	/**
	 * Find by ID of reference: accessControl.id
	 */
	public List<AsgnAccessControl> findByAccessControlId(Long accessControlId) {
		return (List<AsgnAccessControl>) this
				.getEntityManager()
				.createQuery(
						"select e from AsgnAccessControl e where e.clientId = :pClientId and e.accessControl.id = :pAccessControlId",
						AsgnAccessControl.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccessControlId", accessControlId)
				.getResultList();
	}
}
