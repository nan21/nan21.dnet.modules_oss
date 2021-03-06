/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.org.domain.entity;

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
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = OrganizationHierarchyItem.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class OrganizationHierarchyItem extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_ORG_HRCHY_ITEM";
	public static final String SEQUENCE_NAME = "BD_ORG_HRCHY_ITEM_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = OrganizationHierarchy.class)
	@JoinColumn(name = "HIERARCHY_ID", referencedColumnName = "ID")
	private OrganizationHierarchy hierarchy;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
	@JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
	private Organization org;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
	@JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
	private Organization parent;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrganizationHierarchy getHierarchy() {
		return this.hierarchy;
	}

	public void setHierarchy(OrganizationHierarchy hierarchy) {
		if (hierarchy != null) {
			this.__validate_client_context__(hierarchy.getClientId());
		}
		this.hierarchy = hierarchy;
	}

	public Organization getOrg() {
		return this.org;
	}

	public void setOrg(Organization org) {
		if (org != null) {
			this.__validate_client_context__(org.getClientId());
		}
		this.org = org;
	}

	public Organization getParent() {
		return this.parent;
	}

	public void setParent(Organization parent) {
		if (parent != null) {
			this.__validate_client_context__(parent.getClientId());
		}
		this.parent = parent;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
