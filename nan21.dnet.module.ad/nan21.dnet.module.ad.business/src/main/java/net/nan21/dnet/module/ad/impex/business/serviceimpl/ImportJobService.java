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
import net.nan21.dnet.module.ad.impex.business.service.IImportJobService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;

/**
 * Repository functionality for {@link ImportJob} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ImportJobService extends AbstractEntityService<ImportJob>
		implements
			IImportJobService {

	public ImportJobService() {
		super();
	}

	public ImportJobService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ImportJob> getEntityClass() {
		return ImportJob.class;
	}

	/**
	 * Find by unique key
	 */
	public ImportJob findByName(String name) {
		return (ImportJob) this.em.createNamedQuery(ImportJob.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: items
	 */
	public List<ImportJob> findByItems(ImportJobItem items) {
		return this.findByItemsId(items.getId());
	}

	/**
	 * Find by ID of reference: items.id
	 */
	public List<ImportJob> findByItemsId(Long itemsId) {
		return (List<ImportJob>) this.em
				.createQuery(
						"select distinct e from ImportJob e, IN (e.items) c where e.clientId = :pClientId and c.id = :pItemsId",
						ImportJob.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pItemsId", itemsId).getResultList();
	}
}
