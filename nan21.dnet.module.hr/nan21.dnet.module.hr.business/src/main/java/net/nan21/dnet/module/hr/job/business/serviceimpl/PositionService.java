/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.job.business.service.IPositionService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.Position;

/**
 * Repository functionality for {@link Position} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PositionService extends AbstractEntityService<Position>
		implements
			IPositionService {

	public PositionService() {
		super();
	}

	public PositionService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Position> getEntityClass() {
		return Position.class;
	}

	/**
	 * Find by unique key
	 */
	public Position findByCode(String code) {
		return (Position) this.getEntityManager()
				.createNamedQuery(Position.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Position findByName(String name) {
		return (Position) this.getEntityManager()
				.createNamedQuery(Position.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: org
	 */
	public List<Position> findByOrg(Organization org) {
		return this.findByOrgId(org.getId());
	}

	/**
	 * Find by ID of reference: org.id
	 */
	public List<Position> findByOrgId(Long orgId) {
		return (List<Position>) this
				.getEntityManager()
				.createQuery(
						"select e from Position e where e.clientId = :pClientId and e.org.id = :pOrgId",
						Position.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrgId", orgId).getResultList();
	}

	/**
	 * Find by reference: job
	 */
	public List<Position> findByJob(Job job) {
		return this.findByJobId(job.getId());
	}

	/**
	 * Find by ID of reference: job.id
	 */
	public List<Position> findByJobId(Long jobId) {
		return (List<Position>) this
				.getEntityManager()
				.createQuery(
						"select e from Position e where e.clientId = :pClientId and e.job.id = :pJobId",
						Position.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobId", jobId).getResultList();
	}

	/**
	 * Find by reference: location
	 */
	public List<Position> findByLocation(Location location) {
		return this.findByLocationId(location.getId());
	}

	/**
	 * Find by ID of reference: location.id
	 */
	public List<Position> findByLocationId(Long locationId) {
		return (List<Position>) this
				.getEntityManager()
				.createQuery(
						"select e from Position e where e.clientId = :pClientId and e.location.id = :pLocationId",
						Position.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLocationId", locationId).getResultList();
	}
}
