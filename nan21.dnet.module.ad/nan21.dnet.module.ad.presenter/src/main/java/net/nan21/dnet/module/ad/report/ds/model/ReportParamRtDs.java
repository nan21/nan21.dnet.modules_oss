/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

@Ds(entity = ReportParam.class, jpqlWhere = "  e.active = true  ", sort = {
		@SortField(field = ReportParamRtDs.f_sequenceNo),
		@SortField(field = ReportParamRtDs.f_name)})
public class ReportParamRtDs extends AbstractTypeWithCodeDs<ReportParam> {

	public static final String f_reportId = "reportId";
	public static final String f_reportCode = "reportCode";
	public static final String f_value = "value";
	public static final String f_dataType = "dataType";
	public static final String f_parameterName = "parameterName";
	public static final String f_listOfValues = "listOfValues";
	public static final String f_noEdit = "noEdit";
	public static final String f_mandatory = "mandatory";
	public static final String f_sequenceNo = "sequenceNo";

	@DsField(join = "left", path = "report.id")
	private Long reportId;

	@DsField(join = "left", path = "report.code")
	private String reportCode;

	@DsField(path = "defaultValue")
	private String value;

	@DsField
	private String dataType;

	@DsField(path = "name")
	private String parameterName;

	@DsField
	private String listOfValues;

	@DsField
	private Boolean noEdit;

	@DsField
	private Boolean mandatory;

	@DsField
	private Integer sequenceNo;

	public ReportParamRtDs() {
		super();
	}

	public ReportParamRtDs(ReportParam e) {
		super(e);
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getParameterName() {
		return this.parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getListOfValues() {
		return this.listOfValues;
	}

	public void setListOfValues(String listOfValues) {
		this.listOfValues = listOfValues;
	}

	public Boolean getNoEdit() {
		return this.noEdit;
	}

	public void setNoEdit(Boolean noEdit) {
		this.noEdit = noEdit;
	}

	public Boolean getMandatory() {
		return this.mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
}
