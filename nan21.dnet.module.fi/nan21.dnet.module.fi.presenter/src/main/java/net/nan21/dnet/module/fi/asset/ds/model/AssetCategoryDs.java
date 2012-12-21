/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.fi.asset.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;

@Ds(entity = AssetCategory.class, sort = {@SortField(field = AssetCategoryDs.f_name)})
public class AssetCategoryDs extends AbstractTypeWithCodeDs<AssetCategory> {

	public AssetCategoryDs() {
		super();
	}

	public AssetCategoryDs(AssetCategory e) {
		super(e);
	}
}
