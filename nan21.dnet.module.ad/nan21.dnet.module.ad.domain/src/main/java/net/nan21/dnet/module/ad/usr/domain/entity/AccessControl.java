/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({@NamedQuery(name = AccessControl.NQ_FIND_BY_NAME, query = "SELECT e FROM AccessControl e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AccessControl.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = AccessControl.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class AccessControl extends AbstractType {

	public static final String TABLE_NAME = "AD_ACL";
	public static final String SEQUENCE_NAME = "AD_ACL_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "AccessControl.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = DsAccessControl.class, mappedBy = "accessControl", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<DsAccessControl> dsRules;

	@ManyToMany(mappedBy = "accessControls")
	private Collection<Role> roles;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<DsAccessControl> getDsRules() {
		return this.dsRules;
	}

	public void setDsRules(Collection<DsAccessControl> dsRules) {
		this.dsRules = dsRules;
	}

	public void addToDsRules(DsAccessControl e) {
		if (this.dsRules == null) {
			this.dsRules = new ArrayList<DsAccessControl>();
		}
		e.setAccessControl(this);
		this.dsRules.add(e);
	}

	public Collection<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
