/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.price.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;

@Ds(entity = PriceList.class, sort = {@SortField(field = PriceListDs.f_name)})
@RefLookups({@RefLookup(refId = PriceListDs.f_currencyId, namedQuery = Currency.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PriceListDs.f_currency)})})
public class PriceListDs extends AbstractTypeDs<PriceList> {

	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";
	public static final String f_salesList = "salesList";
	public static final String f_isDefault = "isDefault";

	@DsField(join = "left", path = "currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currency;

	@DsField
	private Boolean salesList;

	@DsField
	private Boolean isDefault;

	public PriceListDs() {
		super();
	}

	public PriceListDs(PriceList e) {
		super(e);
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

	public Boolean getSalesList() {
		return this.salesList;
	}

	public void setSalesList(Boolean salesList) {
		this.salesList = salesList;
	}

	public Boolean getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
}
