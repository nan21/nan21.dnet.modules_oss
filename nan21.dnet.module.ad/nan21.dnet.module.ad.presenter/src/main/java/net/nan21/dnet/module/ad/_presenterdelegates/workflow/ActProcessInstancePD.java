package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDs;

public class ActProcessInstancePD extends AbstractPresenterBaseService {

	public void killInstance(ActProcessInstanceDs ds) throws Exception {
		getWorkflowRuntimeService().deleteProcessInstance(ds.getId(), "killed");
	}

}
