/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.domain.entity;

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

@NamedQueries({@NamedQuery(name = ImportJob.NQ_FIND_BY_NAME, query = "SELECT e FROM ImportJob e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ImportJob.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = ImportJob.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class ImportJob extends AbstractType {

	public static final String TABLE_NAME = "AD_IMP_JOB";
	public static final String SEQUENCE_NAME = "AD_IMP_JOB_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "ImportJob.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = ImportJobItem.class, mappedBy = "job", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<ImportJobItem> items;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<ImportJobItem> getItems() {
		return this.items;
	}

	public void setItems(Collection<ImportJobItem> items) {
		this.items = items;
	}

	public void addToItems(ImportJobItem e) {
		if (this.items == null) {
			this.items = new ArrayList<ImportJobItem>();
		}
		e.setJob(this);
		this.items.add(e);
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
