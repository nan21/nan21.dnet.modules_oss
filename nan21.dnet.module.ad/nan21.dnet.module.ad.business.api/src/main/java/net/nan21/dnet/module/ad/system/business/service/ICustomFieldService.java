/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.CustomField;
import net.nan21.dnet.module.ad.system.domain.entity.CustomFieldGroup;

/**
 * Interface to expose business functions specific for {@link CustomField} domain
 * entity.
 */
public interface ICustomFieldService extends IEntityService<CustomField> {

	/**
	 * Find by unique key
	 */
	public CustomField findByGroup_name(CustomFieldGroup group, String name);

	/**
	 * Find by unique key
	 */
	public CustomField findByGroup_name(Long groupId, String name);

	/**
	 * Find by reference: group
	 */
	public List<CustomField> findByGroup(CustomFieldGroup group);

	/**
	 * Find by ID of reference: group.id
	 */
	public List<CustomField> findByGroupId(Long groupId);
}
