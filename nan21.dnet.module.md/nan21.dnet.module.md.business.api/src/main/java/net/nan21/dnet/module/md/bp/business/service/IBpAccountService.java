/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;

/**
 * Interface to expose business functions specific for {@link BpAccount} domain
 * entity.
 */
public interface IBpAccountService extends IEntityService<BpAccount> {

	/**
	 * Find by unique key
	 */
	public BpAccount findByBp_org(BusinessPartner bpartner, Organization org);

	/**
	 * Find by unique key
	 */
	public BpAccount findByBp_org(Long bpartnerId, Long orgId);

	/**
	 * Find by reference: bpartner
	 */
	public List<BpAccount> findByBpartner(BusinessPartner bpartner);

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<BpAccount> findByBpartnerId(Long bpartnerId);

	/**
	 * Find by reference: org
	 */
	public List<BpAccount> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<BpAccount> findByOrgId(Long orgId);

	/**
	 * Find by reference: custGroup
	 */
	public List<BpAccount> findByCustGroup(CustomerGroup custGroup);

	/**
	 * Find by ID of reference: custGroup.id
	 */
	public List<BpAccount> findByCustGroupId(Long custGroupId);

	/**
	 * Find by reference: custPaymentMethod
	 */
	public List<BpAccount> findByCustPaymentMethod(
			PaymentMethod custPaymentMethod);

	/**
	 * Find by ID of reference: custPaymentMethod.id
	 */
	public List<BpAccount> findByCustPaymentMethodId(Long custPaymentMethodId);

	/**
	 * Find by reference: custPaymentTerm
	 */
	public List<BpAccount> findByCustPaymentTerm(PaymentTerm custPaymentTerm);

	/**
	 * Find by ID of reference: custPaymentTerm.id
	 */
	public List<BpAccount> findByCustPaymentTermId(Long custPaymentTermId);

	/**
	 * Find by reference: custDeliveryMethod
	 */
	public List<BpAccount> findByCustDeliveryMethod(
			DeliveryMethod custDeliveryMethod);

	/**
	 * Find by ID of reference: custDeliveryMethod.id
	 */
	public List<BpAccount> findByCustDeliveryMethodId(Long custDeliveryMethodId);

	/**
	 * Find by reference: vendGroup
	 */
	public List<BpAccount> findByVendGroup(VendorGroup vendGroup);

	/**
	 * Find by ID of reference: vendGroup.id
	 */
	public List<BpAccount> findByVendGroupId(Long vendGroupId);

	/**
	 * Find by reference: vendPaymentMethod
	 */
	public List<BpAccount> findByVendPaymentMethod(
			PaymentMethod vendPaymentMethod);

	/**
	 * Find by ID of reference: vendPaymentMethod.id
	 */
	public List<BpAccount> findByVendPaymentMethodId(Long vendPaymentMethodId);

	/**
	 * Find by reference: vendPaymentTerm
	 */
	public List<BpAccount> findByVendPaymentTerm(PaymentTerm vendPaymentTerm);

	/**
	 * Find by ID of reference: vendPaymentTerm.id
	 */
	public List<BpAccount> findByVendPaymentTermId(Long vendPaymentTermId);
}
