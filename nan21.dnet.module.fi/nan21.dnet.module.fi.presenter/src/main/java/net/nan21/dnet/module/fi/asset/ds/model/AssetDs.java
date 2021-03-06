/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.fi.asset.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

@Ds(entity = Asset.class, sort = {@SortField(field = AssetDs.f_name)})
@RefLookups({
		@RefLookup(refId = AssetDs.f_orgId, namedQuery = Organization.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = AssetDs.f_org)}),
		@RefLookup(refId = AssetDs.f_categoryId, namedQuery = AssetCategory.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = AssetDs.f_category)}),
		@RefLookup(refId = AssetDs.f_currencyId, namedQuery = Currency.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = AssetDs.f_currency)}),
		@RefLookup(refId = AssetDs.f_productId, namedQuery = Product.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = AssetDs.f_productCode)})})
public class AssetDs extends AbstractTypeWithCodeDs<Asset> {

	public static final String f_orgId = "orgId";
	public static final String f_org = "org";
	public static final String f_categoryId = "categoryId";
	public static final String f_category = "category";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";
	public static final String f_productId = "productId";
	public static final String f_productCode = "productCode";
	public static final String f_productName = "productName";
	public static final String f_withDepreciation = "withDepreciation";
	public static final String f_method = "method";
	public static final String f_calculation = "calculation";
	public static final String f_periodType = "periodType";
	public static final String f_periodValue = "periodValue";
	public static final String f_periodPercenatge = "periodPercenatge";
	public static final String f_deprecStartDate = "deprecStartDate";
	public static final String f_deprecEndDate = "deprecEndDate";
	public static final String f_purchaseDate = "purchaseDate";
	public static final String f_initialValue = "initialValue";
	public static final String f_residualValue = "residualValue";
	public static final String f_depreciationAmount = "depreciationAmount";
	public static final String f_initialDeprecAmount = "initialDeprecAmount";

	@DsField(join = "left", path = "org.id")
	private Long orgId;

	@DsField(join = "left", path = "org.code")
	private String org;

	@DsField(join = "left", path = "category.id")
	private Long categoryId;

	@DsField(join = "left", path = "category.code")
	private String category;

	@DsField(join = "left", path = "currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currency;

	@DsField(join = "left", path = "product.id")
	private Long productId;

	@DsField(join = "left", path = "product.code")
	private String productCode;

	@DsField(join = "left", path = "product.name")
	private String productName;

	@DsField
	private Boolean withDepreciation;

	@DsField
	private String method;

	@DsField
	private String calculation;

	@DsField
	private String periodType;

	@DsField
	private Integer periodValue;

	@DsField
	private Integer periodPercenatge;

	@DsField
	private Date deprecStartDate;

	@DsField
	private Date deprecEndDate;

	@DsField
	private Date purchaseDate;

	@DsField
	private Float initialValue;

	@DsField
	private Float residualValue;

	@DsField(path = "deprecAmount")
	private Float depreciationAmount;

	@DsField
	private Float initialDeprecAmount;

	public AssetDs() {
		super();
	}

	public AssetDs(Asset e) {
		super(e);
	}

	public Long getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrg() {
		return this.org;
	}

	public void setOrg(String org) {
		this.org = org;
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

	public Boolean getWithDepreciation() {
		return this.withDepreciation;
	}

	public void setWithDepreciation(Boolean withDepreciation) {
		this.withDepreciation = withDepreciation;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCalculation() {
		return this.calculation;
	}

	public void setCalculation(String calculation) {
		this.calculation = calculation;
	}

	public String getPeriodType() {
		return this.periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public Integer getPeriodValue() {
		return this.periodValue;
	}

	public void setPeriodValue(Integer periodValue) {
		this.periodValue = periodValue;
	}

	public Integer getPeriodPercenatge() {
		return this.periodPercenatge;
	}

	public void setPeriodPercenatge(Integer periodPercenatge) {
		this.periodPercenatge = periodPercenatge;
	}

	public Date getDeprecStartDate() {
		return this.deprecStartDate;
	}

	public void setDeprecStartDate(Date deprecStartDate) {
		this.deprecStartDate = deprecStartDate;
	}

	public Date getDeprecEndDate() {
		return this.deprecEndDate;
	}

	public void setDeprecEndDate(Date deprecEndDate) {
		this.deprecEndDate = deprecEndDate;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Float getInitialValue() {
		return this.initialValue;
	}

	public void setInitialValue(Float initialValue) {
		this.initialValue = initialValue;
	}

	public Float getResidualValue() {
		return this.residualValue;
	}

	public void setResidualValue(Float residualValue) {
		this.residualValue = residualValue;
	}

	public Float getDepreciationAmount() {
		return this.depreciationAmount;
	}

	public void setDepreciationAmount(Float depreciationAmount) {
		this.depreciationAmount = depreciationAmount;
	}

	public Float getInitialDeprecAmount() {
		return this.initialDeprecAmount;
	}

	public void setInitialDeprecAmount(Float initialDeprecAmount) {
		this.initialDeprecAmount = initialDeprecAmount;
	}
}
