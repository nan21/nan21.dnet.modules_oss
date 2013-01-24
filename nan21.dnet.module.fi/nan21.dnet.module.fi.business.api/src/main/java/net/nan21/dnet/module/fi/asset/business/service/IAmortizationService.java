/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.fi.asset.business.service;

import java.util.Date;
import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.fi.asset.domain.entity.Amortization;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;

/**
 * Interface to expose business functions specific for {@link Amortization} domain
 * entity.
 */
public interface IAmortizationService extends IEntityService<Amortization> {

	/**
	 * Find by unique key
	 */
	public Amortization findByAmort(Asset asset, Date postingDate);

	/**
	 * Find by unique key
	 */
	public Amortization findByAmort(Long assetId, Date postingDate);

	/**
	 * Find by reference: asset
	 */
	public List<Amortization> findByAsset(Asset asset);

	/**
	 * Find by ID of reference: asset.id
	 */
	public List<Amortization> findByAssetId(Long assetId);
}
