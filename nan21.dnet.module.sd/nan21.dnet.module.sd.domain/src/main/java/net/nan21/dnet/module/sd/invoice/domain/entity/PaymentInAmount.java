/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentAmount;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@CascadeOnDelete
@Table(name = PaymentInAmount.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class PaymentInAmount extends PaymentAmount {

	public static final String TABLE_NAME = "SD_PYMNT_AMNT";
	public static final String SEQUENCE_NAME = "SD_PYMNT_AMNT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SalesTxAmount.class)
	@JoinColumn(name = "TXAMOUNT_ID", referencedColumnName = "ID")
	private SalesTxAmount txAmount;

	public SalesTxAmount getTxAmount() {
		return this.txAmount;
	}

	public void setTxAmount(SalesTxAmount txAmount) {
		if (txAmount != null) {
			this.__validate_client_context__(txAmount.getClientId());
		}
		this.txAmount = txAmount;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
