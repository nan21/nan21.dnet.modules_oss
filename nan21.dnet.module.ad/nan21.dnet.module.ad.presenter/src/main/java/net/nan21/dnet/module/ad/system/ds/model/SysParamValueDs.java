/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysParamValue;

@Ds(entity = SysParamValue.class, sort = {@SortField(field = SysParamValueDs.f_validFrom, desc = true)})
public class SysParamValueDs extends AbstractAuditableDs<SysParamValue> {

	public static final String f_sysParam = "sysParam";
	public static final String f_validFrom = "validFrom";
	public static final String f_validTo = "validTo";
	public static final String f_value = "value";

	@DsField
	private String sysParam;

	@DsField
	private Date validFrom;

	@DsField
	private Date validTo;

	@DsField
	private String value;

	public SysParamValueDs() {
		super();
	}

	public SysParamValueDs(SysParamValue e) {
		super(e);
	}

	public String getSysParam() {
		return this.sysParam;
	}

	public void setSysParam(String sysParam) {
		this.sysParam = sysParam;
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
