package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import net.nan21.dnet.core.api.action.IFileUploadResult;
import net.nan21.dnet.core.api.model.IUploadedFileDescriptor;
import net.nan21.dnet.core.api.service.IFileUploadService;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.AbstractFileUploadService;
import net.nan21.dnet.module.ad.workflow.business.service.IActDeploymentService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

public class DeployUploadedWorkflow extends AbstractFileUploadService implements
		IFileUploadService {

	@Override
	public IFileUploadResult execute(IUploadedFileDescriptor fileDescriptor,
			InputStream inputStream, Map<String, String> uploadParams)
			throws Exception {

		String name = fileDescriptor.getNewName();
		String deploymentName = (name != null && !name.equals("")) ? name
				: fileDescriptor.getOriginalName();

		InputStream stream = null;

		try {

			ZipInputStream zipInputStream = new ZipInputStream(inputStream);

			RepositoryService rs = getWorkflowEngine().getRepositoryService();
			Deployment d = rs.createDeployment().name(deploymentName)
					.addZipInputStream(zipInputStream).deploy();

			// update clientId

			IActDeploymentService srv = (IActDeploymentService) this
					.getServiceLocator().findEntityService(ActDeployment.class);

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("clientId", Session.user.get().getClientId());
			params.put("id", d.getId());

			// TODO: move these along with the deployment into a tranzactional
			// business method
			srv.update(" update " + ActDeployment.class.getSimpleName()
					+ " set clientId = :clientId where id = :id ", params);

			srv.update(" update " + ActProcessDefinition.class.getSimpleName()
					+ " set clientId = :clientId where deployment.id = :id ",
					params);

		} finally {
			stream.close();
		}

		return null;
	}

}
