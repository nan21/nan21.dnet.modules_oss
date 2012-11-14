/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.order.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderItemTaxService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

/**
 * Repository functionality for {@link SalesOrderItemTax} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SalesOrderItemTaxService
		extends
			AbstractEntityService<SalesOrderItemTax>
		implements
			ISalesOrderItemTaxService {

	public SalesOrderItemTaxService() {
		super();
	}

	public SalesOrderItemTaxService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SalesOrderItemTax> getEntityClass() {
		return SalesOrderItemTax.class;
	}

	/**
	 * Find by reference: salesOrderItem
	 */
	public List<SalesOrderItemTax> findBySalesOrderItem(
			SalesOrderItem salesOrderItem) {
		return this.findBySalesOrderItemId(salesOrderItem.getId());
	}

	/**
	 * Find by ID of reference: salesOrderItem.id
	 */
	public List<SalesOrderItemTax> findBySalesOrderItemId(Long salesOrderItemId) {
		return (List<SalesOrderItemTax>) this.em
				.createQuery(
						"select e from SalesOrderItemTax e where e.clientId = :pClientId and e.salesOrderItem.id = :pSalesOrderItemId",
						SalesOrderItemTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSalesOrderItemId", salesOrderItemId)
				.getResultList();
	}

	/**
	 * Find by reference: tax
	 */
	public List<SalesOrderItemTax> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<SalesOrderItemTax> findByTaxId(Long taxId) {
		return (List<SalesOrderItemTax>) this.em
				.createQuery(
						"select e from SalesOrderItemTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						SalesOrderItemTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}
}
