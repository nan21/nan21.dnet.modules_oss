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
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderTaxService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderTax;

/**
 * Repository functionality for {@link SalesOrderTax} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SalesOrderTaxService extends AbstractEntityService<SalesOrderTax>
		implements
			ISalesOrderTaxService {

	public SalesOrderTaxService() {
		super();
	}

	public SalesOrderTaxService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SalesOrderTax> getEntityClass() {
		return SalesOrderTax.class;
	}

	/**
	 * Find by reference: salesOrder
	 */
	public List<SalesOrderTax> findBySalesOrder(SalesOrder salesOrder) {
		return this.findBySalesOrderId(salesOrder.getId());
	}

	/**
	 * Find by ID of reference: salesOrder.id
	 */
	public List<SalesOrderTax> findBySalesOrderId(Long salesOrderId) {
		return (List<SalesOrderTax>) this
				.getEntityManager()
				.createQuery(
						"select e from SalesOrderTax e where e.clientId = :pClientId and e.salesOrder.id = :pSalesOrderId",
						SalesOrderTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSalesOrderId", salesOrderId).getResultList();
	}

	/**
	 * Find by reference: tax
	 */
	public List<SalesOrderTax> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<SalesOrderTax> findByTaxId(Long taxId) {
		return (List<SalesOrderTax>) this
				.getEntityManager()
				.createQuery(
						"select e from SalesOrderTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						SalesOrderTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}
}
