/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.bp.business.service.IContactService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;

/**
 * Repository functionality for {@link Contact} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ContactService extends AbstractEntityService<Contact>
		implements
			IContactService {

	public ContactService() {
		super();
	}

	public ContactService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Contact> getEntityClass() {
		return Contact.class;
	}

	/**
	 * Find by reference: bpartner
	 */
	public List<Contact> findByBpartner(BusinessPartner bpartner) {
		return this.findByBpartnerId(bpartner.getId());
	}

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<Contact> findByBpartnerId(Long bpartnerId) {
		return (List<Contact>) this
				.getEntityManager()
				.createQuery(
						"select e from Contact e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
						Contact.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpartnerId", bpartnerId).getResultList();
	}
}
