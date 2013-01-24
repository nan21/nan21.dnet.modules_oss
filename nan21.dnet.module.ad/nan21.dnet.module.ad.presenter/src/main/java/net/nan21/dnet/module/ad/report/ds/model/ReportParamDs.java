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
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.ad.report.domain.entity.Report;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

@Ds(entity = ReportParam.class, sort = {@SortField(field = ReportParamDs.f_name)})
@RefLookups({@RefLookup(refId = ReportParamDs.f_reportId, namedQuery = Report.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ReportParamDs.f_reportCode)})})
public class ReportParamDs extends AbstractTypeWithCodeDs<ReportParam> {

	public static final String f_reportId = "reportId";
	public static final String f_reportCode = "reportCode";
	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_defaultValue = "defaultValue";
	public static final String f_dataType = "dataType";
	public static final String f_listOfValues = "listOfValues";
	public static final String f_noEdit = "noEdit";
	public static final String f_mandatory = "mandatory";

	@DsField(join = "left", path = "report.id")
	private Long reportId;

	@DsField(join = "left", path = "report.code")
	private String reportCode;

	@DsField
	private Integer sequenceNo;

	@DsField
	private String defaultValue;

	@DsField
	private String dataType;

	@DsField
	private String listOfValues;

	@DsField
	private Boolean noEdit;

	@DsField
	private Boolean mandatory;

	public ReportParamDs() {
		super();
	}

	public ReportParamDs(ReportParam e) {
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

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
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
}
