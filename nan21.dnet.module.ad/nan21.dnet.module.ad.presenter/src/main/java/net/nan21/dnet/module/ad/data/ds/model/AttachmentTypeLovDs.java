/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.data.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;

@Ds(entity = AttachmentType.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = AttachmentTypeLovDs.f_name)})
public class AttachmentTypeLovDs extends AbstractTypeLov<AttachmentType> {

	public static final String f_useInContext = "useInContext";

	@DsField(jpqlFilter = " :useInContext like e.useInContext ")
	private String useInContext;

	public AttachmentTypeLovDs() {
		super();
	}

	public AttachmentTypeLovDs(AttachmentType e) {
		super(e);
	}

	public String getUseInContext() {
		return this.useInContext;
	}

	public void setUseInContext(String useInContext) {
		this.useInContext = useInContext;
	}
}
