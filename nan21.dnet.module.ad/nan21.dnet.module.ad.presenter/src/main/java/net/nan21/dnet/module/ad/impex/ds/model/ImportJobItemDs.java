/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
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
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;

@Ds(entity = ImportJobItem.class, sort = {@SortField(field = ImportJobItemDs.f_sequenceNo)})
@RefLookups({
		@RefLookup(refId = ImportJobItemDs.f_jobId, namedQuery = ImportJob.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ImportJobItemDs.f_jobName)}),
		@RefLookup(refId = ImportJobItemDs.f_mapId, namedQuery = ImportMap.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ImportJobItemDs.f_mapName)})})
public class ImportJobItemDs extends AbstractAuditableDs<ImportJobItem> {

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_active = "active";
	public static final String f_jobId = "jobId";
	public static final String f_jobName = "jobName";
	public static final String f_mapId = "mapId";
	public static final String f_mapName = "mapName";

	@DsField
	private Integer sequenceNo;

	@DsField
	private Boolean active;

	@DsField(join = "left", path = "job.id")
	private Long jobId;

	@DsField(join = "left", path = "job.name")
	private String jobName;

	@DsField(join = "left", path = "map.id")
	private Long mapId;

	@DsField(join = "left", path = "map.name")
	private String mapName;

	public ImportJobItemDs() {
		super();
	}

	public ImportJobItemDs(ImportJobItem e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getJobId() {
		return this.jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Long getMapId() {
		return this.mapId;
	}

	public void setMapId(Long mapId) {
		this.mapId = mapId;
	}

	public String getMapName() {
		return this.mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
}
