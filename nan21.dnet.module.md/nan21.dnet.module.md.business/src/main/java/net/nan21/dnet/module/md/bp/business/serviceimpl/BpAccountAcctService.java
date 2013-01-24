/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.business.service.IBpAccountAcctService;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccountAcct;

/**
 * Repository functionality for {@link BpAccountAcct} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BpAccountAcctService extends AbstractEntityService<BpAccountAcct>
		implements
			IBpAccountAcctService {

	public BpAccountAcctService() {
		super();
	}

	public BpAccountAcctService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<BpAccountAcct> getEntityClass() {
		return BpAccountAcct.class;
	}

	/**
	 * Find by unique key
	 */
	public BpAccountAcct findByAccount_schema(BpAccount bpAccount,
			AccSchema accSchema) {
		return (BpAccountAcct) this.getEntityManager()
				.createNamedQuery(BpAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpAccount", bpAccount)
				.setParameter("pAccSchema", accSchema).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public BpAccountAcct findByAccount_schema(Long bpAccountId, Long accSchemaId) {
		return (BpAccountAcct) this
				.getEntityManager()
				.createNamedQuery(
						BpAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpAccountId", bpAccountId)
				.setParameter("pAccSchemaId", accSchemaId).getSingleResult();
	}

	/**
	 * Find by reference: bpAccount
	 */
	public List<BpAccountAcct> findByBpAccount(BpAccount bpAccount) {
		return this.findByBpAccountId(bpAccount.getId());
	}

	/**
	 * Find by ID of reference: bpAccount.id
	 */
	public List<BpAccountAcct> findByBpAccountId(Long bpAccountId) {
		return (List<BpAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccountAcct e where e.clientId = :pClientId and e.bpAccount.id = :pBpAccountId",
						BpAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpAccountId", bpAccountId).getResultList();
	}

	/**
	 * Find by reference: accSchema
	 */
	public List<BpAccountAcct> findByAccSchema(AccSchema accSchema) {
		return this.findByAccSchemaId(accSchema.getId());
	}

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<BpAccountAcct> findByAccSchemaId(Long accSchemaId) {
		return (List<BpAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccountAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
						BpAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccSchemaId", accSchemaId).getResultList();
	}

	/**
	 * Find by reference: custSalesAccount
	 */
	public List<BpAccountAcct> findByCustSalesAccount(Account custSalesAccount) {
		return this.findByCustSalesAccountId(custSalesAccount.getId());
	}

	/**
	 * Find by ID of reference: custSalesAccount.id
	 */
	public List<BpAccountAcct> findByCustSalesAccountId(Long custSalesAccountId) {
		return (List<BpAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccountAcct e where e.clientId = :pClientId and e.custSalesAccount.id = :pCustSalesAccountId",
						BpAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustSalesAccountId", custSalesAccountId)
				.getResultList();
	}

	/**
	 * Find by reference: custPrepayAccount
	 */
	public List<BpAccountAcct> findByCustPrepayAccount(Account custPrepayAccount) {
		return this.findByCustPrepayAccountId(custPrepayAccount.getId());
	}

	/**
	 * Find by ID of reference: custPrepayAccount.id
	 */
	public List<BpAccountAcct> findByCustPrepayAccountId(
			Long custPrepayAccountId) {
		return (List<BpAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccountAcct e where e.clientId = :pClientId and e.custPrepayAccount.id = :pCustPrepayAccountId",
						BpAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustPrepayAccountId", custPrepayAccountId)
				.getResultList();
	}

	/**
	 * Find by reference: vendorPurchaseAccount
	 */
	public List<BpAccountAcct> findByVendorPurchaseAccount(
			Account vendorPurchaseAccount) {
		return this
				.findByVendorPurchaseAccountId(vendorPurchaseAccount.getId());
	}

	/**
	 * Find by ID of reference: vendorPurchaseAccount.id
	 */
	public List<BpAccountAcct> findByVendorPurchaseAccountId(
			Long vendorPurchaseAccountId) {
		return (List<BpAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccountAcct e where e.clientId = :pClientId and e.vendorPurchaseAccount.id = :pVendorPurchaseAccountId",
						BpAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pVendorPurchaseAccountId",
						vendorPurchaseAccountId).getResultList();
	}

	/**
	 * Find by reference: vendorPrepayAccount
	 */
	public List<BpAccountAcct> findByVendorPrepayAccount(
			Account vendorPrepayAccount) {
		return this.findByVendorPrepayAccountId(vendorPrepayAccount.getId());
	}

	/**
	 * Find by ID of reference: vendorPrepayAccount.id
	 */
	public List<BpAccountAcct> findByVendorPrepayAccountId(
			Long vendorPrepayAccountId) {
		return (List<BpAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccountAcct e where e.clientId = :pClientId and e.vendorPrepayAccount.id = :pVendorPrepayAccountId",
						BpAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pVendorPrepayAccountId", vendorPrepayAccountId)
				.getResultList();
	}
}
