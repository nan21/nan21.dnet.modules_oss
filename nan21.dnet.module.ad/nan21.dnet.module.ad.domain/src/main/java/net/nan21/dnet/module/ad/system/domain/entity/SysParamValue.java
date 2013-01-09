/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

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

	@Column(name = "SYSPARAM", nullable = false, length = 32)
	@NotBlank
	private String sysParam;

	@Column(name = "VALUE", length = 400)
	private String value;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDFROM", nullable = false)
	@NotNull
	private Date validFrom;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDTO", nullable = false)
	@NotNull
	private Date validTo;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSysParam() {
		return this.sysParam;
	}

	public void setSysParam(String sysParam) {
		this.sysParam = sysParam;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
