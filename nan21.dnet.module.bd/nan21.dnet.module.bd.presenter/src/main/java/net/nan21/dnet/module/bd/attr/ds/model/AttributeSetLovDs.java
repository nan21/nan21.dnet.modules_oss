/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.attr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;

@Ds(entity = AttributeSet.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = AttributeSetLovDs.f_name)})
public class AttributeSetLovDs extends AbstractTypeLov<AttributeSet> {

	public AttributeSetLovDs() {
		super();
	}

	public AttributeSetLovDs(AttributeSet e) {
		super(e);
	}
}
