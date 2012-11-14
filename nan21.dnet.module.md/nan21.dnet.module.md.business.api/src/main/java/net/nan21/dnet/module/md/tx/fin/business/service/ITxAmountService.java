/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.tx.fin.domain.entity.TxAmount;

/**
 * Interface to expose business functions specific for {@link TxAmount} domain
 * entity.
 */
public interface ITxAmountService extends IEntityService<TxAmount> {

	/**
	 * Find by reference: bpartner
	 */
	public List<TxAmount> findByBpartner(BusinessPartner bpartner);

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<TxAmount> findByBpartnerId(Long bpartnerId);

	/**
	 * Find by reference: org
	 */
	public List<TxAmount> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<TxAmount> findByOrgId(Long orgId);

	/**
	 * Find by reference: paymentMethod
	 */
	public List<TxAmount> findByPaymentMethod(PaymentMethod paymentMethod);

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<TxAmount> findByPaymentMethodId(Long paymentMethodId);
}
