/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysDsEventService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsEvent;

/**
 * Repository functionality for {@link SysDsEvent} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysDsEventService extends AbstractEntityService<SysDsEvent>
		implements
			ISysDsEventService {

	public SysDsEventService() {
		super();
	}

	public SysDsEventService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SysDsEvent> getEntityClass() {
		return SysDsEvent.class;
	}

	/**
	 * Find by unique key
	 */
	public SysDsEvent findByName(SysDataSource dataSource, String eventType) {
		return (SysDsEvent) this.getEntityManager()
				.createNamedQuery(SysDsEvent.NQ_FIND_BY_NAME)
				.setParameter("pDataSource", dataSource)
				.setParameter("pEventType", eventType).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public SysDsEvent findByName(Long dataSourceId, String eventType) {
		return (SysDsEvent) this.getEntityManager()
				.createNamedQuery(SysDsEvent.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pDataSourceId", dataSourceId)
				.setParameter("pEventType", eventType).getSingleResult();
	}

	/**
	 * Find by reference: dataSource
	 */
	public List<SysDsEvent> findByDataSource(SysDataSource dataSource) {
		return this.findByDataSourceId(dataSource.getId());
	}

	/**
	 * Find by ID of reference: dataSource.id
	 */
	public List<SysDsEvent> findByDataSourceId(Long dataSourceId) {
		return (List<SysDsEvent>) this
				.getEntityManager()
				.createQuery(
						"select e from SysDsEvent e where  e.dataSource.id = :pDataSourceId",
						SysDsEvent.class)
				.setParameter("pDataSourceId", dataSourceId).getResultList();
	}
}
