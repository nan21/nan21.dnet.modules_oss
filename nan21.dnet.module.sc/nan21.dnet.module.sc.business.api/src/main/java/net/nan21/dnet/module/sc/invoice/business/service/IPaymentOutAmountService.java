/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOutAmount;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;

/**
 * Interface to expose business functions specific for {@link PaymentOutAmount} domain
 * entity.
 */
public interface IPaymentOutAmountService
		extends
			IEntityService<PaymentOutAmount> {

	/**
	 * Find by reference: txAmount
	 */
	public List<PaymentOutAmount> findByTxAmount(PurchaseTxAmount txAmount);

	/**
	 * Find by ID of reference: txAmount.id
	 */
	public List<PaymentOutAmount> findByTxAmountId(Long txAmountId);
}
