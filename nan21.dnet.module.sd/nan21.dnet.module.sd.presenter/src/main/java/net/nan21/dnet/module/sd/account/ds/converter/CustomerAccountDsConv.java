/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.account.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentMethodService;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentTermService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.business.service.ICustomerGroupService;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import net.nan21.dnet.module.sd.account.ds.model.CustomerAccountDs;

public class CustomerAccountDsConv
		extends
			AbstractDsConverter<CustomerAccountDs, BpAccount>
		implements
			IDsConverter<CustomerAccountDs, BpAccount> {

	@Override
	protected void modelToEntityReferences(CustomerAccountDs ds, BpAccount e,
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
		if (ds.getCustomerGroupId() != null) {
			if (e.getCustGroup() == null
					|| !e.getCustGroup().getId()
							.equals(ds.getCustomerGroupId())) {
				e.setCustGroup((CustomerGroup) this.em.find(
						CustomerGroup.class, ds.getCustomerGroupId()));
			}
		} else {
			this.lookup_custGroup_CustomerGroup(ds, e);
		}
		if (ds.getPaymentMethodId() != null) {
			if (e.getCustPaymentMethod() == null
					|| !e.getCustPaymentMethod().getId()
							.equals(ds.getPaymentMethodId())) {
				e.setCustPaymentMethod((PaymentMethod) this.em.find(
						PaymentMethod.class, ds.getPaymentMethodId()));
			}
		} else {
			this.lookup_custPaymentMethod_PaymentMethod(ds, e);
		}
		if (ds.getPaymentTermId() != null) {
			if (e.getCustPaymentTerm() == null
					|| !e.getCustPaymentTerm().getId()
							.equals(ds.getPaymentTermId())) {
				e.setCustPaymentTerm((PaymentTerm) this.em.find(
						PaymentTerm.class, ds.getPaymentTermId()));
			}
		} else {
			this.lookup_custPaymentTerm_PaymentTerm(ds, e);
		}
	}

	protected void lookup_bpartner_BusinessPartner(CustomerAccountDs ds,
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

	protected void lookup_org_Organization(CustomerAccountDs ds, BpAccount e)
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

	protected void lookup_custGroup_CustomerGroup(CustomerAccountDs ds,
			BpAccount e) throws Exception {
		if (ds.getCustomerGroup() != null && !ds.getCustomerGroup().equals("")) {
			CustomerGroup x = null;
			try {
				x = ((ICustomerGroupService) findEntityService(CustomerGroup.class))
						.findByCode(ds.getCustomerGroup());
			} catch (javax.persistence.NoResultException exception) {
				throw new Exception(
						"Invalid value provided to find `CustomerGroup` reference: `customerGroup` = "
								+ ds.getCustomerGroup() + "");
			}
			e.setCustGroup(x);
		} else {
			e.setCustGroup(null);
		}
	}

	protected void lookup_custPaymentMethod_PaymentMethod(CustomerAccountDs ds,
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
			e.setCustPaymentMethod(x);
		} else {
			e.setCustPaymentMethod(null);
		}
	}

	protected void lookup_custPaymentTerm_PaymentTerm(CustomerAccountDs ds,
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
			e.setCustPaymentTerm(x);
		} else {
			e.setCustPaymentTerm(null);
		}
	}
}
