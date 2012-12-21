/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import javax.persistence.QueryHint;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.DsQueryHints;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeValue;
import org.eclipse.persistence.config.QueryHints;

@Ds(entity = ProductAttributeValue.class)
@DsQueryHints({@QueryHint(name = QueryHints.LEFT_FETCH, value = "e.product.attributeSet")})
@RefLookups({
		@RefLookup(refId = ProductAttributeValueDs.f_productId, namedQuery = Product.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductAttributeValueDs.f_productCode)}),
		@RefLookup(refId = ProductAttributeValueDs.f_attributeId, namedQuery = Attribute.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ProductAttributeValueDs.f_attribute)})})
public class ProductAttributeValueDs
		extends
			AbstractAuditableDs<ProductAttributeValue> {

	public static final String f_productId = "productId";
	public static final String f_productCode = "productCode";
	public static final String f_productName = "productName";
	public static final String f_setId = "setId";
	public static final String f_set = "set";
	public static final String f_attributeId = "attributeId";
	public static final String f_attribute = "attribute";
	public static final String f_title = "title";
	public static final String f_dataType = "dataType";
	public static final String f_categoryId = "categoryId";
	public static final String f_category = "category";
	public static final String f_uom = "uom";
	public static final String f_listOfvalues = "listOfvalues";
	public static final String f_value = "value";

	@DsField(join = "left", path = "product.id")
	private Long productId;

	@DsField(join = "left", path = "product.code")
	private String productCode;

	@DsField(join = "left", path = "product.name")
	private String productName;

	@DsField(join = "left", path = "product.attributeSet.id")
	private Long setId;

	@DsField(join = "left", path = "product.attributeSet.name")
	private String set;

	@DsField(join = "left", path = "attribute.id")
	private Long attributeId;

	@DsField(join = "left", path = "attribute.name")
	private String attribute;

	@DsField(join = "left", path = "attribute.title")
	private String title;

	@DsField(join = "left", path = "attribute.dataType")
	private String dataType;

	@DsField(join = "left", path = "attribute.category.id")
	private Long categoryId;

	@DsField(join = "left", path = "attribute.category.name")
	private String category;

	@DsField(join = "left", path = "attribute.uom.code")
	private String uom;

	@DsField(join = "left", path = "attribute.listOfvalues")
	private String listOfvalues;

	@DsField
	private String value;

	public ProductAttributeValueDs() {
		super();
	}

	public ProductAttributeValueDs(ProductAttributeValue e) {
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

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getSetId() {
		return this.setId;
	}

	public void setSetId(Long setId) {
		this.setId = setId;
	}

	public String getSet() {
		return this.set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public Long getAttributeId() {
		return this.attributeId;
	}

	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getListOfvalues() {
		return this.listOfvalues;
	}

	public void setListOfvalues(String listOfvalues) {
		this.listOfvalues = listOfvalues;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
