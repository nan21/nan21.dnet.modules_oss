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
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.business.service.IBpAccountService;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;

/**
 * Repository functionality for {@link BpAccount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BpAccountService extends AbstractEntityService<BpAccount>
		implements
			IBpAccountService {

	public BpAccountService() {
		super();
	}

	public BpAccountService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<BpAccount> getEntityClass() {
		return BpAccount.class;
	}

	/**
	 * Find by unique key
	 */
	public BpAccount findByBp_org(BusinessPartner bpartner, Organization org) {
		return (BpAccount) this.getEntityManager()
				.createNamedQuery(BpAccount.NQ_FIND_BY_BP_ORG)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpartner", bpartner).setParameter("pOrg", org)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public BpAccount findByBp_org(Long bpartnerId, Long orgId) {
		return (BpAccount) this.getEntityManager()
				.createNamedQuery(BpAccount.NQ_FIND_BY_BP_ORG_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpartnerId", bpartnerId)
				.setParameter("pOrgId", orgId).getSingleResult();
	}

	/**
	 * Find by reference: bpartner
	 */
	public List<BpAccount> findByBpartner(BusinessPartner bpartner) {
		return this.findByBpartnerId(bpartner.getId());
	}

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<BpAccount> findByBpartnerId(Long bpartnerId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
						BpAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpartnerId", bpartnerId).getResultList();
	}

	/**
	 * Find by reference: org
	 */
	public List<BpAccount> findByOrg(Organization org) {
		return this.findByOrgId(org.getId());
	}

	/**
	 * Find by ID of reference: org.id
	 */
	public List<BpAccount> findByOrgId(Long orgId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :pClientId and e.org.id = :pOrgId",
						BpAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrgId", orgId).getResultList();
	}

	/**
	 * Find by reference: custGroup
	 */
	public List<BpAccount> findByCustGroup(CustomerGroup custGroup) {
		return this.findByCustGroupId(custGroup.getId());
	}

	/**
	 * Find by ID of reference: custGroup.id
	 */
	public List<BpAccount> findByCustGroupId(Long custGroupId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :pClientId and e.custGroup.id = :pCustGroupId",
						BpAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustGroupId", custGroupId).getResultList();
	}

	/**
	 * Find by reference: custPaymentMethod
	 */
	public List<BpAccount> findByCustPaymentMethod(
			PaymentMethod custPaymentMethod) {
		return this.findByCustPaymentMethodId(custPaymentMethod.getId());
	}

	/**
	 * Find by ID of reference: custPaymentMethod.id
	 */
	public List<BpAccount> findByCustPaymentMethodId(Long custPaymentMethodId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :pClientId and e.custPaymentMethod.id = :pCustPaymentMethodId",
						BpAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustPaymentMethodId", custPaymentMethodId)
				.getResultList();
	}

	/**
	 * Find by reference: custPaymentTerm
	 */
	public List<BpAccount> findByCustPaymentTerm(PaymentTerm custPaymentTerm) {
		return this.findByCustPaymentTermId(custPaymentTerm.getId());
	}

	/**
	 * Find by ID of reference: custPaymentTerm.id
	 */
	public List<BpAccount> findByCustPaymentTermId(Long custPaymentTermId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :pClientId and e.custPaymentTerm.id = :pCustPaymentTermId",
						BpAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustPaymentTermId", custPaymentTermId)
				.getResultList();
	}

	/**
	 * Find by reference: custDeliveryMethod
	 */
	public List<BpAccount> findByCustDeliveryMethod(
			DeliveryMethod custDeliveryMethod) {
		return this.findByCustDeliveryMethodId(custDeliveryMethod.getId());
	}

	/**
	 * Find by ID of reference: custDeliveryMethod.id
	 */
	public List<BpAccount> findByCustDeliveryMethodId(Long custDeliveryMethodId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :pClientId and e.custDeliveryMethod.id = :pCustDeliveryMethodId",
						BpAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustDeliveryMethodId", custDeliveryMethodId)
				.getResultList();
	}

	/**
	 * Find by reference: vendGroup
	 */
	public List<BpAccount> findByVendGroup(VendorGroup vendGroup) {
		return this.findByVendGroupId(vendGroup.getId());
	}

	/**
	 * Find by ID of reference: vendGroup.id
	 */
	public List<BpAccount> findByVendGroupId(Long vendGroupId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :pClientId and e.vendGroup.id = :pVendGroupId",
						BpAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pVendGroupId", vendGroupId).getResultList();
	}

	/**
	 * Find by reference: vendPaymentMethod
	 */
	public List<BpAccount> findByVendPaymentMethod(
			PaymentMethod vendPaymentMethod) {
		return this.findByVendPaymentMethodId(vendPaymentMethod.getId());
	}

	/**
	 * Find by ID of reference: vendPaymentMethod.id
	 */
	public List<BpAccount> findByVendPaymentMethodId(Long vendPaymentMethodId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :pClientId and e.vendPaymentMethod.id = :pVendPaymentMethodId",
						BpAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pVendPaymentMethodId", vendPaymentMethodId)
				.getResultList();
	}

	/**
	 * Find by reference: vendPaymentTerm
	 */
	public List<BpAccount> findByVendPaymentTerm(PaymentTerm vendPaymentTerm) {
		return this.findByVendPaymentTermId(vendPaymentTerm.getId());
	}

	/**
	 * Find by ID of reference: vendPaymentTerm.id
	 */
	public List<BpAccount> findByVendPaymentTermId(Long vendPaymentTermId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :pClientId and e.vendPaymentTerm.id = :pVendPaymentTermId",
						BpAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pVendPaymentTermId", vendPaymentTermId)
				.getResultList();
	}
}
