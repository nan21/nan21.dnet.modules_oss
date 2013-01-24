/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.AuditEntry;
import net.nan21.dnet.module.ad.system.domain.entity.AuditField;

/**
 * Interface to expose business functions specific for {@link AuditField} domain
 * entity.
 */
public interface IAuditFieldService extends IEntityService<AuditField> {

	/**
	 * Find by reference: auditEntry
	 */
	public List<AuditField> findByAuditEntry(AuditEntry auditEntry);

	/**
	 * Find by ID of reference: auditEntry.id
	 */
	public List<AuditField> findByAuditEntryId(Long auditEntryId);
}
