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
import javax.persistence.Lob;
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
@Table(name = QuartzCalendar.TABLE_NAME)
@ReadOnly
@Cache(type = CacheType.NONE)
@Customizer(DefaultEventHandler.class)
public class QuartzCalendar implements Serializable {

	public static final String TABLE_NAME = "XT_QRTZ_CALENDARS";
	public static final String SEQUENCE_NAME = "XT_QRTZ_CALENDARS_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "SCHED_NAME", nullable = false, length = 255)
	@NotBlank
	@Id
	private String schedulerName;

	@Column(name = "CALENDAR_NAME", nullable = false, length = 255)
	@NotBlank
	@Id
	private String calendarName;

	@Column(name = "CALENDAR", nullable = false)
	@NotNull
	@Lob
	private byte[] calendar;

	public String getSchedulerName() {
		return this.schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public String getCalendarName() {
		return this.calendarName;
	}

	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	public byte[] getCalendar() {
		return this.calendar;
	}

	public void setCalendar(byte[] calendar) {
		this.calendar = calendar;
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
