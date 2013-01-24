/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.standards.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationItemService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

/**
 * Repository functionality for {@link ClassificationItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ClassificationItemService
		extends
			AbstractEntityService<ClassificationItem>
		implements
			IClassificationItemService {

	public ClassificationItemService() {
		super();
	}

	public ClassificationItemService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ClassificationItem> getEntityClass() {
		return ClassificationItem.class;
	}

	/**
	 * Find by unique key
	 */
	public ClassificationItem findBySyscode(ClassificationSystem classSystem,
			String code) {
		return (ClassificationItem) this.getEntityManager()
				.createNamedQuery(ClassificationItem.NQ_FIND_BY_SYSCODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pClassSystem", classSystem)
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ClassificationItem findBySyscode(Long classSystemId, String code) {
		return (ClassificationItem) this
				.getEntityManager()
				.createNamedQuery(
						ClassificationItem.NQ_FIND_BY_SYSCODE_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pClassSystemId", classSystemId)
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ClassificationItem findBySysname(ClassificationSystem classSystem,
			String name) {
		return (ClassificationItem) this.getEntityManager()
				.createNamedQuery(ClassificationItem.NQ_FIND_BY_SYSNAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pClassSystem", classSystem)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ClassificationItem findBySysname(Long classSystemId, String name) {
		return (ClassificationItem) this
				.getEntityManager()
				.createNamedQuery(
						ClassificationItem.NQ_FIND_BY_SYSNAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pClassSystemId", classSystemId)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: classSystem
	 */
	public List<ClassificationItem> findByClassSystem(
			ClassificationSystem classSystem) {
		return this.findByClassSystemId(classSystem.getId());
	}

	/**
	 * Find by ID of reference: classSystem.id
	 */
	public List<ClassificationItem> findByClassSystemId(Long classSystemId) {
		return (List<ClassificationItem>) this
				.getEntityManager()
				.createQuery(
						"select e from ClassificationItem e where e.clientId = :pClientId and e.classSystem.id = :pClassSystemId",
						ClassificationItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pClassSystemId", classSystemId).getResultList();
	}
}
