/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.activity.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEvent;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventPriority;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventStatus;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

@Ds(entity = CalendarEvent.class)
@RefLookups({
		@RefLookup(refId = MyCalendarEventDs.f_bpartnerId, namedQuery = BusinessPartner.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = MyCalendarEventDs.f_bpartnerCode)}),
		@RefLookup(refId = MyCalendarEventDs.f_priorityId, namedQuery = CalendarEventPriority.NQ_FIND_BY_TYPE_AND_NAME, params = {
				@Param(name = "pEventType", field = MyCalendarEventDs.f_eventType),
				@Param(name = "pName", field = MyCalendarEventDs.f_priorityName)}),
		@RefLookup(refId = MyCalendarEventDs.f_statusId, namedQuery = CalendarEventStatus.NQ_FIND_BY_TYPE_AND_NAME, params = {
				@Param(name = "pEventType", field = MyCalendarEventDs.f_eventType),
				@Param(name = "pName", field = MyCalendarEventDs.f_statusName)})})
public class MyCalendarEventDs extends AbstractAuditableDs<CalendarEvent> {

	public static final String f_subject = "subject";
	public static final String f_startDate = "startDate";
	public static final String f_endDate = "endDate";
	public static final String f_dueDate = "dueDate";
	public static final String f_eventType = "eventType";
	public static final String f_statusId = "statusId";
	public static final String f_statusName = "statusName";
	public static final String f_priorityId = "priorityId";
	public static final String f_priorityName = "priorityName";
	public static final String f_bpartnerId = "bpartnerId";
	public static final String f_bpartnerCode = "bpartnerCode";
	public static final String f_contactId = "contactId";
	public static final String f_contact = "contact";
	public static final String f_notes = "notes";
	public static final String f_location = "location";
	public static final String f_url = "url";
	public static final String f_reminder = "reminder";
	public static final String f_allDay = "allDay";
	public static final String f_targetId = "targetId";
	public static final String f_targetType = "targetType";

	@DsField
	private String subject;

	@DsField(jpqlFilter = " e.endDate >= :startDate ")
	private Date startDate;

	@DsField(jpqlFilter = " e.startDate <= :endDate ")
	private Date endDate;

	@DsField
	private Date dueDate;

	@DsField
	private String eventType;

	@DsField(join = "left", path = "status.id")
	private Long statusId;

	@DsField(join = "left", path = "status.name")
	private String statusName;

	@DsField(join = "left", path = "priority.id")
	private Long priorityId;

	@DsField(join = "left", path = "priority.name")
	private String priorityName;

	@DsField(join = "left", path = "bpartner.id")
	private Long bpartnerId;

	@DsField(join = "left", path = "bpartner.code")
	private String bpartnerCode;

	@DsField(join = "left", path = "contact.id")
	private Long contactId;

	@DsField(join = "left", fetch = false, path = "contact.name")
	private String contact;

	@DsField
	private String notes;

	@DsField
	private String location;

	@DsField
	private String url;

	@DsField
	private String reminder;

	@DsField
	private Boolean allDay;

	@DsField
	private Long targetId;

	@DsField
	private String targetType;

	public MyCalendarEventDs() {
		super();
	}

	public MyCalendarEventDs(CalendarEvent e) {
		super(e);
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Long getPriorityId() {
		return this.priorityId;
	}

	public void setPriorityId(Long priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriorityName() {
		return this.priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	public Long getBpartnerId() {
		return this.bpartnerId;
	}

	public void setBpartnerId(Long bpartnerId) {
		this.bpartnerId = bpartnerId;
	}

	public String getBpartnerCode() {
		return this.bpartnerCode;
	}

	public void setBpartnerCode(String bpartnerCode) {
		this.bpartnerCode = bpartnerCode;
	}

	public Long getContactId() {
		return this.contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getReminder() {
		return this.reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	public Boolean getAllDay() {
		return this.allDay;
	}

	public void setAllDay(Boolean allDay) {
		this.allDay = allDay;
	}

	public Long getTargetId() {
		return this.targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public String getTargetType() {
		return this.targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
}
