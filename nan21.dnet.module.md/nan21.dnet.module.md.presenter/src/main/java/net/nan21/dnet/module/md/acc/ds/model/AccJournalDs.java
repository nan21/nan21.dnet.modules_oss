/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.acc.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;

@Ds(entity = AccJournal.class, sort = {@SortField(field = AccJournalDs.f_name)})
public class AccJournalDs extends AbstractTypeDs<AccJournal> {

	public AccJournalDs() {
		super();
	}

	public AccJournalDs(AccJournal e) {
		super(e);
	}
}
