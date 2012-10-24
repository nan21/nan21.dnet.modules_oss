package net.nan21.dnet.module.ad._presenterdelegates.system;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.ad.system.ds.filter.SysParamDsFilter;

public class SysParamPD extends AbstractPresenterBaseService {
	public void reloadSysConfig(SysParamDsFilter ds) throws Exception {
		this.getSystemConfig().reloadSysparams();
	}
}
