/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.price.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceDs;
import net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceDsParam;

import net.nan21.dnet.core.api.session.Session;

public class ProductPriceDsQueryBuilder
		extends
			QueryBuilderWithJpql<ProductPriceDs, ProductPriceDs, ProductPriceDsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getProductCategoryId() != null) {
			addFilterCondition("  e.product.id in ( select p.id from  Product p, IN (p.categories) c where c.id = :productCategoryId )  ");
			addCustomFilterItem("productCategoryId",
					this.params.getProductCategoryId());
		}
	}
}
