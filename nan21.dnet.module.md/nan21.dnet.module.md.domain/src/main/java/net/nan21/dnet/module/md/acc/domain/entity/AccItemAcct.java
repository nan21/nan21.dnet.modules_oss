/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.acc.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({
		@NamedQuery(name = AccItemAcct.NQ_FIND_BY_ITEM_SCHEMA, query = "SELECT e FROM AccItemAcct e WHERE e.clientId = :pClientId and e.accItem = :pAccItem and e.accSchema = :pAccSchema", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = AccItemAcct.NQ_FIND_BY_ITEM_SCHEMA_PRIMITIVE, query = "SELECT e FROM AccItemAcct e WHERE e.clientId = :pClientId and e.accItem.id = :pAccItemId and e.accSchema.id = :pAccSchemaId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AccItemAcct.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = AccItemAcct.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "ACCITEM_ID", "ACCSCHEMA_ID"})})
@Customizer(DefaultEventHandler.class)
public class AccItemAcct extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_ACC_ITEM_ACCT";
	public static final String SEQUENCE_NAME = "MD_ACC_ITEM_ACCT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Item_schema.
	 */
	public static final String NQ_FIND_BY_ITEM_SCHEMA = "AccItemAcct.findByItem_schema";

	/**
	 * Named query find by unique key: Item_schema using the ID field for references.
	 */
	public static final String NQ_FIND_BY_ITEM_SCHEMA_PRIMITIVE = "AccItemAcct.findByItem_schema_PRIMITIVE";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AccItem.class)
	@JoinColumn(name = "ACCITEM_ID", referencedColumnName = "ID")
	private AccItem accItem;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
	@JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
	private AccSchema accSchema;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
	@JoinColumn(name = "CRACCOUNT_ID", referencedColumnName = "ID")
	private Account crAccount;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
	@JoinColumn(name = "DBACCOUNT_ID", referencedColumnName = "ID")
	private Account dbAccount;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccItem getAccItem() {
		return this.accItem;
	}

	public void setAccItem(AccItem accItem) {
		if (accItem != null) {
			this.__validate_client_context__(accItem.getClientId());
		}
		this.accItem = accItem;
	}

	public AccSchema getAccSchema() {
		return this.accSchema;
	}

	public void setAccSchema(AccSchema accSchema) {
		if (accSchema != null) {
			this.__validate_client_context__(accSchema.getClientId());
		}
		this.accSchema = accSchema;
	}

	public Account getCrAccount() {
		return this.crAccount;
	}

	public void setCrAccount(Account crAccount) {
		if (crAccount != null) {
			this.__validate_client_context__(crAccount.getClientId());
		}
		this.crAccount = crAccount;
	}

	public Account getDbAccount() {
		return this.dbAccount;
	}

	public void setDbAccount(Account dbAccount) {
		if (dbAccount != null) {
			this.__validate_client_context__(dbAccount.getClientId());
		}
		this.dbAccount = dbAccount;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
