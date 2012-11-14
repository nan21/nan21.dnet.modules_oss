/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
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
		this.em = em;
	}

	@Override
	public Class<SysDsEvent> getEntityClass() {
		return SysDsEvent.class;
	}

	/**
	 * Find by unique key
	 */
	public SysDsEvent findByName(SysDataSource dataSource, String eventType) {
		return (SysDsEvent) this.em
				.createNamedQuery(SysDsEvent.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDataSource", dataSource)
				.setParameter("pEventType", eventType).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public SysDsEvent findByName(Long dataSourceId, String eventType) {
		return (SysDsEvent) this.em
				.createNamedQuery(SysDsEvent.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
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
		return (List<SysDsEvent>) this.em
				.createQuery(
						"select e from SysDsEvent e where e.clientId = :pClientId and e.dataSource.id = :pDataSourceId",
						SysDsEvent.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDataSourceId", dataSourceId).getResultList();
	}
}
