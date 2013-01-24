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
import net.nan21.dnet.module.ad.impex.business.service.IExportMapService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;

/**
 * Repository functionality for {@link ExportMap} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ExportMapService extends AbstractEntityService<ExportMap>
		implements
			IExportMapService {

	public ExportMapService() {
		super();
	}

	public ExportMapService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ExportMap> getEntityClass() {
		return ExportMap.class;
	}

	/**
	 * Find by unique key
	 */
	public ExportMap findByName(String name) {
		return (ExportMap) this.getEntityManager()
				.createNamedQuery(ExportMap.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: items
	 */
	public List<ExportMap> findByItems(ExportMapItem items) {
		return this.findByItemsId(items.getId());
	}

	/**
	 * Find by ID of reference: items.id
	 */
	public List<ExportMap> findByItemsId(Long itemsId) {
		return (List<ExportMap>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from ExportMap e, IN (e.items) c where e.clientId = :pClientId and c.id = :pItemsId",
						ExportMap.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pItemsId", itemsId).getResultList();
	}
}
