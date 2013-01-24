/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentAmount;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@CascadeOnDelete
@Table(name = PaymentOutAmount.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class PaymentOutAmount extends PaymentAmount {

	public static final String TABLE_NAME = "SC_PYMNT_AMNT";
	public static final String SEQUENCE_NAME = "SC_PYMNT_AMNT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PurchaseTxAmount.class)
	@JoinColumn(name = "TXAMOUNT_ID", referencedColumnName = "ID")
	private PurchaseTxAmount txAmount;

	public PurchaseTxAmount getTxAmount() {
		return this.txAmount;
	}

	public void setTxAmount(PurchaseTxAmount txAmount) {
		if (txAmount != null) {
			this.__validate_client_context__(txAmount.getClientId());
		}
		this.txAmount = txAmount;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
