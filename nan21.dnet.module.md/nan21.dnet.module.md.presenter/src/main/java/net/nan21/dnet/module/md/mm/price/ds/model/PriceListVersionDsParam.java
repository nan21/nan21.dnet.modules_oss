/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.price.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class PriceListVersionDsParam extends EmptyParam {

	public static final String f_productCategoryId = "productCategoryId";
	public static final String f_productCategory = "productCategory";
	public static final String f_copyFromVersionId = "copyFromVersionId";
	public static final String f_copyFromVersion = "copyFromVersion";

	private Long productCategoryId;

	private String productCategory;

	private Long copyFromVersionId;

	private String copyFromVersion;

	public Long getProductCategoryId() {
		return this.productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Long getCopyFromVersionId() {
		return this.copyFromVersionId;
	}

	public void setCopyFromVersionId(Long copyFromVersionId) {
		this.copyFromVersionId = copyFromVersionId;
	}

	public String getCopyFromVersion() {
		return this.copyFromVersion;
	}

	public void setCopyFromVersion(String copyFromVersion) {
		this.copyFromVersion = copyFromVersion;
	}
}
