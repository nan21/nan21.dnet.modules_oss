/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.IImportMapItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;


public class ImportMapItemService extends AbstractEntityService<ImportMapItem>
		implements IImportMapItemService {
 
	public ImportMapItemService() {
		super();
	}

	public ImportMapItemService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ImportMapItem> getEntityClass() {
		return ImportMapItem.class;
	}
	
	public List<ImportMapItem> findByImportMap(ImportMap importMap) {
		return this.findByImportMapId(importMap.getId()); 
	}
	
	public List<ImportMapItem> findByImportMapId(Long importMapId) {
		return (List<ImportMapItem>) this.em
			.createQuery("select e from ImportMapItem e where e.clientId = :pClientId and e.importMap.id = :pImportMapId", ImportMapItem.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pImportMapId", importMapId)			 	
			.getResultList(); 
	}
}
