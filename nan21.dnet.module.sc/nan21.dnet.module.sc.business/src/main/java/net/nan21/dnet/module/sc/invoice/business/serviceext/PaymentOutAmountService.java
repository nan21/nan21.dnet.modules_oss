/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.serviceext;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.sc.invoice.business.service.IPaymentOutAmountService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOutAmount;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;

/**
 * Business extensions specific for {@link PaymentOutAmount} domain entity.
 * 
 */
public class PaymentOutAmountService
		extends
		net.nan21.dnet.module.sc.invoice.business.serviceimpl.PaymentOutAmountService
		implements IPaymentOutAmountService {

	@Override
	protected void postInsert(List<PaymentOutAmount> list)
			throws BusinessException {
		List<PurchaseTxAmount> txAmounts = new ArrayList<PurchaseTxAmount>();

		for (PaymentOutAmount payAmount : list) {
			PurchaseTxAmount txAmount = payAmount.getTxAmount();
			if (txAmount != null) {
				txAmount.setPayedAmount(txAmount.getPayedAmount()
						+ payAmount.getAmount());
				txAmount.setAmount(txAmount.getAmount() - payAmount.getAmount());
				txAmounts.add(txAmount);
			}
		}
		this.findEntityService(PurchaseTxAmount.class).update(txAmounts);
	}

}
