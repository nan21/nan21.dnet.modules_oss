/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

@NamedQueries({@NamedQuery(name = WfDefProcess.NQ_FIND_BY_NAME, query = "SELECT e FROM WfDefProcess e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = WfDefProcess.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = WfDefProcess.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class WfDefProcess extends AbstractType {

	public static final String TABLE_NAME = "AD_WFDEF_PROC";
	public static final String SEQUENCE_NAME = "AD_WFDEF_PROC_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "WfDefProcess.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = WfDefNode.class, mappedBy = "process", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<WfDefNode> nodes;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<WfDefNode> getNodes() {
		return this.nodes;
	}

	public void setNodes(Collection<WfDefNode> nodes) {
		this.nodes = nodes;
	}

	public void addToNodes(WfDefNode e) {
		if (this.nodes == null) {
			this.nodes = new ArrayList<WfDefNode>();
		}
		e.setProcess(this);
		this.nodes.add(e);
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
