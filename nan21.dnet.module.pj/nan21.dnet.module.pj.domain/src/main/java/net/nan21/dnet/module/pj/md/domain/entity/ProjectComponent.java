/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.domain.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({
		@NamedQuery(name = ProjectComponent.NQ_FIND_BY_NAME, query = "SELECT e FROM ProjectComponent e WHERE e.clientId = :pClientId and e.project = :pProject and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ProjectComponent.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM ProjectComponent e WHERE e.clientId = :pClientId and e.project.id = :pProjectId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ProjectComponent.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = ProjectComponent.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "PROJECT_ID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class ProjectComponent extends AbstractType {

	public static final String TABLE_NAME = "PJ_PRJ_CMP";
	public static final String SEQUENCE_NAME = "PJ_PRJ_CMP_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "ProjectComponent.findByName";

	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "ProjectComponent.findByName_PRIMITIVE";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Assignable.class)
	@JoinColumn(name = "COMPONENTLEAD_ID", referencedColumnName = "ID")
	private Assignable componentLead;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Project.class)
	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
	private Project project;

	@ManyToMany(mappedBy = "affectedComponents")
	private Collection<Issue> affectingIssues;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Assignable getComponentLead() {
		return this.componentLead;
	}

	public void setComponentLead(Assignable componentLead) {
		if (componentLead != null) {
			this.__validate_client_context__(componentLead.getClientId());
		}
		this.componentLead = componentLead;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		if (project != null) {
			this.__validate_client_context__(project.getClientId());
		}
		this.project = project;
	}

	public Collection<Issue> getAffectingIssues() {
		return this.affectingIssues;
	}

	public void setAffectingIssues(Collection<Issue> affectingIssues) {
		this.affectingIssues = affectingIssues;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
