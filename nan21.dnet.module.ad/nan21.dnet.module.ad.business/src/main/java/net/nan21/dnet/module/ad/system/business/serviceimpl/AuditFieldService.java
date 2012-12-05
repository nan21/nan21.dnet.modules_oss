/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.IAuditFieldService;
import net.nan21.dnet.module.ad.system.domain.entity.AuditEntry;
import net.nan21.dnet.module.ad.system.domain.entity.AuditField;

/**
 * Repository functionality for {@link AuditField} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AuditFieldService extends AbstractEntityService<AuditField>
		implements
			IAuditFieldService {

	public AuditFieldService() {
		super();
	}

	public AuditFieldService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AuditField> getEntityClass() {
		return AuditField.class;
	}

	/**
	 * Find by reference: auditEntry
	 */
	public List<AuditField> findByAuditEntry(AuditEntry auditEntry) {
		return this.findByAuditEntryId(auditEntry.getId());
	}

	/**
	 * Find by ID of reference: auditEntry.id
	 */
	public List<AuditField> findByAuditEntryId(Long auditEntryId) {
		return (List<AuditField>) this
				.getEntityManager()
				.createQuery(
						"select e from AuditField e where e.clientId = :pClientId and e.auditEntry.id = :pAuditEntryId",
						AuditField.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAuditEntryId", auditEntryId).getResultList();
	}
}
