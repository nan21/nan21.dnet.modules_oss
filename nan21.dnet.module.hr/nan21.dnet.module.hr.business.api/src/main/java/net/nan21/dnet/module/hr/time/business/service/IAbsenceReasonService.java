/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

public interface IAbsenceReasonService extends IEntityService<AbsenceReason> {
	
	public AbsenceReason findByName(String name);
	
	public List<AbsenceReason> findByType(AbsenceType type);
	
	public List<AbsenceReason> findByTypeId(Long typeId);
	
}
