/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.serviceext;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md._businessdelegates.bp.BpCustomerAcctBD;
import net.nan21.dnet.module.md._businessdelegates.bp.BpVendorAcctBD;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

/**
 * Business extensions specific for {@link BusinessPartner} domain entity.
 * 
 */
public class BusinessPartnerService extends
		net.nan21.dnet.module.md.bp.business.serviceimpl.BusinessPartnerService
		implements IBusinessPartnerService {

	@Override
	public String getPostingCustomerAcct(BusinessPartner businessPartner,
			Organization organization, AccSchema schema)
			throws BusinessException {
		return this.getBusinessDelegate(BpCustomerAcctBD.class).getPostingAcct(
				businessPartner, organization, schema);
	}

	@Override
	public String getPostingVendorAcct(BusinessPartner businessPartner,
			Organization organization, AccSchema schema)
			throws BusinessException {
		return this.getBusinessDelegate(BpVendorAcctBD.class).getPostingAcct(
				businessPartner, organization, schema);
	}

}
