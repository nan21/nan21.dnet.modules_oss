/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

@Ds(entity = Product.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = ProductWithUomLovDs.fCODE)})
public class ProductWithUomLovDs extends AbstractTypeWithCodeLov<Product> {

	public static final String fUOMID = "uomId";
	public static final String fUOM = "uom";
	public static final String fSALE = "sale";
	public static final String fPURCHASE = "purchase";

	@DsField(join = "left", path = "defaultUom.id")
	private Long uomId;

	@DsField(join = "left", path = "defaultUom.code")
	private String uom;

	@DsField()
	private Boolean sale;

	@DsField()
	private Boolean purchase;

	public ProductWithUomLovDs() {
		super();
	}

	public ProductWithUomLovDs(Product e) {
		super(e);
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
}
