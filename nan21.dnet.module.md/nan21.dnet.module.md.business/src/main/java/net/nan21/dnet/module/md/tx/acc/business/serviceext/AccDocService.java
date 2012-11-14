/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.acc.business.serviceext;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md._businessdelegates.tx.fin.AccDocToAccOperationBD;
import net.nan21.dnet.module.md.tx.acc.business.service.IAccDocService;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;

/**
 * Business extensions specific for {@link AccDoc} domain entity.
 * 
 */
public class AccDocService extends
		net.nan21.dnet.module.md.tx.acc.business.serviceimpl.AccDocService
		implements IAccDocService {

	@Override
	public void doPost(AccDoc doc) throws BusinessException {
		this.getBusinessDelegate(AccDocToAccOperationBD.class).post(doc);
	}

	@Override
	public void doUnPost(AccDoc doc) throws BusinessException {
		this.getBusinessDelegate(AccDocToAccOperationBD.class).unPost(doc);
	}

}
