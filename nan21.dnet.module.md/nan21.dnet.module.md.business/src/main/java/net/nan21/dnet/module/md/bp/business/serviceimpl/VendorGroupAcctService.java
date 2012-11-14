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
import net.nan21.dnet.module.md.bp.business.service.IVendorGroupAcctService;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;

/**
 * Repository functionality for {@link VendorGroupAcct} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class VendorGroupAcctService
		extends
			AbstractEntityService<VendorGroupAcct>
		implements
			IVendorGroupAcctService {

	public VendorGroupAcctService() {
		super();
	}

	public VendorGroupAcctService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<VendorGroupAcct> getEntityClass() {
		return VendorGroupAcct.class;
	}

	/**
	 * Find by unique key
	 */
	public VendorGroupAcct findByGroup_schema(VendorGroup vendorGroup,
			AccSchema accSchema) {
		return (VendorGroupAcct) this.em
				.createNamedQuery(VendorGroupAcct.NQ_FIND_BY_GROUP_SCHEMA)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pVendorGroup", vendorGroup)
				.setParameter("pAccSchema", accSchema).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public VendorGroupAcct findByGroup_schema(Long vendorGroupId,
			Long accSchemaId) {
		return (VendorGroupAcct) this.em
				.createNamedQuery(
						VendorGroupAcct.NQ_FIND_BY_GROUP_SCHEMA_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pVendorGroupId", vendorGroupId)
				.setParameter("pAccSchemaId", accSchemaId).getSingleResult();
	}

	/**
	 * Find by reference: vendorGroup
	 */
	public List<VendorGroupAcct> findByVendorGroup(VendorGroup vendorGroup) {
		return this.findByVendorGroupId(vendorGroup.getId());
	}

	/**
	 * Find by ID of reference: vendorGroup.id
	 */
	public List<VendorGroupAcct> findByVendorGroupId(Long vendorGroupId) {
		return (List<VendorGroupAcct>) this.em
				.createQuery(
						"select e from VendorGroupAcct e where e.clientId = :pClientId and e.vendorGroup.id = :pVendorGroupId",
						VendorGroupAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pVendorGroupId", vendorGroupId).getResultList();
	}

	/**
	 * Find by reference: accSchema
	 */
	public List<VendorGroupAcct> findByAccSchema(AccSchema accSchema) {
		return this.findByAccSchemaId(accSchema.getId());
	}

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<VendorGroupAcct> findByAccSchemaId(Long accSchemaId) {
		return (List<VendorGroupAcct>) this.em
				.createQuery(
						"select e from VendorGroupAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
						VendorGroupAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccSchemaId", accSchemaId).getResultList();
	}

	/**
	 * Find by reference: purchaseAccount
	 */
	public List<VendorGroupAcct> findByPurchaseAccount(Account purchaseAccount) {
		return this.findByPurchaseAccountId(purchaseAccount.getId());
	}

	/**
	 * Find by ID of reference: purchaseAccount.id
	 */
	public List<VendorGroupAcct> findByPurchaseAccountId(Long purchaseAccountId) {
		return (List<VendorGroupAcct>) this.em
				.createQuery(
						"select e from VendorGroupAcct e where e.clientId = :pClientId and e.purchaseAccount.id = :pPurchaseAccountId",
						VendorGroupAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPurchaseAccountId", purchaseAccountId)
				.getResultList();
	}

	/**
	 * Find by reference: prepayAccount
	 */
	public List<VendorGroupAcct> findByPrepayAccount(Account prepayAccount) {
		return this.findByPrepayAccountId(prepayAccount.getId());
	}

	/**
	 * Find by ID of reference: prepayAccount.id
	 */
	public List<VendorGroupAcct> findByPrepayAccountId(Long prepayAccountId) {
		return (List<VendorGroupAcct>) this.em
				.createQuery(
						"select e from VendorGroupAcct e where e.clientId = :pClientId and e.prepayAccount.id = :pPrepayAccountId",
						VendorGroupAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPrepayAccountId", prepayAccountId)
				.getResultList();
	}
}
