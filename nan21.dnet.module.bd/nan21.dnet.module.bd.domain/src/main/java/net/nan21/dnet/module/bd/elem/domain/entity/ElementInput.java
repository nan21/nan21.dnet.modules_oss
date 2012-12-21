/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = ElementInput.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class ElementInput extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_ELEM_IN";
	public static final String SEQUENCE_NAME = "BD_ELEM_IN_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "ALIAS", nullable = false, length = 32)
	@NotBlank
	private String alias;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Element.class)
	@JoinColumn(name = "ELEMENT_ID", referencedColumnName = "ID")
	private Element element;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Element.class)
	@JoinColumn(name = "CROSSREFERENCE_ID", referencedColumnName = "ID")
	private Element crossReference;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Element getElement() {
		return this.element;
	}

	public void setElement(Element element) {
		if (element != null) {
			this.__validate_client_context__(element.getClientId());
		}
		this.element = element;
	}

	public Element getCrossReference() {
		return this.crossReference;
	}

	public void setCrossReference(Element crossReference) {
		if (crossReference != null) {
			this.__validate_client_context__(crossReference.getClientId());
		}
		this.crossReference = crossReference;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
