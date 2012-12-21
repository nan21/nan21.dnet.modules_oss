/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.hr.job.domain.entity.JobType;

@Ds(entity = JobType.class, sort = {@SortField(field = JobTypeDs.f_name)})
public class JobTypeDs extends AbstractTypeDs<JobType> {

	public JobTypeDs() {
		super();
	}

	public JobTypeDs(JobType e) {
		super(e);
	}
}
