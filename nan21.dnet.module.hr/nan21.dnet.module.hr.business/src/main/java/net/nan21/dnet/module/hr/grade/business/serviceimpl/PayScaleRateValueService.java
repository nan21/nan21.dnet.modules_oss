/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IPayScaleRateValueService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRateValue;

/**
 * Repository functionality for {@link PayScaleRateValue} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PayScaleRateValueService
		extends
			AbstractEntityService<PayScaleRateValue>
		implements
			IPayScaleRateValueService {

	public PayScaleRateValueService() {
		super();
	}

	public PayScaleRateValueService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PayScaleRateValue> getEntityClass() {
		return PayScaleRateValue.class;
	}

	/**
	 * Find by reference: scaleRate
	 */
	public List<PayScaleRateValue> findByScaleRate(PayScaleRate scaleRate) {
		return this.findByScaleRateId(scaleRate.getId());
	}

	/**
	 * Find by ID of reference: scaleRate.id
	 */
	public List<PayScaleRateValue> findByScaleRateId(Long scaleRateId) {
		return (List<PayScaleRateValue>) this
				.getEntityManager()
				.createQuery(
						"select e from PayScaleRateValue e where e.clientId = :pClientId and e.scaleRate.id = :pScaleRateId",
						PayScaleRateValue.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pScaleRateId", scaleRateId).getResultList();
	}

	/**
	 * Find by reference: scalePoint
	 */
	public List<PayScaleRateValue> findByScalePoint(PayScalePoint scalePoint) {
		return this.findByScalePointId(scalePoint.getId());
	}

	/**
	 * Find by ID of reference: scalePoint.id
	 */
	public List<PayScaleRateValue> findByScalePointId(Long scalePointId) {
		return (List<PayScaleRateValue>) this
				.getEntityManager()
				.createQuery(
						"select e from PayScaleRateValue e where e.clientId = :pClientId and e.scalePoint.id = :pScalePointId",
						PayScaleRateValue.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pScalePointId", scalePointId).getResultList();
	}
}
