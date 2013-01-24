/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;

@Ds(entity = ProductAccount.class)
@RefLookups({
		@RefLookup(refId = ProductAccountDs.f_orgId, namedQuery = Organization.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductAccountDs.f_org)}),
		@RefLookup(refId = ProductAccountDs.f_groupId, namedQuery = ProductAccountGroup.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductAccountDs.f_groupCode)}),
		@RefLookup(refId = ProductAccountDs.f_productId, namedQuery = Product.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductAccountDs.f_productCode)})})
public class ProductAccountDs extends AbstractAuditableDs<ProductAccount> {

	public static final String f_orgId = "orgId";
	public static final String f_org = "org";
	public static final String f_groupId = "groupId";
	public static final String f_groupCode = "groupCode";
	public static final String f_productId = "productId";
	public static final String f_productCode = "productCode";
	public static final String f_analiticSegment = "analiticSegment";

	@DsField(join = "left", path = "org.id")
	private Long orgId;

	@DsField(join = "left", path = "org.code")
	private String org;

	@DsField(join = "left", path = "group.id")
	private Long groupId;

	@DsField(join = "left", path = "group.code")
	private String groupCode;

	@DsField(join = "left", path = "product.id")
	private Long productId;

	@DsField(join = "left", path = "product.code")
	private String productCode;

	@DsField
	private String analiticSegment;

	public ProductAccountDs() {
		super();
	}

	public ProductAccountDs(ProductAccount e) {
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

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupCode() {
		return this.groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
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

	public String getAnaliticSegment() {
		return this.analiticSegment;
	}

	public void setAnaliticSegment(String analiticSegment) {
		this.analiticSegment = analiticSegment;
	}
}
