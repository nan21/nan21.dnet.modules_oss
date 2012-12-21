/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@CascadeOnDelete
@Table(name = PaymentIn.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class PaymentIn extends Payment {

	public static final String TABLE_NAME = "SD_PYMNT";
	public static final String SEQUENCE_NAME = "SD_PYMNT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getCode() == null || this.getCode().equals("")) {
			event.updateAttributeWithObject("code", "PYI-" + this.getId());
		}
	}
}
