/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
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
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({
		@NamedQuery(name = PayScalePoint.NQ_FIND_BY_SCALE_CODE, query = "SELECT e FROM PayScalePoint e WHERE e.clientId = :pClientId and e.payScale = :pPayScale and e.code = :pCode", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = PayScalePoint.NQ_FIND_BY_SCALE_CODE_PRIMITIVE, query = "SELECT e FROM PayScalePoint e WHERE e.clientId = :pClientId and e.payScale.id = :pPayScaleId and e.code = :pCode", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = PayScalePoint.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = PayScalePoint.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "PAYSCALE_ID", "CODE"})})
@Customizer(DefaultEventHandler.class)
public class PayScalePoint extends AbstractAuditable {

	public static final String TABLE_NAME = "HR_PAYSCL_POINT";
	public static final String SEQUENCE_NAME = "HR_PAYSCL_POINT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Scale_code.
	 */
	public static final String NQ_FIND_BY_SCALE_CODE = "PayScalePoint.findByScale_code";

	/**
	 * Named query find by unique key: Scale_code using the ID field for references.
	 */
	public static final String NQ_FIND_BY_SCALE_CODE_PRIMITIVE = "PayScalePoint.findByScale_code_PRIMITIVE";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "CODE", nullable = false, length = 32)
	@NotBlank
	private String code;

	@Column(name = "SEQUENCENO")
	private Integer sequenceNo;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PayScale.class)
	@JoinColumn(name = "PAYSCALE_ID", referencedColumnName = "ID")
	private PayScale payScale;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
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

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
