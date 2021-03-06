/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.uom.domain.entity;

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
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Measuring units conversion.*/
@NamedQueries({})
@Entity
@Table(name = UomConversion.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class UomConversion extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_UOM_CNV";
	public static final String SEQUENCE_NAME = "BD_UOM_CNV_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	/** Multiplication factor. Specify either a multiplication or a division factor*/
	@Column(name = "MULTIPLYWITH", scale = 6)
	private Float multiplyWith;

	/** Division factor. Specify either a multiplication or a division factor*/
	@Column(name = "DIVIDETO", scale = 6)
	private Float divideTo;

	@Column(name = "ACTIVE", nullable = false)
	@NotNull
	private Boolean active;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
	@JoinColumn(name = "SOURCE_ID", referencedColumnName = "ID")
	private Uom source;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
	@JoinColumn(name = "TARGET_ID", referencedColumnName = "ID")
	private Uom target;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getMultiplyWith() {
		return this.multiplyWith;
	}

	public void setMultiplyWith(Float multiplyWith) {
		this.multiplyWith = multiplyWith;
	}

	public Float getDivideTo() {
		return this.divideTo;
	}

	public void setDivideTo(Float divideTo) {
		this.divideTo = divideTo;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Uom getSource() {
		return this.source;
	}

	public void setSource(Uom source) {
		if (source != null) {
			this.__validate_client_context__(source.getClientId());
		}
		this.source = source;
	}

	public Uom getTarget() {
		return this.target;
	}

	public void setTarget(Uom target) {
		if (target != null) {
			this.__validate_client_context__(target.getClientId());
		}
		this.target = target;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getActive() == null) {
			event.updateAttributeWithObject("active", false);
		}
	}
}
