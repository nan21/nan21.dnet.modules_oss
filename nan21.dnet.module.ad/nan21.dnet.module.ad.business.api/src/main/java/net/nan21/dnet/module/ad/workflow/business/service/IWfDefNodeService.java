/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeField;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

/**
 * Interface to expose business functions specific for {@link WfDefNode} domain
 * entity.
 */
public interface IWfDefNodeService extends IEntityService<WfDefNode> {

	/**
	 * Find by unique key
	 */
	public WfDefNode findByName(String name);

	/**
	 * Find by reference: process
	 */
	public List<WfDefNode> findByProcess(WfDefProcess process);

	/**
	 * Find by ID of reference: process.id
	 */
	public List<WfDefNode> findByProcessId(Long processId);

	/**
	 * Find by reference: fields
	 */
	public List<WfDefNode> findByFields(WfDefNodeField fields);

	/**
	 * Find by ID of reference: fields.id
	 */
	public List<WfDefNode> findByFieldsId(Long fieldsId);
}
