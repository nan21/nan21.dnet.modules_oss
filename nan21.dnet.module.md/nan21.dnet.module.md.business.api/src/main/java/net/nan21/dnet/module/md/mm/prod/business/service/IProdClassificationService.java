/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProdClassification;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

/**
 * Interface to expose business functions specific for {@link ProdClassification} domain
 * entity.
 */
public interface IProdClassificationService
		extends
			IEntityService<ProdClassification> {

	/**
	 * Find by reference: product
	 */
	public List<ProdClassification> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<ProdClassification> findByProductId(Long productId);

	/**
	 * Find by reference: classSystem
	 */
	public List<ProdClassification> findByClassSystem(
			ClassificationSystem classSystem);

	/**
	 * Find by ID of reference: classSystem.id
	 */
	public List<ProdClassification> findByClassSystemId(Long classSystemId);

	/**
	 * Find by reference: classCode
	 */
	public List<ProdClassification> findByClassCode(ClassificationItem classCode);

	/**
	 * Find by ID of reference: classCode.id
	 */
	public List<ProdClassification> findByClassCodeId(Long classCodeId);
}
