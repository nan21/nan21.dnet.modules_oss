/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.account.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentMethodService;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentTermService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.business.service.IVendorGroupService;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;
import net.nan21.dnet.module.sc.account.ds.model.VendorAccountDs;

public class VendorAccountDsConv
		extends
			AbstractDsConverter<VendorAccountDs, BpAccount>
		implements
			IDsConverter<VendorAccountDs, BpAccount> {

	@Override
	protected void modelToEntityReferences(VendorAccountDs ds, BpAccount e,
			boolean isInsert) throws Exception {
		if (ds.getBusinessPartnerId() != null) {
			if (e.getBpartner() == null
					|| !e.getBpartner().getId()
							.equals(ds.getBusinessPartnerId())) {
				e.setBpartner((BusinessPartner) this.em.find(
						BusinessPartner.class, ds.getBusinessPartnerId()));
			}
		} else {
			this.lookup_bpartner_BusinessPartner(ds, e);
		}
		if (ds.getOrgId() != null) {
			if (e.getOrg() == null || !e.getOrg().getId().equals(ds.getOrgId())) {
				e.setOrg((Organization) this.em.find(Organization.class,
						ds.getOrgId()));
			}
		} else {
			this.lookup_org_Organization(ds, e);
		}
		if (ds.getVendorGroupId() != null) {
			if (e.getVendGroup() == null
					|| !e.getVendGroup().getId().equals(ds.getVendorGroupId())) {
				e.setVendGroup((VendorGroup) this.em.find(VendorGroup.class,
						ds.getVendorGroupId()));
			}
		} else {
			this.lookup_vendGroup_VendorGroup(ds, e);
		}
		if (ds.getPaymentMethodId() != null) {
			if (e.getVendPaymentMethod() == null
					|| !e.getVendPaymentMethod().getId()
							.equals(ds.getPaymentMethodId())) {
				e.setVendPaymentMethod((PaymentMethod) this.em.find(
						PaymentMethod.class, ds.getPaymentMethodId()));
			}
		} else {
			this.lookup_vendPaymentMethod_PaymentMethod(ds, e);
		}
		if (ds.getPaymentTermId() != null) {
			if (e.getVendPaymentTerm() == null
					|| !e.getVendPaymentTerm().getId()
							.equals(ds.getPaymentTermId())) {
				e.setVendPaymentTerm((PaymentTerm) this.em.find(
						PaymentTerm.class, ds.getPaymentTermId()));
			}
		} else {
			this.lookup_vendPaymentTerm_PaymentTerm(ds, e);
		}
	}

	protected void lookup_bpartner_BusinessPartner(VendorAccountDs ds,
			BpAccount e) throws Exception {
		if (ds.getBusinessPartnerCode() != null
				&& !ds.getBusinessPartnerCode().equals("")) {
			BusinessPartner x = null;
			try {
				x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
						.findByCode(ds.getBusinessPartnerCode());
			} catch (javax.persistence.NoResultException exception) {
				throw new Exception(
						"Invalid value provided to find `BusinessPartner` reference: `businessPartnerCode` = "
								+ ds.getBusinessPartnerCode() + "");
			}
			e.setBpartner(x);
		} else {
			e.setBpartner(null);
		}
	}

	protected void lookup_org_Organization(VendorAccountDs ds, BpAccount e)
			throws Exception {
		if (ds.getOrg() != null && !ds.getOrg().equals("")) {
			Organization x = null;
			try {
				x = ((IOrganizationService) findEntityService(Organization.class))
						.findByCode(ds.getOrg());
			} catch (javax.persistence.NoResultException exception) {
				throw new Exception(
						"Invalid value provided to find `Organization` reference: `org` = "
								+ ds.getOrg() + "");
			}
			e.setOrg(x);
		} else {
			e.setOrg(null);
		}
	}

	protected void lookup_vendGroup_VendorGroup(VendorAccountDs ds, BpAccount e)
			throws Exception {
		if (ds.getVendorGroup() != null && !ds.getVendorGroup().equals("")) {
			VendorGroup x = null;
			try {
				x = ((IVendorGroupService) findEntityService(VendorGroup.class))
						.findByCode(ds.getVendorGroup());
			} catch (javax.persistence.NoResultException exception) {
				throw new Exception(
						"Invalid value provided to find `VendorGroup` reference: `vendorGroup` = "
								+ ds.getVendorGroup() + "");
			}
			e.setVendGroup(x);
		} else {
			e.setVendGroup(null);
		}
	}

	protected void lookup_vendPaymentMethod_PaymentMethod(VendorAccountDs ds,
			BpAccount e) throws Exception {
		if (ds.getPaymentMethod() != null && !ds.getPaymentMethod().equals("")) {
			PaymentMethod x = null;
			try {
				x = ((IPaymentMethodService) findEntityService(PaymentMethod.class))
						.findByName(ds.getPaymentMethod());
			} catch (javax.persistence.NoResultException exception) {
				throw new Exception(
						"Invalid value provided to find `PaymentMethod` reference: `paymentMethod` = "
								+ ds.getPaymentMethod() + "");
			}
			e.setVendPaymentMethod(x);
		} else {
			e.setVendPaymentMethod(null);
		}
	}

	protected void lookup_vendPaymentTerm_PaymentTerm(VendorAccountDs ds,
			BpAccount e) throws Exception {
		if (ds.getPaymentTerm() != null && !ds.getPaymentTerm().equals("")) {
			PaymentTerm x = null;
			try {
				x = ((IPaymentTermService) findEntityService(PaymentTerm.class))
						.findByName(ds.getPaymentTerm());
			} catch (javax.persistence.NoResultException exception) {
				throw new Exception(
						"Invalid value provided to find `PaymentTerm` reference: `paymentTerm` = "
								+ ds.getPaymentTerm() + "");
			}
			e.setVendPaymentTerm(x);
		} else {
			e.setVendPaymentTerm(null);
		}
	}
}
