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
import net.nan21.dnet.module.ad.system.business.service.IAuditEntryService;
import net.nan21.dnet.module.ad.system.domain.entity.AuditEntry;
import net.nan21.dnet.module.ad.system.domain.entity.AuditField;

/**
 * Repository functionality for {@link AuditEntry} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AuditEntryService extends AbstractEntityService<AuditEntry>
		implements
			IAuditEntryService {

	public AuditEntryService() {
		super();
	}

	public AuditEntryService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<AuditEntry> getEntityClass() {
		return AuditEntry.class;
	}

	/**
	 * Find by reference: auditFields
	 */
	public List<AuditEntry> findByAuditFields(AuditField auditFields) {
		return this.findByAuditFieldsId(auditFields.getId());
	}

	/**
	 * Find by ID of reference: auditFields.id
	 */
	public List<AuditEntry> findByAuditFieldsId(Long auditFieldsId) {
		return (List<AuditEntry>) this.em
				.createQuery(
						"select distinct e from AuditEntry e, IN (e.auditFields) c where e.clientId = :pClientId and c.id = :pAuditFieldsId",
						AuditEntry.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAuditFieldsId", auditFieldsId).getResultList();
	}
}
