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
import net.nan21.dnet.core.presenter.service.ds.AbstractEntityDsService;
import net.nan21.dnet.module.md._businessapi.SysParamMD;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductDs;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductDsParam;

public class ProductDsService extends
		AbstractEntityDsService<ProductDs, ProductDs, ProductDsParam, Product>
		implements IDsService<ProductDs, ProductDs, ProductDsParam> {

	@Override
	protected void postFind(
			IQueryBuilder<ProductDs, ProductDs, ProductDsParam> builder,
			List<ProductDs> result) throws Exception {

		String MM_PRODUCT_ICON_BASEURL = this.getSystemConfig()
				.getSysParamValue(SysParamMD.MM_PRODUCT_ICON_BASEURL);

		String MM_PRODUCT_ICON_EXT = this.getSystemConfig().getSysParamValue(
				SysParamMD.MM_PRODUCT_ICON_EXT);

		String MM_PRODUCT_ICON_SUFFIX = this.getSystemConfig()
				.getSysParamValue(SysParamMD.MM_PRODUCT_ICON_SUFFIX);

		for (ProductDs ds : result) {

			if (StringUtils.isBlank(ds.getIconUrl())) {
				ds.setIconLocation(MM_PRODUCT_ICON_BASEURL + "/" + ds.getCode()
						+ MM_PRODUCT_ICON_SUFFIX + "." + MM_PRODUCT_ICON_EXT);

			} else {
				if (!ds.getIconUrl().startsWith("http")) {
					ds.setIconLocation(MM_PRODUCT_ICON_BASEURL + "/"
							+ ds.getIconUrl());
				} else {
					ds.setIconLocation(ds.getIconUrl());
				}
			}
		}
	}
}
