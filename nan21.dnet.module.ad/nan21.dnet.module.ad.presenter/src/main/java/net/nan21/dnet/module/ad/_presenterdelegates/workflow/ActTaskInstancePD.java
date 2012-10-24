package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDs;

public class ActTaskInstancePD extends AbstractPresenterBaseService {

	public void assignTask(ActTaskInstanceDs ds) throws Exception {
		getWorkflowTaskService().setAssignee(ds.getId(), ds.getAssignee());
	}

	public void completeTask(ActTaskInstanceDs ds) throws Exception {
		getWorkflowTaskService().complete(ds.getId());
	}

}
