/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.acc.business.service;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.acc.domain.entity.AccItemAcct;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

/**
 * Interface to expose business functions specific for {@link AccItemAcct} domain
 * entity.
 */
public interface IAccItemAcctService extends IEntityService<AccItemAcct> {

	public String getDbPostingAcct(AccItem accItem, AccSchema accSchema)
			throws BusinessException;

	public String getCrPostingAcct(AccItem accItem, AccSchema accSchema)
			throws BusinessException;

	/**
	 * Find by unique key
	 */
	public AccItemAcct findByItem_schema(AccItem accItem, AccSchema accSchema);

	/**
	 * Find by unique key
	 */
	public AccItemAcct findByItem_schema(Long accItemId, Long accSchemaId);

	/**
	 * Find by reference: accItem
	 */
	public List<AccItemAcct> findByAccItem(AccItem accItem);

	/**
	 * Find by ID of reference: accItem.id
	 */
	public List<AccItemAcct> findByAccItemId(Long accItemId);

	/**
	 * Find by reference: accSchema
	 */
	public List<AccItemAcct> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<AccItemAcct> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: crAccount
	 */
	public List<AccItemAcct> findByCrAccount(Account crAccount);

	/**
	 * Find by ID of reference: crAccount.id
	 */
	public List<AccItemAcct> findByCrAccountId(Long crAccountId);

	/**
	 * Find by reference: dbAccount
	 */
	public List<AccItemAcct> findByDbAccount(Account dbAccount);

	/**
	 * Find by ID of reference: dbAccount.id
	 */
	public List<AccItemAcct> findByDbAccountId(Long dbAccountId);
}
