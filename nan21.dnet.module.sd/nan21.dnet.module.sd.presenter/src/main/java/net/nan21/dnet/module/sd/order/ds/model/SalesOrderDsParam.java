/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.EmptyParam;

public class SalesOrderDsParam extends EmptyParam {

	public static final String f_delivDocTypeId = "delivDocTypeId";
	public static final String f_delivDocType = "delivDocType";
	public static final String f_delivTxTypeId = "delivTxTypeId";
	public static final String f_delivTxType = "delivTxType";
	public static final String f_delivEventData = "delivEventData";
	public static final String f_invDocTypeId = "invDocTypeId";
	public static final String f_invDocType = "invDocType";
	public static final String f_copyFromId = "copyFromId";
	public static final String f_copyFrom = "copyFrom";

	private Long delivDocTypeId;

	private String delivDocType;

	private Long delivTxTypeId;

	private String delivTxType;

	private Date delivEventData;

	private Long invDocTypeId;

	private String invDocType;

	private Long copyFromId;

	private String copyFrom;

	public Long getDelivDocTypeId() {
		return this.delivDocTypeId;
	}

	public void setDelivDocTypeId(Long delivDocTypeId) {
		this.delivDocTypeId = delivDocTypeId;
	}

	public String getDelivDocType() {
		return this.delivDocType;
	}

	public void setDelivDocType(String delivDocType) {
		this.delivDocType = delivDocType;
	}

	public Long getDelivTxTypeId() {
		return this.delivTxTypeId;
	}

	public void setDelivTxTypeId(Long delivTxTypeId) {
		this.delivTxTypeId = delivTxTypeId;
	}

	public String getDelivTxType() {
		return this.delivTxType;
	}

	public void setDelivTxType(String delivTxType) {
		this.delivTxType = delivTxType;
	}

	public Date getDelivEventData() {
		return this.delivEventData;
	}

	public void setDelivEventData(Date delivEventData) {
		this.delivEventData = delivEventData;
	}

	public Long getInvDocTypeId() {
		return this.invDocTypeId;
	}

	public void setInvDocTypeId(Long invDocTypeId) {
		this.invDocTypeId = invDocTypeId;
	}

	public String getInvDocType() {
		return this.invDocType;
	}

	public void setInvDocType(String invDocType) {
		this.invDocType = invDocType;
	}

	public Long getCopyFromId() {
		return this.copyFromId;
	}

	public void setCopyFromId(Long copyFromId) {
		this.copyFromId = copyFromId;
	}

	public String getCopyFrom() {
		return this.copyFrom;
	}

	public void setCopyFrom(String copyFrom) {
		this.copyFrom = copyFrom;
	}
}
