/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Transient;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = ActProcessDefinition.TABLE_NAME)
@Cache(type = CacheType.NONE)
@Customizer(DefaultEventHandler.class)
public class ActProcessDefinition implements IModelWithId, Serializable {

	public static final String TABLE_NAME = "ACT_RE_PROCDEF";
	public static final String SEQUENCE_NAME = "ACT_RE_PROCDEF_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "ID_", nullable = false, length = 64)
	@NotBlank
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private String id;

	@Column(name = "REV_")
	private Integer revision;

	@Column(name = "CATEGORY_", length = 255)
	private String category;

	@Column(name = "NAME_", nullable = false, length = 255)
	@NotBlank
	private String name;

	@Column(name = "KEY_", nullable = false, length = 255)
	@NotBlank
	private String key;

	@Column(name = "VERSION_")
	private Integer procDefVersion;

	@Column(name = "RESOURCE_NAME_", length = 255)
	private String resourceName;

	@Column(name = "DGRM_RESOURCE_NAME_", length = 255)
	private String diagramResourceName;

	@Column(name = "HAS_START_FORM_KEY_")
	private Boolean hasStartForm;

	@Column(name = "SUSPENSION_STATE_")
	private Integer suspensionState;

	@Column(name = "CLIENTID")
	private Long clientId;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ActDeployment.class)
	@JoinColumn(name = "DEPLOYMENT_ID_", referencedColumnName = "ID_")
	private ActDeployment deployment;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getRevision() {
		return this.revision;
	}

	public void setRevision(Integer revision) {
		this.revision = revision;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getProcDefVersion() {
		return this.procDefVersion;
	}

	public void setProcDefVersion(Integer procDefVersion) {
		this.procDefVersion = procDefVersion;
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getDiagramResourceName() {
		return this.diagramResourceName;
	}

	public void setDiagramResourceName(String diagramResourceName) {
		this.diagramResourceName = diagramResourceName;
	}

	public Boolean getHasStartForm() {
		return this.hasStartForm;
	}

	public void setHasStartForm(Boolean hasStartForm) {
		this.hasStartForm = hasStartForm;
	}

	public Integer getSuspensionState() {
		return this.suspensionState;
	}

	public void setSuspensionState(Integer suspensionState) {
		this.suspensionState = suspensionState;
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	@Transient
	public String getFullName() {
		return this.name + " v" + this.procDefVersion;
	}

	public void setFullName(String fullName) {
	}

	@Transient
	public Long getVersion() {
		return 1L;
	}

	public void setVersion(Long version) {
	}

	public ActDeployment getDeployment() {
		return this.deployment;
	}

	public void setDeployment(ActDeployment deployment) {
		this.deployment = deployment;
	}

	public void aboutToInsert(DescriptorEvent event) {
		event.updateAttributeWithObject("clientId", Session.user.get()
				.getClientId());

	}

	public void aboutToUpdate(DescriptorEvent event) {
	}
}
