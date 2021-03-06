/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.domain.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@CascadeOnDelete
@DiscriminatorValue("PO")
@Table(name = PurchaseInventoryTransaction.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class PurchaseInventoryTransaction extends InvTransaction {

	public static final String TABLE_NAME = "SC_INVT_TX";
	public static final String SEQUENCE_NAME = "SC_INVT_TX_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
	@JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID")
	private BusinessPartner supplier;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PurchaseOrder.class)
	@JoinColumn(name = "PURCHASEORDER_ID", referencedColumnName = "ID")
	private PurchaseOrder purchaseOrder;

	public BusinessPartner getSupplier() {
		return this.supplier;
	}

	public void setSupplier(BusinessPartner supplier) {
		if (supplier != null) {
			this.__validate_client_context__(supplier.getClientId());
		}
		this.supplier = supplier;
	}

	public PurchaseOrder getPurchaseOrder() {
		return this.purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		if (purchaseOrder != null) {
			this.__validate_client_context__(purchaseOrder.getClientId());
		}
		this.purchaseOrder = purchaseOrder;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
