/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.contact.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.contact.business.service.IPersonService;
import net.nan21.dnet.module.bd.contact.domain.entity.Person;

/**
 * Repository functionality for {@link Person} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PersonService extends AbstractEntityService<Person>
		implements
			IPersonService {

	public PersonService() {
		super();
	}

	public PersonService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Person> getEntityClass() {
		return Person.class;
	}
}
