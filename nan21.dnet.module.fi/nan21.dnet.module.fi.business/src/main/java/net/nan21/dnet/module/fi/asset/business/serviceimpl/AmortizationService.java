/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.fi.asset.business.serviceimpl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.fi.asset.business.service.IAmortizationService;
import net.nan21.dnet.module.fi.asset.domain.entity.Amortization;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;

/**
 * Repository functionality for {@link Amortization} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AmortizationService extends AbstractEntityService<Amortization>
		implements
			IAmortizationService {

	public AmortizationService() {
		super();
	}

	public AmortizationService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Amortization> getEntityClass() {
		return Amortization.class;
	}

	/**
	 * Find by unique key
	 */
	public Amortization findByAmort(Asset asset, Date postingDate) {
		return (Amortization) this.getEntityManager()
				.createNamedQuery(Amortization.NQ_FIND_BY_AMORT)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAsset", asset)
				.setParameter("pPostingDate", postingDate).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Amortization findByAmort(Long assetId, Date postingDate) {
		return (Amortization) this.getEntityManager()
				.createNamedQuery(Amortization.NQ_FIND_BY_AMORT_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAssetId", assetId)
				.setParameter("pPostingDate", postingDate).getSingleResult();
	}

	/**
	 * Find by reference: asset
	 */
	public List<Amortization> findByAsset(Asset asset) {
		return this.findByAssetId(asset.getId());
	}

	/**
	 * Find by ID of reference: asset.id
	 */
	public List<Amortization> findByAssetId(Long assetId) {
		return (List<Amortization>) this
				.getEntityManager()
				.createQuery(
						"select e from Amortization e where e.clientId = :pClientId and e.asset.id = :pAssetId",
						Amortization.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAssetId", assetId).getResultList();
	}
}
