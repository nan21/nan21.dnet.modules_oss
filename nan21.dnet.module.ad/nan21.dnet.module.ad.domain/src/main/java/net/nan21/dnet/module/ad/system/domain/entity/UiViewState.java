/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = UiViewState.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class UiViewState extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_UI_VIEW_STATE";
	public static final String SEQUENCE_NAME = "AD_UI_VIEW_STATE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "NAME", nullable = false, length = 255)
	@NotBlank
	private String name;

	@Column(name = "CMP", nullable = false, length = 255)
	@NotBlank
	private String cmp;

	@Column(name = "CMPTYPE", nullable = false, length = 16)
	@NotBlank
	private String cmpType;

	@Column(name = "STATEVALUE", length = 4000)
	private String stateValue;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCmp() {
		return this.cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public String getCmpType() {
		return this.cmpType;
	}

	public void setCmpType(String cmpType) {
		this.cmpType = cmpType;
	}

	public String getStateValue() {
		return this.stateValue;
	}

	public void setStateValue(String stateValue) {
		this.stateValue = stateValue;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
