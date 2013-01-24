/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.inventory.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;

@Ds(entity = InvTransactionType.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = InvTransactionTypeLovDs.f_name)})
public class InvTransactionTypeLovDs
		extends
			AbstractTypeLov<InvTransactionType> {

	public static final String f_docTypeId = "docTypeId";
	public static final String f_docType = "docType";

	@DsField(join = "left", path = "docType.id")
	private Long docTypeId;

	@DsField(join = "left", path = "docType.name")
	private String docType;

	public InvTransactionTypeLovDs() {
		super();
	}

	public InvTransactionTypeLovDs(InvTransactionType e) {
		super(e);
	}

	public Long getDocTypeId() {
		return this.docTypeId;
	}

	public void setDocTypeId(Long docTypeId) {
		this.docTypeId = docTypeId;
	}

	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}
}
