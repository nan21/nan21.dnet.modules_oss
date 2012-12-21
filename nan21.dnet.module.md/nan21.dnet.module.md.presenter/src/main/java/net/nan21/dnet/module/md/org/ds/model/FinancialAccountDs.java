/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;

@Ds(entity = FinancialAccount.class, sort = {@SortField(field = FinancialAccountDs.f_name)})
@RefLookups({
		@RefLookup(refId = FinancialAccountDs.f_currencyId, namedQuery = Currency.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = FinancialAccountDs.f_currency)}),
		@RefLookup(refId = FinancialAccountDs.f_orgId, namedQuery = Organization.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = FinancialAccountDs.f_org)}),
		@RefLookup(refId = FinancialAccountDs.f_journalId, namedQuery = AccJournal.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = FinancialAccountDs.f_journal)})})
public class FinancialAccountDs extends AbstractTypeDs<FinancialAccount> {

	public static final String f_type = "type";
	public static final String f_orgId = "orgId";
	public static final String f_org = "org";
	public static final String f_journalId = "journalId";
	public static final String f_journal = "journal";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";
	public static final String f_analiticSegment = "analiticSegment";

	@DsField(noUpdate = true)
	private String type;

	@DsField(join = "left", path = "org.id")
	private Long orgId;

	@DsField(join = "left", path = "org.code")
	private String org;

	@DsField(join = "left", path = "journal.id")
	private Long journalId;

	@DsField(join = "left", path = "journal.name")
	private String journal;

	@DsField(join = "left", path = "currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currency;

	@DsField
	private String analiticSegment;

	public FinancialAccountDs() {
		super();
	}

	public FinancialAccountDs(FinancialAccount e) {
		super(e);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrg() {
		return this.org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public Long getJournalId() {
		return this.journalId;
	}

	public void setJournalId(Long journalId) {
		this.journalId = journalId;
	}

	public String getJournal() {
		return this.journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public Long getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAnaliticSegment() {
		return this.analiticSegment;
	}

	public void setAnaliticSegment(String analiticSegment) {
		this.analiticSegment = analiticSegment;
	}
}
