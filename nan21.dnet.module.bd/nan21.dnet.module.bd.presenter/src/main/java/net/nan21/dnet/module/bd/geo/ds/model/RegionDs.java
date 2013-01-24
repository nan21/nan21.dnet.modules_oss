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
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

@Ds(entity = Region.class, sort = {@SortField(field = RegionDs.f_countryCode),
		@SortField(field = RegionDs.f_name)})
@RefLookups({@RefLookup(refId = RegionDs.f_countryId, namedQuery = Country.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = RegionDs.f_countryCode)})})
public class RegionDs extends AbstractTypeWithCodeDs<Region> {

	public static final String f_iso = "iso";
	public static final String f_countryId = "countryId";
	public static final String f_countryCode = "countryCode";

	@DsField
	private String iso;

	@DsField(join = "left", path = "country.id")
	private Long countryId;

	@DsField(join = "left", path = "country.code")
	private String countryCode;

	public RegionDs() {
		super();
	}

	public RegionDs(Region e) {
		super(e);
	}

	public String getIso() {
		return this.iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
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
}
