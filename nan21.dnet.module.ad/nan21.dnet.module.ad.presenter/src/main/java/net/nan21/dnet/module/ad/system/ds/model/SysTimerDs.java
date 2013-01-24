/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;
import net.nan21.dnet.module.ad.system.domain.entity.SysTimer;

@Ds(entity = SysTimer.class, sort = {@SortField(field = SysTimerDs.f_name)})
@RefLookups({@RefLookup(refId = SysTimerDs.f_jobCtxId, namedQuery = SysJobCtx.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = SysTimerDs.f_jobCtx)})})
public class SysTimerDs extends AbstractTypeDs<SysTimer> {

	public static final String f_jobCtxId = "jobCtxId";
	public static final String f_jobCtx = "jobCtx";
	public static final String f_startTime = "startTime";
	public static final String f_endTime = "endTime";
	public static final String f_type = "type";
	public static final String f_cronExpression = "cronExpression";
	public static final String f_repeatCount = "repeatCount";
	public static final String f_repeatInterval = "repeatInterval";
	public static final String f_repeatIntervalType = "repeatIntervalType";

	@DsField(join = "left", path = "jobCtx.id")
	private Long jobCtxId;

	@DsField(join = "left", path = "jobCtx.name")
	private String jobCtx;

	@DsField
	private Date startTime;

	@DsField
	private Date endTime;

	@DsField
	private String type;

	@DsField
	private String cronExpression;

	@DsField
	private Integer repeatCount;

	@DsField
	private Integer repeatInterval;

	@DsField
	private String repeatIntervalType;

	public SysTimerDs() {
		super();
	}

	public SysTimerDs(SysTimer e) {
		super(e);
	}

	public Long getJobCtxId() {
		return this.jobCtxId;
	}

	public void setJobCtxId(Long jobCtxId) {
		this.jobCtxId = jobCtxId;
	}

	public String getJobCtx() {
		return this.jobCtx;
	}

	public void setJobCtx(String jobCtx) {
		this.jobCtx = jobCtx;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCronExpression() {
		return this.cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public Integer getRepeatCount() {
		return this.repeatCount;
	}

	public void setRepeatCount(Integer repeatCount) {
		this.repeatCount = repeatCount;
	}

	public Integer getRepeatInterval() {
		return this.repeatInterval;
	}

	public void setRepeatInterval(Integer repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	public String getRepeatIntervalType() {
		return this.repeatIntervalType;
	}

	public void setRepeatIntervalType(String repeatIntervalType) {
		this.repeatIntervalType = repeatIntervalType;
	}
}
