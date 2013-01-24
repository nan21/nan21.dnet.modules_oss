/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sd.opportunity.domain.entity.Opportunity;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;

/**
 * Interface to expose business functions specific for {@link Opportunity} domain
 * entity.
 */
public interface IOpportunityService extends IEntityService<Opportunity> {

	/**
	 * Find by reference: account
	 */
	public List<Opportunity> findByAccount(BusinessPartner account);

	/**
	 * Find by ID of reference: account.id
	 */
	public List<Opportunity> findByAccountId(Long accountId);

	/**
	 * Find by reference: expectedCurrency
	 */
	public List<Opportunity> findByExpectedCurrency(Currency expectedCurrency);

	/**
	 * Find by ID of reference: expectedCurrency.id
	 */
	public List<Opportunity> findByExpectedCurrencyId(Long expectedCurrencyId);

	/**
	 * Find by reference: salesStage
	 */
	public List<Opportunity> findBySalesStage(OpportunityStage salesStage);

	/**
	 * Find by ID of reference: salesStage.id
	 */
	public List<Opportunity> findBySalesStageId(Long salesStageId);

	/**
	 * Find by reference: status
	 */
	public List<Opportunity> findByStatus(OpportunityStatus status);

	/**
	 * Find by ID of reference: status.id
	 */
	public List<Opportunity> findByStatusId(Long statusId);

	/**
	 * Find by reference: priority
	 */
	public List<Opportunity> findByPriority(OpportunityPriority priority);

	/**
	 * Find by ID of reference: priority.id
	 */
	public List<Opportunity> findByPriorityId(Long priorityId);

	/**
	 * Find by reference: leadSource
	 */
	public List<Opportunity> findByLeadSource(OpportunitySource leadSource);

	/**
	 * Find by ID of reference: leadSource.id
	 */
	public List<Opportunity> findByLeadSourceId(Long leadSourceId);

	/**
	 * Find by reference: resultReason
	 */
	public List<Opportunity> findByResultReason(
			OpportunityResultReason resultReason);

	/**
	 * Find by ID of reference: resultReason.id
	 */
	public List<Opportunity> findByResultReasonId(Long resultReasonId);

	/**
	 * Find by reference: assignedTo
	 */
	public List<Opportunity> findByAssignedTo(Assignable assignedTo);

	/**
	 * Find by ID of reference: assignedTo.id
	 */
	public List<Opportunity> findByAssignedToId(Long assignedToId);
}
