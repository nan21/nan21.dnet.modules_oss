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
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductManufacturer;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductManufacturerDs;

public class ProductManufacturerDsService
		extends
		AbstractEntityDsService<ProductManufacturerDs, ProductManufacturerDs, EmptyParam, ProductManufacturer>
		implements
		IDsService<ProductManufacturerDs, ProductManufacturerDs, EmptyParam> {

	@Override
	protected void postFind(
			IQueryBuilder<ProductManufacturerDs, ProductManufacturerDs, EmptyParam> builder,
			List<ProductManufacturerDs> result) throws Exception {

		String MM_MANUFACT_ICON_BASEURL = this.getSystemConfig()
				.getSysParamValue(SysParamMD.MM_MANUFACT_ICON_BASEURL);

		String MM_MANUFACT_ICON_EXT = this.getSystemConfig().getSysParamValue(
				SysParamMD.MM_MANUFACT_ICON_EXT);

		for (ProductManufacturerDs ds : result) {

			if (StringUtils.isBlank(ds.getIconUrl())) {
				ds.setIconLocation(MM_MANUFACT_ICON_BASEURL + "/"
						+ ds.getCode() + "." + MM_MANUFACT_ICON_EXT);

			} else {
				if (!ds.getIconUrl().startsWith("http")) {
					ds.setIconLocation(MM_MANUFACT_ICON_BASEURL + "/"
							+ ds.getIconUrl());
				} else {
					ds.setIconLocation(ds.getIconUrl());
				}
			}
		}
	}

}