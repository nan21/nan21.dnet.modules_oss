/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.currency.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRate;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

@Ds(entity = CurrencyXRate.class, sort = {
		@SortField(field = CurrencyXRateDs.f_validAt, desc = true),
		@SortField(field = CurrencyXRateDs.f_sourceCode),
		@SortField(field = CurrencyXRateDs.f_targetCode)})
@RefLookups({
		@RefLookup(refId = CurrencyXRateDs.f_sourceId),
		@RefLookup(refId = CurrencyXRateDs.f_targetId),
		@RefLookup(refId = CurrencyXRateDs.f_providerId, namedQuery = CurrencyXRateProvider.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = CurrencyXRateDs.f_providerCode)})})
public class CurrencyXRateDs extends AbstractAuditableDs<CurrencyXRate> {

	public static final String f_sourceId = "sourceId";
	public static final String f_sourceCode = "sourceCode";
	public static final String f_targetId = "targetId";
	public static final String f_targetCode = "targetCode";
	public static final String f_validAt = "validAt";
	public static final String f_value = "value";
	public static final String f_providerId = "providerId";
	public static final String f_providerCode = "providerCode";

	@DsField(join = "left", path = "source.id")
	private Long sourceId;

	@DsField(join = "left", path = "source.code")
	private String sourceCode;

	@DsField(join = "left", path = "target.id")
	private Long targetId;

	@DsField(join = "left", path = "target.code")
	private String targetCode;

	@DsField
	private Date validAt;

	@DsField
	private Float value;

	@DsField(join = "left", path = "provider.id")
	private Long providerId;

	@DsField(join = "left", path = "provider.code")
	private String providerCode;

	public CurrencyXRateDs() {
		super();
	}

	public CurrencyXRateDs(CurrencyXRate e) {
		super(e);
	}

	public Long getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceCode() {
		return this.sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public Long getTargetId() {
		return this.targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public String getTargetCode() {
		return this.targetCode;
	}

	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}

	public Date getValidAt() {
		return this.validAt;
	}

	public void setValidAt(Date validAt) {
		this.validAt = validAt;
	}

	public Float getValue() {
		return this.value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Long getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	public String getProviderCode() {
		return this.providerCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}
}
