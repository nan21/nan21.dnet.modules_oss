/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.md.bp.domain.entity.CompanyLegalForm;

@Ds(entity = CompanyLegalForm.class, sort = {@SortField(field = CompanyLegalFormDs.f_name)})
@RefLookups({@RefLookup(refId = CompanyLegalFormDs.f_countryId, namedQuery = Country.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = CompanyLegalFormDs.f_country)})})
public class CompanyLegalFormDs extends AbstractTypeDs<CompanyLegalForm> {

	public static final String f_countryId = "countryId";
	public static final String f_country = "country";

	@DsField(join = "left", path = "country.id")
	private Long countryId;

	@DsField(join = "left", path = "country.code")
	private String country;

	public CompanyLegalFormDs() {
		super();
	}

	public CompanyLegalFormDs(CompanyLegalForm e) {
		super(e);
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
