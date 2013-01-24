/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Transient;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = ActIdentityGroup.TABLE_NAME)
@Cache(type = CacheType.NONE)
@Customizer(DefaultEventHandler.class)
public class ActIdentityGroup implements IModelWithId, Serializable {

	public static final String TABLE_NAME = "ACT_ID_GROUP";
	public static final String SEQUENCE_NAME = "ACT_ID_GROUP_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "ID_", nullable = false, length = 64)
	@NotBlank
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private String id;

	@Column(name = "NAME_", nullable = false, length = 255)
	@NotBlank
	private String name;

	@Column(name = "REV_")
	private Integer revision;

	@Column(name = "TYPE_", length = 255)
	private String type;

	@ManyToMany(mappedBy = "groups")
	private Collection<ActIdentityUser> users;

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

	public Integer getRevision() {
		return this.revision;
	}

	public void setRevision(Integer revision) {
		this.revision = revision;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Transient
	public Long getVersion() {
		return 1L;
	}

	public void setVersion(Long version) {
	}

	public Collection<ActIdentityUser> getUsers() {
		return this.users;
	}

	public void setUsers(Collection<ActIdentityUser> users) {
		this.users = users;
	}

	public void aboutToInsert(DescriptorEvent event) {

	}

	public void aboutToUpdate(DescriptorEvent event) {
	}
}
