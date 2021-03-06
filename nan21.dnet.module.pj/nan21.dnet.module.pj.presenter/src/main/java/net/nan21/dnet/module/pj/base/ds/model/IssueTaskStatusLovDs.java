/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;

@Ds(entity = IssueTaskStatus.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = IssueTaskStatusLovDs.f_name)})
public class IssueTaskStatusLovDs extends AbstractTypeLov<IssueTaskStatus> {

	public IssueTaskStatusLovDs() {
		super();
	}

	public IssueTaskStatusLovDs(IssueTaskStatus e) {
		super(e);
	}
}
