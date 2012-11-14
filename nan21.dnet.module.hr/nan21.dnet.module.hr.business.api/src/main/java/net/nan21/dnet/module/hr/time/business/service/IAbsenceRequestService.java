/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequest;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequestItem;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

/**
 * Interface to expose business functions specific for {@link AbsenceRequest} domain
 * entity.
 */
public interface IAbsenceRequestService extends IEntityService<AbsenceRequest> {

	/**
	 * Find by reference: employee
	 */
	public List<AbsenceRequest> findByEmployee(Employee employee);

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<AbsenceRequest> findByEmployeeId(Long employeeId);

	/**
	 * Find by reference: type
	 */
	public List<AbsenceRequest> findByType(AbsenceType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<AbsenceRequest> findByTypeId(Long typeId);

	/**
	 * Find by reference: reason
	 */
	public List<AbsenceRequest> findByReason(AbsenceReason reason);

	/**
	 * Find by ID of reference: reason.id
	 */
	public List<AbsenceRequest> findByReasonId(Long reasonId);

	/**
	 * Find by reference: items
	 */
	public List<AbsenceRequest> findByItems(AbsenceRequestItem items);

	/**
	 * Find by ID of reference: items.id
	 */
	public List<AbsenceRequest> findByItemsId(Long itemsId);
}
