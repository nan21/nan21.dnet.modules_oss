/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.res.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.res.domain.entity.EmployeeBase;

/**
 * Interface to expose business functions specific for {@link EmployeeBase} domain
 * entity.
 */
public interface IEmployeeBaseService extends IEntityService<EmployeeBase> {

	/**
	 * Find by reference: employer
	 */
	public List<EmployeeBase> findByEmployer(Organization employer);

	/**
	 * Find by ID of reference: employer.id
	 */
	public List<EmployeeBase> findByEmployerId(Long employerId);

	/**
	 * Find by reference: citizenship
	 */
	public List<EmployeeBase> findByCitizenship(Country citizenship);

	/**
	 * Find by ID of reference: citizenship.id
	 */
	public List<EmployeeBase> findByCitizenshipId(Long citizenshipId);
}
