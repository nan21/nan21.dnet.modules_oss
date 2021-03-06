/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.org.domain.entity.StockLocatorType;

@Ds(entity = StockLocatorType.class, sort = {@SortField(field = StockLocatorTypeDs.f_name)})
public class StockLocatorTypeDs extends AbstractTypeDs<StockLocatorType> {

	public StockLocatorTypeDs() {
		super();
	}

	public StockLocatorTypeDs(StockLocatorType e) {
		super(e);
	}
}
