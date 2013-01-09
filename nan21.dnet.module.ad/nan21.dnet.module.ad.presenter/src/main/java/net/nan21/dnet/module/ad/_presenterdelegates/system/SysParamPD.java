package net.nan21.dnet.module.ad._presenterdelegates.system;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.ad.system.business.service.ISysParamService;
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;
import net.nan21.dnet.module.ad.system.ds.model.SysParamDs;

public class SysParamPD extends AbstractPresenterBaseService {

	public void reloadSysConfig(SysParamDs filter) throws Exception {
		this.getSystemConfig().reloadSysparams();
	}

	public void synchronizeCatalog(SysParamDs filter) throws Exception {
		((ISysParamService) this.findEntityService(SysParam.class))
				.doSynchronizeCatalog();
	}

}
