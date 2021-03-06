/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.report.domain.entity.DsReportParam;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

@Ds(entity = DsReportParam.class)
@RefLookups({
		@RefLookup(refId = DsReportParamDs.f_dsReportId),
		@RefLookup(refId = DsReportParamDs.f_paramId, namedQuery = ReportParam.NQ_FIND_BY_CODE_PRIMITIVE, params = {
				@Param(name = "pReportId", field = DsReportParamDs.f_reportId),
				@Param(name = "pCode", field = DsReportParamDs.f_paramCode)})})
public class DsReportParamDs extends AbstractAuditableDs<DsReportParam> {

	public static final String f_dsReportId = "dsReportId";
	public static final String f_reportId = "reportId";
	public static final String f_reportCode = "reportCode";
	public static final String f_paramId = "paramId";
	public static final String f_paramCode = "paramCode";
	public static final String f_paramName = "paramName";
	public static final String f_dataSource = "dataSource";
	public static final String f_dsField = "dsField";
	public static final String f_staticValue = "staticValue";

	@DsField(join = "left", path = "dsReport.id")
	private Long dsReportId;

	@DsField(join = "left", path = "dsReport.report.id")
	private Long reportId;

	@DsField(join = "left", path = "dsReport.report.code")
	private String reportCode;

	@DsField(join = "left", path = "reportParam.id")
	private Long paramId;

	@DsField(join = "left", path = "reportParam.code")
	private String paramCode;

	@DsField(join = "left", path = "reportParam.name")
	private String paramName;

	@DsField(join = "left", path = "dsReport.dataSource")
	private String dataSource;

	@DsField
	private String dsField;

	@DsField
	private String staticValue;

	public DsReportParamDs() {
		super();
	}

	public DsReportParamDs(DsReportParam e) {
		super(e);
	}

	public Long getDsReportId() {
		return this.dsReportId;
	}

	public void setDsReportId(Long dsReportId) {
		this.dsReportId = dsReportId;
	}

	public Long getReportId() {
		return this.reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public String getReportCode() {
		return this.reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public Long getParamId() {
		return this.paramId;
	}

	public void setParamId(Long paramId) {
		this.paramId = paramId;
	}

	public String getParamCode() {
		return this.paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getDsField() {
		return this.dsField;
	}

	public void setDsField(String dsField) {
		this.dsField = dsField;
	}

	public String getStaticValue() {
		return this.staticValue;
	}

	public void setStaticValue(String staticValue) {
		this.staticValue = staticValue;
	}
}
