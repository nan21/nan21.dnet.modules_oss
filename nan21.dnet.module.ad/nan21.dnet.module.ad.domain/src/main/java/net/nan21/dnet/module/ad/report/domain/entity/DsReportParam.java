/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
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
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = DsReportParam.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class DsReportParam extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_DS_RPT_PARAM";
	public static final String SEQUENCE_NAME = "AD_DS_RPT_PARAM_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	/** Reference to the data-source field. 
	 */
	@Column(name = "DSFIELD", length = 255)
	private String dsField;

	@Column(name = "STATICVALUE", length = 400)
	private String staticValue;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DsReport.class)
	@JoinColumn(name = "DSREPORT_ID", referencedColumnName = "ID")
	private DsReport dsReport;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ReportParam.class)
	@JoinColumn(name = "REPORTPARAM_ID", referencedColumnName = "ID")
	private ReportParam reportParam;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsField() {
		return this.dsField;
	}

	public void setDsField(String dsField) {
		this.dsField = dsField;
	}

	public String getStaticValue() {
		return this.staticValue;
	}

	public void setStaticValue(String staticValue) {
		this.staticValue = staticValue;
	}

	public DsReport getDsReport() {
		return this.dsReport;
	}

	public void setDsReport(DsReport dsReport) {
		if (dsReport != null) {
			this.__validate_client_context__(dsReport.getClientId());
		}
		this.dsReport = dsReport;
	}

	public ReportParam getReportParam() {
		return this.reportParam;
	}

	public void setReportParam(ReportParam reportParam) {
		if (reportParam != null) {
			this.__validate_client_context__(reportParam.getClientId());
		}
		this.reportParam = reportParam;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
