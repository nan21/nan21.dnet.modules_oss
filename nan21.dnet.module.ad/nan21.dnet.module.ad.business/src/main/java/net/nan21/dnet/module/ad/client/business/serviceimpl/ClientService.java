/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.client.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.client.domain.entity.Client;

/**
 * Repository functionality for {@link Client} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ClientService extends AbstractEntityService<Client> {

	public ClientService() {
		super();
	}

	public ClientService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Client> getEntityClass() {
		return Client.class;
	}
}
