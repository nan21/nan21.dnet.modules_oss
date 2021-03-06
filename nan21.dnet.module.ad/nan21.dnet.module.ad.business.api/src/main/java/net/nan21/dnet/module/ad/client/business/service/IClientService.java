/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.client.business.service;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.client.domain.entity.Client;

/**
 * Interface to expose business functions specific for {@link Client} domain
 * entity.
 */
public interface IClientService extends IEntityService<Client> {

	public void doInsertWithUserAccounts(Client client, String userCode,
			String userName, String password) throws BusinessException;

	public void doInsertWithUserAccountsAndSetup(Client client,
			String userCode, String userName, String password, Long importJobId)
			throws BusinessException;
}
