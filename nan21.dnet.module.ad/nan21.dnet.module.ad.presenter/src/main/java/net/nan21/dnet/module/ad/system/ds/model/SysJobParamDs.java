/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysJob;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;

@Ds(entity = SysJobParam.class, sort = {@SortField(field = SysJobParamDs.f_name)})
@RefLookups({@RefLookup(refId = SysJobParamDs.f_jobId, namedQuery = SysJob.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = SysJobParamDs.f_job)})})
public class SysJobParamDs extends AbstractTypeDs<SysJobParam> {

	public static final String f_jobId = "jobId";
	public static final String f_job = "job";
	public static final String f_dataType = "dataType";

	@DsField(join = "left", path = "job.id")
	private Long jobId;

	@DsField(join = "left", path = "job.name")
	private String job;

	@DsField
	private String dataType;

	public SysJobParamDs() {
		super();
	}

	public SysJobParamDs(SysJobParam e) {
		super(e);
	}

	public Long getJobId() {
		return this.jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
