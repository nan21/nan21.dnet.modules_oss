/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.base.tx.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;

@Ds(entity = PaymentMethod.class, sort = {@SortField(field = PaymentMethodDs.f_name)})
@RefLookups({@RefLookup(refId = PaymentMethodDs.f_docTypeId, namedQuery = TxDocType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PaymentMethodDs.f_docType)})})
public class PaymentMethodDs extends AbstractTypeDs<PaymentMethod> {

	public static final String f_type = "type";
	public static final String f_docTypeId = "docTypeId";
	public static final String f_docType = "docType";

	@DsField
	private String type;

	@DsField(join = "left", path = "docType.id")
	private Long docTypeId;

	@DsField(join = "left", path = "docType.name")
	private String docType;

	public PaymentMethodDs() {
		super();
	}

	public PaymentMethodDs(PaymentMethod e) {
		super(e);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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
