/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;

@Ds(entity = OpportunityPriority.class, sort = {@SortField(field = OpportunityPriorityDs.f_name)})
public class OpportunityPriorityDs extends AbstractTypeDs<OpportunityPriority> {

	public static final String f_sequenceNo = "sequenceNo";

	@DsField
	private Integer sequenceNo;

	public OpportunityPriorityDs() {
		super();
	}

	public OpportunityPriorityDs(OpportunityPriority e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
}
