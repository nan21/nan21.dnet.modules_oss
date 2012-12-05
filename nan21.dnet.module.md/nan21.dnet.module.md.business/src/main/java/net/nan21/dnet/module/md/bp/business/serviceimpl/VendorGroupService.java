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
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.business.service.IVendorGroupService;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;

/**
 * Repository functionality for {@link VendorGroup} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class VendorGroupService extends AbstractEntityService<VendorGroup>
		implements
			IVendorGroupService {

	public VendorGroupService() {
		super();
	}

	public VendorGroupService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<VendorGroup> getEntityClass() {
		return VendorGroup.class;
	}

	/**
	 * Find by unique key
	 */
	public VendorGroup findByCode(String code) {
		return (VendorGroup) this.getEntityManager()
				.createNamedQuery(VendorGroup.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public VendorGroup findByName(String name) {
		return (VendorGroup) this.getEntityManager()
				.createNamedQuery(VendorGroup.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: paymentMethod
	 */
	public List<VendorGroup> findByPaymentMethod(PaymentMethod paymentMethod) {
		return this.findByPaymentMethodId(paymentMethod.getId());
	}

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<VendorGroup> findByPaymentMethodId(Long paymentMethodId) {
		return (List<VendorGroup>) this
				.getEntityManager()
				.createQuery(
						"select e from VendorGroup e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
						VendorGroup.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentMethodId", paymentMethodId)
				.getResultList();
	}

	/**
	 * Find by reference: paymentTerm
	 */
	public List<VendorGroup> findByPaymentTerm(PaymentTerm paymentTerm) {
		return this.findByPaymentTermId(paymentTerm.getId());
	}

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<VendorGroup> findByPaymentTermId(Long paymentTermId) {
		return (List<VendorGroup>) this
				.getEntityManager()
				.createQuery(
						"select e from VendorGroup e where e.clientId = :pClientId and e.paymentTerm.id = :pPaymentTermId",
						VendorGroup.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentTermId", paymentTermId).getResultList();
	}

	/**
	 * Find by reference: accounts
	 */
	public List<VendorGroup> findByAccounts(VendorGroupAcct accounts) {
		return this.findByAccountsId(accounts.getId());
	}

	/**
	 * Find by ID of reference: accounts.id
	 */
	public List<VendorGroup> findByAccountsId(Long accountsId) {
		return (List<VendorGroup>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from VendorGroup e, IN (e.accounts) c where e.clientId = :pClientId and c.id = :pAccountsId",
						VendorGroup.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccountsId", accountsId).getResultList();
	}
}
