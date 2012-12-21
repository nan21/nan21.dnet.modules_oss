/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtxParam;

@Ds(entity = SysJobCtxParam.class)
@RefLookups({
		@RefLookup(refId = SysJobCtxParamDs.f_jobCtxId, namedQuery = SysJobCtx.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = SysJobCtxParamDs.f_jobCtx)}),
		@RefLookup(refId = SysJobCtxParamDs.f_jobParamId)})
public class SysJobCtxParamDs extends AbstractAuditableDs<SysJobCtxParam> {

	public static final String f_jobCtxId = "jobCtxId";
	public static final String f_jobCtx = "jobCtx";
	public static final String f_jobAlias = "jobAlias";
	public static final String f_jobParamId = "jobParamId";
	public static final String f_jobParam = "jobParam";
	public static final String f_dataType = "dataType";

	@DsField(join = "left", path = "jobCtx.id")
	private Long jobCtxId;

	@DsField(join = "left", path = "jobCtx.name")
	private String jobCtx;

	@DsField(join = "left", path = "jobCtx.jobAlias")
	private String jobAlias;

	@DsField(join = "left", path = "jobParam.id")
	private Long jobParamId;

	@DsField(join = "left", path = "jobParam.name")
	private String jobParam;

	@DsField(join = "left", path = "jobParam.dataType")
	private String dataType;

	public SysJobCtxParamDs() {
		super();
	}

	public SysJobCtxParamDs(SysJobCtxParam e) {
		super(e);
	}

	public Long getJobCtxId() {
		return this.jobCtxId;
	}

	public void setJobCtxId(Long jobCtxId) {
		this.jobCtxId = jobCtxId;
	}

	public String getJobCtx() {
		return this.jobCtx;
	}

	public void setJobCtx(String jobCtx) {
		this.jobCtx = jobCtx;
	}

	public String getJobAlias() {
		return this.jobAlias;
	}

	public void setJobAlias(String jobAlias) {
		this.jobAlias = jobAlias;
	}

	public Long getJobParamId() {
		return this.jobParamId;
	}

	public void setJobParamId(Long jobParamId) {
		this.jobParamId = jobParamId;
	}

	public String getJobParam() {
		return this.jobParam;
	}

	public void setJobParam(String jobParam) {
		this.jobParam = jobParam;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
