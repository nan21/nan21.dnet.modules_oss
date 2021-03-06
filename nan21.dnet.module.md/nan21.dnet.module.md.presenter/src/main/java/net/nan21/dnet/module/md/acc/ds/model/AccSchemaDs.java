/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.acc.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;

@Ds(entity = AccSchema.class, sort = {@SortField(field = AccSchemaDs.f_name)})
public class AccSchemaDs extends AbstractTypeWithCodeDs<AccSchema> {

	public AccSchemaDs() {
		super();
	}

	public AccSchemaDs(AccSchema e) {
		super(e);
	}
}
