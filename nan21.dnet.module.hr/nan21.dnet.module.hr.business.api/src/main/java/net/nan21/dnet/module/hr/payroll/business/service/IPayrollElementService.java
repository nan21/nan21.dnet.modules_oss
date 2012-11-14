/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;

/**
 * Interface to expose business functions specific for {@link PayrollElement} domain
 * entity.
 */
public interface IPayrollElementService extends IEntityService<PayrollElement> {

	/**
	 * Find by unique key
	 */
	public PayrollElement findByEngine_code(Engine engine, String code);

	/**
	 * Find by unique key
	 */
	public PayrollElement findByEngine_code(Long engineId, String code);

	/**
	 * Find by reference: accItem
	 */
	public List<PayrollElement> findByAccItem(AccItem accItem);

	/**
	 * Find by ID of reference: accItem.id
	 */
	public List<PayrollElement> findByAccItemId(Long accItemId);

	/**
	 * Find by reference: sourceElement
	 */
	public List<PayrollElement> findBySourceElement(PayrollElement sourceElement);

	/**
	 * Find by ID of reference: sourceElement.id
	 */
	public List<PayrollElement> findBySourceElementId(Long sourceElementId);
}
