/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractSimpleEntity;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = AuditEntry.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class AuditEntry extends AbstractSimpleEntity {

	public static final String TABLE_NAME = "AD_AUDIT";
	public static final String SEQUENCE_NAME = "AD_AUDIT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "OPERATION", nullable = false, length = 16)
	@NotBlank
	private String operation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDAT", nullable = false)
	@NotNull
	private Date createdAt;

	@Column(name = "CREATEDBY", nullable = false, length = 32)
	@NotBlank
	private String createdBy;

	@Column(name = "SOURCEFQN", nullable = false, length = 255)
	@NotBlank
	private String sourceFQN;

	@Column(name = "SOURCEID", length = 255)
	private String sourceId;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = AuditField.class, mappedBy = "auditEntry", cascade = CascadeType.PERSIST)
	private Collection<AuditField> auditFields;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
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

	public String getSourceFQN() {
		return this.sourceFQN;
	}

	public void setSourceFQN(String sourceFQN) {
		this.sourceFQN = sourceFQN;
	}

	public String getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Collection<AuditField> getAuditFields() {
		return this.auditFields;
	}

	public void setAuditFields(Collection<AuditField> auditFields) {
		this.auditFields = auditFields;
	}

	public void addToAuditFields(AuditField e) {
		if (this.auditFields == null) {
			this.auditFields = new ArrayList<AuditField>();
		}
		e.setAuditEntry(this);
		this.auditFields.add(e);
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
