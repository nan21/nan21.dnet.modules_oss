/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;

public interface IImportMapService extends IEntityService<ImportMap> {
	
	public ImportMap findByName(String name);
	
	public List<ImportMap> findByItems(ImportMapItem items);
	
	public List<ImportMap> findByItemsId(Long itemsId);
	
}
