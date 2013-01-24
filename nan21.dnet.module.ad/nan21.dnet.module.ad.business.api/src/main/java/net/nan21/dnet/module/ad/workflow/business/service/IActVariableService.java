/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActByteArray;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActVariable;

/**
 * Interface to expose business functions specific for {@link ActVariable} domain
 * entity.
 */
public interface IActVariableService extends IEntityService<ActVariable> {

	/**
	 * Find by reference: byteArray
	 */
	public List<ActVariable> findByByteArray(ActByteArray byteArray);

	/**
	 * Find by ID of reference: byteArray.id
	 */
	public List<ActVariable> findByByteArrayId(String byteArrayId);
}
