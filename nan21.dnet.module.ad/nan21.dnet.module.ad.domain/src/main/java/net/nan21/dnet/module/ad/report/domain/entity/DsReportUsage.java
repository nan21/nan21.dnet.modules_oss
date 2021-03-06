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
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = DsReportUsage.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class DsReportUsage extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_DS_RPT_USAGE";
	public static final String SEQUENCE_NAME = "AD_DS_RPT_USAGE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "FRAMENAME", length = 255)
	private String frameName;

	@Column(name = "TOOLBARKEY", length = 400)
	private String toolbarKey;

	@Column(name = "DCKEY", length = 400)
	private String dcKey;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DsReport.class)
	@JoinColumn(name = "DSREPORT_ID", referencedColumnName = "ID")
	private DsReport dsReport;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrameName() {
		return this.frameName;
	}

	public void setFrameName(String frameName) {
		this.frameName = frameName;
	}

	public String getToolbarKey() {
		return this.toolbarKey;
	}

	public void setToolbarKey(String toolbarKey) {
		this.toolbarKey = toolbarKey;
	}

	public String getDcKey() {
		return this.dcKey;
	}

	public void setDcKey(String dcKey) {
		this.dcKey = dcKey;
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

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
