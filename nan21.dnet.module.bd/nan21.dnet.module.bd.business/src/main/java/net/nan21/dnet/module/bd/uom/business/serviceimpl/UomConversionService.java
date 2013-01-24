/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.uom.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.business.service.IUomConversionService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.bd.uom.domain.entity.UomConversion;

/**
 * Repository functionality for {@link UomConversion} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class UomConversionService extends AbstractEntityService<UomConversion>
		implements
			IUomConversionService {

	public UomConversionService() {
		super();
	}

	public UomConversionService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<UomConversion> getEntityClass() {
		return UomConversion.class;
	}

	/**
	 * Find by reference: source
	 */
	public List<UomConversion> findBySource(Uom source) {
		return this.findBySourceId(source.getId());
	}

	/**
	 * Find by ID of reference: source.id
	 */
	public List<UomConversion> findBySourceId(Long sourceId) {
		return (List<UomConversion>) this
				.getEntityManager()
				.createQuery(
						"select e from UomConversion e where e.clientId = :pClientId and e.source.id = :pSourceId",
						UomConversion.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSourceId", sourceId).getResultList();
	}

	/**
	 * Find by reference: target
	 */
	public List<UomConversion> findByTarget(Uom target) {
		return this.findByTargetId(target.getId());
	}

	/**
	 * Find by ID of reference: target.id
	 */
	public List<UomConversion> findByTargetId(Long targetId) {
		return (List<UomConversion>) this
				.getEntityManager()
				.createQuery(
						"select e from UomConversion e where e.clientId = :pClientId and e.target.id = :pTargetId",
						UomConversion.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTargetId", targetId).getResultList();
	}
}
