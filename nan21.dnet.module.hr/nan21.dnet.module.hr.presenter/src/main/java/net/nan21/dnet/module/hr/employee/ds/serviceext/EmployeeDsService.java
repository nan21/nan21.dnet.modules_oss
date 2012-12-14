/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.ds.serviceext;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.nan21.dnet.core.api.action.IQueryBuilder;
import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.ds.AbstractEntityDsService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeDs;
import net.nan21.dnet.module.md._businessapi.SysParamMD;

public class EmployeeDsService extends
		AbstractEntityDsService<EmployeeDs, EmployeeDs, EmptyParam, Employee>
		implements IDsService<EmployeeDs, EmployeeDs, EmptyParam> {

	@Override
	protected void postFind(
			IQueryBuilder<EmployeeDs, EmployeeDs, EmptyParam> builder,
			List<EmployeeDs> result) throws Exception {

		String HR_EMPL_PHOTO_BASEURL = this.getSystemConfig().getSysParamValue(
				SysParamMD.HR_EMPL_PHOTO_BASEURL);

		String HR_EMPL_PHOTO_EXT = this.getSystemConfig().getSysParamValue(
				SysParamMD.HR_EMPL_PHOTO_EXT);

		String HR_EMPL_PHOTO_SUFFIX = this.getSystemConfig().getSysParamValue(
				SysParamMD.HR_EMPL_PHOTO_SUFFIX);

		for (EmployeeDs ds : result) {

			if (StringUtils.isBlank(ds.getPhotoUrl())) {
				ds.setPhotoLocation(HR_EMPL_PHOTO_BASEURL + "/" + ds.getCode()
						+ HR_EMPL_PHOTO_SUFFIX + "." + HR_EMPL_PHOTO_EXT);

			} else {
				if (!ds.getPhotoUrl().startsWith("http")) {
					ds.setPhotoLocation(HR_EMPL_PHOTO_BASEURL + "/"
							+ ds.getPhotoUrl());
				} else {
					ds.setPhotoLocation(ds.getPhotoUrl());
				}
			}
		}
	}

}
