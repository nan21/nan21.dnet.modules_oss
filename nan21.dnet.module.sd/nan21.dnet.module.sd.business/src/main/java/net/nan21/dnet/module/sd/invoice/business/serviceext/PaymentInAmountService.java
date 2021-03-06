/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.serviceext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.sd.invoice.business.service.IPaymentInAmountService;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentInAmount;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;

/**
 * Business extensions specific for {@link PaymentInAmount} domain entity.
 * 
 */
public class PaymentInAmountService
		extends
		net.nan21.dnet.module.sd.invoice.business.serviceimpl.PaymentInAmountService
		implements IPaymentInAmountService {

	@Override
	protected void postInsert(List<PaymentInAmount> list)
			throws BusinessException {
		this.calculateTxAmounts(list, true);
	}

	@Override
	protected void preDelete(List<PaymentInAmount> list)
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
	protected void calculateTxAmounts(List<PaymentInAmount> list, boolean add)
			throws BusinessException {

		List<SalesTxAmount> txAmounts = new ArrayList<SalesTxAmount>();

		for (PaymentInAmount payAmount : list) {
			SalesTxAmount txAmount = payAmount.getTxAmount();
			if (txAmount != null) {
				if (add) {
					txAmount.setPayedAmount(txAmount.getPayedAmount()
							+ payAmount.getAmount());
					txAmount.setAmount(txAmount.getAmount()
							- payAmount.getAmount());
					txAmounts.add(txAmount);
				} else {
					txAmount.setPayedAmount(txAmount.getPayedAmount()
							- payAmount.getAmount());
					txAmount.setAmount(txAmount.getAmount()
							+ payAmount.getAmount());
					txAmounts.add(txAmount);
				}

			}
		}
		this.findEntityService(SalesTxAmount.class).update(txAmounts);
	}
}
