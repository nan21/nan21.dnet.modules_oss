/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.domain.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({@NamedQuery(name = ProjectRole.NQ_FIND_BY_NAME, query = "SELECT e FROM ProjectRole e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ProjectRole.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = ProjectRole.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class ProjectRole extends AbstractType {

	public static final String TABLE_NAME = "PJ_PRJ_ROLE";
	public static final String SEQUENCE_NAME = "PJ_PRJ_ROLE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "ProjectRole.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@ManyToMany(mappedBy = "projectRoles")
	private Collection<ProjectType> projectTypes;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<ProjectType> getProjectTypes() {
		return this.projectTypes;
	}

	public void setProjectTypes(Collection<ProjectType> projectTypes) {
		this.projectTypes = projectTypes;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
