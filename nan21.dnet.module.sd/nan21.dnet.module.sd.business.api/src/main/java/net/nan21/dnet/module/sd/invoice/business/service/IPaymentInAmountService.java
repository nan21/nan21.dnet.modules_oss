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

public interface IPaymentInAmountService extends IEntityService<PaymentInAmount> {
	
	public List<PaymentInAmount> findByTxAmount(SalesTxAmount txAmount);
	
	public List<PaymentInAmount> findByTxAmountId(Long txAmountId);
	
}
