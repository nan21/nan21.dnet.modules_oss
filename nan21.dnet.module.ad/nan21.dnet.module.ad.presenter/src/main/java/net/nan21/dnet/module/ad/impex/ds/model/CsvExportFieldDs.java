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
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;

@Ds(entity = CsvExportField.class, sort = {@SortField(field = CsvExportFieldDs.f_sequenceNo)})
@RefLookups({@RefLookup(refId = CsvExportFieldDs.f_csvExportId, namedQuery = CsvExport.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = CsvExportFieldDs.f_csvExport)})})
public class CsvExportFieldDs extends AbstractAuditableDs<CsvExportField> {

	public static final String f_csvExportId = "csvExportId";
	public static final String f_csvExport = "csvExport";
	public static final String f_dataSource = "dataSource";
	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_dsField = "dsField";
	public static final String f_alias = "alias";
	public static final String f_active = "active";

	@DsField(join = "left", path = "csvExport.id")
	private Long csvExportId;

	@DsField(join = "left", path = "csvExport.name")
	private String csvExport;

	@DsField(join = "left", path = "csvExport.dataSource")
	private String dataSource;

	@DsField
	private Integer sequenceNo;

	@DsField
	private String dsField;

	@DsField
	private String alias;

	@DsField
	private Boolean active;

	public CsvExportFieldDs() {
		super();
	}

	public CsvExportFieldDs(CsvExportField e) {
		super(e);
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

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getDsField() {
		return this.dsField;
	}

	public void setDsField(String dsField) {
		this.dsField = dsField;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
