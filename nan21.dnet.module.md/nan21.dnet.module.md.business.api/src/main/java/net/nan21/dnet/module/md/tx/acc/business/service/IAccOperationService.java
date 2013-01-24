/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.acc.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccOperation;

/**
 * Interface to expose business functions specific for {@link AccOperation} domain
 * entity.
 */
public interface IAccOperationService extends IEntityService<AccOperation> {

	/**
	 * Find by reference: org
	 */
	public List<AccOperation> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<AccOperation> findByOrgId(Long orgId);

	/**
	 * Find by reference: accSchema
	 */
	public List<AccOperation> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<AccOperation> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: period
	 */
	public List<AccOperation> findByPeriod(FiscalPeriod period);

	/**
	 * Find by ID of reference: period.id
	 */
	public List<AccOperation> findByPeriodId(Long periodId);

	/**
	 * Find by reference: accDoc
	 */
	public List<AccOperation> findByAccDoc(AccDoc accDoc);

	/**
	 * Find by ID of reference: accDoc.id
	 */
	public List<AccOperation> findByAccDocId(Long accDocId);

	/**
	 * Find by reference: accDocLine
	 */
	public List<AccOperation> findByAccDocLine(AccDocLine accDocLine);

	/**
	 * Find by ID of reference: accDocLine.id
	 */
	public List<AccOperation> findByAccDocLineId(Long accDocLineId);
}
