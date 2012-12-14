/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.ds.serviceext;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.nan21.dnet.core.api.action.IQueryBuilder;
import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.ds.AbstractEntityDsService;
import net.nan21.dnet.module.md._businessapi.SysParamMD;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductCategory;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductCategoryDs;

public class ProductCategoryDsService
		extends
		AbstractEntityDsService<ProductCategoryDs, ProductCategoryDs, EmptyParam, ProductCategory>
		implements IDsService<ProductCategoryDs, ProductCategoryDs, EmptyParam> {

	@Override
	protected void postFind(
			IQueryBuilder<ProductCategoryDs, ProductCategoryDs, EmptyParam> builder,
			List<ProductCategoryDs> result) throws Exception {

		String MM_PRODCATEG_ICON_BASEURL = this.getSystemConfig()
				.getSysParamValue(SysParamMD.MM_PRODCATEG_ICON_BASEURL);

		String MM_PRODCATEG_ICON_EXT = this.getSystemConfig().getSysParamValue(
				SysParamMD.MM_PRODCATEG_ICON_EXT);

		for (ProductCategoryDs ds : result) {

			if (StringUtils.isBlank(ds.getIconUrl())) {
				ds.setIconLocation(MM_PRODCATEG_ICON_BASEURL + "/"
						+ ds.getCode() + "." + MM_PRODCATEG_ICON_EXT);

			} else {
				if (!ds.getIconUrl().startsWith("http")) {
					ds.setIconLocation(MM_PRODCATEG_ICON_BASEURL + "/"
							+ ds.getIconUrl());
				} else {
					ds.setIconLocation(ds.getIconUrl());
				}
			}
		}
	}

}
