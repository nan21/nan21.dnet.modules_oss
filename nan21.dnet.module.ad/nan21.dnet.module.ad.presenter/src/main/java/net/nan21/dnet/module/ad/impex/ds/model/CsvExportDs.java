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
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;

@Ds(entity = CsvExport.class, sort = {@SortField(field = CsvExportDs.f_name)})
public class CsvExportDs extends AbstractTypeDs<CsvExport> {

	public static final String f_dataSource = "dataSource";

	@DsField
	private String dataSource;

	public CsvExportDs() {
		super();
	}

	public CsvExportDs(CsvExport e) {
		super(e);
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
}
