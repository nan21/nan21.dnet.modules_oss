/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.activity.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventPriority;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventStatus;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = CalendarEvent.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class CalendarEvent extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_ACT";
	public static final String SEQUENCE_NAME = "MD_ACT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "SUBJECT", nullable = false, length = 255)
	@NotBlank
	private String subject;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STARTDATE")
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENDDATE")
	private Date endDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DUEDATE")
	private Date dueDate;

	@Column(name = "EVENTTYPE", length = 16)
	private String eventType;

	@Column(name = "NOTES", length = 4000)
	private String notes;

	@Column(name = "LOCATION", length = 4000)
	private String location;

	@Column(name = "URL", length = 400)
	private String url;

	@Column(name = "REMINDER", length = 32)
	private String reminder;

	@Column(name = "ALLDAY", nullable = false)
	@NotNull
	private Boolean allDay;

	@Column(name = "TARGETID")
	private Long targetId;

	@Column(name = "TARGETTYPE", length = 255)
	private String targetType;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CalendarEventStatus.class)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
	private CalendarEventStatus status;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CalendarEventPriority.class)
	@JoinColumn(name = "PRIORITY_ID", referencedColumnName = "ID")
	private CalendarEventPriority priority;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
	@JoinColumn(name = "BPARTNER_ID", referencedColumnName = "ID")
	private BusinessPartner bpartner;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Contact.class)
	@JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID")
	private Contact contact;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Transient
	public String getBusinessObject() {
		return "CalendarEvent.";
	}

	public void setBusinessObject(String businessObject) {
	}

	public CalendarEventStatus getStatus() {
		return this.status;
	}

	public void setStatus(CalendarEventStatus status) {
		if (status != null) {
			this.__validate_client_context__(status.getClientId());
		}
		this.status = status;
	}

	public CalendarEventPriority getPriority() {
		return this.priority;
	}

	public void setPriority(CalendarEventPriority priority) {
		if (priority != null) {
			this.__validate_client_context__(priority.getClientId());
		}
		this.priority = priority;
	}

	public BusinessPartner getBpartner() {
		return this.bpartner;
	}

	public void setBpartner(BusinessPartner bpartner) {
		if (bpartner != null) {
			this.__validate_client_context__(bpartner.getClientId());
		}
		this.bpartner = bpartner;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		if (contact != null) {
			this.__validate_client_context__(contact.getClientId());
		}
		this.contact = contact;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getAllDay() == null) {
			event.updateAttributeWithObject("allDay", false);
		}
	}
}
