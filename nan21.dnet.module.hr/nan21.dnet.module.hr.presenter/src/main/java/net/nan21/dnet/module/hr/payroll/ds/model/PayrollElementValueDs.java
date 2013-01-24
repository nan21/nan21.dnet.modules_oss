/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElementValue;

@Ds(entity = PayrollElementValue.class, jpqlWhere = " e.element.balance = false ", sort = {
		@SortField(field = PayrollElementValueDs.f_periodStart, desc = true),
		@SortField(field = PayrollElementValueDs.f_sequenceNo),
		@SortField(field = PayrollElementValueDs.f_employeeId)})
public class PayrollElementValueDs
		extends
			AbstractAuditableDs<PayrollElementValue> {

	public static final String f_elementId = "elementId";
	public static final String f_element = "element";
	public static final String f_elementName = "elementName";
	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_dataType = "dataType";
	public static final String f_calculation = "calculation";
	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_employeeId = "employeeId";
	public static final String f_employeeName = "employeeName";
	public static final String f_jobCode = "jobCode";
	public static final String f_positionCode = "positionCode";
	public static final String f_employerId = "employerId";
	public static final String f_employer = "employer";
	public static final String f_value = "value";
	public static final String f_periodId = "periodId";
	public static final String f_period = "period";
	public static final String f_periodStart = "periodStart";
	public static final String f_periodEnd = "periodEnd";

	@DsField(join = "left", path = "element.id")
	private Long elementId;

	@DsField(join = "left", path = "element.code")
	private String element;

	@DsField(join = "left", path = "element.name")
	private String elementName;

	@DsField(join = "left", path = "element.sequenceNo")
	private Integer sequenceNo;

	@DsField(join = "left", path = "element.dataType")
	private String dataType;

	@DsField(join = "left", path = "element.calculation")
	private String calculation;

	@DsField(join = "left", path = "element.type.id")
	private Long typeId;

	@DsField(join = "left", path = "element.type.name")
	private String type;

	@DsField(join = "left", path = "assignment.employee.id")
	private Long employeeId;

	@DsField(join = "left", orderBy = "lastName,firstName", fetch = false, path = "assignment.employee.name")
	private String employeeName;

	@DsField(join = "left", path = "assignment.job.code")
	private String jobCode;

	@DsField(join = "left", path = "assignment.position.code")
	private String positionCode;

	@DsField(join = "left", path = "org.id")
	private Long employerId;

	@DsField(join = "left", path = "org.code")
	private String employer;

	@DsField
	private String value;

	@DsField(join = "left", path = "period.id")
	private Long periodId;

	@DsField(join = "left", path = "period.name")
	private String period;

	@DsField(join = "left", path = "period.startDate")
	private Date periodStart;

	@DsField(join = "left", path = "period.endDate")
	private Date periodEnd;

	public PayrollElementValueDs() {
		super();
	}

	public PayrollElementValueDs(PayrollElementValue e) {
		super(e);
	}

	public Long getElementId() {
		return this.elementId;
	}

	public void setElementId(Long elementId) {
		this.elementId = elementId;
	}

	public String getElement() {
		return this.element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getElementName() {
		return this.elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getCalculation() {
		return this.calculation;
	}

	public void setCalculation(String calculation) {
		this.calculation = calculation;
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getJobCode() {
		return this.jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getPositionCode() {
		return this.positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public Long getEmployerId() {
		return this.employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public String getEmployer() {
		return this.employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getPeriodId() {
		return this.periodId;
	}

	public void setPeriodId(Long periodId) {
		this.periodId = periodId;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Date getPeriodStart() {
		return this.periodStart;
	}

	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}

	public Date getPeriodEnd() {
		return this.periodEnd;
	}

	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}
}
