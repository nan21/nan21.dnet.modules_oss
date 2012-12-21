/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.domain.entity;

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
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = JobRequirement.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class JobRequirement extends AbstractAuditable {

	public static final String TABLE_NAME = "HR_JOB_RQM";
	public static final String SEQUENCE_NAME = "HR_JOB_RQM_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "NOTES", length = 4000)
	private String notes;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Job.class)
	@JoinColumn(name = "JOB_ID", referencedColumnName = "ID")
	private Job job;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = WorkRequirement.class)
	@JoinColumn(name = "REQUIREMENT_ID", referencedColumnName = "ID")
	private WorkRequirement requirement;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		if (job != null) {
			this.__validate_client_context__(job.getClientId());
		}
		this.job = job;
	}

	public WorkRequirement getRequirement() {
		return this.requirement;
	}

	public void setRequirement(WorkRequirement requirement) {
		if (requirement != null) {
			this.__validate_client_context__(requirement.getClientId());
		}
		this.requirement = requirement;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
