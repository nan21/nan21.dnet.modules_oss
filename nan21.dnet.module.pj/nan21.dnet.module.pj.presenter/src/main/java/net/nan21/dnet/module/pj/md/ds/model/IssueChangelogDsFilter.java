/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;
import java.util.Date;
import net.nan21.dnet.module.pj.md.ds.model.IssueChangelogDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class IssueChangelogDsFilter extends IssueChangelogDs {

	private Date fixedInVersionDate_From;

	private Date fixedInVersionDate_To;

	public Date getFixedInVersionDate_From() {
		return this.fixedInVersionDate_From;
	}

	public Date getFixedInVersionDate_To() {
		return this.fixedInVersionDate_To;
	}

	public void setFixedInVersionDate_From(Date fixedInVersionDate_From) {
		this.fixedInVersionDate_From = fixedInVersionDate_From;
	}

	public void setFixedInVersionDate_To(Date fixedInVersionDate_To) {
		this.fixedInVersionDate_To = fixedInVersionDate_To;
	}
}
