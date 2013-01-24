/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.acc.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

/**
 * Interface to expose business functions specific for {@link Account} domain
 * entity.
 */
public interface IAccountService extends IEntityService<Account> {

	/**
	 * Find by unique key
	 */
	public Account findByCode(String code);

	/**
	 * Find by reference: accSchema
	 */
	public List<Account> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<Account> findByAccSchemaId(Long accSchemaId);
}
