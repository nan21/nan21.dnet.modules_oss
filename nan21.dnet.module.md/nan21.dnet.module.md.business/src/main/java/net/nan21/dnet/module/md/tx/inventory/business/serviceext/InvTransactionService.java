/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.inventory.business.serviceext;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md._businessdelegates.mm.inventory.InvTransactionBD;
import net.nan21.dnet.module.md.tx.inventory.business.service.IInvTransactionService;

/**
 * Business extensions specific for {@link InvTransaction} domain entity.
 * 
 */
public class InvTransactionService
		extends
		net.nan21.dnet.module.md.tx.inventory.business.serviceimpl.InvTransactionService
		implements IInvTransactionService {

	@Override
	public void doConfirm(Long transactionId) throws BusinessException {
		this.getBusinessDelegate(InvTransactionBD.class).confirm(transactionId);
	}

	@Override
	public void doUnConfirm(Long transactionId) throws BusinessException {
		this.getBusinessDelegate(InvTransactionBD.class).unConfirm(
				transactionId);
	}

}
