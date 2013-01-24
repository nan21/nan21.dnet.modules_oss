/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

/**
 * Interface to expose business functions specific for {@link PaymentItem} domain
 * entity.
 */
public interface IPaymentItemService extends IEntityService<PaymentItem> {

	/**
	 * Find by reference: payment
	 */
	public List<PaymentItem> findByPayment(Payment payment);

	/**
	 * Find by ID of reference: payment.id
	 */
	public List<PaymentItem> findByPaymentId(Long paymentId);

	/**
	 * Find by reference: accItem
	 */
	public List<PaymentItem> findByAccItem(AccItem accItem);

	/**
	 * Find by ID of reference: accItem.id
	 */
	public List<PaymentItem> findByAccItemId(Long accItemId);

	/**
	 * Find by reference: product
	 */
	public List<PaymentItem> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<PaymentItem> findByProductId(Long productId);

	/**
	 * Find by reference: uom
	 */
	public List<PaymentItem> findByUom(Uom uom);

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<PaymentItem> findByUomId(Long uomId);
}
