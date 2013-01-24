/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.fin.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

@Ds(entity = PaymentItem.class)
@RefLookups({
		@RefLookup(refId = PaymentItemDs.f_paymentId),
		@RefLookup(refId = PaymentItemDs.f_accItemId, namedQuery = AccItem.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PaymentItemDs.f_accItem)}),
		@RefLookup(refId = PaymentItemDs.f_productId, namedQuery = Product.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PaymentItemDs.f_product)}),
		@RefLookup(refId = PaymentItemDs.f_uomId, namedQuery = Uom.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PaymentItemDs.f_uom)})})
public class PaymentItemDs extends AbstractAuditableDs<PaymentItem> {

	public static final String f_paymentId = "paymentId";
	public static final String f_accItemId = "accItemId";
	public static final String f_accItem = "accItem";
	public static final String f_productId = "productId";
	public static final String f_product = "product";
	public static final String f_uomId = "uomId";
	public static final String f_uom = "uom";
	public static final String f_quantity = "quantity";
	public static final String f_unitPrice = "unitPrice";
	public static final String f_amount = "amount";

	@DsField(join = "left", path = "payment.id")
	private Long paymentId;

	@DsField(join = "left", path = "accItem.id")
	private Long accItemId;

	@DsField(join = "left", path = "accItem.name")
	private String accItem;

	@DsField(join = "left", path = "product.id")
	private Long productId;

	@DsField(join = "left", path = "product.code")
	private String product;

	@DsField(join = "left", path = "uom.id")
	private Long uomId;

	@DsField(join = "left", path = "uom.code")
	private String uom;

	@DsField
	private Float quantity;

	@DsField
	private Float unitPrice;

	@DsField
	private Float amount;

	public PaymentItemDs() {
		super();
	}

	public PaymentItemDs(PaymentItem e) {
		super(e);
	}

	public Long getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getAccItemId() {
		return this.accItemId;
	}

	public void setAccItemId(Long accItemId) {
		this.accItemId = accItemId;
	}

	public String getAccItem() {
		return this.accItem;
	}

	public void setAccItem(String accItem) {
		this.accItem = accItem;
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

	public Float getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public Float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}
}
