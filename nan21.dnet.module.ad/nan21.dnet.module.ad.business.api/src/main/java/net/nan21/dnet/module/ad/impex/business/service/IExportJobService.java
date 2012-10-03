/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJobItem;

public interface IExportJobService extends IEntityService<ExportJob> {
	
	public ExportJob findByName(String name);
	
	public List<ExportJob> findByItems(ExportJobItem items);
	
	public List<ExportJob> findByItemsId(Long itemsId);
	
}
