/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.payroll.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({@NamedQuery(name = PayrollPeriod.NQ_FIND_BY_NAME, query = "SELECT e FROM PayrollPeriod e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = PayrollPeriod.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = PayrollPeriod.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class PayrollPeriod extends AbstractType {

	public static final String TABLE_NAME = "HR_PAYROLL_PRD";
	public static final String SEQUENCE_NAME = "HR_PAYROLL_PRD_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "PayrollPeriod.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE", nullable = false)
	@NotNull
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE", nullable = false)
	@NotNull
	private Date endDate;

	@Column(name = "PROCESSED", nullable = false)
	@NotNull
	private Boolean processed;

	@Column(name = "CLOSED", nullable = false)
	@NotNull
	private Boolean closed;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Payroll.class)
	@JoinColumn(name = "PAYROLL_ID", referencedColumnName = "ID")
	private Payroll payroll;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getProcessed() {
		return this.processed;
	}

	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}

	public Boolean getClosed() {
		return this.closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public Payroll getPayroll() {
		return this.payroll;
	}

	public void setPayroll(Payroll payroll) {
		if (payroll != null) {
			this.__validate_client_context__(payroll.getClientId());
		}
		this.payroll = payroll;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getProcessed() == null) {
			event.updateAttributeWithObject("processed", false);
		}
		if (this.getClosed() == null) {
			event.updateAttributeWithObject("closed", false);
		}
	}
}
