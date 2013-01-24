/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.data.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;

@Ds(entity = AttachmentType.class, sort = {@SortField(field = AttachmentTypeDs.f_name)})
public class AttachmentTypeDs extends AbstractTypeDs<AttachmentType> {

	public static final String f_category = "category";
	public static final String f_uploadPath = "uploadPath";
	public static final String f_baseUrl = "baseUrl";
	public static final String f_useInContext = "useInContext";

	@DsField
	private String category;

	@DsField
	private String uploadPath;

	@DsField
	private String baseUrl;

	@DsField
	private String useInContext;

	public AttachmentTypeDs() {
		super();
	}

	public AttachmentTypeDs(AttachmentType e) {
		super(e);
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUploadPath() {
		return this.uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getUseInContext() {
		return this.useInContext;
	}

	public void setUseInContext(String useInContext) {
		this.useInContext = useInContext;
	}
}
