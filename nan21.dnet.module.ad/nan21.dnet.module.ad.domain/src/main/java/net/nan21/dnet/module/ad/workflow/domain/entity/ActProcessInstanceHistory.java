/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.io.Serializable;
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
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;
import net.nan21.dnet.core.api.util.Duration;

@NamedQueries({})
@Entity
@Table(name = ActProcessInstanceHistory.TABLE_NAME)
@Cache(type = CacheType.NONE)
@Customizer(DefaultEventHandler.class)
public class ActProcessInstanceHistory implements IModelWithId, Serializable {

	public static final String TABLE_NAME = "ACT_HI_PROCINST";
	public static final String SEQUENCE_NAME = "ACT_HI_PROCINST_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "ID_", nullable = false, length = 64)
	@NotBlank
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private String id;

	@Column(name = "PROC_INST_ID_", length = 64)
	private String processInstanceId;

	@Column(name = "BUSINESS_KEY_", length = 255)
	private String businessKey;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_TIME_", nullable = false)
	@NotNull
	private Date startTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_TIME_")
	private Date endTime;

	@Column(name = "DURATION_")
	private Long duration;

	@Column(name = "START_USER_ID_", length = 32)
	private String startedBy;

	@Column(name = "START_ACT_ID_", length = 255)
	private String startAction;

	@Column(name = "END_ACT_ID_", length = 255)
	private String endAction;

	@Column(name = "DELETE_REASON_", length = 4000)
	private String deleteReason;

	@Column(name = "SUPER_PROCESS_INSTANCE_ID_", length = 255)
	private String superProcInstanceId;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ActProcessDefinition.class)
	@JoinColumn(name = "PROC_DEF_ID_", referencedColumnName = "ID_")
	private ActProcessDefinition processDefinition;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProcessInstanceId() {
		return this.processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getBusinessKey() {
		return this.businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getDuration() {
		return this.duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	@Transient
	public String getDurationText() {
		return Duration.format(this.duration);
	}

	public void setDurationText(String durationText) {
	}

	public String getStartedBy() {
		return this.startedBy;
	}

	public void setStartedBy(String startedBy) {
		this.startedBy = startedBy;
	}

	public String getStartAction() {
		return this.startAction;
	}

	public void setStartAction(String startAction) {
		this.startAction = startAction;
	}

	public String getEndAction() {
		return this.endAction;
	}

	public void setEndAction(String endAction) {
		this.endAction = endAction;
	}

	public String getDeleteReason() {
		return this.deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public String getSuperProcInstanceId() {
		return this.superProcInstanceId;
	}

	public void setSuperProcInstanceId(String superProcInstanceId) {
		this.superProcInstanceId = superProcInstanceId;
	}

	@Transient
	public Long getVersion() {
		return 1L;
	}

	public void setVersion(Long version) {
	}

	public ActProcessDefinition getProcessDefinition() {
		return this.processDefinition;
	}

	public void setProcessDefinition(ActProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}

	public void aboutToInsert(DescriptorEvent event) {

	}

	public void aboutToUpdate(DescriptorEvent event) {
	}
}
