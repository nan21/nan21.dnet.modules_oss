/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.client.business.serviceext;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.ad._businessdelegates.client.ClientBD;
import net.nan21.dnet.module.ad.client.business.service.IClientService;
import net.nan21.dnet.module.ad.client.domain.entity.Client;

/**
 * Business extensions specific for {@link Client} domain entity.
 * 
 */
public class ClientService extends
		net.nan21.dnet.module.ad.client.business.serviceimpl.ClientService
		implements IClientService {

	@Override
	public void doInsertWithUserAccounts(Client client, String userCode,
			String userName, String password) throws BusinessException {
		this.getBusinessDelegate(ClientBD.class).createAdminUser(client,
				userCode, userName, password);

	}

}
