/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequest;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequestItem;

/**
 * Interface to expose business functions specific for {@link AbsenceRequestItem} domain
 * entity.
 */
public interface IAbsenceRequestItemService
		extends
			IEntityService<AbsenceRequestItem> {

	/**
	 * Find by reference: absenceRequest
	 */
	public List<AbsenceRequestItem> findByAbsenceRequest(
			AbsenceRequest absenceRequest);

	/**
	 * Find by ID of reference: absenceRequest.id
	 */
	public List<AbsenceRequestItem> findByAbsenceRequestId(Long absenceRequestId);
}
