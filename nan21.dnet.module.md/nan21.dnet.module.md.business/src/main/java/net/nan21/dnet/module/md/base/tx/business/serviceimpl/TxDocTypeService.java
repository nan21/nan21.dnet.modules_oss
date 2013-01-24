/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tx.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.md.base.tx.business.service.ITxDocTypeService;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocSequence;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;

/**
 * Repository functionality for {@link TxDocType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class TxDocTypeService extends AbstractEntityService<TxDocType>
		implements
			ITxDocTypeService {

	public TxDocTypeService() {
		super();
	}

	public TxDocTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<TxDocType> getEntityClass() {
		return TxDocType.class;
	}

	/**
	 * Find by unique key
	 */
	public TxDocType findByName(String name) {
		return (TxDocType) this.getEntityManager()
				.createNamedQuery(TxDocType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: docSequence
	 */
	public List<TxDocType> findByDocSequence(TxDocSequence docSequence) {
		return this.findByDocSequenceId(docSequence.getId());
	}

	/**
	 * Find by ID of reference: docSequence.id
	 */
	public List<TxDocType> findByDocSequenceId(Long docSequenceId) {
		return (List<TxDocType>) this
				.getEntityManager()
				.createQuery(
						"select e from TxDocType e where e.clientId = :pClientId and e.docSequence.id = :pDocSequenceId",
						TxDocType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDocSequenceId", docSequenceId).getResultList();
	}

	/**
	 * Find by reference: journal
	 */
	public List<TxDocType> findByJournal(AccJournal journal) {
		return this.findByJournalId(journal.getId());
	}

	/**
	 * Find by ID of reference: journal.id
	 */
	public List<TxDocType> findByJournalId(Long journalId) {
		return (List<TxDocType>) this
				.getEntityManager()
				.createQuery(
						"select e from TxDocType e where e.clientId = :pClientId and e.journal.id = :pJournalId",
						TxDocType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJournalId", journalId).getResultList();
	}
}
