/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.serviceext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		this.calculateTxAmounts(list, true);
	}

	@Override
	protected void preDelete(List<PaymentOutAmount> list)
			throws BusinessException {
		this.calculateTxAmounts(list, false);
	}

	@Override
	protected void preDeleteByIds(List<Object> ids, Map<String, Object> context)
			throws BusinessException {
		this.calculateTxAmounts(this.findByIds(ids), false);
	}

	/**
	 * Update txAmounts from payment amount.
	 * 
	 * @param list
	 * @param add
	 * @throws BusinessException
	 */
	protected void calculateTxAmounts(List<PaymentOutAmount> list, boolean add)
			throws BusinessException {
		List<PurchaseTxAmount> txAmounts = new ArrayList<PurchaseTxAmount>();
		for (PaymentOutAmount payAmount : list) {
			PurchaseTxAmount txAmount = payAmount.getTxAmount();
			if (txAmount != null) {
				if (add) {
					txAmount.setPayedAmount(txAmount.getPayedAmount()
							+ payAmount.getAmount());
					txAmount.setAmount(txAmount.getAmount()
							- payAmount.getAmount());
				} else {
					txAmount.setPayedAmount(txAmount.getPayedAmount()
							- payAmount.getAmount());
					txAmount.setAmount(txAmount.getAmount()
							+ payAmount.getAmount());
				}

				txAmounts.add(txAmount);
			}
		}
		this.findEntityService(PurchaseTxAmount.class).update(txAmounts);
	}

}
