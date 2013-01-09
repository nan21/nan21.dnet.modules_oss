/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.nan21.dnet.core.api.descriptor.ISysParamDefinitions;
import net.nan21.dnet.core.api.descriptor.SysParamDefinition;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.ad.system.business.service.ISysParamService;
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;

/**
 * Business extensions specific for {@link SysParam} domain entity.
 * 
 */
public class SysParamService extends
		net.nan21.dnet.module.ad.system.business.serviceimpl.SysParamService
		implements ISysParamService {

	@Override
	public void doSynchronizeCatalog() throws BusinessException {

		@SuppressWarnings("unchecked")
		List<ISysParamDefinitions> osgiSysParams = (List<ISysParamDefinitions>) this
				.getApplicationContext().getBean("osgiSysParams");

		List<SysParam> entities = new ArrayList<SysParam>();

		for (ISysParamDefinitions osgiSysParam : osgiSysParams) {
			Collection<SysParamDefinition> spdefs;
			try {
				spdefs = osgiSysParam.getSysParamDefinitions();
			} catch (Exception e1) {
				throw new BusinessException(
						"Cannot read system parameter definitions. ",
						e1.getCause());
			}

			for (SysParamDefinition spdef : spdefs) {
				SysParam e = new SysParam();
				e.setActive(true);
				e.setCode(spdef.getName());
				e.setName(spdef.getTitle());
				e.setDefaultValue(spdef.getDefaultValue());
				e.setListOfValues(spdef.getListOfValues());
				e.setDescription(spdef.getDescription());
				entities.add(e);
			}

		}

		this.update("delete from " + SysParam.class.getSimpleName(), null);
		this.insert(entities);
	}

}
