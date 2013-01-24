/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.md.mm.prod.business.service.IProdClassificationService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProdClassification;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

/**
 * Repository functionality for {@link ProdClassification} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProdClassificationService
		extends
			AbstractEntityService<ProdClassification>
		implements
			IProdClassificationService {

	public ProdClassificationService() {
		super();
	}

	public ProdClassificationService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProdClassification> getEntityClass() {
		return ProdClassification.class;
	}

	/**
	 * Find by reference: product
	 */
	public List<ProdClassification> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}

	/**
	 * Find by ID of reference: product.id
	 */
	public List<ProdClassification> findByProductId(Long productId) {
		return (List<ProdClassification>) this
				.getEntityManager()
				.createQuery(
						"select e from ProdClassification e where e.clientId = :pClientId and e.product.id = :pProductId",
						ProdClassification.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId).getResultList();
	}

	/**
	 * Find by reference: classSystem
	 */
	public List<ProdClassification> findByClassSystem(
			ClassificationSystem classSystem) {
		return this.findByClassSystemId(classSystem.getId());
	}

	/**
	 * Find by ID of reference: classSystem.id
	 */
	public List<ProdClassification> findByClassSystemId(Long classSystemId) {
		return (List<ProdClassification>) this
				.getEntityManager()
				.createQuery(
						"select e from ProdClassification e where e.clientId = :pClientId and e.classSystem.id = :pClassSystemId",
						ProdClassification.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pClassSystemId", classSystemId).getResultList();
	}

	/**
	 * Find by reference: classCode
	 */
	public List<ProdClassification> findByClassCode(ClassificationItem classCode) {
		return this.findByClassCodeId(classCode.getId());
	}

	/**
	 * Find by ID of reference: classCode.id
	 */
	public List<ProdClassification> findByClassCodeId(Long classCodeId) {
		return (List<ProdClassification>) this
				.getEntityManager()
				.createQuery(
						"select e from ProdClassification e where e.clientId = :pClientId and e.classCode.id = :pClassCodeId",
						ProdClassification.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pClassCodeId", classCodeId).getResultList();
	}
}
