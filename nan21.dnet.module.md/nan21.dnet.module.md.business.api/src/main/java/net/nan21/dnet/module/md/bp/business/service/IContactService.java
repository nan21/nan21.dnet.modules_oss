/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;

/**
 * Interface to expose business functions specific for {@link Contact} domain
 * entity.
 */
public interface IContactService extends IEntityService<Contact> {

	/**
	 * Find by reference: bpartner
	 */
	public List<Contact> findByBpartner(BusinessPartner bpartner);

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<Contact> findByBpartnerId(Long bpartnerId);
}
