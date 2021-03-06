/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({
		@NamedQuery(name = Country.NQ_FIND_BY_CODE, query = "SELECT e FROM Country e WHERE e.clientId = :pClientId and e.code = :pCode", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Country.NQ_FIND_BY_NAME, query = "SELECT e FROM Country e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Country.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = Country.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = Country.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class Country extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "BD_GEO_CNTRY";
	public static final String SEQUENCE_NAME = "BD_GEO_CNTRY_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Country.findByCode";

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Country.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "ISO2", length = 2)
	private String iso2;

	@Column(name = "ISO3", length = 3)
	private String iso3;

	@Column(name = "HASREGIONS", nullable = false)
	@NotNull
	private Boolean hasRegions;

	@Column(name = "DEFAULTCURRENCY", length = 3)
	private String defaultCurrency;

	@Column(name = "DEFAULTLANGUAGE", length = 5)
	private String defaultLanguage;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIso2() {
		return this.iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	public String getIso3() {
		return this.iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public Boolean getHasRegions() {
		return this.hasRegions;
	}

	public void setHasRegions(Boolean hasRegions) {
		this.hasRegions = hasRegions;
	}

	public String getDefaultCurrency() {
		return this.defaultCurrency;
	}

	public void setDefaultCurrency(String defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	}

	public String getDefaultLanguage() {
		return this.defaultLanguage;
	}

	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getHasRegions() == null) {
			event.updateAttributeWithObject("hasRegions", false);
		}
	}
}
