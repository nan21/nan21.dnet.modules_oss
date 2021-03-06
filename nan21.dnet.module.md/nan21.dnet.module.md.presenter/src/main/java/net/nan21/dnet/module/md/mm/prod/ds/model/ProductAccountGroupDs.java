/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;

@Ds(entity = ProductAccountGroup.class, sort = {@SortField(field = ProductAccountGroupDs.f_name)})
public class ProductAccountGroupDs
		extends
			AbstractTypeWithCodeDs<ProductAccountGroup> {

	public ProductAccountGroupDs() {
		super();
	}

	public ProductAccountGroupDs(ProductAccountGroup e) {
		super(e);
	}
}
