/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

@Ds(entity = ReportServer.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = ReportServerLovDs.f_name)})
public class ReportServerLovDs extends AbstractTypeLov<ReportServer> {

	public ReportServerLovDs() {
		super();
	}

	public ReportServerLovDs(ReportServer e) {
		super(e);
	}
}
