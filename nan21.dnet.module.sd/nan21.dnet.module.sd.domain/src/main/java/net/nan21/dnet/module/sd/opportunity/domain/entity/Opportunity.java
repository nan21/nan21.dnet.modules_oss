/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = Opportunity.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class Opportunity extends AbstractType {

	public static final String TABLE_NAME = "SD_OPORT";
	public static final String SEQUENCE_NAME = "SD_OPORT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "EXPECTEDAMOUNT", nullable = false, scale = 2)
	@NotNull
	private Float expectedAmount;

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPECTEDCLOSEDATE", nullable = false)
	@NotNull
	private Date expectedCloseDate;

	@Column(name = "CAMPAIGN", length = 255)
	private String campaign;

	@Column(name = "PROBABILITY", scale = 2)
	private Float probability;

	@Column(name = "RESULTNOTE", length = 4000)
	private String resultNote;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
	@JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
	private BusinessPartner account;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
	@JoinColumn(name = "EXPECTEDCURRENCY_ID", referencedColumnName = "ID")
	private Currency expectedCurrency;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = OpportunityStage.class)
	@JoinColumn(name = "SALESSTAGE_ID", referencedColumnName = "ID")
	private OpportunityStage salesStage;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = OpportunityStatus.class)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
	private OpportunityStatus status;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = OpportunityPriority.class)
	@JoinColumn(name = "PRIORITY_ID", referencedColumnName = "ID")
	private OpportunityPriority priority;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = OpportunitySource.class)
	@JoinColumn(name = "LEADSOURCE_ID", referencedColumnName = "ID")
	private OpportunitySource leadSource;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = OpportunityResultReason.class)
	@JoinColumn(name = "RESULTREASON_ID", referencedColumnName = "ID")
	private OpportunityResultReason resultReason;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Assignable.class)
	@JoinColumn(name = "ASSIGNEDTO_ID", referencedColumnName = "ID")
	private Assignable assignedTo;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getExpectedAmount() {
		return this.expectedAmount;
	}

	public void setExpectedAmount(Float expectedAmount) {
		this.expectedAmount = expectedAmount;
	}

	public Date getExpectedCloseDate() {
		return this.expectedCloseDate;
	}

	public void setExpectedCloseDate(Date expectedCloseDate) {
		this.expectedCloseDate = expectedCloseDate;
	}

	public String getCampaign() {
		return this.campaign;
	}

	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	public Float getProbability() {
		return this.probability;
	}

	public void setProbability(Float probability) {
		this.probability = probability;
	}

	public String getResultNote() {
		return this.resultNote;
	}

	public void setResultNote(String resultNote) {
		this.resultNote = resultNote;
	}

	@Transient
	public String getBusinessObject() {
		return "Opportunity.";
	}

	public void setBusinessObject(String businessObject) {
	}

	public BusinessPartner getAccount() {
		return this.account;
	}

	public void setAccount(BusinessPartner account) {
		if (account != null) {
			this.__validate_client_context__(account.getClientId());
		}
		this.account = account;
	}

	public Currency getExpectedCurrency() {
		return this.expectedCurrency;
	}

	public void setExpectedCurrency(Currency expectedCurrency) {
		if (expectedCurrency != null) {
			this.__validate_client_context__(expectedCurrency.getClientId());
		}
		this.expectedCurrency = expectedCurrency;
	}

	public OpportunityStage getSalesStage() {
		return this.salesStage;
	}

	public void setSalesStage(OpportunityStage salesStage) {
		if (salesStage != null) {
			this.__validate_client_context__(salesStage.getClientId());
		}
		this.salesStage = salesStage;
	}

	public OpportunityStatus getStatus() {
		return this.status;
	}

	public void setStatus(OpportunityStatus status) {
		if (status != null) {
			this.__validate_client_context__(status.getClientId());
		}
		this.status = status;
	}

	public OpportunityPriority getPriority() {
		return this.priority;
	}

	public void setPriority(OpportunityPriority priority) {
		if (priority != null) {
			this.__validate_client_context__(priority.getClientId());
		}
		this.priority = priority;
	}

	public OpportunitySource getLeadSource() {
		return this.leadSource;
	}

	public void setLeadSource(OpportunitySource leadSource) {
		if (leadSource != null) {
			this.__validate_client_context__(leadSource.getClientId());
		}
		this.leadSource = leadSource;
	}

	public OpportunityResultReason getResultReason() {
		return this.resultReason;
	}

	public void setResultReason(OpportunityResultReason resultReason) {
		if (resultReason != null) {
			this.__validate_client_context__(resultReason.getClientId());
		}
		this.resultReason = resultReason;
	}

	public Assignable getAssignedTo() {
		return this.assignedTo;
	}

	public void setAssignedTo(Assignable assignedTo) {
		if (assignedTo != null) {
			this.__validate_client_context__(assignedTo.getClientId());
		}
		this.assignedTo = assignedTo;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
