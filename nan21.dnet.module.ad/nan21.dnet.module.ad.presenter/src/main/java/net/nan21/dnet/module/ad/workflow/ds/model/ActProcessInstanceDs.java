/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractBaseDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessInstanceHistory;

@Ds(entity = ActProcessInstanceHistory.class, jpqlWhere = " e.endTime is null ", sort = {@SortField(field = ActProcessInstanceDs.f_startTime, desc = true)})
public class ActProcessInstanceDs
		extends
			AbstractBaseDs<ActProcessInstanceHistory> {

	public static final String f_id = "id";
	public static final String f_processInstanceId = "processInstanceId";
	public static final String f_processId = "processId";
	public static final String f_process = "process";
	public static final String f_processVersion = "processVersion";
	public static final String f_clientId = "clientId";
	public static final String f_startTime = "startTime";
	public static final String f_startedBy = "startedBy";
	public static final String f_startAction = "startAction";

	@DsField
	private String id;

	@DsField
	private String processInstanceId;

	@DsField(join = "left", path = "processDefinition.id")
	private String processId;

	@DsField(join = "left", path = "processDefinition.name")
	private String process;

	@DsField(join = "left", path = "processDefinition.procDefVersion")
	private Integer processVersion;

	@DsField(join = "left", path = "processDefinition.clientId")
	private Long clientId;

	@DsField
	private Date startTime;

	@DsField
	private String startedBy;

	@DsField
	private String startAction;

	public ActProcessInstanceDs() {
		super();
	}

	public ActProcessInstanceDs(ActProcessInstanceHistory e) {
		super(e);
	}

	public String getId() {
		return this.id;
	}

	public void setId(Object id) {
		this.id = (String) id;
	}

	public String getProcessInstanceId() {
		return this.processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getProcessId() {
		return this.processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getProcess() {
		return this.process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public Integer getProcessVersion() {
		return this.processVersion;
	}

	public void setProcessVersion(Integer processVersion) {
		this.processVersion = processVersion;
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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
}
