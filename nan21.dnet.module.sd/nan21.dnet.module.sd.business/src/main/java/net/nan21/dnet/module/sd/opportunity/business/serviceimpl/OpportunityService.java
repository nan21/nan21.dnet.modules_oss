/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.Opportunity;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;

/**
 * Repository functionality for {@link Opportunity} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OpportunityService extends AbstractEntityService<Opportunity>
		implements
			IOpportunityService {

	public OpportunityService() {
		super();
	}

	public OpportunityService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Opportunity> getEntityClass() {
		return Opportunity.class;
	}

	/**
	 * Find by reference: account
	 */
	public List<Opportunity> findByAccount(BusinessPartner account) {
		return this.findByAccountId(account.getId());
	}

	/**
	 * Find by ID of reference: account.id
	 */
	public List<Opportunity> findByAccountId(Long accountId) {
		return (List<Opportunity>) this
				.getEntityManager()
				.createQuery(
						"select e from Opportunity e where e.clientId = :pClientId and e.account.id = :pAccountId",
						Opportunity.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccountId", accountId).getResultList();
	}

	/**
	 * Find by reference: expectedCurrency
	 */
	public List<Opportunity> findByExpectedCurrency(Currency expectedCurrency) {
		return this.findByExpectedCurrencyId(expectedCurrency.getId());
	}

	/**
	 * Find by ID of reference: expectedCurrency.id
	 */
	public List<Opportunity> findByExpectedCurrencyId(Long expectedCurrencyId) {
		return (List<Opportunity>) this
				.getEntityManager()
				.createQuery(
						"select e from Opportunity e where e.clientId = :pClientId and e.expectedCurrency.id = :pExpectedCurrencyId",
						Opportunity.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pExpectedCurrencyId", expectedCurrencyId)
				.getResultList();
	}

	/**
	 * Find by reference: salesStage
	 */
	public List<Opportunity> findBySalesStage(OpportunityStage salesStage) {
		return this.findBySalesStageId(salesStage.getId());
	}

	/**
	 * Find by ID of reference: salesStage.id
	 */
	public List<Opportunity> findBySalesStageId(Long salesStageId) {
		return (List<Opportunity>) this
				.getEntityManager()
				.createQuery(
						"select e from Opportunity e where e.clientId = :pClientId and e.salesStage.id = :pSalesStageId",
						Opportunity.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSalesStageId", salesStageId).getResultList();
	}

	/**
	 * Find by reference: status
	 */
	public List<Opportunity> findByStatus(OpportunityStatus status) {
		return this.findByStatusId(status.getId());
	}

	/**
	 * Find by ID of reference: status.id
	 */
	public List<Opportunity> findByStatusId(Long statusId) {
		return (List<Opportunity>) this
				.getEntityManager()
				.createQuery(
						"select e from Opportunity e where e.clientId = :pClientId and e.status.id = :pStatusId",
						Opportunity.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pStatusId", statusId).getResultList();
	}

	/**
	 * Find by reference: priority
	 */
	public List<Opportunity> findByPriority(OpportunityPriority priority) {
		return this.findByPriorityId(priority.getId());
	}

	/**
	 * Find by ID of reference: priority.id
	 */
	public List<Opportunity> findByPriorityId(Long priorityId) {
		return (List<Opportunity>) this
				.getEntityManager()
				.createQuery(
						"select e from Opportunity e where e.clientId = :pClientId and e.priority.id = :pPriorityId",
						Opportunity.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPriorityId", priorityId).getResultList();
	}

	/**
	 * Find by reference: leadSource
	 */
	public List<Opportunity> findByLeadSource(OpportunitySource leadSource) {
		return this.findByLeadSourceId(leadSource.getId());
	}

	/**
	 * Find by ID of reference: leadSource.id
	 */
	public List<Opportunity> findByLeadSourceId(Long leadSourceId) {
		return (List<Opportunity>) this
				.getEntityManager()
				.createQuery(
						"select e from Opportunity e where e.clientId = :pClientId and e.leadSource.id = :pLeadSourceId",
						Opportunity.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLeadSourceId", leadSourceId).getResultList();
	}

	/**
	 * Find by reference: resultReason
	 */
	public List<Opportunity> findByResultReason(
			OpportunityResultReason resultReason) {
		return this.findByResultReasonId(resultReason.getId());
	}

	/**
	 * Find by ID of reference: resultReason.id
	 */
	public List<Opportunity> findByResultReasonId(Long resultReasonId) {
		return (List<Opportunity>) this
				.getEntityManager()
				.createQuery(
						"select e from Opportunity e where e.clientId = :pClientId and e.resultReason.id = :pResultReasonId",
						Opportunity.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pResultReasonId", resultReasonId)
				.getResultList();
	}

	/**
	 * Find by reference: assignedTo
	 */
	public List<Opportunity> findByAssignedTo(Assignable assignedTo) {
		return this.findByAssignedToId(assignedTo.getId());
	}

	/**
	 * Find by ID of reference: assignedTo.id
	 */
	public List<Opportunity> findByAssignedToId(Long assignedToId) {
		return (List<Opportunity>) this
				.getEntityManager()
				.createQuery(
						"select e from Opportunity e where e.clientId = :pClientId and e.assignedTo.id = :pAssignedToId",
						Opportunity.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAssignedToId", assignedToId).getResultList();
	}
}
