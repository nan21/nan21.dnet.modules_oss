/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.sd.opportunity.domain.entity.Opportunity;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;

@Ds(entity = Opportunity.class, sort = {@SortField(field = OpportunityDs.f_name)})
@RefLookups({
		@RefLookup(refId = OpportunityDs.f_accountId),
		@RefLookup(refId = OpportunityDs.f_statusId, namedQuery = OpportunityStatus.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = OpportunityDs.f_status)}),
		@RefLookup(refId = OpportunityDs.f_priorityId, namedQuery = OpportunityPriority.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = OpportunityDs.f_priority)}),
		@RefLookup(refId = OpportunityDs.f_currencyId, namedQuery = Currency.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = OpportunityDs.f_currency)}),
		@RefLookup(refId = OpportunityDs.f_salesStageId, namedQuery = OpportunityStage.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = OpportunityDs.f_salesStage)}),
		@RefLookup(refId = OpportunityDs.f_leadSourceId, namedQuery = OpportunitySource.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = OpportunityDs.f_leadSource)}),
		@RefLookup(refId = OpportunityDs.f_resultReasonId, namedQuery = OpportunityResultReason.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = OpportunityDs.f_resultReason)}),
		@RefLookup(refId = OpportunityDs.f_assignedToId)})
public class OpportunityDs extends AbstractTypeDs<Opportunity> {

	public static final String f_accountId = "accountId";
	public static final String f_account = "account";
	public static final String f_closeDate = "closeDate";
	public static final String f_probability = "probability";
	public static final String f_amount = "amount";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";
	public static final String f_statusId = "statusId";
	public static final String f_status = "status";
	public static final String f_priorityId = "priorityId";
	public static final String f_priority = "priority";
	public static final String f_salesStageId = "salesStageId";
	public static final String f_salesStage = "salesStage";
	public static final String f_leadSourceId = "leadSourceId";
	public static final String f_leadSource = "leadSource";
	public static final String f_campaign = "campaign";
	public static final String f_resultReasonId = "resultReasonId";
	public static final String f_resultReason = "resultReason";
	public static final String f_resultNote = "resultNote";
	public static final String f_assignedToId = "assignedToId";
	public static final String f_assignedTo = "assignedTo";
	public static final String f_className = "className";
	public static final String f_businessObject = "businessObject";

	@DsField(join = "left", path = "account.id")
	private Long accountId;

	@DsField(join = "left", path = "account.name")
	private String account;

	@DsField(path = "expectedCloseDate")
	private Date closeDate;

	@DsField
	private Float probability;

	@DsField(path = "expectedAmount")
	private Float amount;

	@DsField(join = "left", path = "expectedCurrency.id")
	private Long currencyId;

	@DsField(join = "left", path = "expectedCurrency.code")
	private String currency;

	@DsField(join = "left", path = "status.id")
	private Long statusId;

	@DsField(join = "left", path = "status.name")
	private String status;

	@DsField(join = "left", path = "priority.id")
	private Long priorityId;

	@DsField(join = "left", path = "priority.name")
	private String priority;

	@DsField(join = "left", path = "salesStage.id")
	private Long salesStageId;

	@DsField(join = "left", path = "salesStage.name")
	private String salesStage;

	@DsField(join = "left", path = "leadSource.id")
	private Long leadSourceId;

	@DsField(join = "left", path = "leadSource.name")
	private String leadSource;

	@DsField
	private String campaign;

	@DsField(join = "left", path = "resultReason.id")
	private Long resultReasonId;

	@DsField(join = "left", path = "resultReason.name")
	private String resultReason;

	@DsField
	private String resultNote;

	@DsField(join = "left", path = "assignedTo.id")
	private Long assignedToId;

	@DsField(join = "left", path = "assignedTo.name")
	private String assignedTo;

	@DsField(fetch = false)
	private String className;

	@DsField(fetch = false)
	private String businessObject;

	public OpportunityDs() {
		super();
	}

	public OpportunityDs(Opportunity e) {
		super(e);
	}

	public Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getCloseDate() {
		return this.closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Float getProbability() {
		return this.probability;
	}

	public void setProbability(Float probability) {
		this.probability = probability;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
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

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getPriorityId() {
		return this.priorityId;
	}

	public void setPriorityId(Long priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Long getSalesStageId() {
		return this.salesStageId;
	}

	public void setSalesStageId(Long salesStageId) {
		this.salesStageId = salesStageId;
	}

	public String getSalesStage() {
		return this.salesStage;
	}

	public void setSalesStage(String salesStage) {
		this.salesStage = salesStage;
	}

	public Long getLeadSourceId() {
		return this.leadSourceId;
	}

	public void setLeadSourceId(Long leadSourceId) {
		this.leadSourceId = leadSourceId;
	}

	public String getLeadSource() {
		return this.leadSource;
	}

	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}

	public String getCampaign() {
		return this.campaign;
	}

	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	public Long getResultReasonId() {
		return this.resultReasonId;
	}

	public void setResultReasonId(Long resultReasonId) {
		this.resultReasonId = resultReasonId;
	}

	public String getResultReason() {
		return this.resultReason;
	}

	public void setResultReason(String resultReason) {
		this.resultReason = resultReason;
	}

	public String getResultNote() {
		return this.resultNote;
	}

	public void setResultNote(String resultNote) {
		this.resultNote = resultNote;
	}

	public Long getAssignedToId() {
		return this.assignedToId;
	}

	public void setAssignedToId(Long assignedToId) {
		this.assignedToId = assignedToId;
	}

	public String getAssignedTo() {
		return this.assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getBusinessObject() {
		return this.businessObject;
	}

	public void setBusinessObject(String businessObject) {
		this.businessObject = businessObject;
	}
}
