/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;
import net.nan21.dnet.core.api.session.SessionUtils;

@NamedQueries({})
@Entity
@Table(name = ActDeployment.TABLE_NAME)
@Cache(type = CacheType.NONE)
@Customizer(DefaultEventHandler.class)
public class ActDeployment implements IModelWithId, Serializable {

	public static final String TABLE_NAME = "ACT_RE_DEPLOYMENT";
	public static final String SEQUENCE_NAME = "ACT_RE_DEPLOYMENT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "ID_", nullable = false, length = 64)
	@NotBlank
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private String id;

	@Column(name = "NAME_", nullable = false, length = 255)
	@NotBlank
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DEPLOY_TIME_", nullable = false)
	@NotNull
	private Date deployTime;

	@Column(name = "CLIENTID")
	private Long clientId;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDeployTime() {
		return this.deployTime;
	}

	public void setDeployTime(Date deployTime) {
		this.deployTime = deployTime;
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	@Transient
	public String getFullName() {
		return this.name + " / " + SessionUtils.formatDateTime(this.deployTime);
	}

	public void setFullName(String fullName) {
	}

	public void aboutToInsert(DescriptorEvent event) {
		event.updateAttributeWithObject("clientId", Session.user.get()
				.getClientId());

	}

	public void aboutToUpdate(DescriptorEvent event) {
	}
}
