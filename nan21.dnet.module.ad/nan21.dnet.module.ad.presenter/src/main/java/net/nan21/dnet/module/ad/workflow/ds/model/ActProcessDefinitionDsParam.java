/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ActProcessDefinitionDsParam extends EmptyParam {

	public static final String f_deployment = "deployment";

	private String deployment;

	public String getDeployment() {
		return this.deployment;
	}

	public void setDeployment(String deployment) {
		this.deployment = deployment;
	}
}
