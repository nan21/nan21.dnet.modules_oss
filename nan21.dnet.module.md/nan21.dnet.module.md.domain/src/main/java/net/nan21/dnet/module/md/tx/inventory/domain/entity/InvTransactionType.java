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
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({@NamedQuery(name = InvTransactionType.NQ_FIND_BY_NAME, query = "SELECT e FROM InvTransactionType e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = InvTransactionType.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = InvTransactionType.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class InvTransactionType extends AbstractType {

	public static final String TABLE_NAME = "TX_INVT_TX_TYPE";
	public static final String SEQUENCE_NAME = "TX_INVT_TX_TYPE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "InvTransactionType.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "HASFROMINVENTORY", nullable = false)
	@NotNull
	private Boolean hasFromInventory;

	@Column(name = "HASTOINVENTORY", nullable = false)
	@NotNull
	private Boolean hasToInventory;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = TxDocType.class)
	@JoinColumn(name = "DOCTYPE_ID", referencedColumnName = "ID")
	private TxDocType docType;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getHasFromInventory() {
		return this.hasFromInventory;
	}

	public void setHasFromInventory(Boolean hasFromInventory) {
		this.hasFromInventory = hasFromInventory;
	}

	public Boolean getHasToInventory() {
		return this.hasToInventory;
	}

	public void setHasToInventory(Boolean hasToInventory) {
		this.hasToInventory = hasToInventory;
	}

	public TxDocType getDocType() {
		return this.docType;
	}

	public void setDocType(TxDocType docType) {
		if (docType != null) {
			this.__validate_client_context__(docType.getClientId());
		}
		this.docType = docType;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getHasFromInventory() == null) {
			event.updateAttributeWithObject("hasFromInventory", false);
		}
		if (this.getHasToInventory() == null) {
			event.updateAttributeWithObject("hasToInventory", false);
		}
	}
}
