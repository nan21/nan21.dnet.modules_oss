/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.Position;

/**
 * Interface to expose business functions specific for {@link Position} domain
 * entity.
 */
public interface IPositionService extends IEntityService<Position> {

	/**
	 * Find by unique key
	 */
	public Position findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Position findByName(String name);

	/**
	 * Find by reference: org
	 */
	public List<Position> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<Position> findByOrgId(Long orgId);

	/**
	 * Find by reference: job
	 */
	public List<Position> findByJob(Job job);

	/**
	 * Find by ID of reference: job.id
	 */
	public List<Position> findByJobId(Long jobId);

	/**
	 * Find by reference: location
	 */
	public List<Position> findByLocation(Location location);

	/**
	 * Find by ID of reference: location.id
	 */
	public List<Position> findByLocationId(Long locationId);
}
