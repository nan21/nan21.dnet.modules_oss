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
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;

@Ds(entity = ExportMapItem.class)
@RefLookups({
		@RefLookup(refId = ExportMapItemDs.f_exportMapId, namedQuery = ExportMap.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ExportMapItemDs.f_exportMap)}),
		@RefLookup(refId = ExportMapItemDs.f_csvExportId, namedQuery = CsvExport.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ExportMapItemDs.f_csvExport)})})
public class ExportMapItemDs extends AbstractAuditableDs<ExportMapItem> {

	public static final String f_exportMapId = "exportMapId";
	public static final String f_exportMap = "exportMap";
	public static final String f_csvExportId = "csvExportId";
	public static final String f_csvExport = "csvExport";
	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_fileName = "fileName";
	public static final String f_path = "path";
	public static final String f_active = "active";

	@DsField(join = "left", path = "exportMap.id")
	private Long exportMapId;

	@DsField(join = "left", path = "exportMap.name")
	private String exportMap;

	@DsField(join = "left", path = "csvExport.id")
	private Long csvExportId;

	@DsField(join = "left", path = "csvExport.name")
	private String csvExport;

	@DsField
	private Integer sequenceNo;

	@DsField
	private String fileName;

	@DsField
	private String path;

	@DsField
	private Boolean active;

	public ExportMapItemDs() {
		super();
	}

	public ExportMapItemDs(ExportMapItem e) {
		super(e);
	}

	public Long getExportMapId() {
		return this.exportMapId;
	}

	public void setExportMapId(Long exportMapId) {
		this.exportMapId = exportMapId;
	}

	public String getExportMap() {
		return this.exportMap;
	}

	public void setExportMap(String exportMap) {
		this.exportMap = exportMap;
	}

	public Long getCsvExportId() {
		return this.csvExportId;
	}

	public void setCsvExportId(Long csvExportId) {
		this.csvExportId = csvExportId;
	}

	public String getCsvExport() {
		return this.csvExport;
	}

	public void setCsvExport(String csvExport) {
		this.csvExport = csvExport;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
