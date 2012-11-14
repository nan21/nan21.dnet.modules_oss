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
import net.nan21.dnet.module.ad.system.business.service.ISysDsServiceService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

/**
 * Repository functionality for {@link SysDsService} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysDsServiceService extends AbstractEntityService<SysDsService>
		implements
			ISysDsServiceService {

	public SysDsServiceService() {
		super();
	}

	public SysDsServiceService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SysDsService> getEntityClass() {
		return SysDsService.class;
	}

	/**
	 * Find by unique key
	 */
	public SysDsService findByName(SysDataSource dataSource, String name) {
		return (SysDsService) this.em
				.createNamedQuery(SysDsService.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDataSource", dataSource)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public SysDsService findByName(Long dataSourceId, String name) {
		return (SysDsService) this.em
				.createNamedQuery(SysDsService.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDataSourceId", dataSourceId)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: dataSource
	 */
	public List<SysDsService> findByDataSource(SysDataSource dataSource) {
		return this.findByDataSourceId(dataSource.getId());
	}

	/**
	 * Find by ID of reference: dataSource.id
	 */
	public List<SysDsService> findByDataSourceId(Long dataSourceId) {
		return (List<SysDsService>) this.em
				.createQuery(
						"select e from SysDsService e where e.clientId = :pClientId and e.dataSource.id = :pDataSourceId",
						SysDsService.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDataSourceId", dataSourceId).getResultList();
	}
}
