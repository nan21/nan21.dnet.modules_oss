/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProdClassification;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

@Ds(entity = ProdClassification.class)
@RefLookups({
		@RefLookup(refId = ProdClassificationDs.f_productId, namedQuery = Product.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProdClassificationDs.f_productCode)}),
		@RefLookup(refId = ProdClassificationDs.f_classificationSystemId, namedQuery = ClassificationSystem.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProdClassificationDs.f_classificationSystem)}),
		@RefLookup(refId = ProdClassificationDs.f_classificationId, namedQuery = ClassificationItem.NQ_FIND_BY_SYSCODE_PRIMITIVE, params = {
				@Param(name = "pClassSystemId", field = ProdClassificationDs.f_classificationSystemId),
				@Param(name = "pCode", field = ProdClassificationDs.f_classificationCode)})})
public class ProdClassificationDs
		extends
			AbstractAuditableDs<ProdClassification> {

	public static final String f_productId = "productId";
	public static final String f_productCode = "productCode";
	public static final String f_classificationSystemId = "classificationSystemId";
	public static final String f_classificationSystem = "classificationSystem";
	public static final String f_classificationId = "classificationId";
	public static final String f_classificationCode = "classificationCode";
	public static final String f_classificationName = "classificationName";

	@DsField(join = "left", path = "product.id")
	private Long productId;

	@DsField(join = "left", path = "product.code")
	private String productCode;

	@DsField(join = "left", path = "classSystem.id")
	private Long classificationSystemId;

	@DsField(join = "left", path = "classSystem.code")
	private String classificationSystem;

	@DsField(join = "left", path = "classCode.id")
	private Long classificationId;

	@DsField(join = "left", path = "classCode.code")
	private String classificationCode;

	@DsField(join = "left", path = "classCode.name")
	private String classificationName;

	public ProdClassificationDs() {
		super();
	}

	public ProdClassificationDs(ProdClassification e) {
		super(e);
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Long getClassificationSystemId() {
		return this.classificationSystemId;
	}

	public void setClassificationSystemId(Long classificationSystemId) {
		this.classificationSystemId = classificationSystemId;
	}

	public String getClassificationSystem() {
		return this.classificationSystem;
	}

	public void setClassificationSystem(String classificationSystem) {
		this.classificationSystem = classificationSystem;
	}

	public Long getClassificationId() {
		return this.classificationId;
	}

	public void setClassificationId(Long classificationId) {
		this.classificationId = classificationId;
	}

	public String getClassificationCode() {
		return this.classificationCode;
	}

	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
	}

	public String getClassificationName() {
		return this.classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}
}
