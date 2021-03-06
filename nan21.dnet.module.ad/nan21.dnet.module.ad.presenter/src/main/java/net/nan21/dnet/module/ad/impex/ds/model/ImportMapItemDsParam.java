/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ImportMapItemDsParam extends EmptyParam {

	public static final String f_importFileLocation = "importFileLocation";
	public static final String f_importDataSource = "importDataSource";
	public static final String f_importUkFieldName = "importUkFieldName";

	private String importFileLocation;

	private String importDataSource;

	private String importUkFieldName;

	public String getImportFileLocation() {
		return this.importFileLocation;
	}

	public void setImportFileLocation(String importFileLocation) {
		this.importFileLocation = importFileLocation;
	}

	public String getImportDataSource() {
		return this.importDataSource;
	}

	public void setImportDataSource(String importDataSource) {
		this.importDataSource = importDataSource;
	}

	public String getImportUkFieldName() {
		return this.importUkFieldName;
	}

	public void setImportUkFieldName(String importUkFieldName) {
		this.importUkFieldName = importUkFieldName;
	}
}
