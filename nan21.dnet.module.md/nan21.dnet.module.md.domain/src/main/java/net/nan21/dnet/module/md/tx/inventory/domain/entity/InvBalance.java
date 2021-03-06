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
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = InvBalance.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class InvBalance extends AbstractAuditable {

	public static final String TABLE_NAME = "TX_INVT_BALANCE";
	public static final String SEQUENCE_NAME = "TX_INVT_BALANCE_SEQ";

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

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SubInventory.class)
	@JoinColumn(name = "SUBINVENTORY_ID", referencedColumnName = "ID")
	private SubInventory subInventory;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = StockLocator.class)
	@JoinColumn(name = "LOCATOR_ID", referencedColumnName = "ID")
	private StockLocator locator;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
	private Product item;

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

	public SubInventory getSubInventory() {
		return this.subInventory;
	}

	public void setSubInventory(SubInventory subInventory) {
		if (subInventory != null) {
			this.__validate_client_context__(subInventory.getClientId());
		}
		this.subInventory = subInventory;
	}

	public StockLocator getLocator() {
		return this.locator;
	}

	public void setLocator(StockLocator locator) {
		if (locator != null) {
			this.__validate_client_context__(locator.getClientId());
		}
		this.locator = locator;
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
