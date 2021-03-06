/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.inventory.domain.entity;

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
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = InvTransactionLine.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class InvTransactionLine extends AbstractAuditable {

	public static final String TABLE_NAME = "TX_INVT_TX_LINE";
	public static final String SEQUENCE_NAME = "TX_INVT_TX_LINE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "QUANTITY", nullable = false, scale = 2)
	@NotNull
	private Float quantity;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = InvTransaction.class)
	@JoinColumn(name = "INVTRANSACTION_ID", referencedColumnName = "ID")
	private InvTransaction invTransaction;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
	private Product item;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SubInventory.class)
	@JoinColumn(name = "FROM_SUBINV_ID", referencedColumnName = "ID")
	private SubInventory fromSubInventory;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = StockLocator.class)
	@JoinColumn(name = "FROMLOCATOR_ID", referencedColumnName = "ID")
	private StockLocator fromLocator;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SubInventory.class)
	@JoinColumn(name = "TO_SUBINV_ID", referencedColumnName = "ID")
	private SubInventory toSubInventory;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = StockLocator.class)
	@JoinColumn(name = "TOLOCATOR_ID", referencedColumnName = "ID")
	private StockLocator toLocator;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
	@JoinColumn(name = "UOM_ID", referencedColumnName = "ID")
	private Uom uom;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public InvTransaction getInvTransaction() {
		return this.invTransaction;
	}

	public void setInvTransaction(InvTransaction invTransaction) {
		if (invTransaction != null) {
			this.__validate_client_context__(invTransaction.getClientId());
		}
		this.invTransaction = invTransaction;
	}

	public Product getItem() {
		return this.item;
	}

	public void setItem(Product item) {
		if (item != null) {
			this.__validate_client_context__(item.getClientId());
		}
		this.item = item;
	}

	public SubInventory getFromSubInventory() {
		return this.fromSubInventory;
	}

	public void setFromSubInventory(SubInventory fromSubInventory) {
		if (fromSubInventory != null) {
			this.__validate_client_context__(fromSubInventory.getClientId());
		}
		this.fromSubInventory = fromSubInventory;
	}

	public StockLocator getFromLocator() {
		return this.fromLocator;
	}

	public void setFromLocator(StockLocator fromLocator) {
		if (fromLocator != null) {
			this.__validate_client_context__(fromLocator.getClientId());
		}
		this.fromLocator = fromLocator;
	}

	public SubInventory getToSubInventory() {
		return this.toSubInventory;
	}

	public void setToSubInventory(SubInventory toSubInventory) {
		if (toSubInventory != null) {
			this.__validate_client_context__(toSubInventory.getClientId());
		}
		this.toSubInventory = toSubInventory;
	}

	public StockLocator getToLocator() {
		return this.toLocator;
	}

	public void setToLocator(StockLocator toLocator) {
		if (toLocator != null) {
			this.__validate_client_context__(toLocator.getClientId());
		}
		this.toLocator = toLocator;
	}

	public Uom getUom() {
		return this.uom;
	}

	public void setUom(Uom uom) {
		if (uom != null) {
			this.__validate_client_context__(uom.getClientId());
		}
		this.uom = uom;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
