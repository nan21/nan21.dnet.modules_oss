/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.base.tx.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;

@Ds(entity = TxDocType.class, sort = {@SortField(field = TxDocTypeDs.f_name)})
@RefLookups({@RefLookup(refId = TxDocTypeDs.f_journalId, namedQuery = AccJournal.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = TxDocTypeDs.f_journal)})})
public class TxDocTypeDs extends AbstractTypeDs<TxDocType> {

	public static final String f_journalId = "journalId";
	public static final String f_journal = "journal";
	public static final String f_category = "category";

	@DsField(join = "left", path = "journal.id")
	private Long journalId;

	@DsField(join = "left", path = "journal.name")
	private String journal;

	@DsField
	private String category;

	public TxDocTypeDs() {
		super();
	}

	public TxDocTypeDs(TxDocType e) {
		super(e);
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

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
