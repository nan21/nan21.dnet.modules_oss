/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.md.bp.business.service.IBpClassificationService;
import net.nan21.dnet.module.md.bp.domain.entity.BpClassification;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

/**
 * Repository functionality for {@link BpClassification} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BpClassificationService
		extends
			AbstractEntityService<BpClassification>
		implements
			IBpClassificationService {

	public BpClassificationService() {
		super();
	}

	public BpClassificationService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<BpClassification> getEntityClass() {
		return BpClassification.class;
	}

	/**
	 * Find by reference: bp
	 */
	public List<BpClassification> findByBp(BusinessPartner bp) {
		return this.findByBpId(bp.getId());
	}

	/**
	 * Find by ID of reference: bp.id
	 */
	public List<BpClassification> findByBpId(Long bpId) {
		return (List<BpClassification>) this
				.getEntityManager()
				.createQuery(
						"select e from BpClassification e where e.clientId = :pClientId and e.bp.id = :pBpId",
						BpClassification.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpId", bpId).getResultList();
	}

	/**
	 * Find by reference: classSystem
	 */
	public List<BpClassification> findByClassSystem(
			ClassificationSystem classSystem) {
		return this.findByClassSystemId(classSystem.getId());
	}

	/**
	 * Find by ID of reference: classSystem.id
	 */
	public List<BpClassification> findByClassSystemId(Long classSystemId) {
		return (List<BpClassification>) this
				.getEntityManager()
				.createQuery(
						"select e from BpClassification e where e.clientId = :pClientId and e.classSystem.id = :pClassSystemId",
						BpClassification.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pClassSystemId", classSystemId).getResultList();
	}

	/**
	 * Find by reference: classCode
	 */
	public List<BpClassification> findByClassCode(ClassificationItem classCode) {
		return this.findByClassCodeId(classCode.getId());
	}

	/**
	 * Find by ID of reference: classCode.id
	 */
	public List<BpClassification> findByClassCodeId(Long classCodeId) {
		return (List<BpClassification>) this
				.getEntityManager()
				.createQuery(
						"select e from BpClassification e where e.clientId = :pClientId and e.classCode.id = :pClassCodeId",
						BpClassification.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pClassCodeId", classCodeId).getResultList();
	}
}
