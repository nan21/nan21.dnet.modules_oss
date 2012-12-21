/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
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
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = ImportMapItem.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class ImportMapItem extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_IMP_MAP_ITEM";
	public static final String SEQUENCE_NAME = "AD_IMP_MAP_ITEM_SEQ";

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

	@Column(name = "DATASOURCENAME", nullable = false, length = 255)
	@NotBlank
	private String dataSourceName;

	@Column(name = "PATH", length = 255)
	private String path;

	@Column(name = "FILENAME", length = 255)
	private String fileName;

	@Column(name = "UKFIELDNAME", length = 32)
	private String ukFieldName;

	@Column(name = "ACTIVE", nullable = false)
	@NotNull
	private Boolean active;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ImportMap.class)
	@JoinColumn(name = "IMPORTMAP_ID", referencedColumnName = "ID")
	private ImportMap importMap;

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

	public String getDataSourceName() {
		return this.dataSourceName;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
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

	public ImportMap getImportMap() {
		return this.importMap;
	}

	public void setImportMap(ImportMap importMap) {
		if (importMap != null) {
			this.__validate_client_context__(importMap.getClientId());
		}
		this.importMap = importMap;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getActive() == null) {
			event.updateAttributeWithObject("active", false);
		}
	}
}
