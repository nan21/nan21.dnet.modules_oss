/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.base.tx.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;

@Ds(entity = TxDocType.class, jpqlWhere = " e.active=true and e.category = 'sales-invoice' ", sort = {@SortField(field = TxDocTypeSILovDs.f_name)})
public class TxDocTypeSILovDs extends AbstractTypeLov<TxDocType> {

	public static final String f_category = "category";

	@DsField
	private String category;

	public TxDocTypeSILovDs() {
		super();
	}

	public TxDocTypeSILovDs(TxDocType e) {
		super(e);
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
