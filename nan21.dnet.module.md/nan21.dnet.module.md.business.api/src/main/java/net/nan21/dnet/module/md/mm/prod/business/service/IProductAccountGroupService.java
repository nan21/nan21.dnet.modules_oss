/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroupAcct;

/**
 * Interface to expose business functions specific for {@link ProductAccountGroup} domain
 * entity.
 */
public interface IProductAccountGroupService
		extends
			IEntityService<ProductAccountGroup> {

	/**
	 * Find by unique key
	 */
	public ProductAccountGroup findByCode(String code);

	/**
	 * Find by unique key
	 */
	public ProductAccountGroup findByName(String name);

	/**
	 * Find by reference: accounts
	 */
	public List<ProductAccountGroup> findByAccounts(
			ProductAccountGroupAcct accounts);

	/**
	 * Find by ID of reference: accounts.id
	 */
	public List<ProductAccountGroup> findByAccountsId(Long accountsId);
}
