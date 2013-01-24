/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.price.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.mm.price.business.service.IPriceListVersionService;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceListVersion;

/**
 * Repository functionality for {@link PriceListVersion} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PriceListVersionService
		extends
			AbstractEntityService<PriceListVersion>
		implements
			IPriceListVersionService {

	public PriceListVersionService() {
		super();
	}

	public PriceListVersionService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PriceListVersion> getEntityClass() {
		return PriceListVersion.class;
	}

	/**
	 * Find by unique key
	 */
	public PriceListVersion findByName(String name) {
		return (PriceListVersion) this.getEntityManager()
				.createNamedQuery(PriceListVersion.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: priceList
	 */
	public List<PriceListVersion> findByPriceList(PriceList priceList) {
		return this.findByPriceListId(priceList.getId());
	}

	/**
	 * Find by ID of reference: priceList.id
	 */
	public List<PriceListVersion> findByPriceListId(Long priceListId) {
		return (List<PriceListVersion>) this
				.getEntityManager()
				.createQuery(
						"select e from PriceListVersion e where e.clientId = :pClientId and e.priceList.id = :pPriceListId",
						PriceListVersion.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPriceListId", priceListId).getResultList();
	}
}
