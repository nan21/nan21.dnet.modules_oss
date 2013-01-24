/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.domain.entity;

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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequest;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Expanded absence request items. */
@NamedQueries({})
@Entity
@Table(name = AbsenceRequestItem.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class AbsenceRequestItem extends AbstractAuditable {

	public static final String TABLE_NAME = "HR_ABSN_REQ_ITEM";
	public static final String SEQUENCE_NAME = "HR_ABSN_REQ_ITEM_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "EVENTDATE", nullable = false)
	@NotNull
	private Date eventDate;

	@Column(name = "HOURS", nullable = false)
	@NotNull
	private Integer hours;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AbsenceRequest.class)
	@JoinColumn(name = "ABSENCEREQUEST_ID", referencedColumnName = "ID")
	private AbsenceRequest absenceRequest;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Integer getHours() {
		return this.hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public AbsenceRequest getAbsenceRequest() {
		return this.absenceRequest;
	}

	public void setAbsenceRequest(AbsenceRequest absenceRequest) {
		if (absenceRequest != null) {
			this.__validate_client_context__(absenceRequest.getClientId());
		}
		this.absenceRequest = absenceRequest;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
