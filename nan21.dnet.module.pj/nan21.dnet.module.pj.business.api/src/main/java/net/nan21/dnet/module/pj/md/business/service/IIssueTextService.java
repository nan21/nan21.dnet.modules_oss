/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.IssueText;

/**
 * Interface to expose business functions specific for {@link IssueText} domain
 * entity.
 */
public interface IIssueTextService extends IEntityService<IssueText> {

	/**
	 * Find by reference: issue
	 */
	public List<IssueText> findByIssue(Issue issue);

	/**
	 * Find by ID of reference: issue.id
	 */
	public List<IssueText> findByIssueId(Long issueId);

	/**
	 * Find by reference: issueTextType
	 */
	public List<IssueText> findByIssueTextType(IssueTextType issueTextType);

	/**
	 * Find by ID of reference: issueTextType.id
	 */
	public List<IssueText> findByIssueTextTypeId(Long issueTextTypeId);
}
