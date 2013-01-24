/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tx.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocSequence;

/**
 * Interface to expose business functions specific for {@link TxDocSequence} domain
 * entity.
 */
public interface ITxDocSequenceService extends IEntityService<TxDocSequence> {

	/**
	 * Find by unique key
	 */
	public TxDocSequence findByName(String name);
}
