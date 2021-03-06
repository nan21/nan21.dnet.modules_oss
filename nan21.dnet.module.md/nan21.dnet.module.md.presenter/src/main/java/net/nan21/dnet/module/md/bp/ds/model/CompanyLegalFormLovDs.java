/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.md.bp.domain.entity.CompanyLegalForm;

@Ds(entity = CompanyLegalForm.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = CompanyLegalFormLovDs.f_name)})
public class CompanyLegalFormLovDs extends AbstractTypeLov<CompanyLegalForm> {

	public static final String f_countryId = "countryId";

	@DsField(join = "left", path = "country.id")
	private Long countryId;

	public CompanyLegalFormLovDs() {
		super();
	}

	public CompanyLegalFormLovDs(CompanyLegalForm e) {
		super(e);
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
}
