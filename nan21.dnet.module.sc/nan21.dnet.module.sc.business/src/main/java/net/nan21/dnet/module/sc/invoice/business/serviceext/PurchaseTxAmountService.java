/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.serviceext;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseTxAmountService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;

/**
 * Business extensions specific for {@link PurchaseTxAmount} domain entity.
 * 
 */
public class PurchaseTxAmountService
		extends
		net.nan21.dnet.module.sc.invoice.business.serviceimpl.PurchaseTxAmountService
		implements IPurchaseTxAmountService {

	/**
	 * Infer the business-partner and organization information from the source
	 * document: order or invoice
	 */
	@Override
	protected void preInsert(PurchaseTxAmount e) throws BusinessException {
		if (e.getOrder() != null) {
			e.setBpartner(e.getOrder().getSupplier());
			e.setOrg(e.getOrder().getCustomer());
		} else if (e.getInvoice() != null) {
			e.setBpartner(e.getInvoice().getSupplier());
			e.setOrg(e.getInvoice().getCustomer());
		}
	}
}
