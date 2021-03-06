/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.fi.asset.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;
import net.nan21.dnet.module.md.res.domain.entity.AssetBase;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({@NamedQuery(name = Asset.NQ_FIND_BY_CODE, query = "SELECT e FROM Asset e WHERE e.clientId = :pClientId and e.code = :pCode", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@CascadeOnDelete
@Table(name = Asset.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class Asset extends AssetBase {

	public static final String TABLE_NAME = "FI_ASSET";
	public static final String SEQUENCE_NAME = "FI_ASSET_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Asset.findByCode";

	@Column(name = "WITHDEPRECIATION", nullable = false)
	@NotNull
	private Boolean withDepreciation;

	@Column(name = "METHOD", length = 16)
	private String method;

	@Column(name = "CALCULATION", length = 16)
	private String calculation;

	@Column(name = "PERIODTYPE", length = 16)
	private String periodType;

	@Column(name = "PERIODVALUE")
	private Integer periodValue;

	@Column(name = "PERIODPERCENATGE")
	private Integer periodPercenatge;

	@Temporal(TemporalType.DATE)
	@Column(name = "DEPRECSTARTDATE")
	private Date deprecStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "DEPRECENDDATE")
	private Date deprecEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "PURCHASEDATE")
	private Date purchaseDate;

	@Column(name = "INITIALVALUE", scale = 2)
	private Float initialValue;

	@Column(name = "RESIDUALVALUE", scale = 2)
	private Float residualValue;

	@Column(name = "INITIALDEPRECAMOUNT", scale = 2)
	private Float initialDeprecAmount;

	@Column(name = "DEPRECAMOUNT", scale = 2)
	private Float deprecAmount;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AssetCategory.class)
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
	private AssetCategory category;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
	@JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID")
	private Currency currency;

	public Boolean getWithDepreciation() {
		return this.withDepreciation;
	}

	public void setWithDepreciation(Boolean withDepreciation) {
		this.withDepreciation = withDepreciation;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCalculation() {
		return this.calculation;
	}

	public void setCalculation(String calculation) {
		this.calculation = calculation;
	}

	public String getPeriodType() {
		return this.periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public Integer getPeriodValue() {
		return this.periodValue;
	}

	public void setPeriodValue(Integer periodValue) {
		this.periodValue = periodValue;
	}

	public Integer getPeriodPercenatge() {
		return this.periodPercenatge;
	}

	public void setPeriodPercenatge(Integer periodPercenatge) {
		this.periodPercenatge = periodPercenatge;
	}

	public Date getDeprecStartDate() {
		return this.deprecStartDate;
	}

	public void setDeprecStartDate(Date deprecStartDate) {
		this.deprecStartDate = deprecStartDate;
	}

	public Date getDeprecEndDate() {
		return this.deprecEndDate;
	}

	public void setDeprecEndDate(Date deprecEndDate) {
		this.deprecEndDate = deprecEndDate;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Float getInitialValue() {
		return this.initialValue;
	}

	public void setInitialValue(Float initialValue) {
		this.initialValue = initialValue;
	}

	public Float getResidualValue() {
		return this.residualValue;
	}

	public void setResidualValue(Float residualValue) {
		this.residualValue = residualValue;
	}

	public Float getInitialDeprecAmount() {
		return this.initialDeprecAmount;
	}

	public void setInitialDeprecAmount(Float initialDeprecAmount) {
		this.initialDeprecAmount = initialDeprecAmount;
	}

	public Float getDeprecAmount() {
		return this.deprecAmount;
	}

	public void setDeprecAmount(Float deprecAmount) {
		this.deprecAmount = deprecAmount;
	}

	public AssetCategory getCategory() {
		return this.category;
	}

	public void setCategory(AssetCategory category) {
		if (category != null) {
			this.__validate_client_context__(category.getClientId());
		}
		this.category = category;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		if (currency != null) {
			this.__validate_client_context__(currency.getClientId());
		}
		this.currency = currency;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getWithDepreciation() == null) {
			event.updateAttributeWithObject("withDepreciation", false);
		}
	}
}
