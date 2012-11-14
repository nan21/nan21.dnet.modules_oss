/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tax.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.base.tax.business.service.ITaxAcctService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.base.tax.domain.entity.TaxAcct;

/**
 * Repository functionality for {@link TaxAcct} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class TaxAcctService extends AbstractEntityService<TaxAcct>
		implements
			ITaxAcctService {

	public TaxAcctService() {
		super();
	}

	public TaxAcctService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<TaxAcct> getEntityClass() {
		return TaxAcct.class;
	}

	/**
	 * Find by unique key
	 */
	public TaxAcct findByTax_schema(Tax tax, AccSchema accSchema) {
		return (TaxAcct) this.em
				.createNamedQuery(TaxAcct.NQ_FIND_BY_TAX_SCHEMA)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTax", tax)
				.setParameter("pAccSchema", accSchema).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public TaxAcct findByTax_schema(Long taxId, Long accSchemaId) {
		return (TaxAcct) this.em
				.createNamedQuery(TaxAcct.NQ_FIND_BY_TAX_SCHEMA_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId)
				.setParameter("pAccSchemaId", accSchemaId).getSingleResult();
	}

	/**
	 * Find by reference: tax
	 */
	public List<TaxAcct> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<TaxAcct> findByTaxId(Long taxId) {
		return (List<TaxAcct>) this.em
				.createQuery(
						"select e from TaxAcct e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						TaxAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}

	/**
	 * Find by reference: accSchema
	 */
	public List<TaxAcct> findByAccSchema(AccSchema accSchema) {
		return this.findByAccSchemaId(accSchema.getId());
	}

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<TaxAcct> findByAccSchemaId(Long accSchemaId) {
		return (List<TaxAcct>) this.em
				.createQuery(
						"select e from TaxAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
						TaxAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccSchemaId", accSchemaId).getResultList();
	}

	/**
	 * Find by reference: salesAccount
	 */
	public List<TaxAcct> findBySalesAccount(Account salesAccount) {
		return this.findBySalesAccountId(salesAccount.getId());
	}

	/**
	 * Find by ID of reference: salesAccount.id
	 */
	public List<TaxAcct> findBySalesAccountId(Long salesAccountId) {
		return (List<TaxAcct>) this.em
				.createQuery(
						"select e from TaxAcct e where e.clientId = :pClientId and e.salesAccount.id = :pSalesAccountId",
						TaxAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSalesAccountId", salesAccountId)
				.getResultList();
	}

	/**
	 * Find by reference: purchaseAccount
	 */
	public List<TaxAcct> findByPurchaseAccount(Account purchaseAccount) {
		return this.findByPurchaseAccountId(purchaseAccount.getId());
	}

	/**
	 * Find by ID of reference: purchaseAccount.id
	 */
	public List<TaxAcct> findByPurchaseAccountId(Long purchaseAccountId) {
		return (List<TaxAcct>) this.em
				.createQuery(
						"select e from TaxAcct e where e.clientId = :pClientId and e.purchaseAccount.id = :pPurchaseAccountId",
						TaxAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPurchaseAccountId", purchaseAccountId)
				.getResultList();
	}

	/**
	 * Find by reference: nonDeductAccount
	 */
	public List<TaxAcct> findByNonDeductAccount(Account nonDeductAccount) {
		return this.findByNonDeductAccountId(nonDeductAccount.getId());
	}

	/**
	 * Find by ID of reference: nonDeductAccount.id
	 */
	public List<TaxAcct> findByNonDeductAccountId(Long nonDeductAccountId) {
		return (List<TaxAcct>) this.em
				.createQuery(
						"select e from TaxAcct e where e.clientId = :pClientId and e.nonDeductAccount.id = :pNonDeductAccountId",
						TaxAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pNonDeductAccountId", nonDeductAccountId)
				.getResultList();
	}
}
