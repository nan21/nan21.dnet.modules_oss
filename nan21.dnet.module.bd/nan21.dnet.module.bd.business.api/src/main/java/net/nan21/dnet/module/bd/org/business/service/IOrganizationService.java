/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Calendar;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;

/**
 * Interface to expose business functions specific for {@link Organization} domain
 * entity.
 */
public interface IOrganizationService extends IEntityService<Organization> {

	/**
	 * Find by unique key
	 */
	public Organization findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Organization findByName(String name);

	/**
	 * Find by reference: type
	 */
	public List<Organization> findByType(OrganizationType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Organization> findByTypeId(Long typeId);

	/**
	 * Find by reference: calendar
	 */
	public List<Organization> findByCalendar(Calendar calendar);

	/**
	 * Find by ID of reference: calendar.id
	 */
	public List<Organization> findByCalendarId(Long calendarId);
}
