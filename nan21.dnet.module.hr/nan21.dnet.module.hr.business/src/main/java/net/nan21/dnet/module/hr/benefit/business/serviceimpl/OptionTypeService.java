/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.benefit.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.benefit.business.service.IOptionTypeService;
import net.nan21.dnet.module.hr.benefit.domain.entity.OptionType;

/**
 * Repository functionality for {@link OptionType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OptionTypeService extends AbstractEntityService<OptionType>
		implements
			IOptionTypeService {

	public OptionTypeService() {
		super();
	}

	public OptionTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<OptionType> getEntityClass() {
		return OptionType.class;
	}

	/**
	 * Find by unique key
	 */
	public OptionType findByName(String name) {
		return (OptionType) this.em
				.createNamedQuery(OptionType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
