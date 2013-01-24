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
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.business.service.ICustomerGroupService;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroupAcct;

/**
 * Repository functionality for {@link CustomerGroup} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CustomerGroupService extends AbstractEntityService<CustomerGroup>
		implements
			ICustomerGroupService {

	public CustomerGroupService() {
		super();
	}

	public CustomerGroupService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CustomerGroup> getEntityClass() {
		return CustomerGroup.class;
	}

	/**
	 * Find by unique key
	 */
	public CustomerGroup findByCode(String code) {
		return (CustomerGroup) this.getEntityManager()
				.createNamedQuery(CustomerGroup.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public CustomerGroup findByName(String name) {
		return (CustomerGroup) this.getEntityManager()
				.createNamedQuery(CustomerGroup.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: paymentMethod
	 */
	public List<CustomerGroup> findByPaymentMethod(PaymentMethod paymentMethod) {
		return this.findByPaymentMethodId(paymentMethod.getId());
	}

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<CustomerGroup> findByPaymentMethodId(Long paymentMethodId) {
		return (List<CustomerGroup>) this
				.getEntityManager()
				.createQuery(
						"select e from CustomerGroup e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
						CustomerGroup.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentMethodId", paymentMethodId)
				.getResultList();
	}

	/**
	 * Find by reference: paymentTerm
	 */
	public List<CustomerGroup> findByPaymentTerm(PaymentTerm paymentTerm) {
		return this.findByPaymentTermId(paymentTerm.getId());
	}

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<CustomerGroup> findByPaymentTermId(Long paymentTermId) {
		return (List<CustomerGroup>) this
				.getEntityManager()
				.createQuery(
						"select e from CustomerGroup e where e.clientId = :pClientId and e.paymentTerm.id = :pPaymentTermId",
						CustomerGroup.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentTermId", paymentTermId).getResultList();
	}

	/**
	 * Find by reference: accounts
	 */
	public List<CustomerGroup> findByAccounts(CustomerGroupAcct accounts) {
		return this.findByAccountsId(accounts.getId());
	}

	/**
	 * Find by ID of reference: accounts.id
	 */
	public List<CustomerGroup> findByAccountsId(Long accountsId) {
		return (List<CustomerGroup>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from CustomerGroup e, IN (e.accounts) c where e.clientId = :pClientId and c.id = :pAccountsId",
						CustomerGroup.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccountsId", accountsId).getResultList();
	}
}
