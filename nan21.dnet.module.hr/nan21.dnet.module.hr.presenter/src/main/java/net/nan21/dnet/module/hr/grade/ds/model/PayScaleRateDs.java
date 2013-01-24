/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;

@Ds(entity = PayScaleRate.class, sort = {@SortField(field = PayScaleRateDs.f_name)})
@RefLookups({
		@RefLookup(refId = PayScaleRateDs.f_currencyId, namedQuery = Currency.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PayScaleRateDs.f_currencyCode)}),
		@RefLookup(refId = PayScaleRateDs.f_payScaleId, namedQuery = PayScale.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PayScaleRateDs.f_payScaleCode)})})
public class PayScaleRateDs extends AbstractTypeDs<PayScaleRate> {

	public static final String f_payScaleId = "payScaleId";
	public static final String f_payScaleCode = "payScaleCode";
	public static final String f_payScaleName = "payScaleName";
	public static final String f_currencyId = "currencyId";
	public static final String f_currencyCode = "currencyCode";

	@DsField(join = "left", path = "payScale.id")
	private Long payScaleId;

	@DsField(join = "left", path = "payScale.code")
	private String payScaleCode;

	@DsField(join = "left", path = "payScale.name")
	private String payScaleName;

	@DsField(join = "left", path = "currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currencyCode;

	public PayScaleRateDs() {
		super();
	}

	public PayScaleRateDs(PayScaleRate e) {
		super(e);
	}

	public Long getPayScaleId() {
		return this.payScaleId;
	}

	public void setPayScaleId(Long payScaleId) {
		this.payScaleId = payScaleId;
	}

	public String getPayScaleCode() {
		return this.payScaleCode;
	}

	public void setPayScaleCode(String payScaleCode) {
		this.payScaleCode = payScaleCode;
	}

	public String getPayScaleName() {
		return this.payScaleName;
	}

	public void setPayScaleName(String payScaleName) {
		this.payScaleName = payScaleName;
	}

	public Long getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
