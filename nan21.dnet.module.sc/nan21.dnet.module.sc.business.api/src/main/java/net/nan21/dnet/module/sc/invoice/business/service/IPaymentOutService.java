/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.service;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;

/**
 * Interface to expose business functions specific for {@link PaymentOut} domain
 * entity.
 */
public interface IPaymentOutService extends IEntityService<PaymentOut> {

	public void doConfirm(PaymentOut payment) throws BusinessException;

	public void doUnConfirm(PaymentOut payment) throws BusinessException;

	public void doPost(PaymentOut payment) throws BusinessException;

	public void doUnPost(PaymentOut payment) throws BusinessException;
}
