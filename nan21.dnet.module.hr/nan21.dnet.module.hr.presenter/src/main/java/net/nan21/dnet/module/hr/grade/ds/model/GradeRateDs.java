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
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;

@Ds(entity = GradeRate.class, sort = {@SortField(field = GradeRateDs.f_name)})
@RefLookups({@RefLookup(refId = GradeRateDs.f_currencyId, namedQuery = Currency.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = GradeRateDs.f_currencyCode)})})
public class GradeRateDs extends AbstractTypeDs<GradeRate> {

	public static final String f_currencyId = "currencyId";
	public static final String f_currencyCode = "currencyCode";

	@DsField(join = "left", path = "currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currencyCode;

	public GradeRateDs() {
		super();
	}

	public GradeRateDs(GradeRate e) {
		super(e);
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
