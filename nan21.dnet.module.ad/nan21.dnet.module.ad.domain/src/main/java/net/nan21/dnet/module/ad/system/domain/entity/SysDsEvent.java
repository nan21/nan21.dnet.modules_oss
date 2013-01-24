/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractAuditableNoTenant;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({
		@NamedQuery(name = SysDsEvent.NQ_FIND_BY_NAME, query = "SELECT e FROM SysDsEvent e WHERE e.dataSource = :pDataSource and e.eventType = :pEventType", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = SysDsEvent.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM SysDsEvent e WHERE e.dataSource.id = :pDataSourceId and e.eventType = :pEventType", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = SysDsEvent.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = SysDsEvent.TABLE_NAME
		+ "_UK1", columnNames = {"DATASOURCE_ID", "EVENTTYPE"})})
@Customizer(DefaultEventHandler.class)
public class SysDsEvent extends AbstractAuditableNoTenant {

	public static final String TABLE_NAME = "AD_SYS_DS_EVNT";
	public static final String SEQUENCE_NAME = "AD_SYS_DS_EVNT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "SysDsEvent.findByName";

	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "SysDsEvent.findByName_PRIMITIVE";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "EVENTTYPE", nullable = false, length = 32)
	@NotBlank
	private String eventType;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SysDataSource.class)
	@JoinColumn(name = "DATASOURCE_ID", referencedColumnName = "ID")
	private SysDataSource dataSource;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public SysDataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(SysDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
