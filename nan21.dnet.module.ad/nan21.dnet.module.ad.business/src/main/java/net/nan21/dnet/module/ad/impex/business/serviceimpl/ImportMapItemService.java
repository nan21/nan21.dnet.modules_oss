/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
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

/**
 * Repository functionality for {@link ImportMapItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ImportMapItemService extends AbstractEntityService<ImportMapItem>
		implements
			IImportMapItemService {

	public ImportMapItemService() {
		super();
	}

	public ImportMapItemService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ImportMapItem> getEntityClass() {
		return ImportMapItem.class;
	}

	/**
	 * Find by reference: importMap
	 */
	public List<ImportMapItem> findByImportMap(ImportMap importMap) {
		return this.findByImportMapId(importMap.getId());
	}

	/**
	 * Find by ID of reference: importMap.id
	 */
	public List<ImportMapItem> findByImportMapId(Long importMapId) {
		return (List<ImportMapItem>) this
				.getEntityManager()
				.createQuery(
						"select e from ImportMapItem e where e.clientId = :pClientId and e.importMap.id = :pImportMapId",
						ImportMapItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pImportMapId", importMapId).getResultList();
	}
}
