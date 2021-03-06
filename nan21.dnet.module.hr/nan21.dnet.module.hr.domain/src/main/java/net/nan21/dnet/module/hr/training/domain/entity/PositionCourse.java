/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.training.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.training.domain.entity.Course;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = PositionCourse.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class PositionCourse extends AbstractAuditable {

	public static final String TABLE_NAME = "HR_POS_COURSE";
	public static final String SEQUENCE_NAME = "HR_POS_COURSE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "MANDATORY", nullable = false)
	@NotNull
	private Boolean mandatory;

	/** The number of days the course is valid for. 
				If it is not null this course should be attended by the employee occupyping this position after the specified number of days. 
	 */
	@Column(name = "VALIDFOR")
	private Integer validFor;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Position.class)
	@JoinColumn(name = "POSITION_ID", referencedColumnName = "ID")
	private Position position;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Course.class)
	@JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
	private Course course;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getMandatory() {
		return this.mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Integer getValidFor() {
		return this.validFor;
	}

	public void setValidFor(Integer validFor) {
		this.validFor = validFor;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		if (position != null) {
			this.__validate_client_context__(position.getClientId());
		}
		this.position = position;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		if (course != null) {
			this.__validate_client_context__(course.getClientId());
		}
		this.course = course;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getMandatory() == null) {
			event.updateAttributeWithObject("mandatory", false);
		}
	}
}
