/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class CsvExportDsParam extends EmptyParam {

	public static final String f_cloneName = "cloneName";

	private String cloneName;

	public String getCloneName() {
		return this.cloneName;
	}

	public void setCloneName(String cloneName) {
		this.cloneName = cloneName;
	}
}
