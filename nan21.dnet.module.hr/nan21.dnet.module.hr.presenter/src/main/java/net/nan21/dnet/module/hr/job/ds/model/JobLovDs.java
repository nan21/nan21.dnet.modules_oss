/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.hr.job.domain.entity.Job;

@Ds(entity = Job.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = JobLovDs.f_code)})
public class JobLovDs extends AbstractTypeWithCodeLov<Job> {

	public JobLovDs() {
		super();
	}

	public JobLovDs(Job e) {
		super(e);
	}
}
