/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.business.service.ICustomerGroupAcctService;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroupAcct;

/**
 * Repository functionality for {@link CustomerGroupAcct} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CustomerGroupAcctService
		extends
			AbstractEntityService<CustomerGroupAcct>
		implements
			ICustomerGroupAcctService {

	public CustomerGroupAcctService() {
		super();
	}

	public CustomerGroupAcctService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<CustomerGroupAcct> getEntityClass() {
		return CustomerGroupAcct.class;
	}

	/**
	 * Find by unique key
	 */
	public CustomerGroupAcct findByGroup_schema(CustomerGroup custGroup,
			AccSchema accSchema) {
		return (CustomerGroupAcct) this.em
				.createNamedQuery(CustomerGroupAcct.NQ_FIND_BY_GROUP_SCHEMA)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustGroup", custGroup)
				.setParameter("pAccSchema", accSchema).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public CustomerGroupAcct findByGroup_schema(Long custGroupId,
			Long accSchemaId) {
		return (CustomerGroupAcct) this.em
				.createNamedQuery(
						CustomerGroupAcct.NQ_FIND_BY_GROUP_SCHEMA_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustGroupId", custGroupId)
				.setParameter("pAccSchemaId", accSchemaId).getSingleResult();
	}

	/**
	 * Find by reference: custGroup
	 */
	public List<CustomerGroupAcct> findByCustGroup(CustomerGroup custGroup) {
		return this.findByCustGroupId(custGroup.getId());
	}

	/**
	 * Find by ID of reference: custGroup.id
	 */
	public List<CustomerGroupAcct> findByCustGroupId(Long custGroupId) {
		return (List<CustomerGroupAcct>) this.em
				.createQuery(
						"select e from CustomerGroupAcct e where e.clientId = :pClientId and e.custGroup.id = :pCustGroupId",
						CustomerGroupAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustGroupId", custGroupId).getResultList();
	}

	/**
	 * Find by reference: accSchema
	 */
	public List<CustomerGroupAcct> findByAccSchema(AccSchema accSchema) {
		return this.findByAccSchemaId(accSchema.getId());
	}

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<CustomerGroupAcct> findByAccSchemaId(Long accSchemaId) {
		return (List<CustomerGroupAcct>) this.em
				.createQuery(
						"select e from CustomerGroupAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
						CustomerGroupAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccSchemaId", accSchemaId).getResultList();
	}

	/**
	 * Find by reference: salesAccount
	 */
	public List<CustomerGroupAcct> findBySalesAccount(Account salesAccount) {
		return this.findBySalesAccountId(salesAccount.getId());
	}

	/**
	 * Find by ID of reference: salesAccount.id
	 */
	public List<CustomerGroupAcct> findBySalesAccountId(Long salesAccountId) {
		return (List<CustomerGroupAcct>) this.em
				.createQuery(
						"select e from CustomerGroupAcct e where e.clientId = :pClientId and e.salesAccount.id = :pSalesAccountId",
						CustomerGroupAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSalesAccountId", salesAccountId)
				.getResultList();
	}

	/**
	 * Find by reference: prepayAccount
	 */
	public List<CustomerGroupAcct> findByPrepayAccount(Account prepayAccount) {
		return this.findByPrepayAccountId(prepayAccount.getId());
	}

	/**
	 * Find by ID of reference: prepayAccount.id
	 */
	public List<CustomerGroupAcct> findByPrepayAccountId(Long prepayAccountId) {
		return (List<CustomerGroupAcct>) this.em
				.createQuery(
						"select e from CustomerGroupAcct e where e.clientId = :pClientId and e.prepayAccount.id = :pPrepayAccountId",
						CustomerGroupAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPrepayAccountId", prepayAccountId)
				.getResultList();
	}
}
