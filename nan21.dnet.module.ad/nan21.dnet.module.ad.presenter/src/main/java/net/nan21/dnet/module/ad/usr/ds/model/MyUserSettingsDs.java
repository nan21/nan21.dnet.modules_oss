/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDateFormat;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

@Ds(entity = User.class, sort = {@SortField(field = MyUserSettingsDs.f_name)})
@RefLookups({@RefLookup(refId = MyUserSettingsDs.f_dateFormatId, namedQuery = SysDateFormat.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = MyUserSettingsDs.f_dateFormat)})})
public class MyUserSettingsDs extends AbstractTypeWithCodeDs<User> {

	public static final String f_decimalSeparator = "decimalSeparator";
	public static final String f_thousandSeparator = "thousandSeparator";
	public static final String f_dateFormatId = "dateFormatId";
	public static final String f_dateFormat = "dateFormat";

	@DsField
	private String decimalSeparator;

	@DsField
	private String thousandSeparator;

	@DsField(join = "left", path = "dateFormat.id")
	private Long dateFormatId;

	@DsField(join = "left", path = "dateFormat.name")
	private String dateFormat;

	public MyUserSettingsDs() {
		super();
	}

	public MyUserSettingsDs(User e) {
		super(e);
	}

	public String getDecimalSeparator() {
		return this.decimalSeparator;
	}

	public void setDecimalSeparator(String decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}

	public String getThousandSeparator() {
		return this.thousandSeparator;
	}

	public void setThousandSeparator(String thousandSeparator) {
		this.thousandSeparator = thousandSeparator;
	}

	public Long getDateFormatId() {
		return this.dateFormatId;
	}

	public void setDateFormatId(Long dateFormatId) {
		this.dateFormatId = dateFormatId;
	}

	public String getDateFormat() {
		return this.dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
}
