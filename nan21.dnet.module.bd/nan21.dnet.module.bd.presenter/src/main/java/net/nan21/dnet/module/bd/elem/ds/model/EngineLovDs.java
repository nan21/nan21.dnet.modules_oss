/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.elem.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

@Ds(entity = Engine.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = EngineLovDs.f_name)})
public class EngineLovDs extends AbstractTypeLov<Engine> {

	public static final String f_type = "type";

	@DsField
	private String type;

	public EngineLovDs() {
		super();
	}

	public EngineLovDs(Engine e) {
		super(e);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
