/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.bd.contact.domain.entity.Person;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Business partner contacts. */
@NamedQueries({})
@Entity
@CascadeOnDelete
@Table(name = Contact.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class Contact extends Person {

	public static final String TABLE_NAME = "MD_BP_CNTC";
	public static final String SEQUENCE_NAME = "MD_BP_CNTC_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "ACTIVE", nullable = false)
	@NotNull
	private Boolean active;

	@Column(name = "POSITION", length = 255)
	private String position;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
	@JoinColumn(name = "BPARTNER_ID", referencedColumnName = "ID")
	private BusinessPartner bpartner;

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public BusinessPartner getBpartner() {
		return this.bpartner;
	}

	public void setBpartner(BusinessPartner bpartner) {
		if (bpartner != null) {
			this.__validate_client_context__(bpartner.getClientId());
		}
		this.bpartner = bpartner;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getActive() == null) {
		}
	}
}
