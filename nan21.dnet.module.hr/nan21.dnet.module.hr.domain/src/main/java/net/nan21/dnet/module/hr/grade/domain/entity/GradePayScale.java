/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.domain.entity;

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
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = GradePayScale.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class GradePayScale extends AbstractAuditable {

	public static final String TABLE_NAME = "HR_GRD_PAYSCL";
	public static final String SEQUENCE_NAME = "HR_GRD_PAYSCL_SEQ";

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
	@Column(name = "VALIDFROM")
	private Date validFrom;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDTO")
	private Date validTo;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Grade.class)
	@JoinColumn(name = "GRADE_ID", referencedColumnName = "ID")
	private Grade grade;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PayScale.class)
	@JoinColumn(name = "PAYSCALE_ID", referencedColumnName = "ID")
	private PayScale payScale;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PayScalePoint.class)
	@JoinColumn(name = "CEILING_ID", referencedColumnName = "ID")
	private PayScalePoint ceiling;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
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

	public PayScale getPayScale() {
		return this.payScale;
	}

	public void setPayScale(PayScale payScale) {
		if (payScale != null) {
			this.__validate_client_context__(payScale.getClientId());
		}
		this.payScale = payScale;
	}

	public PayScalePoint getCeiling() {
		return this.ceiling;
	}

	public void setCeiling(PayScalePoint ceiling) {
		if (ceiling != null) {
			this.__validate_client_context__(ceiling.getClientId());
		}
		this.ceiling = ceiling;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
