/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.usr.domain.entity.Bookmark;

@Ds(entity = Bookmark.class, sort = {@SortField(field = BookmarkRtLovDs.f_sequenceNo)})
public class BookmarkRtLovDs extends AbstractTypeDs<Bookmark> {

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_parentId = "parentId";
	public static final String f_parent = "parent";
	public static final String f_text = "text";
	public static final String f_frame = "frame";
	public static final String f_bundle = "bundle";
	public static final String f_separatorBefore = "separatorBefore";
	public static final String f_separatorAfter = "separatorAfter";
	public static final String f_leaf = "leaf";

	@DsField
	private Integer sequenceNo;

	@DsField(join = "left", path = "parent.id")
	private Long parentId;

	@DsField(join = "left", path = "parent.title")
	private String parent;

	@DsField(path = "title")
	private String text;

	@DsField
	private String frame;

	@DsField
	private String bundle;

	@DsField
	private Boolean separatorBefore;

	@DsField
	private Boolean separatorAfter;

	@DsField(fetch = false, path = "leafNode")
	private Boolean leaf;

	public BookmarkRtLovDs() {
		super();
	}

	public BookmarkRtLovDs(Bookmark e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
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

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
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

	public Boolean getLeaf() {
		return this.leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
}
