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

public interface IAuditEntryService extends IEntityService<AuditEntry> {
	
	public List<AuditEntry> findByAuditFields(AuditField auditFields);
	
	public List<AuditEntry> findByAuditFieldsId(Long auditFieldsId);
	
}
