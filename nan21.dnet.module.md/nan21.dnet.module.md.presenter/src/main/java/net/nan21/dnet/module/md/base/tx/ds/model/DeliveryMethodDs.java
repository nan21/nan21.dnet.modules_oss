/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.base.tx.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;

@Ds(entity = DeliveryMethod.class, sort = {@SortField(field = DeliveryMethodDs.f_name)})
public class DeliveryMethodDs extends AbstractTypeDs<DeliveryMethod> {

	public static final String f_delivery = "delivery";
	public static final String f_externalCourier = "externalCourier";

	@DsField
	private Boolean delivery;

	@DsField
	private Boolean externalCourier;

	public DeliveryMethodDs() {
		super();
	}

	public DeliveryMethodDs(DeliveryMethod e) {
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
