package net.nan21.dnet.module.pj._businessdelegates;

import java.util.ArrayList;

import net.nan21.dnet.core.api.setup.ISetupParticipant;
import net.nan21.dnet.core.api.setup.ISetupTask;
import net.nan21.dnet.core.business.service.setup.AbstractBusinessSetupParticipant;

public class Setup_PJ extends AbstractBusinessSetupParticipant implements
		ISetupParticipant {

	@Override
	protected void onExecute() throws Exception {
	}

	@Override
	protected void init() {
		this.targetName = "DNet-MM";
		this.createTasks();
	}

	private void createTasks() {
		this.tasks = new ArrayList<ISetupTask>();

		// There is nothing to setup here, this one is run to enforce that the
		// database objects are created in the right order
		// in case the object creation is managed by eclipselink

		this.getEntityManager().createQuery("select count(e) from Project e")
				.getResultList().get(0);
	}

}
