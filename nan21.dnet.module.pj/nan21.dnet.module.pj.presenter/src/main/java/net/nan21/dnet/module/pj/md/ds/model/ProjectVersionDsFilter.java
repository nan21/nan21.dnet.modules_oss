/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;
import java.util.Date;
import net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class ProjectVersionDsFilter extends ProjectVersionDs {

	private Date planDate_From;

	private Date planDate_To;

	private Date releaseDate_From;

	private Date releaseDate_To;

	public Date getPlanDate_From() {
		return this.planDate_From;
	}

	public Date getPlanDate_To() {
		return this.planDate_To;
	}

	public void setPlanDate_From(Date planDate_From) {
		this.planDate_From = planDate_From;
	}

	public void setPlanDate_To(Date planDate_To) {
		this.planDate_To = planDate_To;
	}

	public Date getReleaseDate_From() {
		return this.releaseDate_From;
	}

	public Date getReleaseDate_To() {
		return this.releaseDate_To;
	}

	public void setReleaseDate_From(Date releaseDate_From) {
		this.releaseDate_From = releaseDate_From;
	}

	public void setReleaseDate_To(Date releaseDate_To) {
		this.releaseDate_To = releaseDate_To;
	}
}
