/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.acc.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.tx.acc.business.service.IAccOperationService;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccOperation;

/**
 * Repository functionality for {@link AccOperation} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccOperationService extends AbstractEntityService<AccOperation>
		implements
			IAccOperationService {

	public AccOperationService() {
		super();
	}

	public AccOperationService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<AccOperation> getEntityClass() {
		return AccOperation.class;
	}

	/**
	 * Find by reference: org
	 */
	public List<AccOperation> findByOrg(Organization org) {
		return this.findByOrgId(org.getId());
	}

	/**
	 * Find by ID of reference: org.id
	 */
	public List<AccOperation> findByOrgId(Long orgId) {
		return (List<AccOperation>) this.em
				.createQuery(
						"select e from AccOperation e where e.clientId = :pClientId and e.org.id = :pOrgId",
						AccOperation.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrgId", orgId).getResultList();
	}

	/**
	 * Find by reference: accSchema
	 */
	public List<AccOperation> findByAccSchema(AccSchema accSchema) {
		return this.findByAccSchemaId(accSchema.getId());
	}

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<AccOperation> findByAccSchemaId(Long accSchemaId) {
		return (List<AccOperation>) this.em
				.createQuery(
						"select e from AccOperation e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
						AccOperation.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccSchemaId", accSchemaId).getResultList();
	}

	/**
	 * Find by reference: period
	 */
	public List<AccOperation> findByPeriod(FiscalPeriod period) {
		return this.findByPeriodId(period.getId());
	}

	/**
	 * Find by ID of reference: period.id
	 */
	public List<AccOperation> findByPeriodId(Long periodId) {
		return (List<AccOperation>) this.em
				.createQuery(
						"select e from AccOperation e where e.clientId = :pClientId and e.period.id = :pPeriodId",
						AccOperation.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPeriodId", periodId).getResultList();
	}

	/**
	 * Find by reference: accDoc
	 */
	public List<AccOperation> findByAccDoc(AccDoc accDoc) {
		return this.findByAccDocId(accDoc.getId());
	}

	/**
	 * Find by ID of reference: accDoc.id
	 */
	public List<AccOperation> findByAccDocId(Long accDocId) {
		return (List<AccOperation>) this.em
				.createQuery(
						"select e from AccOperation e where e.clientId = :pClientId and e.accDoc.id = :pAccDocId",
						AccOperation.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccDocId", accDocId).getResultList();
	}

	/**
	 * Find by reference: accDocLine
	 */
	public List<AccOperation> findByAccDocLine(AccDocLine accDocLine) {
		return this.findByAccDocLineId(accDocLine.getId());
	}

	/**
	 * Find by ID of reference: accDocLine.id
	 */
	public List<AccOperation> findByAccDocLineId(Long accDocLineId) {
		return (List<AccOperation>) this.em
				.createQuery(
						"select e from AccOperation e where e.clientId = :pClientId and e.accDocLine.id = :pAccDocLineId",
						AccOperation.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccDocLineId", accDocLineId).getResultList();
	}
}
