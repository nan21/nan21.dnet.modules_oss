/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.acc.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.acc.business.service.IAccJournalService;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;

/**
 * Repository functionality for {@link AccJournal} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccJournalService extends AbstractEntityService<AccJournal>
		implements
			IAccJournalService {

	public AccJournalService() {
		super();
	}

	public AccJournalService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<AccJournal> getEntityClass() {
		return AccJournal.class;
	}

	/**
	 * Find by unique key
	 */
	public AccJournal findByName(String name) {
		return (AccJournal) this.em
				.createNamedQuery(AccJournal.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
