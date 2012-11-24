/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

/**
 * Repository functionality for {@link PurchaseOrder} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PurchaseOrderService extends AbstractEntityService<PurchaseOrder> {

	public PurchaseOrderService() {
		super();
	}

	public PurchaseOrderService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<PurchaseOrder> getEntityClass() {
		return PurchaseOrder.class;
	}

	/**
	 * Find by unique key
	 */
	public PurchaseOrder findByCode(String code) {
		return (PurchaseOrder) this.em
				.createNamedQuery(PurchaseOrder.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by reference: docType
	 */
	public List<PurchaseOrder> findByDocType(TxDocType docType) {
		return this.findByDocTypeId(docType.getId());
	}

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<PurchaseOrder> findByDocTypeId(Long docTypeId) {
		return (List<PurchaseOrder>) this.em
				.createQuery(
						"select e from PurchaseOrder e where e.clientId = :pClientId and e.docType.id = :pDocTypeId",
						PurchaseOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDocTypeId", docTypeId).getResultList();
	}

	/**
	 * Find by reference: supplier
	 */
	public List<PurchaseOrder> findBySupplier(BusinessPartner supplier) {
		return this.findBySupplierId(supplier.getId());
	}

	/**
	 * Find by ID of reference: supplier.id
	 */
	public List<PurchaseOrder> findBySupplierId(Long supplierId) {
		return (List<PurchaseOrder>) this.em
				.createQuery(
						"select e from PurchaseOrder e where e.clientId = :pClientId and e.supplier.id = :pSupplierId",
						PurchaseOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSupplierId", supplierId).getResultList();
	}

	/**
	 * Find by reference: customer
	 */
	public List<PurchaseOrder> findByCustomer(Organization customer) {
		return this.findByCustomerId(customer.getId());
	}

	/**
	 * Find by ID of reference: customer.id
	 */
	public List<PurchaseOrder> findByCustomerId(Long customerId) {
		return (List<PurchaseOrder>) this.em
				.createQuery(
						"select e from PurchaseOrder e where e.clientId = :pClientId and e.customer.id = :pCustomerId",
						PurchaseOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustomerId", customerId).getResultList();
	}

	/**
	 * Find by reference: priceList
	 */
	public List<PurchaseOrder> findByPriceList(PriceList priceList) {
		return this.findByPriceListId(priceList.getId());
	}

	/**
	 * Find by ID of reference: priceList.id
	 */
	public List<PurchaseOrder> findByPriceListId(Long priceListId) {
		return (List<PurchaseOrder>) this.em
				.createQuery(
						"select e from PurchaseOrder e where e.clientId = :pClientId and e.priceList.id = :pPriceListId",
						PurchaseOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPriceListId", priceListId).getResultList();
	}

	/**
	 * Find by reference: currency
	 */
	public List<PurchaseOrder> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<PurchaseOrder> findByCurrencyId(Long currencyId) {
		return (List<PurchaseOrder>) this.em
				.createQuery(
						"select e from PurchaseOrder e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
						PurchaseOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCurrencyId", currencyId).getResultList();
	}

	/**
	 * Find by reference: paymentMethod
	 */
	public List<PurchaseOrder> findByPaymentMethod(PaymentMethod paymentMethod) {
		return this.findByPaymentMethodId(paymentMethod.getId());
	}

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<PurchaseOrder> findByPaymentMethodId(Long paymentMethodId) {
		return (List<PurchaseOrder>) this.em
				.createQuery(
						"select e from PurchaseOrder e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
						PurchaseOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentMethodId", paymentMethodId)
				.getResultList();
	}

	/**
	 * Find by reference: paymentTerm
	 */
	public List<PurchaseOrder> findByPaymentTerm(PaymentTerm paymentTerm) {
		return this.findByPaymentTermId(paymentTerm.getId());
	}

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<PurchaseOrder> findByPaymentTermId(Long paymentTermId) {
		return (List<PurchaseOrder>) this.em
				.createQuery(
						"select e from PurchaseOrder e where e.clientId = :pClientId and e.paymentTerm.id = :pPaymentTermId",
						PurchaseOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentTermId", paymentTermId).getResultList();
	}

	/**
	 * Find by reference: inventory
	 */
	public List<PurchaseOrder> findByInventory(Organization inventory) {
		return this.findByInventoryId(inventory.getId());
	}

	/**
	 * Find by ID of reference: inventory.id
	 */
	public List<PurchaseOrder> findByInventoryId(Long inventoryId) {
		return (List<PurchaseOrder>) this.em
				.createQuery(
						"select e from PurchaseOrder e where e.clientId = :pClientId and e.inventory.id = :pInventoryId",
						PurchaseOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pInventoryId", inventoryId).getResultList();
	}

	/**
	 * Find by reference: deliveryMethod
	 */
	public List<PurchaseOrder> findByDeliveryMethod(
			DeliveryMethod deliveryMethod) {
		return this.findByDeliveryMethodId(deliveryMethod.getId());
	}

	/**
	 * Find by ID of reference: deliveryMethod.id
	 */
	public List<PurchaseOrder> findByDeliveryMethodId(Long deliveryMethodId) {
		return (List<PurchaseOrder>) this.em
				.createQuery(
						"select e from PurchaseOrder e where e.clientId = :pClientId and e.deliveryMethod.id = :pDeliveryMethodId",
						PurchaseOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDeliveryMethodId", deliveryMethodId)
				.getResultList();
	}

	/**
	 * Find by reference: lines
	 */
	public List<PurchaseOrder> findByLines(PurchaseOrderItem lines) {
		return this.findByLinesId(lines.getId());
	}

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<PurchaseOrder> findByLinesId(Long linesId) {
		return (List<PurchaseOrder>) this.em
				.createQuery(
						"select distinct e from PurchaseOrder e, IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
						PurchaseOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLinesId", linesId).getResultList();
	}
}
