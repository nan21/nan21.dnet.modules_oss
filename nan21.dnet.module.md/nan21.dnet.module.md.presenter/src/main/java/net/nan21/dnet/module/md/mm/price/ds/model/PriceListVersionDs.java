/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.price.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceListVersion;

@Ds(entity = PriceListVersion.class, sort = {@SortField(field = PriceListVersionDs.f_name)})
@RefLookups({@RefLookup(refId = PriceListVersionDs.f_priceListId, namedQuery = PriceList.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PriceListVersionDs.f_priceList)})})
public class PriceListVersionDs extends AbstractTypeDs<PriceListVersion> {

	public static final String f_priceListId = "priceListId";
	public static final String f_priceList = "priceList";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";
	public static final String f_validFrom = "validFrom";

	@DsField(join = "left", path = "priceList.id")
	private Long priceListId;

	@DsField(join = "left", path = "priceList.name")
	private String priceList;

	@DsField(join = "left", path = "priceList.currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "priceList.currency.code")
	private String currency;

	@DsField
	private Date validFrom;

	public PriceListVersionDs() {
		super();
	}

	public PriceListVersionDs(PriceListVersion e) {
		super(e);
	}

	public Long getPriceListId() {
		return this.priceListId;
	}

	public void setPriceListId(Long priceListId) {
		this.priceListId = priceListId;
	}

	public String getPriceList() {
		return this.priceList;
	}

	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}

	public Long getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
}
