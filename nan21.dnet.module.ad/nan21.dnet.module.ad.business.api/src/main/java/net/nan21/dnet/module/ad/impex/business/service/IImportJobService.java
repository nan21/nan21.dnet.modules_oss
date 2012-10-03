/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;

public interface IImportJobService extends IEntityService<ImportJob> {
	
	public ImportJob findByName(String name);
	
	public List<ImportJob> findByItems(ImportJobItem items);
	
	public List<ImportJob> findByItemsId(Long itemsId);
	
}
