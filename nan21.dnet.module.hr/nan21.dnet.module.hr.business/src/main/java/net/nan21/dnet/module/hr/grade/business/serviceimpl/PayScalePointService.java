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
import net.nan21.dnet.module.hr.grade.business.service.IPayScalePointService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

/**
 * Repository functionality for {@link PayScalePoint} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PayScalePointService extends AbstractEntityService<PayScalePoint>
		implements
			IPayScalePointService {

	public PayScalePointService() {
		super();
	}

	public PayScalePointService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PayScalePoint> getEntityClass() {
		return PayScalePoint.class;
	}

	/**
	 * Find by unique key
	 */
	public PayScalePoint findByScale_code(PayScale payScale, String code) {
		return (PayScalePoint) this.getEntityManager()
				.createNamedQuery(PayScalePoint.NQ_FIND_BY_SCALE_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPayScale", payScale)
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public PayScalePoint findByScale_code(Long payScaleId, String code) {
		return (PayScalePoint) this
				.getEntityManager()
				.createNamedQuery(PayScalePoint.NQ_FIND_BY_SCALE_CODE_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPayScaleId", payScaleId)
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by reference: payScale
	 */
	public List<PayScalePoint> findByPayScale(PayScale payScale) {
		return this.findByPayScaleId(payScale.getId());
	}

	/**
	 * Find by ID of reference: payScale.id
	 */
	public List<PayScalePoint> findByPayScaleId(Long payScaleId) {
		return (List<PayScalePoint>) this
				.getEntityManager()
				.createQuery(
						"select e from PayScalePoint e where e.clientId = :pClientId and e.payScale.id = :pPayScaleId",
						PayScalePoint.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPayScaleId", payScaleId).getResultList();
	}
}
