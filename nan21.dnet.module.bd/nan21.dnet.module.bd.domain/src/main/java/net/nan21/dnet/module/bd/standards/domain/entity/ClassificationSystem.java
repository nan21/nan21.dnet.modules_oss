/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.standards.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({
		@NamedQuery(name = ClassificationSystem.NQ_FIND_BY_CODE, query = "SELECT e FROM ClassificationSystem e WHERE e.clientId = :pClientId and e.code = :pCode", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ClassificationSystem.NQ_FIND_BY_NAME, query = "SELECT e FROM ClassificationSystem e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ClassificationSystem.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = ClassificationSystem.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = ClassificationSystem.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class ClassificationSystem extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "BD_CLSF";
	public static final String SEQUENCE_NAME = "BD_CLSF_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "ClassificationSystem.findByCode";

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "ClassificationSystem.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "INTERNAL", nullable = false)
	@NotNull
	private Boolean internal;

	@Column(name = "TAG", length = 255)
	private String tag;

	@Column(name = "USEINCONTEXT", nullable = false, length = 32)
	@NotBlank
	private String useInContext;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getInternal() {
		return this.internal;
	}

	public void setInternal(Boolean internal) {
		this.internal = internal;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getUseInContext() {
		return this.useInContext;
	}

	public void setUseInContext(String useInContext) {
		this.useInContext = useInContext;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getInternal() == null) {
			event.updateAttributeWithObject("internal", false);
		}
	}
}
