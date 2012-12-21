/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.domain.entity;

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
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = BpClassification.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class BpClassification extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_BP_CLSF";
	public static final String SEQUENCE_NAME = "MD_BP_CLSF_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
	@JoinColumn(name = "BP_ID", referencedColumnName = "ID")
	private BusinessPartner bp;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ClassificationSystem.class)
	@JoinColumn(name = "CLASSSYSTEM_ID", referencedColumnName = "ID")
	private ClassificationSystem classSystem;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ClassificationItem.class)
	@JoinColumn(name = "CLASSCODE_ID", referencedColumnName = "ID")
	private ClassificationItem classCode;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BusinessPartner getBp() {
		return this.bp;
	}

	public void setBp(BusinessPartner bp) {
		if (bp != null) {
			this.__validate_client_context__(bp.getClientId());
		}
		this.bp = bp;
	}

	public ClassificationSystem getClassSystem() {
		return this.classSystem;
	}

	public void setClassSystem(ClassificationSystem classSystem) {
		if (classSystem != null) {
			this.__validate_client_context__(classSystem.getClientId());
		}
		this.classSystem = classSystem;
	}

	public ClassificationItem getClassCode() {
		return this.classCode;
	}

	public void setClassCode(ClassificationItem classCode) {
		if (classCode != null) {
			this.__validate_client_context__(classCode.getClientId());
		}
		this.classCode = classCode;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
