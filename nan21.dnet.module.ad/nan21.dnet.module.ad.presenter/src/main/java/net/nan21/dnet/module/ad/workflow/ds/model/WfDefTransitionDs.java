/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefTransition;

@Ds(entity = WfDefTransition.class)
@RefLookups({
		@RefLookup(refId = WfDefTransitionDs.f_processId),
		@RefLookup(refId = WfDefTransitionDs.f_sourceId, namedQuery = WfDefNode.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = WfDefTransitionDs.f_source)}),
		@RefLookup(refId = WfDefTransitionDs.f_targetId, namedQuery = WfDefNode.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = WfDefTransitionDs.f_target)})})
public class WfDefTransitionDs extends AbstractAuditableDs<WfDefTransition> {

	public static final String f_processId = "processId";
	public static final String f_process = "process";
	public static final String f_sourceId = "sourceId";
	public static final String f_source = "source";
	public static final String f_targetId = "targetId";
	public static final String f_target = "target";

	@DsField(join = "left", path = "process.id")
	private Long processId;

	@DsField(join = "left", path = "process.name")
	private String process;

	@DsField(join = "left", path = "source.id")
	private Long sourceId;

	@DsField(join = "left", path = "source.name")
	private String source;

	@DsField(join = "left", path = "target.id")
	private Long targetId;

	@DsField(join = "left", path = "target.name")
	private String target;

	public WfDefTransitionDs() {
		super();
	}

	public WfDefTransitionDs(WfDefTransition e) {
		super(e);
	}

	public Long getProcessId() {
		return this.processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}

	public String getProcess() {
		return this.process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public Long getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getTargetId() {
		return this.targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
