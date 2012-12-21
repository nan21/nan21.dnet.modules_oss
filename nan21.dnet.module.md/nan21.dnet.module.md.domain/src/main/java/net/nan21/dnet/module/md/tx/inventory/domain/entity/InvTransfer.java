/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.inventory.domain.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@CascadeOnDelete
@DiscriminatorValue("TRSF")
@Table(name = InvTransfer.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class InvTransfer extends InvTransaction {

	public static final String TABLE_NAME = "TX_INVT_TX_TRSF";
	public static final String SEQUENCE_NAME = "TX_INVT_TX_TRSF_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
