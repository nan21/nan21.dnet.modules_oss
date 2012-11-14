/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Transient;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = ActProperty.TABLE_NAME)
@Cache(type = CacheType.NONE)
@Customizer(DefaultEventHandler.class)
public class ActProperty {

	public static final String TABLE_NAME = "ACT_GE_PROPERTY";
	public static final String SEQUENCE_NAME = "ACT_GE_PROPERTY_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "NAME_", nullable = false, length = 255)
	@NotBlank
	@Id
	private String name;

	@Column(name = "VALUE_", length = 400)
	private String value;

	@Column(name = "REV_")
	private Integer revision;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getRevision() {
		return this.revision;
	}

	public void setRevision(Integer revision) {
		this.revision = revision;
	}

	@Transient
	public Long getVersion() {
		return 1L;
	}

	public void setVersion(Long version) {
	}

	public void aboutToInsert(DescriptorEvent event) {

	}

	public void aboutToUpdate(DescriptorEvent event) {
	}
}
