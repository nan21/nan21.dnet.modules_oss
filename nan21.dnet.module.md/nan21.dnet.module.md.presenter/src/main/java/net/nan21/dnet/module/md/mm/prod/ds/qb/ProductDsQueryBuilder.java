/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductDs;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductDsParam;

import net.nan21.dnet.core.api.session.Session;

public class ProductDsQueryBuilder
		extends
			QueryBuilderWithJpql<ProductDs, ProductDs, ProductDsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getProductCategoryId() != null) {
			addFilterCondition("  e.id in ( select p.id from  Product p, IN (p.categories) c where c.id = :productCategoryId )  ");
			addCustomFilterItem("productCategoryId",
					this.params.getProductCategoryId());
		}
	}
}
