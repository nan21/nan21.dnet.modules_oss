/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.fi.asset.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;

@Ds(entity = AssetCategory.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = AssetCategoryLovDs.f_code)})
public class AssetCategoryLovDs extends AbstractTypeWithCodeLov<AssetCategory> {

	public AssetCategoryLovDs() {
		super();
	}

	public AssetCategoryLovDs(AssetCategory e) {
		super(e);
	}
}
