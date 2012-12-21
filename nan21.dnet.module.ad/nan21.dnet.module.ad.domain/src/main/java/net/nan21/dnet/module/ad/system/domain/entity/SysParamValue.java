/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.domain.entity;

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
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = SysParamValue.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class SysParamValue extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_SYS_PARAMVAL";
	public static final String SEQUENCE_NAME = "AD_SYS_PARAMVAL_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "VALUE", length = 400)
	private String value;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SysParam.class)
	@JoinColumn(name = "SYSPARAM_ID", referencedColumnName = "ID")
	private SysParam sysParam;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public SysParam getSysParam() {
		return this.sysParam;
	}

	public void setSysParam(SysParam sysParam) {
		if (sysParam != null) {
			this.__validate_client_context__(sysParam.getClientId());
		}
		this.sysParam = sysParam;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
