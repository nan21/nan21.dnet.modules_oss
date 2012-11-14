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

/**
 * Interface to expose business functions specific for {@link WfDefNodeField} domain
 * entity.
 */
public interface IWfDefNodeFieldService extends IEntityService<WfDefNodeField> {

	/**
	 * Find by unique key
	 */
	public WfDefNodeField findByName(String name);

	/**
	 * Find by reference: node
	 */
	public List<WfDefNodeField> findByNode(WfDefNode node);

	/**
	 * Find by ID of reference: node.id
	 */
	public List<WfDefNodeField> findByNodeId(Long nodeId);
}
