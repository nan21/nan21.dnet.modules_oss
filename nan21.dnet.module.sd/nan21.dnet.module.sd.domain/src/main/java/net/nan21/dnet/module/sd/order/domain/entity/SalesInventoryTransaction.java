/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.order.domain.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@CascadeOnDelete
@DiscriminatorValue("SO")
@Table(name = SalesInventoryTransaction.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class SalesInventoryTransaction extends InvTransaction {

	public static final String TABLE_NAME = "SD_INVT_TX";
	public static final String SEQUENCE_NAME = "SD_INVT_TX_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "DELIVERYNOTES", length = 4000)
	private String deliveryNotes;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
	private BusinessPartner customer;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Location.class)
	@JoinColumn(name = "DELIVERYLOCATION_ID", referencedColumnName = "ID")
	private Location deliveryLocation;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Contact.class)
	@JoinColumn(name = "DELIVERYCONTACT_ID", referencedColumnName = "ID")
	private Contact deliveryContact;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SalesOrder.class)
	@JoinColumn(name = "SALESORDER_ID", referencedColumnName = "ID")
	private SalesOrder salesOrder;

	public String getDeliveryNotes() {
		return this.deliveryNotes;
	}

	public void setDeliveryNotes(String deliveryNotes) {
		this.deliveryNotes = deliveryNotes;
	}

	public BusinessPartner getCustomer() {
		return this.customer;
	}

	public void setCustomer(BusinessPartner customer) {
		if (customer != null) {
			this.__validate_client_context__(customer.getClientId());
		}
		this.customer = customer;
	}

	public Location getDeliveryLocation() {
		return this.deliveryLocation;
	}

	public void setDeliveryLocation(Location deliveryLocation) {
		if (deliveryLocation != null) {
			this.__validate_client_context__(deliveryLocation.getClientId());
		}
		this.deliveryLocation = deliveryLocation;
	}

	public Contact getDeliveryContact() {
		return this.deliveryContact;
	}

	public void setDeliveryContact(Contact deliveryContact) {
		if (deliveryContact != null) {
			this.__validate_client_context__(deliveryContact.getClientId());
		}
		this.deliveryContact = deliveryContact;
	}

	public SalesOrder getSalesOrder() {
		return this.salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		if (salesOrder != null) {
			this.__validate_client_context__(salesOrder.getClientId());
		}
		this.salesOrder = salesOrder;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
