/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.AuditEntry;
import net.nan21.dnet.module.ad.system.domain.entity.AuditField;

/**
 * Interface to expose business functions specific for {@link AuditEntry} domain
 * entity.
 */
public interface IAuditEntryService extends IEntityService<AuditEntry> {

	/**
	 * Find by reference: auditFields
	 */
	public List<AuditEntry> findByAuditFields(AuditField auditFields);

	/**
	 * Find by ID of reference: auditFields.id
	 */
	public List<AuditEntry> findByAuditFieldsId(Long auditFieldsId);
}
