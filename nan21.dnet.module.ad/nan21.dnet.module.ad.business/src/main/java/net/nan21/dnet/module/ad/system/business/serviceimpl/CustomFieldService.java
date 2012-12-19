/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ICustomFieldService;
import net.nan21.dnet.module.ad.system.domain.entity.CustomField;
import net.nan21.dnet.module.ad.system.domain.entity.CustomFieldGroup;

/**
 * Repository functionality for {@link CustomField} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CustomFieldService extends AbstractEntityService<CustomField>
		implements
			ICustomFieldService {

	public CustomFieldService() {
		super();
	}

	public CustomFieldService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CustomField> getEntityClass() {
		return CustomField.class;
	}

	/**
	 * Find by unique key
	 */
	public CustomField findByGroup_name(CustomFieldGroup group, String name) {
		return (CustomField) this.getEntityManager()
				.createNamedQuery(CustomField.NQ_FIND_BY_GROUP_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pGroup", group).setParameter("pName", name)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public CustomField findByGroup_name(Long groupId, String name) {
		return (CustomField) this.getEntityManager()
				.createNamedQuery(CustomField.NQ_FIND_BY_GROUP_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pGroupId", groupId).setParameter("pName", name)
				.getSingleResult();
	}

	/**
	 * Find by reference: group
	 */
	public List<CustomField> findByGroup(CustomFieldGroup group) {
		return this.findByGroupId(group.getId());
	}

	/**
	 * Find by ID of reference: group.id
	 */
	public List<CustomField> findByGroupId(Long groupId) {
		return (List<CustomField>) this
				.getEntityManager()
				.createQuery(
						"select e from CustomField e where e.clientId = :pClientId and e.group.id = :pGroupId",
						CustomField.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pGroupId", groupId).getResultList();
	}
}
