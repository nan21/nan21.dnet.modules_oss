/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.report.domain.entity;

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
import net.nan21.dnet.module.ad.report.domain.entity.Report;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = DsReport.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class DsReport extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_DS_RPT";
	public static final String SEQUENCE_NAME = "AD_DS_RPT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	/** Reference to the data-source. 
	 */
	@Column(name = "DATASOURCE", nullable = false, length = 255)
	@NotBlank
	private String dataSource;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Report.class)
	@JoinColumn(name = "REPORT_ID", referencedColumnName = "ID")
	private Report report;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public Report getReport() {
		return this.report;
	}

	public void setReport(Report report) {
		if (report != null) {
			this.__validate_client_context__(report.getClientId());
		}
		this.report = report;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
