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
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTaskInstanceHistory;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;
import net.nan21.dnet.core.api.util.Duration;

@NamedQueries({})
@Entity
@Table(name = ActTaskInstanceHistory.TABLE_NAME)
@Cache(type = CacheType.NONE)
@Customizer(DefaultEventHandler.class)
public class ActTaskInstanceHistory implements IModelWithId, Serializable {

	public static final String TABLE_NAME = "ACT_HI_TASKINST";
	public static final String SEQUENCE_NAME = "ACT_HI_TASKINST_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "ID_", nullable = false, length = 64)
	@NotBlank
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private String id;

	@Column(name = "TASK_DEF_KEY_", length = 255)
	private String taskDefinitionKey;

	@Column(name = "PROC_INST_ID_", length = 64)
	private String processInstanceId;

	@Column(name = "EXECUTION_ID_", length = 255)
	private String executionId;

	@Column(name = "NAME_", length = 255)
	private String name;

	@Column(name = "DESCRIPTION_", length = 4000)
	private String description;

	@Column(name = "OWNER_", length = 32)
	private String owner;

	@Column(name = "ASSIGNEE_", length = 32)
	private String assignee;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_TIME_", nullable = false)
	@NotNull
	private Date startTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_TIME_")
	private Date endTime;

	@Column(name = "DURATION_")
	private Long duration;

	@Column(name = "DELETE_REASON_", length = 255)
	private String deleteReason;

	@Column(name = "PRIORITY_")
	private Long priority;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DUE_DATE_")
	private Date dueDate;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ActProcessDefinition.class)
	@JoinColumn(name = "PROC_DEF_ID_", referencedColumnName = "ID_")
	private ActProcessDefinition processDefinition;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ActTaskInstanceHistory.class)
	@JoinColumn(name = "PARENT_TASK_ID_", referencedColumnName = "ID_")
	private ActTaskInstanceHistory parent;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskDefinitionKey() {
		return this.taskDefinitionKey;
	}

	public void setTaskDefinitionKey(String taskDefinitionKey) {
		this.taskDefinitionKey = taskDefinitionKey;
	}

	public String getProcessInstanceId() {
		return this.processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getExecutionId() {
		return this.executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAssignee() {
		return this.assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
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

	public String getDeleteReason() {
		return this.deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public Long getPriority() {
		return this.priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public ActProcessDefinition getProcessDefinition() {
		return this.processDefinition;
	}

	public void setProcessDefinition(ActProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}

	public ActTaskInstanceHistory getParent() {
		return this.parent;
	}

	public void setParent(ActTaskInstanceHistory parent) {
		this.parent = parent;
	}

	public void aboutToInsert(DescriptorEvent event) {

	}

	public void aboutToUpdate(DescriptorEvent event) {
	}
}
