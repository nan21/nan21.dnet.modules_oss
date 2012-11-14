/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.uom.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

@Ds(entity = Uom.class, jpqlWhere = " e.type.category = 'volume' ", sort = {@SortField(field = UomVolumeLovDs.fCODE)})
public class UomVolumeLovDs extends AbstractTypeWithCodeLov<Uom> {

	public UomVolumeLovDs() {
		super();
	}

	public UomVolumeLovDs(Uom e) {
		super(e);
	}
}
