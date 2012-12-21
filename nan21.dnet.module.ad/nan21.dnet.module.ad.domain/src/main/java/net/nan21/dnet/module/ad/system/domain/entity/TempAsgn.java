/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = TempAsgn.TABLE_NAME)
@ReadOnly
@Customizer(DefaultEventHandler.class)
public class TempAsgn implements IModelWithId, Serializable {

	public static final String TABLE_NAME = "AD_TEMP_ASGN";
	public static final String SEQUENCE_NAME = "AD_TEMP_ASGN_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "UUID", nullable = false, length = 255)
	@NotBlank
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private String id;

	@Column(name = "ASGNCMP", nullable = false, length = 255)
	@NotBlank
	private String asgnName;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAsgnName() {
		return this.asgnName;
	}

	public void setAsgnName(String asgnName) {
		this.asgnName = asgnName;
	}

	public void aboutToInsert(DescriptorEvent event) {

	}

	public void aboutToUpdate(DescriptorEvent event) {
	}
}
