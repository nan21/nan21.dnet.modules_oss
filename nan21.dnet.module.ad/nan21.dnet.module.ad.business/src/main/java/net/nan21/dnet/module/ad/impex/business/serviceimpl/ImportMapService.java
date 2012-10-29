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
import net.nan21.dnet.module.ad.impex.business.service.IImportMapService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;


public class ImportMapService extends AbstractEntityService<ImportMap>
		implements IImportMapService {
 
	public ImportMapService() {
		super();
	}

	public ImportMapService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ImportMap> getEntityClass() {
		return ImportMap.class;
	}
	
	public ImportMap findByName(String name) {		 
		return (ImportMap) this.em
			.createNamedQuery(ImportMap.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
	
	public List<ImportMap> findByItems(ImportMapItem items) {
		return this.findByItemsId(items.getId()); 
	}
	
	public List<ImportMap> findByItemsId(Long itemsId) {
		return (List<ImportMap>) this.em
			.createQuery("select distinct e from ImportMap e, IN (e.items) c where e.clientId = :pClientId and c.id = :pItemsId", ImportMap.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pItemsId", itemsId)			 	
			.getResultList(); 
	}
}
