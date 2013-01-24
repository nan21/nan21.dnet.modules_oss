/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.elem.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = ElementFormula.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class ElementFormula extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_ELEM_FORMULA";
	public static final String SEQUENCE_NAME = "BD_ELEM_FORMULA_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDFROM", nullable = false)
	@NotNull
	private Date validFrom;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDTO")
	private Date validTo;

	@Column(name = "STATICVALUE", nullable = false)
	@NotNull
	private Boolean staticValue;

	@Column(name = "EXPRESSION", length = 4000)
	private String expression;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Element.class)
	@JoinColumn(name = "ELEMENT_ID", referencedColumnName = "ID")
	private Element element;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Boolean getStaticValue() {
		return this.staticValue;
	}

	public void setStaticValue(Boolean staticValue) {
		this.staticValue = staticValue;
	}

	public String getExpression() {
		return this.expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
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

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getStaticValue() == null) {
			event.updateAttributeWithObject("staticValue", false);
		}
	}
}
