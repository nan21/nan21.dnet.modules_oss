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
import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = GradePayScalePoint.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class GradePayScalePoint extends AbstractAuditable {

	public static final String TABLE_NAME = "HR_GRD_PAYSCL_POINT";
	public static final String SEQUENCE_NAME = "HR_GRD_PAYSCL_POINT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "STEP")
	private Integer step;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = GradePayScale.class)
	@JoinColumn(name = "GRADEPAYSCALE_ID", referencedColumnName = "ID")
	private GradePayScale gradePayScale;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PayScalePoint.class)
	@JoinColumn(name = "POINT_ID", referencedColumnName = "ID")
	private PayScalePoint point;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStep() {
		return this.step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public GradePayScale getGradePayScale() {
		return this.gradePayScale;
	}

	public void setGradePayScale(GradePayScale gradePayScale) {
		if (gradePayScale != null) {
			this.__validate_client_context__(gradePayScale.getClientId());
		}
		this.gradePayScale = gradePayScale;
	}

	public PayScalePoint getPoint() {
		return this.point;
	}

	public void setPoint(PayScalePoint point) {
		if (point != null) {
			this.__validate_client_context__(point.getClientId());
		}
		this.point = point;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
