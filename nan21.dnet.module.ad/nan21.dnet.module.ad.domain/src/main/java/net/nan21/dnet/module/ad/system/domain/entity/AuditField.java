/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractSimpleEntity;
import net.nan21.dnet.module.ad.system.domain.entity.AuditEntry;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = AuditField.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class AuditField extends AbstractSimpleEntity {

	public static final String TABLE_NAME = "AD_AUDIT_FLD";
	public static final String SEQUENCE_NAME = "AD_AUDIT_FLD_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "FIELDNAME", nullable = false, length = 255)
	@NotBlank
	private String fieldName;

	@Column(name = "OLDVALUE", length = 4000)
	private String oldValue;

	@Column(name = "NEWVALUE", length = 4000)
	private String newValue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDAT", nullable = false)
	@NotNull
	private Date createdAt;

	@Column(name = "CREATEDBY", nullable = false, length = 32)
	@NotBlank
	private String createdBy;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AuditEntry.class)
	@JoinColumn(name = "AUDITENTRY_ID", referencedColumnName = "ID")
	private AuditEntry auditEntry;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getOldValue() {
		return this.oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return this.newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public AuditEntry getAuditEntry() {
		return this.auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		if (auditEntry != null) {
			this.__validate_client_context__(auditEntry.getClientId());
		}
		this.auditEntry = auditEntry;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
