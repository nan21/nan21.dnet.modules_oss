package net.nan21.dnet.module.sd._businessdelegates.invoice;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceItemService;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;

public class SalesInvoiceCreateLines extends AbstractBusinessDelegate {

	ISalesInvoiceItemService itemService;
	ISalesInvoiceService service;

	/**
	 * Create lines for the target invoice by copying them from the source
	 * invoice with the given ID
	 * 
	 * @param target
	 * @param sourceCode
	 * @throws BusinessException
	 */
	public void copyLines(SalesInvoice target, Long sourceId)
			throws BusinessException {
		if (sourceId == null) {
			throw new BusinessException(
					"Cannot copy lines. No source invoice specified.");
		}
		SalesInvoice source = this.getSalesInvoiceService().findById(sourceId);
		copyLines(target, source);
	}

	/**
	 * Create lines for the target invoice by copying them from the source
	 * 
	 * @param target
	 * @param source
	 * @throws BusinessException
	 */
	public void copyLines(SalesInvoice target, SalesInvoice source)
			throws BusinessException {
		if (source == null) {
			throw new BusinessException(
					"Cannot copy lines. No source invoice specified.");
		}
		List<SalesInvoiceItem> targetItems = new ArrayList<SalesInvoiceItem>();
		List<SalesInvoiceItem> sourceItems = this.getSalesInvoiceItemService()
				.findBySalesInvoiceId(source.getId());

		for (SalesInvoiceItem si : sourceItems) {
			SalesInvoiceItem ti = new SalesInvoiceItem();
			ti.setSalesInvoice(target);

			ti.setLineAmount(si.getLineAmount());
			ti.setNetAmount(si.getNetAmount());
			ti.setUnitPrice(si.getUnitPrice());
			ti.setQuantity(si.getQuantity());
			ti.setUom(si.getUom());

			ti.setProduct(si.getProduct());
			ti.setTax(si.getTax());
			targetItems.add(ti);
		}

		this.getSalesInvoiceItemService().insert(targetItems);
	}

	/**
	 * Get the sales invoice items service
	 * 
	 * @return
	 * @throws BusinessException
	 */
	protected ISalesInvoiceItemService getSalesInvoiceItemService()
			throws BusinessException {

		if (this.itemService == null) {
			this.itemService = (ISalesInvoiceItemService) this
					.findEntityService(SalesInvoiceItem.class);
		}
		return this.itemService;
	}

	/**
	 * Get the sales invoice service
	 * 
	 * @return
	 * @throws BusinessException
	 */
	protected ISalesInvoiceService getSalesInvoiceService()
			throws BusinessException {

		if (this.service == null) {
			this.service = (ISalesInvoiceService) this
					.findEntityService(SalesInvoice.class);
		}
		return this.service;
	}

}
