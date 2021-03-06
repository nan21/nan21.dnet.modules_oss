/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tx.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({@NamedQuery(name = DeliveryMethod.NQ_FIND_BY_NAME, query = "SELECT e FROM DeliveryMethod e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = DeliveryMethod.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = DeliveryMethod.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class DeliveryMethod extends AbstractType {

	public static final String TABLE_NAME = "MD_DLVR_MTD";
	public static final String SEQUENCE_NAME = "MD_DLVR_MTD_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "DeliveryMethod.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "DELIVERY", nullable = false)
	@NotNull
	private Boolean delivery;

	@Column(name = "EXTERNALCOURIER", nullable = false)
	@NotNull
	private Boolean externalCourier;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getDelivery() == null) {
			event.updateAttributeWithObject("delivery", false);
		}
		if (this.getExternalCourier() == null) {
			event.updateAttributeWithObject("externalCourier", false);
		}
	}
}
