/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.price.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;

@Ds(entity = PriceList.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = PriceListLovDs.f_name)})
public class PriceListLovDs extends AbstractTypeLov<PriceList> {

	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";

	@DsField(join = "left", path = "currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currency;

	public PriceListLovDs() {
		super();
	}

	public PriceListLovDs(PriceList e) {
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
}
