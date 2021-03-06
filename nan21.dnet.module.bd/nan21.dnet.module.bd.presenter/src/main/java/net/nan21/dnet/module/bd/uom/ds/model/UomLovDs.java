/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.uom.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

@Ds(entity = Uom.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = UomLovDs.f_code)})
public class UomLovDs extends AbstractTypeWithCodeLov<Uom> {

	public UomLovDs() {
		super();
	}

	public UomLovDs(Uom e) {
		super(e);
	}
}
