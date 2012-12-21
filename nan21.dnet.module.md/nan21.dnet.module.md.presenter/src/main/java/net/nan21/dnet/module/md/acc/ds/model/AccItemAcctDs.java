/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.acc.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.acc.domain.entity.AccItemAcct;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

@Ds(entity = AccItemAcct.class)
@RefLookups({
		@RefLookup(refId = AccItemAcctDs.f_accItemId, namedQuery = AccItem.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = AccItemAcctDs.f_accItem)}),
		@RefLookup(refId = AccItemAcctDs.f_accSchemaId, namedQuery = AccSchema.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = AccItemAcctDs.f_accSchema)}),
		@RefLookup(refId = AccItemAcctDs.f_crAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = AccItemAcctDs.f_crAccount)}),
		@RefLookup(refId = AccItemAcctDs.f_dbAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = AccItemAcctDs.f_dbAccount)})})
public class AccItemAcctDs extends AbstractAuditableDs<AccItemAcct> {

	public static final String f_accItemId = "accItemId";
	public static final String f_accItem = "accItem";
	public static final String f_accSchemaId = "accSchemaId";
	public static final String f_accSchema = "accSchema";
	public static final String f_crAccountId = "crAccountId";
	public static final String f_crAccount = "crAccount";
	public static final String f_dbAccountId = "dbAccountId";
	public static final String f_dbAccount = "dbAccount";

	@DsField(join = "left", path = "accItem.id")
	private Long accItemId;

	@DsField(join = "left", path = "accItem.name")
	private String accItem;

	@DsField(join = "left", path = "accSchema.id")
	private Long accSchemaId;

	@DsField(join = "left", path = "accSchema.code")
	private String accSchema;

	@DsField(join = "left", path = "crAccount.id")
	private Long crAccountId;

	@DsField(join = "left", path = "crAccount.code")
	private String crAccount;

	@DsField(join = "left", path = "dbAccount.id")
	private Long dbAccountId;

	@DsField(join = "left", path = "dbAccount.code")
	private String dbAccount;

	public AccItemAcctDs() {
		super();
	}

	public AccItemAcctDs(AccItemAcct e) {
		super(e);
	}

	public Long getAccItemId() {
		return this.accItemId;
	}

	public void setAccItemId(Long accItemId) {
		this.accItemId = accItemId;
	}

	public String getAccItem() {
		return this.accItem;
	}

	public void setAccItem(String accItem) {
		this.accItem = accItem;
	}

	public Long getAccSchemaId() {
		return this.accSchemaId;
	}

	public void setAccSchemaId(Long accSchemaId) {
		this.accSchemaId = accSchemaId;
	}

	public String getAccSchema() {
		return this.accSchema;
	}

	public void setAccSchema(String accSchema) {
		this.accSchema = accSchema;
	}

	public Long getCrAccountId() {
		return this.crAccountId;
	}

	public void setCrAccountId(Long crAccountId) {
		this.crAccountId = crAccountId;
	}

	public String getCrAccount() {
		return this.crAccount;
	}

	public void setCrAccount(String crAccount) {
		this.crAccount = crAccount;
	}

	public Long getDbAccountId() {
		return this.dbAccountId;
	}

	public void setDbAccountId(Long dbAccountId) {
		this.dbAccountId = dbAccountId;
	}

	public String getDbAccount() {
		return this.dbAccount;
	}

	public void setDbAccount(String dbAccount) {
		this.dbAccount = dbAccount;
	}
}
