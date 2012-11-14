/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.serviceext;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesTxAmountService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;

public class SalesTxAmountService
		extends
		net.nan21.dnet.module.sd.invoice.business.serviceimpl.SalesTxAmountService
		implements ISalesTxAmountService {

	/**
	 * Infer the business-partner and organization information from the source
	 * document: order or invoice
	 */
	@Override
	protected void preInsert(SalesTxAmount e) throws BusinessException {
		if (e.getOrder() != null) {
			e.setBpartner(e.getOrder().getCustomer());
			e.setOrg(e.getOrder().getSupplier());
		} else if (e.getInvoice() != null) {
			e.setBpartner(e.getInvoice().getCustomer());
			e.setOrg(e.getInvoice().getSupplier());
		}
	}

}
