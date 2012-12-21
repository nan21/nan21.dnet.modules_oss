/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.inventory.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;

@Ds(entity = InvTransactionType.class, sort = {@SortField(field = InvTransactionTypeDs.f_name)})
@RefLookups({@RefLookup(refId = InvTransactionTypeDs.f_docTypeId, namedQuery = TxDocType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = InvTransactionTypeDs.f_docType)})})
public class InvTransactionTypeDs extends AbstractTypeDs<InvTransactionType> {

	public static final String f_docTypeId = "docTypeId";
	public static final String f_docType = "docType";
	public static final String f_hasFromInventory = "hasFromInventory";
	public static final String f_hasToInventory = "hasToInventory";

	@DsField(join = "left", path = "docType.id")
	private Long docTypeId;

	@DsField(join = "left", path = "docType.name")
	private String docType;

	@DsField
	private Boolean hasFromInventory;

	@DsField
	private Boolean hasToInventory;

	public InvTransactionTypeDs() {
		super();
	}

	public InvTransactionTypeDs(InvTransactionType e) {
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

	public Boolean getHasFromInventory() {
		return this.hasFromInventory;
	}

	public void setHasFromInventory(Boolean hasFromInventory) {
		this.hasFromInventory = hasFromInventory;
	}

	public Boolean getHasToInventory() {
		return this.hasToInventory;
	}

	public void setHasToInventory(Boolean hasToInventory) {
		this.hasToInventory = hasToInventory;
	}
}
