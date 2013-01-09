/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysDataSourceService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

/**
 * Repository functionality for {@link SysDataSource} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysDataSourceService extends AbstractEntityService<SysDataSource>
		implements
			ISysDataSourceService {

	public SysDataSourceService() {
		super();
	}

	public SysDataSourceService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SysDataSource> getEntityClass() {
		return SysDataSource.class;
	}

	/**
	 * Find by unique key
	 */
	public SysDataSource findByName(String name) {
		return (SysDataSource) this.getEntityManager()
				.createNamedQuery(SysDataSource.NQ_FIND_BY_NAME)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public SysDataSource findByModel(String model) {
		return (SysDataSource) this.getEntityManager()
				.createNamedQuery(SysDataSource.NQ_FIND_BY_MODEL)
				.setParameter("pModel", model).getSingleResult();
	}

	/**
	 * Find by reference: fields
	 */
	public List<SysDataSource> findByFields(SysDsField fields) {
		return this.findByFieldsId(fields.getId());
	}

	/**
	 * Find by ID of reference: fields.id
	 */
	public List<SysDataSource> findByFieldsId(Long fieldsId) {
		return (List<SysDataSource>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from SysDataSource e, IN (e.fields) c where  c.id = :pFieldsId",
						SysDataSource.class)
				.setParameter("pFieldsId", fieldsId).getResultList();
	}

	/**
	 * Find by reference: serviceMethods
	 */
	public List<SysDataSource> findByServiceMethods(SysDsService serviceMethods) {
		return this.findByServiceMethodsId(serviceMethods.getId());
	}

	/**
	 * Find by ID of reference: serviceMethods.id
	 */
	public List<SysDataSource> findByServiceMethodsId(Long serviceMethodsId) {
		return (List<SysDataSource>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from SysDataSource e, IN (e.serviceMethods) c where  c.id = :pServiceMethodsId",
						SysDataSource.class)
				.setParameter("pServiceMethodsId", serviceMethodsId)
				.getResultList();
	}
}
