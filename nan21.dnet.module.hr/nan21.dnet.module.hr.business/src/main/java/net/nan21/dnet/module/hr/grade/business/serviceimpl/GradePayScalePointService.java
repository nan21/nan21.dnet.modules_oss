/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IGradePayScalePointService;
import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScalePoint;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

/**
 * Repository functionality for {@link GradePayScalePoint} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class GradePayScalePointService
		extends
			AbstractEntityService<GradePayScalePoint>
		implements
			IGradePayScalePointService {

	public GradePayScalePointService() {
		super();
	}

	public GradePayScalePointService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<GradePayScalePoint> getEntityClass() {
		return GradePayScalePoint.class;
	}

	/**
	 * Find by reference: gradePayScale
	 */
	public List<GradePayScalePoint> findByGradePayScale(
			GradePayScale gradePayScale) {
		return this.findByGradePayScaleId(gradePayScale.getId());
	}

	/**
	 * Find by ID of reference: gradePayScale.id
	 */
	public List<GradePayScalePoint> findByGradePayScaleId(Long gradePayScaleId) {
		return (List<GradePayScalePoint>) this.em
				.createQuery(
						"select e from GradePayScalePoint e where e.clientId = :pClientId and e.gradePayScale.id = :pGradePayScaleId",
						GradePayScalePoint.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pGradePayScaleId", gradePayScaleId)
				.getResultList();
	}

	/**
	 * Find by reference: point
	 */
	public List<GradePayScalePoint> findByPoint(PayScalePoint point) {
		return this.findByPointId(point.getId());
	}

	/**
	 * Find by ID of reference: point.id
	 */
	public List<GradePayScalePoint> findByPointId(Long pointId) {
		return (List<GradePayScalePoint>) this.em
				.createQuery(
						"select e from GradePayScalePoint e where e.clientId = :pClientId and e.point.id = :pPointId",
						GradePayScalePoint.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPointId", pointId).getResultList();
	}
}
