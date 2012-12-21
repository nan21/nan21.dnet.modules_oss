/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;

@Ds(entity = Grade.class, sort = {@SortField(field = GradeDs.f_name)})
public class GradeDs extends AbstractTypeWithCodeDs<Grade> {

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_validFrom = "validFrom";
	public static final String f_validTo = "validTo";

	@DsField
	private Integer sequenceNo;

	@DsField
	private Date validFrom;

	@DsField
	private Date validTo;

	public GradeDs() {
		super();
	}

	public GradeDs(Grade e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
}
