/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ICustomFieldGroupService;
import net.nan21.dnet.module.ad.system.domain.entity.CustomFieldGroup;

/**
 * Repository functionality for {@link CustomFieldGroup} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CustomFieldGroupService
		extends
			AbstractEntityService<CustomFieldGroup>
		implements
			ICustomFieldGroupService {

	public CustomFieldGroupService() {
		super();
	}

	public CustomFieldGroupService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CustomFieldGroup> getEntityClass() {
		return CustomFieldGroup.class;
	}
}
