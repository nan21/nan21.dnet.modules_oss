/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.domain.entity;

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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({
	@NamedQuery(
		name=PurchaseOrderTax.NQ_FIND_BY_ID,
		query="SELECT e FROM PurchaseOrderTax e WHERE e.clientId = :pClientId and e.id = :pId ",
		hints=@QueryHint(name=QueryHints.BIND_PARAMETERS, value=HintValues.TRUE)
	)
	,@NamedQuery(
		name=PurchaseOrderTax.NQ_FIND_BY_IDS,
		query="SELECT e FROM PurchaseOrderTax e WHERE e.clientId = :pClientId and e.id in :pIds",
		hints=@QueryHint(name=QueryHints.BIND_PARAMETERS, value=HintValues.TRUE)
	)
})
@Entity
@Table(
	name=PurchaseOrderTax.TABLE_NAME
)
@Customizer(DefaultEventHandler.class)
public class PurchaseOrderTax extends AbstractAuditable  {
	
	public static final String TABLE_NAME = "SC_ORD_TAX";
	public static final String SEQUENCE_NAME = "SC_ORD_TAX_SEQ";
	
	private static final long serialVersionUID = -8865917134914502125L;
	
	/**
	 * Named query find by ID.
	 */ 
	public static final String NQ_FIND_BY_ID = "PurchaseOrderTax.findById";
	
	/**
	 * Named query find by IDs.
	 */     
	public static final String NQ_FIND_BY_IDS = "PurchaseOrderTax.findByIds";
	
	/**
			 * System generated unique identifier.
			 */
	@Column(name="ID", nullable=false)
	@NotNull
	@Id
	@GeneratedValue(generator=SEQUENCE_NAME)
	private Long id;
	
	@Column(name="BASEAMOUNT", nullable=false, scale=2)
	@NotNull
	private Float baseAmount;
	
	@Column(name="TAXAMOUNT", nullable=false, scale=2)
	@NotNull
	private Float taxAmount;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=PurchaseOrder.class)
	@JoinColumn(name="PURCHASEORDER_ID", referencedColumnName="ID")
	private PurchaseOrder purchaseOrder;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Tax.class)
	@JoinColumn(name="TAX_ID", referencedColumnName="ID")
	private Tax tax;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Float getBaseAmount() {
		return this.baseAmount;
	}
	
	public void setBaseAmount(Float baseAmount) {
		this.baseAmount = baseAmount;
	}
	
	public Float getTaxAmount() {
		return this.taxAmount;
	}
	
	public void setTaxAmount(Float taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	public PurchaseOrder getPurchaseOrder() {
		return this.purchaseOrder;
	}
	
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		if (purchaseOrder != null ) {
			this.__validate_client_context__(purchaseOrder.getClientId());
		}
		this.purchaseOrder = purchaseOrder;
	}
	
	public Tax getTax() {
		return this.tax;
	}
	
	public void setTax(Tax tax) {
		if (tax != null ) {
			this.__validate_client_context__(tax.getClientId());
		}
		this.tax = tax;
	}
	
	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);
	
	}
}
