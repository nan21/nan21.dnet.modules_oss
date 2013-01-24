/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.benefit.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.benefit.business.service.IOptionService;
import net.nan21.dnet.module.hr.benefit.domain.entity.Option;

/**
 * Repository functionality for {@link Option} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OptionService extends AbstractEntityService<Option>
		implements
			IOptionService {

	public OptionService() {
		super();
	}

	public OptionService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Option> getEntityClass() {
		return Option.class;
	}

	/**
	 * Find by unique key
	 */
	public Option findByName(String name) {
		return (Option) this.getEntityManager()
				.createNamedQuery(Option.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
