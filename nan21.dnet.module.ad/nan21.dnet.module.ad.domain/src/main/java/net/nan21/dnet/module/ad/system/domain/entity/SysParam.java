/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractTypeWithCodeNoTenant;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/**  
 * System parameters.
 */
@NamedQueries({
		@NamedQuery(name = SysParam.NQ_FIND_BY_CODE, query = "SELECT e FROM SysParam e WHERE e.code = :pCode", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = SysParam.NQ_FIND_BY_NAME, query = "SELECT e FROM SysParam e WHERE e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = SysParam.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = SysParam.TABLE_NAME + "_UK1", columnNames = {"CODE"}),
		@UniqueConstraint(name = SysParam.TABLE_NAME + "_UK2", columnNames = {"NAME"})})
@Customizer(DefaultEventHandler.class)
public class SysParam extends AbstractTypeWithCodeNoTenant {

	public static final String TABLE_NAME = "AD_SYS_PARAM";
	public static final String SEQUENCE_NAME = "AD_SYS_PARAM_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "SysParam.findByCode";

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "SysParam.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "DEFAULTVALUE", length = 400)
	private String defaultValue;

	@Column(name = "LISTOFVALUES", length = 400)
	private String listOfValues;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getListOfValues() {
		return this.listOfValues;
	}

	public void setListOfValues(String listOfValues) {
		this.listOfValues = listOfValues;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
