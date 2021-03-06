/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.domain.entity;

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
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Product substitutes.*/
@NamedQueries({})
@Entity
@Table(name = ProductSubstitute.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class ProductSubstitute extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_PROD_SUBST";
	public static final String SEQUENCE_NAME = "MD_PROD_SUBST_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "NOTES", length = 4000)
	private String notes;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
	@JoinColumn(name = "REFPRODUCT_ID", referencedColumnName = "ID")
	private Product refProduct;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
	@JoinColumn(name = "EQUIVALENCE_ID", referencedColumnName = "ID")
	private Product equivalence;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Product getRefProduct() {
		return this.refProduct;
	}

	public void setRefProduct(Product refProduct) {
		if (refProduct != null) {
			this.__validate_client_context__(refProduct.getClientId());
		}
		this.refProduct = refProduct;
	}

	public Product getEquivalence() {
		return this.equivalence;
	}

	public void setEquivalence(Product equivalence) {
		if (equivalence != null) {
			this.__validate_client_context__(equivalence.getClientId());
		}
		this.equivalence = equivalence;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
