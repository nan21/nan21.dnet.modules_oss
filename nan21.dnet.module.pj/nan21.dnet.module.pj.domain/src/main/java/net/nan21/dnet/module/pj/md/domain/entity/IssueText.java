/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = IssueText.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class IssueText extends AbstractAuditable {

	public static final String TABLE_NAME = "PJ_ISSUE_TXT";
	public static final String SEQUENCE_NAME = "PJ_ISSUE_TXT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "CONTENT", length = 400)
	private String content;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Issue.class)
	@JoinColumn(name = "ISSUE_ID", referencedColumnName = "ID")
	private Issue issue;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = IssueTextType.class)
	@JoinColumn(name = "ISSUETEXTTYPE_ID", referencedColumnName = "ID")
	private IssueTextType issueTextType;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Issue getIssue() {
		return this.issue;
	}

	public void setIssue(Issue issue) {
		if (issue != null) {
			this.__validate_client_context__(issue.getClientId());
		}
		this.issue = issue;
	}

	public IssueTextType getIssueTextType() {
		return this.issueTextType;
	}

	public void setIssueTextType(IssueTextType issueTextType) {
		if (issueTextType != null) {
			this.__validate_client_context__(issueTextType.getClientId());
		}
		this.issueTextType = issueTextType;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
