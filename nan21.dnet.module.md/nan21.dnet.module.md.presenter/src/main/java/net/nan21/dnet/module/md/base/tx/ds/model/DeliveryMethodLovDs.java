/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.base.tx.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;

@Ds(entity = DeliveryMethod.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = DeliveryMethodLovDs.f_name)})
public class DeliveryMethodLovDs extends AbstractTypeLov<DeliveryMethod> {

	public static final String f_delivery = "delivery";
	public static final String f_externalCourier = "externalCourier";

	@DsField
	private Boolean delivery;

	@DsField
	private Boolean externalCourier;

	public DeliveryMethodLovDs() {
		super();
	}

	public DeliveryMethodLovDs(DeliveryMethod e) {
		super(e);
	}

	public Boolean getDelivery() {
		return this.delivery;
	}

	public void setDelivery(Boolean delivery) {
		this.delivery = delivery;
	}

	public Boolean getExternalCourier() {
		return this.externalCourier;
	}

	public void setExternalCourier(Boolean externalCourier) {
		this.externalCourier = externalCourier;
	}
}
