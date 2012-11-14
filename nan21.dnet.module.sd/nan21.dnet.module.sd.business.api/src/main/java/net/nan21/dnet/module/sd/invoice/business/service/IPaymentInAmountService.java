/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentInAmount;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;

/**
 * Interface to expose business functions specific for {@link PaymentInAmount} domain
 * entity.
 */
public interface IPaymentInAmountService
		extends
			IEntityService<PaymentInAmount> {

	/**
	 * Find by reference: txAmount
	 */
	public List<PaymentInAmount> findByTxAmount(SalesTxAmount txAmount);

	/**
	 * Find by ID of reference: txAmount.id
	 */
	public List<PaymentInAmount> findByTxAmountId(Long txAmountId);
}
