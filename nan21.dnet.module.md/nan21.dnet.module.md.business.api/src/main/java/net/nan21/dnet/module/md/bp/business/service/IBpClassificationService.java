/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.md.bp.domain.entity.BpClassification;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

/**
 * Interface to expose business functions specific for {@link BpClassification} domain
 * entity.
 */
public interface IBpClassificationService
		extends
			IEntityService<BpClassification> {

	/**
	 * Find by reference: bp
	 */
	public List<BpClassification> findByBp(BusinessPartner bp);

	/**
	 * Find by ID of reference: bp.id
	 */
	public List<BpClassification> findByBpId(Long bpId);

	/**
	 * Find by reference: classSystem
	 */
	public List<BpClassification> findByClassSystem(
			ClassificationSystem classSystem);

	/**
	 * Find by ID of reference: classSystem.id
	 */
	public List<BpClassification> findByClassSystemId(Long classSystemId);

	/**
	 * Find by reference: classCode
	 */
	public List<BpClassification> findByClassCode(ClassificationItem classCode);

	/**
	 * Find by ID of reference: classCode.id
	 */
	public List<BpClassification> findByClassCodeId(Long classCodeId);
}
