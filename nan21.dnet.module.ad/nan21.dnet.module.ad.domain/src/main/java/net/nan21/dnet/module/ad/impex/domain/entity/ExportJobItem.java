/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.domain.entity;

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
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({
		@NamedQuery(name = ExportJobItem.NQ_FIND_BY_JOB_MAP, query = "SELECT e FROM ExportJobItem e WHERE e.clientId = :pClientId and e.job = :pJob and e.map = :pMap", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ExportJobItem.NQ_FIND_BY_JOB_MAP_PRIMITIVE, query = "SELECT e FROM ExportJobItem e WHERE e.clientId = :pClientId and e.job.id = :pJobId and e.map.id = :pMapId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ExportJobItem.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = ExportJobItem.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "JOB_ID", "MAP_ID"})})
@Customizer(DefaultEventHandler.class)
public class ExportJobItem extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_EXP_JOB_ITEM";
	public static final String SEQUENCE_NAME = "AD_EXP_JOB_ITEM_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Job_map.
	 */
	public static final String NQ_FIND_BY_JOB_MAP = "ExportJobItem.findByJob_map";

	/**
	 * Named query find by unique key: Job_map using the ID field for references.
	 */
	public static final String NQ_FIND_BY_JOB_MAP_PRIMITIVE = "ExportJobItem.findByJob_map_PRIMITIVE";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "SEQUENCENO", nullable = false)
	@NotNull
	private Integer sequenceNo;

	@Column(name = "ACTIVE", nullable = false)
	@NotNull
	private Boolean active;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ExportJob.class)
	@JoinColumn(name = "JOB_ID", referencedColumnName = "ID")
	private ExportJob job;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ExportMap.class)
	@JoinColumn(name = "MAP_ID", referencedColumnName = "ID")
	private ExportMap map;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public ExportJob getJob() {
		return this.job;
	}

	public void setJob(ExportJob job) {
		if (job != null) {
			this.__validate_client_context__(job.getClientId());
		}
		this.job = job;
	}

	public ExportMap getMap() {
		return this.map;
	}

	public void setMap(ExportMap map) {
		if (map != null) {
			this.__validate_client_context__(map.getClientId());
		}
		this.map = map;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getActive() == null) {
			event.updateAttributeWithObject("active", false);
		}
	}
}
