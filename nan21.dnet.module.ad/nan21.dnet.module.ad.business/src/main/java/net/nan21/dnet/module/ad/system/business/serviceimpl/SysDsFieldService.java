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
import net.nan21.dnet.module.ad.system.business.service.ISysDsFieldService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;

/**
 * Repository functionality for {@link SysDsField} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysDsFieldService extends AbstractEntityService<SysDsField>
		implements
			ISysDsFieldService {

	public SysDsFieldService() {
		super();
	}

	public SysDsFieldService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SysDsField> getEntityClass() {
		return SysDsField.class;
	}

	/**
	 * Find by unique key
	 */
	public SysDsField findByName(SysDataSource dataSource, String name) {
		return (SysDsField) this.em
				.createNamedQuery(SysDsField.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDataSource", dataSource)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public SysDsField findByName(Long dataSourceId, String name) {
		return (SysDsField) this.em
				.createNamedQuery(SysDsField.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDataSourceId", dataSourceId)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: dataSource
	 */
	public List<SysDsField> findByDataSource(SysDataSource dataSource) {
		return this.findByDataSourceId(dataSource.getId());
	}

	/**
	 * Find by ID of reference: dataSource.id
	 */
	public List<SysDsField> findByDataSourceId(Long dataSourceId) {
		return (List<SysDsField>) this.em
				.createQuery(
						"select e from SysDsField e where e.clientId = :pClientId and e.dataSource.id = :pDataSourceId",
						SysDsField.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDataSourceId", dataSourceId).getResultList();
	}
}
