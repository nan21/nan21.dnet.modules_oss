/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.IUiViewStateService;
import net.nan21.dnet.module.ad.system.domain.entity.UiViewState;

/**
 * Repository functionality for {@link UiViewState} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class UiViewStateService extends AbstractEntityService<UiViewState>
		implements
			IUiViewStateService {

	public UiViewStateService() {
		super();
	}

	public UiViewStateService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<UiViewState> getEntityClass() {
		return UiViewState.class;
	}
}
