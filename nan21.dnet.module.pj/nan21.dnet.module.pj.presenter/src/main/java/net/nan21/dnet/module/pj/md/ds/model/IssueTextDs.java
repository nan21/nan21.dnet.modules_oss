/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;
import net.nan21.dnet.module.pj.md.domain.entity.IssueText;

@Ds(entity = IssueText.class)
@RefLookups({
		@RefLookup(refId = IssueTextDs.f_issueId),
		@RefLookup(refId = IssueTextDs.f_issueTextTypeId, namedQuery = IssueTextType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = IssueTextDs.f_issueTextType)})})
public class IssueTextDs extends AbstractAuditableDs<IssueText> {

	public static final String f_issueId = "issueId";
	public static final String f_issueTextTypeId = "issueTextTypeId";
	public static final String f_issueTextType = "issueTextType";
	public static final String f_content = "content";

	@DsField(join = "left", path = "issue.id")
	private Long issueId;

	@DsField(join = "left", path = "issueTextType.id")
	private Long issueTextTypeId;

	@DsField(join = "left", path = "issueTextType.name")
	private String issueTextType;

	@DsField
	private String content;

	public IssueTextDs() {
		super();
	}

	public IssueTextDs(IssueText e) {
		super(e);
	}

	public Long getIssueId() {
		return this.issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	public Long getIssueTextTypeId() {
		return this.issueTextTypeId;
	}

	public void setIssueTextTypeId(Long issueTextTypeId) {
		this.issueTextTypeId = issueTextTypeId;
	}

	public String getIssueTextType() {
		return this.issueTextType;
	}

	public void setIssueTextType(String issueTextType) {
		this.issueTextType = issueTextType;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
