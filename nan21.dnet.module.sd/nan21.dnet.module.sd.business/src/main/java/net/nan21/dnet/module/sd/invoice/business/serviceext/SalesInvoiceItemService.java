/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.serviceext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.nan21.dnet.core.api.exceptions.BusinessException;

import net.nan21.dnet.module.sd._businessdelegates.order.SalesTaxBD;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceItemService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;

public class SalesInvoiceItemService
		extends
		net.nan21.dnet.module.sd.invoice.business.serviceimpl.SalesInvoiceItemService
		implements ISalesInvoiceItemService {

	@Override
	protected void postInsert(SalesInvoiceItem e) throws BusinessException {
		this.calculateTaxes(e);
	}

	@Override
	protected void postUpdate(SalesInvoiceItem e) throws BusinessException {
		this.calculateTaxes(e);
	}

	@Override
	protected void postInsert(List<SalesInvoiceItem> list) {
		this.onItemsChange(list);
	}

	@Override
	protected void postUpdate(List<SalesInvoiceItem> list) {
		this.onItemsChange(list);
	}

	@Override
	protected void postDelete(List<SalesInvoiceItem> list) {
		this.onItemsChange(list);
	}

	@Override
	protected void preDeleteByIds(List<Object> ids, Map<String, Object> context) {
		context.put("docIds", this.findByIds(ids));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void postDeleteByIds(List<Object> ids, Map<String, Object> context) {
		this.onItemsChange((List<SalesInvoiceItem>) context.get("docIds"));
	}

	protected void onItemsChange(List<SalesInvoiceItem> list) {
		List<Long> docIds = new ArrayList<Long>();
		for (SalesInvoiceItem item : list) {
			if (!docIds.contains(item.getSalesInvoice().getId())) {
				docIds.add(item.getSalesInvoice().getId());
			}
		}
		for (Long id : docIds) {
			sendMessage("SalesInvoiceService-calculateAmounts", id);
		}
	}

	protected void calculateTaxes(SalesInvoiceItem item)
			throws BusinessException {

		if (item.getTax() != null) {
			SalesTaxBD delegate = this.getBusinessDelegate(SalesTaxBD.class);
			List<SalesInvoiceItemTax> itemTaxes = new ArrayList<SalesInvoiceItemTax>();

			delegate.createItemTax(item, null, itemTaxes);
			Float taxAmount = 0F;
			for (SalesInvoiceItemTax itemTax : itemTaxes) {
				taxAmount += itemTax.getTaxAmount();
			}
			item.setTaxAmount(taxAmount);
			this.getEntityManager().merge(item);
			// this.getEntityManager().flush();
			this.getEntityManager()
					.createQuery(
							"delete from "
									+ SalesInvoiceItemTax.class.getSimpleName()
									+ " e where e.salesInvoiceItem.id = :itemId")
					.setParameter("itemId", item.getId()).executeUpdate();

			for (SalesInvoiceItemTax itemTax : itemTaxes) {
				this.getEntityManager().persist(itemTax);
			}
		}
	}

}
