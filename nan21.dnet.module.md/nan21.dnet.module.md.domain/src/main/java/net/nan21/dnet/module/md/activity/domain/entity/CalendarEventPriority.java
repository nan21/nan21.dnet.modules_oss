/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.activity.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

@NamedQueries({@NamedQuery(name = CalendarEventPriority.NQ_FIND_BY_TYPE_AND_NAME, query = "SELECT e FROM CalendarEventPriority e WHERE e.clientId = :pClientId and e.eventType = :pEventType and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = CalendarEventPriority.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = CalendarEventPriority.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "EVENTTYPE", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class CalendarEventPriority extends AbstractType {

	public static final String TABLE_NAME = "MD_ACT_PRIO";
	public static final String SEQUENCE_NAME = "MD_ACT_PRIO_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Type_and_name.
	 */
	public static final String NQ_FIND_BY_TYPE_AND_NAME = "CalendarEventPriority.findByType_and_name";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "EVENTTYPE", length = 16)
	private String eventType;

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

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
