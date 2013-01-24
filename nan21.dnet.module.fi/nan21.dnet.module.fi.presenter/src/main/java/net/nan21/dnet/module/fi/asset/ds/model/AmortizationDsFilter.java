/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.fi.asset.ds.model;
import java.util.Date;
import net.nan21.dnet.module.fi.asset.ds.model.AmortizationDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class AmortizationDsFilter extends AmortizationDs {

	private Date postingDate_From;

	private Date postingDate_To;

	public Date getPostingDate_From() {
		return this.postingDate_From;
	}

	public Date getPostingDate_To() {
		return this.postingDate_To;
	}

	public void setPostingDate_From(Date postingDate_From) {
		this.postingDate_From = postingDate_From;
	}

	public void setPostingDate_To(Date postingDate_To) {
		this.postingDate_To = postingDate_To;
	}
}
