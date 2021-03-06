/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = QuartzSimpleTrigger.TABLE_NAME)
@ReadOnly
@Cache(type = CacheType.NONE)
@Customizer(DefaultEventHandler.class)
public class QuartzSimpleTrigger implements Serializable {

	public static final String TABLE_NAME = "XT_QRTZ_SIMPLE_TRIGGERS";
	public static final String SEQUENCE_NAME = "XT_QRTZ_SIMPLE_TRIGGERS_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "SCHED_NAME", nullable = false, length = 255)
	@NotBlank
	@Id
	private String schedulerName;

	@Column(name = "TRIGGER_NAME", nullable = false, length = 255)
	@NotBlank
	@Id
	private String triggerName;

	@Column(name = "TRIGGER_GROUP", nullable = false, length = 255)
	@NotBlank
	@Id
	private String triggerGroup;

	@Column(name = "REPEAT_COUNT", nullable = false)
	@NotNull
	private Integer repeatCount;

	@Column(name = "REPEAT_INTERVAL", nullable = false)
	@NotNull
	private Integer repeatInterval;

	@Column(name = "TIMES_TRIGGERED", nullable = false)
	@NotNull
	private Integer timesTriggered;

	public String getSchedulerName() {
		return this.schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public String getTriggerName() {
		return this.triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerGroup() {
		return this.triggerGroup;
	}

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
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

	public Integer getTimesTriggered() {
		return this.timesTriggered;
	}

	public void setTimesTriggered(Integer timesTriggered) {
		this.timesTriggered = timesTriggered;
	}

	@Transient
	public Long getVersion() {
		return 1L;
	}

	public void setVersion(Long version) {
	}

	public void aboutToInsert(DescriptorEvent event) {

	}

	public void aboutToUpdate(DescriptorEvent event) {
	}
}
