/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = ExportMapItem.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class ExportMapItem extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_EXP_MAP_ITEM";
	public static final String SEQUENCE_NAME = "AD_EXP_MAP_ITEM_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "SEQUENCENO", nullable = false)
	@NotNull
	private Integer sequenceNo;

	@Column(name = "PATH", length = 255)
	private String path;

	@Column(name = "FILENAME", length = 255)
	private String fileName;

	@Column(name = "ACTIVE", nullable = false)
	@NotNull
	private Boolean active;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ExportMap.class)
	@JoinColumn(name = "EXPORTMAP_ID", referencedColumnName = "ID")
	private ExportMap exportMap;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CsvExport.class)
	@JoinColumn(name = "CSVEXPORT_ID", referencedColumnName = "ID")
	private CsvExport csvExport;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
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

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public ExportMap getExportMap() {
		return this.exportMap;
	}

	public void setExportMap(ExportMap exportMap) {
		if (exportMap != null) {
			this.__validate_client_context__(exportMap.getClientId());
		}
		this.exportMap = exportMap;
	}

	public CsvExport getCsvExport() {
		return this.csvExport;
	}

	public void setCsvExport(CsvExport csvExport) {
		if (csvExport != null) {
			this.__validate_client_context__(csvExport.getClientId());
		}
		this.csvExport = csvExport;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getActive() == null) {
			event.updateAttributeWithObject("active", false);
		}
	}
}
