/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.ad.system.domain.entity.CustomFieldGroup;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({
		@NamedQuery(name = CustomField.NQ_FIND_BY_ID, query = "SELECT e FROM CustomField e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = CustomField.NQ_FIND_BY_IDS, query = "SELECT e FROM CustomField e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = CustomField.NQ_FIND_BY_GROUP_NAME, query = "SELECT e FROM CustomField e WHERE e.clientId = :pClientId and e.group = :pGroup and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = CustomField.NQ_FIND_BY_GROUP_NAME_PRIMITIVE, query = "SELECT e FROM CustomField e WHERE e.clientId = :pClientId and e.group.id = :pGroupId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = CustomField.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = CustomField.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "GROUP_ID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class CustomField extends AbstractType {

	public static final String TABLE_NAME = "AD_CUST_FIELD";
	public static final String SEQUENCE_NAME = "AD_CUST_FIELD_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by ID.
	 */
	public static final String NQ_FIND_BY_ID = "CustomField.findById";

	/**
	 * Named query find by IDs.
	 */
	public static final String NQ_FIND_BY_IDS = "CustomField.findByIds";

	/**
	 * Named query find by unique key: Group_name.
	 */
	public static final String NQ_FIND_BY_GROUP_NAME = "CustomField.findByGroup_name";

	/**
	 * Named query find by unique key: Group_name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_GROUP_NAME_PRIMITIVE = "CustomField.findByGroup_name_PRIMITIVE";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "DATATYPE", nullable = false, length = 32)
	@NotBlank
	private String dataType;

	@Column(name = "LABEL", length = 255)
	private String label;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CustomFieldGroup.class)
	@JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
	private CustomFieldGroup group;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public CustomFieldGroup getGroup() {
		return this.group;
	}

	public void setGroup(CustomFieldGroup group) {
		if (group != null) {
			this.__validate_client_context__(group.getClientId());
		}
		this.group = group;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
