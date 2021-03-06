/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.price.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.mm.price.domain.entity.ProductPrice;

@Ds(entity = ProductPrice.class)
public class ProductPriceReportDs extends AbstractAuditableDs<ProductPrice> {

	public static final String f_priceListId = "priceListId";
	public static final String f_priceList = "priceList";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";
	public static final String f_priceListVersionId = "priceListVersionId";
	public static final String f_priceListVersion = "priceListVersion";
	public static final String f_validFrom = "validFrom";
	public static final String f_productId = "productId";
	public static final String f_product = "product";
	public static final String f_productName = "productName";
	public static final String f_uomId = "uomId";
	public static final String f_uom = "uom";
	public static final String f_price = "price";

	@DsField(join = "left", path = "priceListVersion.priceList.id")
	private Long priceListId;

	@DsField(join = "left", path = "priceListVersion.priceList.name")
	private String priceList;

	@DsField(join = "left", path = "priceListVersion.priceList.currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "priceListVersion.priceList.currency.code")
	private String currency;

	@DsField(join = "left", path = "priceListVersion.id")
	private Long priceListVersionId;

	@DsField(join = "left", path = "priceListVersion.name")
	private String priceListVersion;

	@DsField(join = "left", path = "priceListVersion.validFrom")
	private Date validFrom;

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

	public ProductPriceReportDs() {
		super();
	}

	public ProductPriceReportDs(ProductPrice e) {
		super(e);
	}

	public Long getPriceListId() {
		return this.priceListId;
	}

	public void setPriceListId(Long priceListId) {
		this.priceListId = priceListId;
	}

	public String getPriceList() {
		return this.priceList;
	}

	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}

	public Long getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
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
