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
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductManufacturer;

@Ds(entity = Product.class, sort = {@SortField(field = ProductDs.f_name)})
@RefLookups({
		@RefLookup(refId = ProductDs.f_manufacturerId, namedQuery = ProductManufacturer.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductDs.f_manufacturerCode)}),
		@RefLookup(refId = ProductDs.f_defaultUomId, namedQuery = Uom.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductDs.f_defaultUomCode)}),
		@RefLookup(refId = ProductDs.f_dimUomId, namedQuery = Uom.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductDs.f_dimUomCode)}),
		@RefLookup(refId = ProductDs.f_volumeUomId, namedQuery = Uom.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductDs.f_volumeUomCode)}),
		@RefLookup(refId = ProductDs.f_weightUomId, namedQuery = Uom.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductDs.f_weightUomCode)}),
		@RefLookup(refId = ProductDs.f_attributeSetId, namedQuery = AttributeSet.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ProductDs.f_attributeSet)})})
public class ProductDs extends AbstractTypeWithCodeDs<Product> {

	public static final String f_iconUrl = "iconUrl";
	public static final String f_imageUrl = "imageUrl";
	public static final String f_description = "description";
	public static final String f_showInCatalog = "showInCatalog";
	public static final String f_sale = "sale";
	public static final String f_purchase = "purchase";
	public static final String f_storable = "storable";
	public static final String f_weight = "weight";
	public static final String f_volume = "volume";
	public static final String f_dimWidth = "dimWidth";
	public static final String f_dimHeight = "dimHeight";
	public static final String f_dimDepth = "dimDepth";
	public static final String f_manufacturerProductNo = "manufacturerProductNo";
	public static final String f_defaultUomId = "defaultUomId";
	public static final String f_defaultUomCode = "defaultUomCode";
	public static final String f_weightUomId = "weightUomId";
	public static final String f_weightUomCode = "weightUomCode";
	public static final String f_volumeUomId = "volumeUomId";
	public static final String f_volumeUomCode = "volumeUomCode";
	public static final String f_dimUomId = "dimUomId";
	public static final String f_dimUomCode = "dimUomCode";
	public static final String f_manufacturerId = "manufacturerId";
	public static final String f_manufacturerCode = "manufacturerCode";
	public static final String f_attributeSetId = "attributeSetId";
	public static final String f_attributeSet = "attributeSet";
	public static final String f_className = "className";
	public static final String f_businessObject = "businessObject";
	public static final String f_iconLocation = "iconLocation";
	public static final String f_imageLocation = "imageLocation";

	@DsField
	private String iconUrl;

	@DsField
	private String imageUrl;

	@DsField
	private String description;

	@DsField
	private Boolean showInCatalog;

	@DsField
	private Boolean sale;

	@DsField
	private Boolean purchase;

	@DsField
	private Boolean storable;

	@DsField
	private Float weight;

	@DsField
	private Float volume;

	@DsField
	private Float dimWidth;

	@DsField
	private Float dimHeight;

	@DsField
	private Float dimDepth;

	@DsField
	private String manufacturerProductNo;

	@DsField(join = "left", path = "defaultUom.id")
	private Long defaultUomId;

	@DsField(join = "left", path = "defaultUom.code")
	private String defaultUomCode;

	@DsField(join = "left", path = "weightUom.id")
	private Long weightUomId;

	@DsField(join = "left", path = "weightUom.code")
	private String weightUomCode;

	@DsField(join = "left", path = "volumeUom.id")
	private Long volumeUomId;

	@DsField(join = "left", path = "volumeUom.code")
	private String volumeUomCode;

	@DsField(join = "left", path = "dimUom.id")
	private Long dimUomId;

	@DsField(join = "left", path = "dimUom.code")
	private String dimUomCode;

	@DsField(join = "left", path = "manufacturer.id")
	private Long manufacturerId;

	@DsField(join = "left", path = "manufacturer.code")
	private String manufacturerCode;

	@DsField(join = "left", path = "attributeSet.id")
	private Long attributeSetId;

	@DsField(join = "left", path = "attributeSet.name")
	private String attributeSet;

	@DsField(fetch = false)
	private String className;

	@DsField(fetch = false)
	private String businessObject;

	private String iconLocation;

	private String imageLocation;

	public ProductDs() {
		super();
	}

	public ProductDs(Product e) {
		super(e);
	}

	public String getIconUrl() {
		return this.iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getShowInCatalog() {
		return this.showInCatalog;
	}

	public void setShowInCatalog(Boolean showInCatalog) {
		this.showInCatalog = showInCatalog;
	}

	public Boolean getSale() {
		return this.sale;
	}

	public void setSale(Boolean sale) {
		this.sale = sale;
	}

	public Boolean getPurchase() {
		return this.purchase;
	}

	public void setPurchase(Boolean purchase) {
		this.purchase = purchase;
	}

	public Boolean getStorable() {
		return this.storable;
	}

	public void setStorable(Boolean storable) {
		this.storable = storable;
	}

	public Float getWeight() {
		return this.weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getVolume() {
		return this.volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}

	public Float getDimWidth() {
		return this.dimWidth;
	}

	public void setDimWidth(Float dimWidth) {
		this.dimWidth = dimWidth;
	}

	public Float getDimHeight() {
		return this.dimHeight;
	}

	public void setDimHeight(Float dimHeight) {
		this.dimHeight = dimHeight;
	}

	public Float getDimDepth() {
		return this.dimDepth;
	}

	public void setDimDepth(Float dimDepth) {
		this.dimDepth = dimDepth;
	}

	public String getManufacturerProductNo() {
		return this.manufacturerProductNo;
	}

	public void setManufacturerProductNo(String manufacturerProductNo) {
		this.manufacturerProductNo = manufacturerProductNo;
	}

	public Long getDefaultUomId() {
		return this.defaultUomId;
	}

	public void setDefaultUomId(Long defaultUomId) {
		this.defaultUomId = defaultUomId;
	}

	public String getDefaultUomCode() {
		return this.defaultUomCode;
	}

	public void setDefaultUomCode(String defaultUomCode) {
		this.defaultUomCode = defaultUomCode;
	}

	public Long getWeightUomId() {
		return this.weightUomId;
	}

	public void setWeightUomId(Long weightUomId) {
		this.weightUomId = weightUomId;
	}

	public String getWeightUomCode() {
		return this.weightUomCode;
	}

	public void setWeightUomCode(String weightUomCode) {
		this.weightUomCode = weightUomCode;
	}

	public Long getVolumeUomId() {
		return this.volumeUomId;
	}

	public void setVolumeUomId(Long volumeUomId) {
		this.volumeUomId = volumeUomId;
	}

	public String getVolumeUomCode() {
		return this.volumeUomCode;
	}

	public void setVolumeUomCode(String volumeUomCode) {
		this.volumeUomCode = volumeUomCode;
	}

	public Long getDimUomId() {
		return this.dimUomId;
	}

	public void setDimUomId(Long dimUomId) {
		this.dimUomId = dimUomId;
	}

	public String getDimUomCode() {
		return this.dimUomCode;
	}

	public void setDimUomCode(String dimUomCode) {
		this.dimUomCode = dimUomCode;
	}

	public Long getManufacturerId() {
		return this.manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerCode() {
		return this.manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public Long getAttributeSetId() {
		return this.attributeSetId;
	}

	public void setAttributeSetId(Long attributeSetId) {
		this.attributeSetId = attributeSetId;
	}

	public String getAttributeSet() {
		return this.attributeSet;
	}

	public void setAttributeSet(String attributeSet) {
		this.attributeSet = attributeSet;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getBusinessObject() {
		return this.businessObject;
	}

	public void setBusinessObject(String businessObject) {
		this.businessObject = businessObject;
	}

	public String getIconLocation() {
		return this.iconLocation;
	}

	public void setIconLocation(String iconLocation) {
		this.iconLocation = iconLocation;
	}

	public String getImageLocation() {
		return this.imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
}
