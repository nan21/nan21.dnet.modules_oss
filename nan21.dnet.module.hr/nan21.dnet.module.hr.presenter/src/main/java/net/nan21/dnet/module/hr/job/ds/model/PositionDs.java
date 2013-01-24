/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.Position;

@Ds(entity = Position.class, sort = {@SortField(field = PositionDs.f_name)})
@RefLookups({
		@RefLookup(refId = PositionDs.f_orgId, namedQuery = Organization.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PositionDs.f_org)}),
		@RefLookup(refId = PositionDs.f_jobId, namedQuery = Job.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PositionDs.f_jobCode)})})
public class PositionDs extends AbstractTypeWithCodeDs<Position> {

	public static final String f_jobId = "jobId";
	public static final String f_jobCode = "jobCode";
	public static final String f_orgId = "orgId";
	public static final String f_org = "org";

	@DsField(join = "left", path = "job.id")
	private Long jobId;

	@DsField(join = "left", path = "job.code")
	private String jobCode;

	@DsField(join = "left", path = "org.id")
	private Long orgId;

	@DsField(join = "left", path = "org.code")
	private String org;

	public PositionDs() {
		super();
	}

	public PositionDs(Position e) {
		super(e);
	}

	public Long getJobId() {
		return this.jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobCode() {
		return this.jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public Long getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrg() {
		return this.org;
	}

	public void setOrg(String org) {
		this.org = org;
	}
}
