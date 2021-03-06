/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ActProcessInstanceDsParam extends EmptyParam {

	public static final String f_processFullName = "processFullName";
	public static final String f_reasonToKill = "reasonToKill";
	public static final String f_from = "from";
	public static final String f_to = "to";

	private String processFullName;

	private String reasonToKill;

	private Date from;

	private Date to;

	public String getProcessFullName() {
		return this.processFullName;
	}

	public void setProcessFullName(String processFullName) {
		this.processFullName = processFullName;
	}

	public String getReasonToKill() {
		return this.reasonToKill;
	}

	public void setReasonToKill(String reasonToKill) {
		this.reasonToKill = reasonToKill;
	}

	public Date getFrom() {
		return this.from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return this.to;
	}

	public void setTo(Date to) {
		this.to = to;
	}
}
