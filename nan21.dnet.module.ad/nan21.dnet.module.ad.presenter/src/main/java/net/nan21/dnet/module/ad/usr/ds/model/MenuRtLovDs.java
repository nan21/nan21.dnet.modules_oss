/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;

@Ds(entity = Menu.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = MenuRtLovDs.f_sequenceNo)})
public class MenuRtLovDs extends AbstractTypeLov<Menu> {

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_title = "title";

	@DsField
	private Integer sequenceNo;

	@DsField
	private String title;

	public MenuRtLovDs() {
		super();
	}

	public MenuRtLovDs(Menu e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
