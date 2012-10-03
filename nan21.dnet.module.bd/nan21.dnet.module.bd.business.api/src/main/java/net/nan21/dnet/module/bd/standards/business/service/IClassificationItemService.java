/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.standards.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

public interface IClassificationItemService extends IEntityService<ClassificationItem> {
	
	public ClassificationItem findBySyscode(ClassificationSystem classSystem,String code);
	
	public ClassificationItem findBySyscode( Long classSystemId,String code);
	
	public ClassificationItem findBySysname(ClassificationSystem classSystem,String name);
	
	public ClassificationItem findBySysname( Long classSystemId,String name);
	
	public List<ClassificationItem> findByClassSystem(ClassificationSystem classSystem);
	
	public List<ClassificationItem> findByClassSystemId(Long classSystemId);
	
}
