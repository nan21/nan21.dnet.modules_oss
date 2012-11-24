package net.nan21.dnet.module.sc._businessdelegates.invoice;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceItemService;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;

public class PurchaseInvoiceCreateLines extends AbstractBusinessDelegate {

	IPurchaseInvoiceItemService itemService;
	IPurchaseInvoiceService service;

	/**
	 * Create lines for the target invoice by copying them from the source
	 * invoice with the given ID
	 * 
	 * @param target
	 * @param sourceCode
	 * @throws BusinessException
	 */
	public void copyLines(PurchaseInvoice target, Long sourceId)
			throws BusinessException {
		if (sourceId == null) {
			throw new BusinessException(
					"Cannot copy lines. No source invoice specified.");
		}
		PurchaseInvoice source = this.getPurchaseInvoiceService().findById(
				sourceId);
		copyLines(target, source);
	}

	/**
	 * Create lines for the target invoice by copying them from the source
	 * 
	 * @param target
	 * @param source
	 * @throws BusinessException
	 */
	public void copyLines(PurchaseInvoice target, PurchaseInvoice source)
			throws BusinessException {
		if (source == null) {
			throw new BusinessException(
					"Cannot copy lines. No source invoice specified.");
		}
		List<PurchaseInvoiceItem> targetItems = new ArrayList<PurchaseInvoiceItem>();
		List<PurchaseInvoiceItem> sourceItems = this
				.getPurchaseInvoiceItemService().findByPurchaseInvoiceId(
						source.getId());

		for (PurchaseInvoiceItem si : sourceItems) {
			PurchaseInvoiceItem ti = new PurchaseInvoiceItem();
			ti.setPurchaseInvoice(target);
			ti.setEntryMode(si.getEntryMode());
			ti.setLineAmount(si.getLineAmount());
			ti.setNetAmount(si.getNetAmount());
			ti.setUnitPrice(si.getUnitPrice());
			ti.setQuantity(si.getQuantity());
			ti.setUom(si.getUom());
			ti.setUseGivenTax(si.getUseGivenTax());
			ti.setProduct(si.getProduct());
			ti.setTax(si.getTax());
			targetItems.add(ti);
		}

		this.getPurchaseInvoiceItemService().insert(targetItems);
	}

	/**
	 * Get the purchase invoice items service
	 * 
	 * @return
	 * @throws BusinessException
	 */
	protected IPurchaseInvoiceItemService getPurchaseInvoiceItemService()
			throws BusinessException {

		if (this.itemService == null) {
			this.itemService = (IPurchaseInvoiceItemService) this
					.findEntityService(PurchaseInvoiceItem.class);
		}
		return this.itemService;
	}

	/**
	 * Get the purchase invoice service
	 * 
	 * @return
	 * @throws BusinessException
	 */
	protected IPurchaseInvoiceService getPurchaseInvoiceService()
			throws BusinessException {

		if (this.service == null) {
			this.service = (IPurchaseInvoiceService) this
					.findEntityService(PurchaseInvoice.class);
		}
		return this.service;
	}

}
