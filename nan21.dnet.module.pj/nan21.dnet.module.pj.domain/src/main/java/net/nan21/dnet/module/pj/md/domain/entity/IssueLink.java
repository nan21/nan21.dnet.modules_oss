/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
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
import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = IssueLink.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class IssueLink extends AbstractAuditable {

	public static final String TABLE_NAME = "PJ_ISSUE_LINK";
	public static final String SEQUENCE_NAME = "PJ_ISSUE_LINK_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Issue.class)
	@JoinColumn(name = "SOURCEISSUE_ID", referencedColumnName = "ID")
	private Issue sourceIssue;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Issue.class)
	@JoinColumn(name = "TARGETISSUE_ID", referencedColumnName = "ID")
	private Issue targetIssue;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = IssueLinkType.class)
	@JoinColumn(name = "LINKTYPE_ID", referencedColumnName = "ID")
	private IssueLinkType linkType;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Issue getSourceIssue() {
		return this.sourceIssue;
	}

	public void setSourceIssue(Issue sourceIssue) {
		if (sourceIssue != null) {
			this.__validate_client_context__(sourceIssue.getClientId());
		}
		this.sourceIssue = sourceIssue;
	}

	public Issue getTargetIssue() {
		return this.targetIssue;
	}

	public void setTargetIssue(Issue targetIssue) {
		if (targetIssue != null) {
			this.__validate_client_context__(targetIssue.getClientId());
		}
		this.targetIssue = targetIssue;
	}

	public IssueLinkType getLinkType() {
		return this.linkType;
	}

	public void setLinkType(IssueLinkType linkType) {
		if (linkType != null) {
			this.__validate_client_context__(linkType.getClientId());
		}
		this.linkType = linkType;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
