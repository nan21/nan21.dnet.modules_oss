/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActByteArray;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDetailHistory;

/**
 * Interface to expose business functions specific for {@link ActDetailHistory} domain
 * entity.
 */
public interface IActDetailHistoryService
		extends
			IEntityService<ActDetailHistory> {

	/**
	 * Find by reference: byteArray
	 */
	public List<ActDetailHistory> findByByteArray(ActByteArray byteArray);

	/**
	 * Find by ID of reference: byteArray.id
	 */
	public List<ActDetailHistory> findByByteArrayId(String byteArrayId);
}
