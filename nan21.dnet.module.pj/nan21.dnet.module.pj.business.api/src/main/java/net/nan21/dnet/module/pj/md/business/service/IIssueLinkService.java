/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.IssueLink;

/**
 * Interface to expose business functions specific for {@link IssueLink} domain
 * entity.
 */
public interface IIssueLinkService extends IEntityService<IssueLink> {

	/**
	 * Find by reference: sourceIssue
	 */
	public List<IssueLink> findBySourceIssue(Issue sourceIssue);

	/**
	 * Find by ID of reference: sourceIssue.id
	 */
	public List<IssueLink> findBySourceIssueId(Long sourceIssueId);

	/**
	 * Find by reference: targetIssue
	 */
	public List<IssueLink> findByTargetIssue(Issue targetIssue);

	/**
	 * Find by ID of reference: targetIssue.id
	 */
	public List<IssueLink> findByTargetIssueId(Long targetIssueId);

	/**
	 * Find by reference: linkType
	 */
	public List<IssueLink> findByLinkType(IssueLinkType linkType);

	/**
	 * Find by ID of reference: linkType.id
	 */
	public List<IssueLink> findByLinkTypeId(Long linkTypeId);
}
