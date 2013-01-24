/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.domain.entity;

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
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = PositionGrade.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class PositionGrade extends AbstractAuditable {

	public static final String TABLE_NAME = "HR_POS_GRD";
	public static final String SEQUENCE_NAME = "HR_POS_GRD_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Position.class)
	@JoinColumn(name = "POSITION_ID", referencedColumnName = "ID")
	private Position position;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Grade.class)
	@JoinColumn(name = "GRADE_ID", referencedColumnName = "ID")
	private Grade grade;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		if (grade != null) {
			this.__validate_client_context__(grade.getClientId());
		}
		this.grade = grade;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
