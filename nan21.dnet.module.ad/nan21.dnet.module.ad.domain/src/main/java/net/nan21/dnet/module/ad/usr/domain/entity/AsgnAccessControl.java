/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Access control rules for assignment components.
 */
@NamedQueries({
		@NamedQuery(name = AsgnAccessControl.NQ_FIND_BY_UNIQUE, query = "SELECT e FROM AsgnAccessControl e WHERE e.clientId = :pClientId and e.accessControl = :pAccessControl and e.dsName = :pDsName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = AsgnAccessControl.NQ_FIND_BY_UNIQUE_PRIMITIVE, query = "SELECT e FROM AsgnAccessControl e WHERE e.clientId = :pClientId and e.accessControl.id = :pAccessControlId and e.dsName = :pDsName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AsgnAccessControl.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = AsgnAccessControl.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "ACCESSCONTROL_ID", "DSNAME"})})
@Customizer(DefaultEventHandler.class)
public class AsgnAccessControl extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_ACL_ASGN";
	public static final String SEQUENCE_NAME = "AD_ACL_ASGN_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Unique.
	 */
	public static final String NQ_FIND_BY_UNIQUE = "AsgnAccessControl.findByUnique";

	/**
	 * Named query find by unique key: Unique using the ID field for references.
	 */
	public static final String NQ_FIND_BY_UNIQUE_PRIMITIVE = "AsgnAccessControl.findByUnique_PRIMITIVE";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "DSNAME", nullable = false, length = 255)
	@NotBlank
	private String dsName;

	/** Specify if it is allowed to query for data.*/
	@Column(name = "QUERYALLOWED", nullable = false)
	@NotNull
	private Boolean queryAllowed;

	/** Specify if it is allowed to update records.*/
	@Column(name = "UPDATEALLOWED", nullable = false)
	@NotNull
	private Boolean updateAllowed;

	/** Specify if it is allowed to import records.*/
	@Column(name = "IMPORTALLOWED", nullable = false)
	@NotNull
	private Boolean importAllowed;

	/** Specify if it is allowed to export records.*/
	@Column(name = "EXPORTALLOWED", nullable = false)
	@NotNull
	private Boolean exportAllowed;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AccessControl.class)
	@JoinColumn(name = "ACCESSCONTROL_ID", referencedColumnName = "ID")
	private AccessControl accessControl;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsName() {
		return this.dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public Boolean getQueryAllowed() {
		return this.queryAllowed;
	}

	public void setQueryAllowed(Boolean queryAllowed) {
		this.queryAllowed = queryAllowed;
	}

	public Boolean getUpdateAllowed() {
		return this.updateAllowed;
	}

	public void setUpdateAllowed(Boolean updateAllowed) {
		this.updateAllowed = updateAllowed;
	}

	public Boolean getImportAllowed() {
		return this.importAllowed;
	}

	public void setImportAllowed(Boolean importAllowed) {
		this.importAllowed = importAllowed;
	}

	public Boolean getExportAllowed() {
		return this.exportAllowed;
	}

	public void setExportAllowed(Boolean exportAllowed) {
		this.exportAllowed = exportAllowed;
	}

	public AccessControl getAccessControl() {
		return this.accessControl;
	}

	public void setAccessControl(AccessControl accessControl) {
		if (accessControl != null) {
			this.__validate_client_context__(accessControl.getClientId());
		}
		this.accessControl = accessControl;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getQueryAllowed() == null) {
			event.updateAttributeWithObject("queryAllowed", false);
		}
		if (this.getUpdateAllowed() == null) {
			event.updateAttributeWithObject("updateAllowed", false);
		}
		if (this.getImportAllowed() == null) {
			event.updateAttributeWithObject("importAllowed", false);
		}
		if (this.getExportAllowed() == null) {
			event.updateAttributeWithObject("exportAllowed", false);
		}
	}
}
