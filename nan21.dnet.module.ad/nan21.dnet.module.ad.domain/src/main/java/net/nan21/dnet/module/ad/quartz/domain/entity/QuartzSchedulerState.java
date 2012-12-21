/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = QuartzSchedulerState.TABLE_NAME)
@ReadOnly
@Cache(type = CacheType.NONE)
@Customizer(DefaultEventHandler.class)
public class QuartzSchedulerState implements Serializable {

	public static final String TABLE_NAME = "XT_QRTZ_SCHEDULER_STATE";
	public static final String SEQUENCE_NAME = "XT_QRTZ_SCHEDULER_STATE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "SCHED_NAME", nullable = false, length = 255)
	@NotBlank
	@Id
	private String schedulerName;

	@Column(name = "INSTANCE_NAME", nullable = false, length = 255)
	@NotBlank
	@Id
	private String instanceName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_CHECKIN_TIME")
	private Date lastCheckinTime;

	@Column(name = "CHECKIN_INTERVAL")
	private Integer checkinInterval;

	public String getSchedulerName() {
		return this.schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public String getInstanceName() {
		return this.instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public Date getLastCheckinTime() {
		return this.lastCheckinTime;
	}

	public void setLastCheckinTime(Date lastCheckinTime) {
		this.lastCheckinTime = lastCheckinTime;
	}

	public Integer getCheckinInterval() {
		return this.checkinInterval;
	}

	public void setCheckinInterval(Integer checkinInterval) {
		this.checkinInterval = checkinInterval;
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
