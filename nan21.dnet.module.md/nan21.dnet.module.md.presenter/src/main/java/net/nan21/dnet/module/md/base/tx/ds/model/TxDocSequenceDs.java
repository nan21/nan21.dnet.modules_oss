/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.base.tx.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocSequence;

@Ds(entity = TxDocSequence.class, sort = {@SortField(field = TxDocSequenceDs.f_name)})
public class TxDocSequenceDs extends AbstractTypeDs<TxDocSequence> {

	public static final String f_firstNo = "firstNo";
	public static final String f_lastNo = "lastNo";
	public static final String f_nextNo = "nextNo";
	public static final String f_incrementBy = "incrementBy";
	public static final String f_prefix = "prefix";
	public static final String f_suffix = "suffix";

	@DsField
	private Integer firstNo;

	@DsField
	private Integer lastNo;

	@DsField
	private Integer nextNo;

	@DsField
	private Integer incrementBy;

	@DsField
	private String prefix;

	@DsField
	private String suffix;

	public TxDocSequenceDs() {
		super();
	}

	public TxDocSequenceDs(TxDocSequence e) {
		super(e);
	}

	public Integer getFirstNo() {
		return this.firstNo;
	}

	public void setFirstNo(Integer firstNo) {
		this.firstNo = firstNo;
	}

	public Integer getLastNo() {
		return this.lastNo;
	}

	public void setLastNo(Integer lastNo) {
		this.lastNo = lastNo;
	}

	public Integer getNextNo() {
		return this.nextNo;
	}

	public void setNextNo(Integer nextNo) {
		this.nextNo = nextNo;
	}

	public Integer getIncrementBy() {
		return this.incrementBy;
	}

	public void setIncrementBy(Integer incrementBy) {
		this.incrementBy = incrementBy;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
