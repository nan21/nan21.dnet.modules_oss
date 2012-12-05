/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.acc.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;

/**
 * Repository functionality for {@link AccSchema} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccSchemaService extends AbstractEntityService<AccSchema>
		implements
			IAccSchemaService {

	public AccSchemaService() {
		super();
	}

	public AccSchemaService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AccSchema> getEntityClass() {
		return AccSchema.class;
	}

	/**
	 * Find by unique key
	 */
	public AccSchema findByCode(String code) {
		return (AccSchema) this.getEntityManager()
				.createNamedQuery(AccSchema.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public AccSchema findByName(String name) {
		return (AccSchema) this.getEntityManager()
				.createNamedQuery(AccSchema.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
