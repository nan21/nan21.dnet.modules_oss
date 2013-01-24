/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.inventory.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;

/**
 * Interface to expose business functions specific for {@link InvTransactionType} domain
 * entity.
 */
public interface IInvTransactionTypeService
		extends
			IEntityService<InvTransactionType> {

	/**
	 * Find by unique key
	 */
	public InvTransactionType findByName(String name);

	/**
	 * Find by reference: docType
	 */
	public List<InvTransactionType> findByDocType(TxDocType docType);

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<InvTransactionType> findByDocTypeId(Long docTypeId);
}
