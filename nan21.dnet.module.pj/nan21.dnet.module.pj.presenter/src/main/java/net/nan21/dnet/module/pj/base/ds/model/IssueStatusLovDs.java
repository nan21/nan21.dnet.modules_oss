/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.pj.base.domain.entity.IssueStatus;

@Ds(entity = IssueStatus.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = IssueStatusLovDs.f_name)})
public class IssueStatusLovDs extends AbstractTypeLov<IssueStatus> {

	public IssueStatusLovDs() {
		super();
	}

	public IssueStatusLovDs(IssueStatus e) {
		super(e);
	}
}
