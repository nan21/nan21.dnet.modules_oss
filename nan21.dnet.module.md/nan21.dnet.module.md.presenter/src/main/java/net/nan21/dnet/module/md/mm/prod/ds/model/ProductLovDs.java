/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

@Ds(entity = Product.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = ProductLovDs.f_code)})
public class ProductLovDs extends AbstractTypeWithCodeLov<Product> {

	public ProductLovDs() {
		super();
	}

	public ProductLovDs(Product e) {
		super(e);
	}
}
