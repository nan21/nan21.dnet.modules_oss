/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = TempAsgnLine.TABLE_NAME)
@ReadOnly
@Customizer(DefaultEventHandler.class)
public class TempAsgnLine implements Serializable {

	public static final String TABLE_NAME = "AD_TEMP_ASGN_LINE";
	public static final String SEQUENCE_NAME = "AD_TEMP_ASGN_LINE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "ITEMID", nullable = false)
	@NotNull
	@Id
	private Long itemId;

	@Column(name = "SELECTION_UUID", nullable = false, length = 255)
	@NotBlank
	@Id
	private String selectionId;

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getSelectionId() {
		return this.selectionId;
	}

	public void setSelectionId(String selectionId) {
		this.selectionId = selectionId;
	}

	public void aboutToInsert(DescriptorEvent event) {

	}

	public void aboutToUpdate(DescriptorEvent event) {
	}
}
