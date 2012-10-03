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

public interface IPaymentOutAmountService extends IEntityService<PaymentOutAmount> {
	
	public List<PaymentOutAmount> findByTxAmount(PurchaseTxAmount txAmount);
	
	public List<PaymentOutAmount> findByTxAmountId(Long txAmountId);
	
}
