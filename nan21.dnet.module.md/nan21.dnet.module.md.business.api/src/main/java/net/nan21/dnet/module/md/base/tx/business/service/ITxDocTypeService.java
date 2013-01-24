/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tx.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocSequence;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;

/**
 * Interface to expose business functions specific for {@link TxDocType} domain
 * entity.
 */
public interface ITxDocTypeService extends IEntityService<TxDocType> {

	/**
	 * Find by unique key
	 */
	public TxDocType findByName(String name);

	/**
	 * Find by reference: docSequence
	 */
	public List<TxDocType> findByDocSequence(TxDocSequence docSequence);

	/**
	 * Find by ID of reference: docSequence.id
	 */
	public List<TxDocType> findByDocSequenceId(Long docSequenceId);

	/**
	 * Find by reference: journal
	 */
	public List<TxDocType> findByJournal(AccJournal journal);

	/**
	 * Find by ID of reference: journal.id
	 */
	public List<TxDocType> findByJournalId(Long journalId);
}
