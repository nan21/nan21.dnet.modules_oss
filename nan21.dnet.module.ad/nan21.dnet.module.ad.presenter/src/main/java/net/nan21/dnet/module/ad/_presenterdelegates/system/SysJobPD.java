package net.nan21.dnet.module.ad._presenterdelegates.system;

 

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.ad.system.ds.filter.SysJobDsFilter;

public class SysJobPD extends AbstractPresenterBaseService {

	public void synchronizeCatalog(SysJobDsFilter ds) throws Exception {
		 
		//ConfigurableApplicationContext  x = (ConfigurableApplicationContext)this.getAppContext();  
		// x.getBeanFactory().getBeanDefinition("UserDsService");
		System.out.println("dddddddddddddd");
	}
}
