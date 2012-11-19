/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.service;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentIn;

/**
 * Interface to expose business functions specific for {@link PaymentIn} domain
 * entity.
 */
public interface IPaymentInService extends IEntityService<PaymentIn> {

	public void doConfirm(PaymentIn payment) throws BusinessException;

	public void doUnConfirm(PaymentIn payment) throws BusinessException;

	public void doPost(PaymentIn payment) throws BusinessException;

	public void doUnPost(PaymentIn payment) throws BusinessException;
}
