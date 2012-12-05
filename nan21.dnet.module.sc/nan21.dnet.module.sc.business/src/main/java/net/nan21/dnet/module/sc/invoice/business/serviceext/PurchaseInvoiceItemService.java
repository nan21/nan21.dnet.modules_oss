/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.serviceext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.sc._businessdelegates.order.PurchaseTaxBD;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceItemService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItemTax;

public class PurchaseInvoiceItemService
		extends
		net.nan21.dnet.module.sc.invoice.business.serviceimpl.PurchaseInvoiceItemService
		implements IPurchaseInvoiceItemService {

	@Override
	protected void preInsert(PurchaseInvoiceItem e) throws BusinessException {
		this.applyEntryModePreSave(e);
	}

	@Override
	protected void preUpdate(PurchaseInvoiceItem e) throws BusinessException {
		this.applyEntryModePreSave(e);
	}

	@Override
	protected void postInsert(PurchaseInvoiceItem e) throws BusinessException {
		this.calculateTaxes(e);
	}

	@Override
	protected void postUpdate(PurchaseInvoiceItem e) throws BusinessException {
		this.calculateTaxes(e);
	}

	@Override
	protected void postInsert(List<PurchaseInvoiceItem> list) {
		this.onItemsChange(list);
	}

	@Override
	protected void postUpdate(List<PurchaseInvoiceItem> list) {
		this.onItemsChange(list);
	}

	@Override
	protected void postDelete(List<PurchaseInvoiceItem> list) {
		this.onItemsChange(list);
	}

	@Override
	protected void preDeleteByIds(List<Object> ids, Map<String, Object> context) {
		context.put("docIds", this.findByIds(ids));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void postDeleteByIds(List<Object> ids, Map<String, Object> context) {
		this.onItemsChange((List<PurchaseInvoiceItem>) context.get("docIds"));
	}

	protected void onItemsChange(List<PurchaseInvoiceItem> list) {
		List<Long> docIds = new ArrayList<Long>();
		for (PurchaseInvoiceItem item : list) {
			if (!docIds.contains(item.getPurchaseInvoice().getId())) {
				docIds.add(item.getPurchaseInvoice().getId());
			}
		}
		for (Long id : docIds) {
			sendMessage("PurchaseInvoiceService-calculateAmounts", id);
		}
	}

	protected void calculateTaxes(PurchaseInvoiceItem item)
			throws BusinessException {

		if (item.getTax() != null) {
			PurchaseTaxBD delegate = this
					.getBusinessDelegate(PurchaseTaxBD.class);
			List<PurchaseInvoiceItemTax> itemTaxes = new ArrayList<PurchaseInvoiceItemTax>();

			delegate.createItemTax(item, null, itemTaxes);
			Float taxAmount = 0F;
			for (PurchaseInvoiceItemTax itemTax : itemTaxes) {
				taxAmount += itemTax.getTaxAmount();
			}

			// this is already set in preSave based on entryMode
			if (!item.getUseGivenTax()) {
				item.setTaxAmount(taxAmount);
			}
			item.setLineAmount(item.getTaxAmount() + item.getNetAmount());
			this.getEntityManager().merge(item);
			// this.getEntityManager().flush();
			this.getEntityManager()
					.createQuery(
							"delete from "
									+ PurchaseInvoiceItemTax.class
											.getSimpleName()
									+ " e where e.purchaseInvoiceItem.id = :itemId")
					.setParameter("itemId", item.getId()).executeUpdate();

			for (PurchaseInvoiceItemTax itemTax : itemTaxes) {
				this.getEntityManager().persist(itemTax);
			}
		} else {
			item.setLineAmount(item.getTaxAmount() + item.getNetAmount());
			this.getEntityManager().merge(item);
			this.getEntityManager()
					.createQuery(
							"delete from "
									+ PurchaseInvoiceItemTax.class
											.getSimpleName()
									+ " e where e.purchaseInvoiceItem.id = :itemId")
					.setParameter("itemId", item.getId()).executeUpdate();
		}
	}

	protected void applyEntryModePreSave(PurchaseInvoiceItem e) {
		if (e.getEntryMode() == null) {
			e.setEntryMode("price");
		}
		e.setUseGivenTax(false);
		if (e.getEntryMode().equals("price")) {
			if (e.getUnitPrice() == null || e.getQuantity() == null) {
				throw new RuntimeException(
						"In `price` entry mode, both line unit price and quantity must be specified. ");
			}
			e.setNetAmount(e.getQuantity() * e.getUnitPrice());
			if (e.getTax() == null) {
				e.setTaxAmount(0F);
			}
		} else {

			if (e.getNetAmount() == null) {
				// !net, tax, total
				if (e.getTaxAmount() != null && e.getLineAmount() != null) {
					// calculate as total - tax and use the given tax
					e.setUseGivenTax(true);
					e.setNetAmount(e.getLineAmount() - e.getTaxAmount());
				} else {
					// !net, !tax , total
					if (e.getLineAmount() != null) {
						if (e.getTax() == null) {
							e.setNetAmount(e.getLineAmount());
							e.setTaxAmount(0F);
						} else {
							throw new RuntimeException(
									"Insufficient information provided for `net-amount` entry mode. ");
						}
					} else {
						throw new RuntimeException(
								"Insufficient information provided for `net-amount` entry mode. ");
					}

				}
				if (e.getNetAmount() != 0) {
					if (e.getQuantity() == null) {
						e.setQuantity(1F);
					}
					e.setUnitPrice(e.getNetAmount() / e.getQuantity());
				}

			} else {
				if (e.getTaxAmount() == null) {
					if (e.getLineAmount() != null) {
						e.setTaxAmount(e.getLineAmount() - e.getNetAmount());
					} else {
						e.setTaxAmount(0F);
					}
				} else {
					if (e.getLineAmount() == null) {
						e.setUseGivenTax(true);
						e.setLineAmount(e.getNetAmount() + e.getTaxAmount());
					}
				}
				if (e.getQuantity() == null) {
					e.setQuantity(1F);
				}
				e.setUnitPrice(e.getNetAmount() / e.getQuantity());
			}

		}

	}

}
