/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.geo.domain.entity.City;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

@Ds(entity = City.class, sort = {@SortField(field = CityDs.f_name)})
@RefLookups({
		@RefLookup(refId = CityDs.f_countryId, namedQuery = Country.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = CityDs.f_countryCode)}),
		@RefLookup(refId = CityDs.f_regionId, namedQuery = Region.NQ_FIND_BY_CODEANDCOUNTRY_PRIMITIVE, params = {
				@Param(name = "pCountryId", field = CityDs.f_countryId),
				@Param(name = "pCode", field = CityDs.f_regionCode)})})
public class CityDs extends AbstractTypeDs<City> {

	public static final String f_countryId = "countryId";
	public static final String f_countryCode = "countryCode";
	public static final String f_regionId = "regionId";
	public static final String f_regionCode = "regionCode";

	@DsField(join = "left", path = "country.id")
	private Long countryId;

	@DsField(join = "left", path = "country.code")
	private String countryCode;

	@DsField(join = "left", path = "region.id")
	private Long regionId;

	@DsField(join = "left", path = "region.code")
	private String regionCode;

	public CityDs() {
		super();
	}

	public CityDs(City e) {
		super(e);
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Long getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
}
