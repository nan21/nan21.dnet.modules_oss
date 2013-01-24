/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.price.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceListVersion;
import net.nan21.dnet.module.md.mm.price.domain.entity.ProductPrice;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

@Ds(entity = ProductPrice.class)
@RefLookups({
		@RefLookup(refId = ProductPriceDs.f_productId, namedQuery = Product.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ProductPriceDs.f_product)}),
		@RefLookup(refId = ProductPriceDs.f_priceListVersionId, namedQuery = PriceListVersion.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ProductPriceDs.f_priceListVersion)}),
		@RefLookup(refId = ProductPriceDs.f_uomId, namedQuery = Uom.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductPriceDs.f_uom)})})
public class ProductPriceDs extends AbstractAuditableDs<ProductPrice> {

	public static final String f_priceListVersionId = "priceListVersionId";
	public static final String f_priceListVersion = "priceListVersion";
	public static final String f_productId = "productId";
	public static final String f_product = "product";
	public static final String f_productName = "productName";
	public static final String f_uomId = "uomId";
	public static final String f_uom = "uom";
	public static final String f_price = "price";

	@DsField(join = "left", path = "priceListVersion.id")
	private Long priceListVersionId;

	@DsField(join = "left", path = "priceListVersion.name")
	private String priceListVersion;

	@DsField(join = "left", path = "product.id")
	private Long productId;

	@DsField(join = "left", path = "product.code")
	private String product;

	@DsField(join = "left", path = "product.name")
	private String productName;

	@DsField(join = "left", path = "uom.id")
	private Long uomId;

	@DsField(join = "left", path = "uom.code")
	private String uom;

	@DsField
	private Float price;

	public ProductPriceDs() {
		super();
	}

	public ProductPriceDs(ProductPrice e) {
		super(e);
	}

	public Long getPriceListVersionId() {
		return this.priceListVersionId;
	}

	public void setPriceListVersionId(Long priceListVersionId) {
		this.priceListVersionId = priceListVersionId;
	}

	public String getPriceListVersion() {
		return this.priceListVersion;
	}

	public void setPriceListVersion(String priceListVersion) {
		this.priceListVersion = priceListVersion;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getUomId() {
		return this.uomId;
	}

	public void setUomId(Long uomId) {
		this.uomId = uomId;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
