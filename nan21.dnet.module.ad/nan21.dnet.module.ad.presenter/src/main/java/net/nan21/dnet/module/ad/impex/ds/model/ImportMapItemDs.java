/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;

@Ds(entity = ImportMapItem.class, sort = {@SortField(field = ImportMapItemDs.f_sequenceNo)})
@RefLookups({@RefLookup(refId = ImportMapItemDs.f_importMapId, namedQuery = ImportMap.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ImportMapItemDs.f_importMapName)})})
public class ImportMapItemDs extends AbstractAuditableDs<ImportMapItem> {

	public static final String f_importMapId = "importMapId";
	public static final String f_importMapName = "importMapName";
	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_dataSource = "dataSource";
	public static final String f_path = "path";
	public static final String f_fileName = "fileName";
	public static final String f_ukFieldName = "ukFieldName";
	public static final String f_active = "active";

	@DsField(join = "left", path = "importMap.id")
	private Long importMapId;

	@DsField(join = "left", path = "importMap.name")
	private String importMapName;

	@DsField
	private Integer sequenceNo;

	@DsField(path = "dataSourceName")
	private String dataSource;

	@DsField
	private String path;

	@DsField
	private String fileName;

	@DsField
	private String ukFieldName;

	@DsField
	private Boolean active;

	public ImportMapItemDs() {
		super();
	}

	public ImportMapItemDs(ImportMapItem e) {
		super(e);
	}

	public Long getImportMapId() {
		return this.importMapId;
	}

	public void setImportMapId(Long importMapId) {
		this.importMapId = importMapId;
	}

	public String getImportMapName() {
		return this.importMapName;
	}

	public void setImportMapName(String importMapName) {
		this.importMapName = importMapName;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUkFieldName() {
		return this.ukFieldName;
	}

	public void setUkFieldName(String ukFieldName) {
		this.ukFieldName = ukFieldName;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
