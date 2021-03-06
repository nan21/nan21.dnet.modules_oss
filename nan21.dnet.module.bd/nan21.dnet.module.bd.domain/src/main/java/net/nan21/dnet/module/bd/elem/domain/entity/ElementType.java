/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.elem.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementCategory;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({
		@NamedQuery(name = ElementType.NQ_FIND_BY_ENGINE_NAME, query = "SELECT e FROM ElementType e WHERE e.clientId = :pClientId and e.engine = :pEngine and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ElementType.NQ_FIND_BY_ENGINE_NAME_PRIMITIVE, query = "SELECT e FROM ElementType e WHERE e.clientId = :pClientId and e.engine.id = :pEngineId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ElementType.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = ElementType.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "ENGINE_ID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class ElementType extends AbstractType {

	public static final String TABLE_NAME = "BD_ELEM_TYPE";
	public static final String SEQUENCE_NAME = "BD_ELEM_TYPE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Engine_name.
	 */
	public static final String NQ_FIND_BY_ENGINE_NAME = "ElementType.findByEngine_name";

	/**
	 * Named query find by unique key: Engine_name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_ENGINE_NAME_PRIMITIVE = "ElementType.findByEngine_name_PRIMITIVE";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Engine.class)
	@JoinColumn(name = "ENGINE_ID", referencedColumnName = "ID")
	private Engine engine;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ElementCategory.class)
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
	private ElementCategory category;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Engine getEngine() {
		return this.engine;
	}

	public void setEngine(Engine engine) {
		if (engine != null) {
			this.__validate_client_context__(engine.getClientId());
		}
		this.engine = engine;
	}

	public ElementCategory getCategory() {
		return this.category;
	}

	public void setCategory(ElementCategory category) {
		if (category != null) {
			this.__validate_client_context__(category.getClientId());
		}
		this.category = category;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
