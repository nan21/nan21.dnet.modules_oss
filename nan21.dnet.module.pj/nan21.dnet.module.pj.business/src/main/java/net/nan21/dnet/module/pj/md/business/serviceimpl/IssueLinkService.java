/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;
import net.nan21.dnet.module.pj.md.business.service.IIssueLinkService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.IssueLink;

/**
 * Repository functionality for {@link IssueLink} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssueLinkService extends AbstractEntityService<IssueLink>
		implements
			IIssueLinkService {

	public IssueLinkService() {
		super();
	}

	public IssueLinkService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<IssueLink> getEntityClass() {
		return IssueLink.class;
	}

	/**
	 * Find by reference: sourceIssue
	 */
	public List<IssueLink> findBySourceIssue(Issue sourceIssue) {
		return this.findBySourceIssueId(sourceIssue.getId());
	}

	/**
	 * Find by ID of reference: sourceIssue.id
	 */
	public List<IssueLink> findBySourceIssueId(Long sourceIssueId) {
		return (List<IssueLink>) this
				.getEntityManager()
				.createQuery(
						"select e from IssueLink e where e.clientId = :pClientId and e.sourceIssue.id = :pSourceIssueId",
						IssueLink.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSourceIssueId", sourceIssueId).getResultList();
	}

	/**
	 * Find by reference: targetIssue
	 */
	public List<IssueLink> findByTargetIssue(Issue targetIssue) {
		return this.findByTargetIssueId(targetIssue.getId());
	}

	/**
	 * Find by ID of reference: targetIssue.id
	 */
	public List<IssueLink> findByTargetIssueId(Long targetIssueId) {
		return (List<IssueLink>) this
				.getEntityManager()
				.createQuery(
						"select e from IssueLink e where e.clientId = :pClientId and e.targetIssue.id = :pTargetIssueId",
						IssueLink.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTargetIssueId", targetIssueId).getResultList();
	}

	/**
	 * Find by reference: linkType
	 */
	public List<IssueLink> findByLinkType(IssueLinkType linkType) {
		return this.findByLinkTypeId(linkType.getId());
	}

	/**
	 * Find by ID of reference: linkType.id
	 */
	public List<IssueLink> findByLinkTypeId(Long linkTypeId) {
		return (List<IssueLink>) this
				.getEntityManager()
				.createQuery(
						"select e from IssueLink e where e.clientId = :pClientId and e.linkType.id = :pLinkTypeId",
						IssueLink.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLinkTypeId", linkTypeId).getResultList();
	}
}
