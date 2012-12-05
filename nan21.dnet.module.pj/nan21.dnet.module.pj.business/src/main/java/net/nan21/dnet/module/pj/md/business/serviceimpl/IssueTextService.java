/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;
import net.nan21.dnet.module.pj.md.business.service.IIssueTextService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.IssueText;

/**
 * Repository functionality for {@link IssueText} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssueTextService extends AbstractEntityService<IssueText>
		implements
			IIssueTextService {

	public IssueTextService() {
		super();
	}

	public IssueTextService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<IssueText> getEntityClass() {
		return IssueText.class;
	}

	/**
	 * Find by reference: issue
	 */
	public List<IssueText> findByIssue(Issue issue) {
		return this.findByIssueId(issue.getId());
	}

	/**
	 * Find by ID of reference: issue.id
	 */
	public List<IssueText> findByIssueId(Long issueId) {
		return (List<IssueText>) this
				.getEntityManager()
				.createQuery(
						"select e from IssueText e where e.clientId = :pClientId and e.issue.id = :pIssueId",
						IssueText.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pIssueId", issueId).getResultList();
	}

	/**
	 * Find by reference: issueTextType
	 */
	public List<IssueText> findByIssueTextType(IssueTextType issueTextType) {
		return this.findByIssueTextTypeId(issueTextType.getId());
	}

	/**
	 * Find by ID of reference: issueTextType.id
	 */
	public List<IssueText> findByIssueTextTypeId(Long issueTextTypeId) {
		return (List<IssueText>) this
				.getEntityManager()
				.createQuery(
						"select e from IssueText e where e.clientId = :pClientId and e.issueTextType.id = :pIssueTextTypeId",
						IssueText.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pIssueTextTypeId", issueTextTypeId)
				.getResultList();
	}
}
