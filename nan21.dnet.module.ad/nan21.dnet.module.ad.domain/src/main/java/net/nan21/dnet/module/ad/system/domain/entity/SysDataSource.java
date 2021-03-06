/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractTypeNoTenant;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({
		@NamedQuery(name = SysDataSource.NQ_FIND_BY_NAME, query = "SELECT e FROM SysDataSource e WHERE e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = SysDataSource.NQ_FIND_BY_MODEL, query = "SELECT e FROM SysDataSource e WHERE e.model = :pModel", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = SysDataSource.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = SysDataSource.TABLE_NAME + "_UK1", columnNames = {"NAME"}),
		@UniqueConstraint(name = SysDataSource.TABLE_NAME + "_UK2", columnNames = {"MODEL"})})
@Customizer(DefaultEventHandler.class)
public class SysDataSource extends AbstractTypeNoTenant {

	public static final String TABLE_NAME = "AD_SYS_DS";
	public static final String SEQUENCE_NAME = "AD_SYS_DS_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "SysDataSource.findByName";

	/**
	 * Named query find by unique key: Model.
	 */
	public static final String NQ_FIND_BY_MODEL = "SysDataSource.findByModel";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "MODEL", nullable = false, length = 255)
	@NotBlank
	private String model;

	@Column(name = "ISASGN", nullable = false)
	@NotNull
	private Boolean isAsgn;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = SysDsField.class, mappedBy = "dataSource", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<SysDsField> fields;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = SysDsService.class, mappedBy = "dataSource", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<SysDsService> serviceMethods;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getIsAsgn() {
		return this.isAsgn;
	}

	public void setIsAsgn(Boolean isAsgn) {
		this.isAsgn = isAsgn;
	}

	public Collection<SysDsField> getFields() {
		return this.fields;
	}

	public void setFields(Collection<SysDsField> fields) {
		this.fields = fields;
	}

	public void addToFields(SysDsField e) {
		if (this.fields == null) {
			this.fields = new ArrayList<SysDsField>();
		}
		e.setDataSource(this);
		this.fields.add(e);
	}

	public Collection<SysDsService> getServiceMethods() {
		return this.serviceMethods;
	}

	public void setServiceMethods(Collection<SysDsService> serviceMethods) {
		this.serviceMethods = serviceMethods;
	}

	public void addToServiceMethods(SysDsService e) {
		if (this.serviceMethods == null) {
			this.serviceMethods = new ArrayList<SysDsService>();
		}
		e.setDataSource(this);
		this.serviceMethods.add(e);
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getIsAsgn() == null) {
			event.updateAttributeWithObject("isAsgn", false);
		}
	}
}
