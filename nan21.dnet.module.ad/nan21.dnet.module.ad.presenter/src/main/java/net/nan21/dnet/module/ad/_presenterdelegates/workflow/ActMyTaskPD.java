package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskDs;

public class ActMyTaskPD extends AbstractPresenterBaseService {

	public void complete(ActMyTaskDs ds) throws Exception {
		getWorkflowTaskService().complete(ds.getId());
	}

}
