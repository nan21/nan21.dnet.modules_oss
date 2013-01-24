/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;
import java.util.Date;
import net.nan21.dnet.module.pj.md.ds.model.IssueRoadmapDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class IssueRoadmapDsFilter extends IssueRoadmapDs {

	private Date targetVersionDate_From;

	private Date targetVersionDate_To;

	public Date getTargetVersionDate_From() {
		return this.targetVersionDate_From;
	}

	public Date getTargetVersionDate_To() {
		return this.targetVersionDate_To;
	}

	public void setTargetVersionDate_From(Date targetVersionDate_From) {
		this.targetVersionDate_From = targetVersionDate_From;
	}

	public void setTargetVersionDate_To(Date targetVersionDate_To) {
		this.targetVersionDate_To = targetVersionDate_To;
	}
}
