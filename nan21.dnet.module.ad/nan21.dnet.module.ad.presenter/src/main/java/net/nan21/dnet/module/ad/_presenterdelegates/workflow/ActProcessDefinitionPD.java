package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;
import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDs;

public class ActProcessDefinitionPD extends AbstractPresenterBaseService {

	public InputStream getStartForm(ActProcessDefinitionDs ds) {
		return null;
	}

	public void startInstance(ActProcessDefinitionDs ds) throws Exception {
		// ProcessEngine pe = getWorkflowEngine();
		String processDefinitionId = ds.getId();

		ProcessDefinition processDefinition = getWorkflowRepositoryService()
				.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();

		boolean hasStartForm = processDefinition.hasStartFormKey();
		if (hasStartForm) {

		}
  
		Map<String, Object> vars = new HashMap<String, Object>();
		this.findEntityService(ActProcessDefinition.class)
				.doStartWfProcessInstanceById(ds.getId(), null, vars);
	}

	public InputStream getDiagram(ActProcessDefinitionDs ds) {
		return null;
	}
}
