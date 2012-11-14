/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({
		@NamedQuery(name = PaymentOut.NQ_FIND_BY_ID, query = "SELECT e FROM PaymentOut e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = PaymentOut.NQ_FIND_BY_IDS, query = "SELECT e FROM PaymentOut e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@CascadeOnDelete
@Table(name = PaymentOut.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class PaymentOut extends Payment {

	public static final String TABLE_NAME = "SC_PYMNT";
	public static final String SEQUENCE_NAME = "SC_PYMNT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by ID.
	 */
	public static final String NQ_FIND_BY_ID = "PaymentOut.findById";

	/**
	 * Named query find by IDs.
	 */
	public static final String NQ_FIND_BY_IDS = "PaymentOut.findByIds";

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getCode() == null || this.getCode().equals("")) {
			event.updateAttributeWithObject("code", "PYO-" + this.getId());
		}
	}
}
