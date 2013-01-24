/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.usr.domain.entity.Bookmark;

@Ds(entity = Bookmark.class, sort = {@SortField(field = BookmarkDs.f_name)})
@RefLookups({@RefLookup(refId = BookmarkDs.f_parentId, namedQuery = Bookmark.NQ_FIND_BY_NAME, params = {
		@Param(name = "pOwner", field = BookmarkDs.f_owner),
		@Param(name = "pName", field = BookmarkDs.f_parent)})})
public class BookmarkDs extends AbstractTypeDs<Bookmark> {

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_title = "title";
	public static final String f_frame = "frame";
	public static final String f_bundle = "bundle";
	public static final String f_separatorBefore = "separatorBefore";
	public static final String f_separatorAfter = "separatorAfter";
	public static final String f_owner = "owner";
	public static final String f_leafNode = "leafNode";
	public static final String f_parentId = "parentId";
	public static final String f_parent = "parent";

	@DsField
	private Integer sequenceNo;

	@DsField
	private String title;

	@DsField
	private String frame;

	@DsField
	private String bundle;

	@DsField
	private Boolean separatorBefore;

	@DsField
	private Boolean separatorAfter;

	@DsField
	private String owner;

	@DsField(fetch = false)
	private Boolean leafNode;

	@DsField(join = "left", path = "parent.id")
	private Long parentId;

	@DsField(join = "left", path = "parent.title")
	private String parent;

	public BookmarkDs() {
		super();
	}

	public BookmarkDs(Bookmark e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFrame() {
		return this.frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getBundle() {
		return this.bundle;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}

	public Boolean getSeparatorBefore() {
		return this.separatorBefore;
	}

	public void setSeparatorBefore(Boolean separatorBefore) {
		this.separatorBefore = separatorBefore;
	}

	public Boolean getSeparatorAfter() {
		return this.separatorAfter;
	}

	public void setSeparatorAfter(Boolean separatorAfter) {
		this.separatorAfter = separatorAfter;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Boolean getLeafNode() {
		return this.leafNode;
	}

	public void setLeafNode(Boolean leafNode) {
		this.leafNode = leafNode;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
}
