/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tx.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.base.tx.business.service.ITxDocSequenceService;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocSequence;

/**
 * Repository functionality for {@link TxDocSequence} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class TxDocSequenceService extends AbstractEntityService<TxDocSequence>
		implements
			ITxDocSequenceService {

	public TxDocSequenceService() {
		super();
	}

	public TxDocSequenceService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<TxDocSequence> getEntityClass() {
		return TxDocSequence.class;
	}

	/**
	 * Find by unique key
	 */
	public TxDocSequence findByName(String name) {
		return (TxDocSequence) this.getEntityManager()
				.createNamedQuery(TxDocSequence.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
