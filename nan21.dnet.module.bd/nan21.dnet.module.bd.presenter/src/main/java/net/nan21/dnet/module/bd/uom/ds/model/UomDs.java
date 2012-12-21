/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.uom.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

@Ds(entity = Uom.class, sort = {@SortField(field = UomDs.f_name)})
@RefLookups({@RefLookup(refId = UomDs.f_typeId, namedQuery = UomType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = UomDs.f_type)})})
public class UomDs extends AbstractTypeWithCodeDs<Uom> {

	public static final String f_typeId = "typeId";
	public static final String f_type = "type";

	@DsField(join = "left", path = "type.id")
	private Long typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	public UomDs() {
		super();
	}

	public UomDs(Uom e) {
		super(e);
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
