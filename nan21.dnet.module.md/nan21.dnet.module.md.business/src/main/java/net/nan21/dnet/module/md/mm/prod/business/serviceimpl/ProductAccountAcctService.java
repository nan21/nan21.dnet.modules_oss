/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountAcctService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountAcct;

/**
 * Repository functionality for {@link ProductAccountAcct} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductAccountAcctService
		extends
			AbstractEntityService<ProductAccountAcct>
		implements
			IProductAccountAcctService {

	public ProductAccountAcctService() {
		super();
	}

	public ProductAccountAcctService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProductAccountAcct> getEntityClass() {
		return ProductAccountAcct.class;
	}

	/**
	 * Find by unique key
	 */
	public ProductAccountAcct findByAccount_schema(ProductAccount prodAccount,
			AccSchema accSchema) {
		return (ProductAccountAcct) this.getEntityManager()
				.createNamedQuery(ProductAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProdAccount", prodAccount)
				.setParameter("pAccSchema", accSchema).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ProductAccountAcct findByAccount_schema(Long prodAccountId,
			Long accSchemaId) {
		return (ProductAccountAcct) this
				.getEntityManager()
				.createNamedQuery(
						ProductAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProdAccountId", prodAccountId)
				.setParameter("pAccSchemaId", accSchemaId).getSingleResult();
	}

	/**
	 * Find by reference: prodAccount
	 */
	public List<ProductAccountAcct> findByProdAccount(ProductAccount prodAccount) {
		return this.findByProdAccountId(prodAccount.getId());
	}

	/**
	 * Find by ID of reference: prodAccount.id
	 */
	public List<ProductAccountAcct> findByProdAccountId(Long prodAccountId) {
		return (List<ProductAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductAccountAcct e where e.clientId = :pClientId and e.prodAccount.id = :pProdAccountId",
						ProductAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProdAccountId", prodAccountId).getResultList();
	}

	/**
	 * Find by reference: accSchema
	 */
	public List<ProductAccountAcct> findByAccSchema(AccSchema accSchema) {
		return this.findByAccSchemaId(accSchema.getId());
	}

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<ProductAccountAcct> findByAccSchemaId(Long accSchemaId) {
		return (List<ProductAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductAccountAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
						ProductAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccSchemaId", accSchemaId).getResultList();
	}

	/**
	 * Find by reference: expenseAccount
	 */
	public List<ProductAccountAcct> findByExpenseAccount(Account expenseAccount) {
		return this.findByExpenseAccountId(expenseAccount.getId());
	}

	/**
	 * Find by ID of reference: expenseAccount.id
	 */
	public List<ProductAccountAcct> findByExpenseAccountId(Long expenseAccountId) {
		return (List<ProductAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductAccountAcct e where e.clientId = :pClientId and e.expenseAccount.id = :pExpenseAccountId",
						ProductAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pExpenseAccountId", expenseAccountId)
				.getResultList();
	}

	/**
	 * Find by reference: revenueAccount
	 */
	public List<ProductAccountAcct> findByRevenueAccount(Account revenueAccount) {
		return this.findByRevenueAccountId(revenueAccount.getId());
	}

	/**
	 * Find by ID of reference: revenueAccount.id
	 */
	public List<ProductAccountAcct> findByRevenueAccountId(Long revenueAccountId) {
		return (List<ProductAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductAccountAcct e where e.clientId = :pClientId and e.revenueAccount.id = :pRevenueAccountId",
						ProductAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRevenueAccountId", revenueAccountId)
				.getResultList();
	}
}
