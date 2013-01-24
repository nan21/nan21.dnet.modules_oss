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
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

@Ds(entity = Location.class)
@RefLookups({
		@RefLookup(refId = LocationDs.f_countryId, namedQuery = Country.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = LocationDs.f_countryCode)}),
		@RefLookup(refId = LocationDs.f_regionId, namedQuery = Region.NQ_FIND_BY_CODEANDCOUNTRY_PRIMITIVE, params = {
				@Param(name = "pCountryId", field = LocationDs.f_countryId),
				@Param(name = "pCode", field = LocationDs.f_regionCode)})})
public class LocationDs extends AbstractAuditableDs<Location> {

	public static final String f_regionName = "regionName";
	public static final String f_cityName = "cityName";
	public static final String f_adress = "adress";
	public static final String f_notes = "notes";
	public static final String f_active = "active";
	public static final String f_countryId = "countryId";
	public static final String f_countryCode = "countryCode";
	public static final String f_regionId = "regionId";
	public static final String f_regionCode = "regionCode";
	public static final String f_cityId = "cityId";
	public static final String f_shipping = "shipping";
	public static final String f_billing = "billing";
	public static final String f_mailing = "mailing";
	public static final String f_targetUuid = "targetUuid";
	public static final String f_targetType = "targetType";

	@DsField
	private String regionName;

	@DsField
	private String cityName;

	@DsField
	private String adress;

	@DsField
	private String notes;

	@DsField
	private Boolean active;

	@DsField(join = "left", path = "country.id")
	private Long countryId;

	@DsField(join = "left", path = "country.code")
	private String countryCode;

	@DsField(join = "left", path = "region.id")
	private Long regionId;

	@DsField(join = "left", path = "region.code")
	private String regionCode;

	@DsField(join = "left", path = "city.id")
	private Long cityId;

	@DsField(path = "forShipping")
	private Boolean shipping;

	@DsField(path = "forBilling")
	private Boolean billing;

	@DsField(path = "forMailing")
	private Boolean mailing;

	@DsField
	private String targetUuid;

	@DsField
	private String targetType;

	public LocationDs() {
		super();
	}

	public LocationDs(Location e) {
		super(e);
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Boolean getShipping() {
		return this.shipping;
	}

	public void setShipping(Boolean shipping) {
		this.shipping = shipping;
	}

	public Boolean getBilling() {
		return this.billing;
	}

	public void setBilling(Boolean billing) {
		this.billing = billing;
	}

	public Boolean getMailing() {
		return this.mailing;
	}

	public void setMailing(Boolean mailing) {
		this.mailing = mailing;
	}

	public String getTargetUuid() {
		return this.targetUuid;
	}

	public void setTargetUuid(String targetUuid) {
		this.targetUuid = targetUuid;
	}

	public String getTargetType() {
		return this.targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
}
