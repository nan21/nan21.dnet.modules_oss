/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;

@Ds(entity = ExportMap.class, sort = {@SortField(field = ExportMapDs.f_name)})
public class ExportMapDs extends AbstractTypeDs<ExportMap> {

	public static final String f_path = "path";

	@DsField
	private String path;

	public ExportMapDs() {
		super();
	}

	public ExportMapDs(ExportMap e) {
		super(e);
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
