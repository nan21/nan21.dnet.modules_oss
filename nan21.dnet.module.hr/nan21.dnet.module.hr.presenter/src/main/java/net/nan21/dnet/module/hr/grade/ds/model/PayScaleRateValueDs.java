/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRateValue;

@Ds(entity = PayScaleRateValue.class)
@RefLookups({
		@RefLookup(refId = PayScaleRateValueDs.f_scaleRateId),
		@RefLookup(refId = PayScaleRateValueDs.f_scalePointId, namedQuery = PayScalePoint.NQ_FIND_BY_SCALE_CODE_PRIMITIVE, params = {
				@Param(name = "pPayScaleId", field = PayScaleRateValueDs.f_scaleRateId),
				@Param(name = "pCode", field = PayScaleRateValueDs.f_scalePointCode)})})
public class PayScaleRateValueDs extends AbstractAuditableDs<PayScaleRateValue> {

	public static final String f_scaleRateId = "scaleRateId";
	public static final String f_scalePointId = "scalePointId";
	public static final String f_scalePointCode = "scalePointCode";
	public static final String f_value = "value";
	public static final String f_validFrom = "validFrom";
	public static final String f_validTo = "validTo";

	@DsField(join = "left", path = "scaleRate.id")
	private Long scaleRateId;

	@DsField(join = "left", path = "scalePoint.id")
	private Long scalePointId;

	@DsField(join = "left", path = "scalePoint.code")
	private String scalePointCode;

	@DsField
	private Float value;

	@DsField
	private Date validFrom;

	@DsField
	private Date validTo;

	public PayScaleRateValueDs() {
		super();
	}

	public PayScaleRateValueDs(PayScaleRateValue e) {
		super(e);
	}

	public Long getScaleRateId() {
		return this.scaleRateId;
	}

	public void setScaleRateId(Long scaleRateId) {
		this.scaleRateId = scaleRateId;
	}

	public Long getScalePointId() {
		return this.scalePointId;
	}

	public void setScalePointId(Long scalePointId) {
		this.scalePointId = scalePointId;
	}

	public String getScalePointCode() {
		return this.scalePointCode;
	}

	public void setScalePointCode(String scalePointCode) {
		this.scalePointCode = scalePointCode;
	}

	public Float getValue() {
		return this.value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
}
