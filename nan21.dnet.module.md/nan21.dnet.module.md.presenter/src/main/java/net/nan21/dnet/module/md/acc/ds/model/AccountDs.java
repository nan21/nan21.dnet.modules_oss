/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.acc.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

@Ds(entity = Account.class, sort = {@SortField(field = AccountDs.f_name)})
@RefLookups({@RefLookup(refId = AccountDs.f_accSchemaId, namedQuery = AccSchema.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = AccountDs.f_accSchema)})})
public class AccountDs extends AbstractTypeWithCodeDs<Account> {

	public static final String f_accSchemaId = "accSchemaId";
	public static final String f_accSchema = "accSchema";
	public static final String f_type = "type";
	public static final String f_summary = "summary";

	@DsField(join = "left", path = "accSchema.id")
	private Long accSchemaId;

	@DsField(join = "left", path = "accSchema.code")
	private String accSchema;

	@DsField
	private String type;

	@DsField
	private Boolean summary;

	public AccountDs() {
		super();
	}

	public AccountDs(Account e) {
		super(e);
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getSummary() {
		return this.summary;
	}

	public void setSummary(Boolean summary) {
		this.summary = summary;
	}
}
