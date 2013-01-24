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
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = CsvExportField.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class CsvExportField extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_CSV_EXP_FLD";
	public static final String SEQUENCE_NAME = "AD_CSV_EXP_FLD_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "SEQUENCENO")
	private Integer sequenceNo;

	@Column(name = "DSFIELD", length = 255)
	private String dsField;

	@Column(name = "ALIAS", length = 255)
	private String alias;

	@Column(name = "ACTIVE", nullable = false)
	@NotNull
	private Boolean active;

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
