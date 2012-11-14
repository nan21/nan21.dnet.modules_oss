/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tx.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;

/**
 * Interface to expose business functions specific for {@link PaymentMethod} domain
 * entity.
 */
public interface IPaymentMethodService extends IEntityService<PaymentMethod> {

	/**
	 * Find by unique key
	 */
	public PaymentMethod findByName(String name);

	/**
	 * Find by reference: docType
	 */
	public List<PaymentMethod> findByDocType(TxDocType docType);

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<PaymentMethod> findByDocTypeId(Long docTypeId);
}
