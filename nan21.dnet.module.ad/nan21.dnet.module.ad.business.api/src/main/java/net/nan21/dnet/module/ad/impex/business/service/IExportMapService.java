/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;

public interface IExportMapService extends IEntityService<ExportMap> {
	
	public ExportMap findByName(String name);
	
	public List<ExportMap> findByItems(ExportMapItem items);
	
	public List<ExportMap> findByItemsId(Long itemsId);
	
}
