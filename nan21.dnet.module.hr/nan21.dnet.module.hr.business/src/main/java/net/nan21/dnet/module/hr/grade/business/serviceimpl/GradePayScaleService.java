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
import net.nan21.dnet.module.hr.grade.business.service.IGradePayScaleService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

/**
 * Repository functionality for {@link GradePayScale} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class GradePayScaleService extends AbstractEntityService<GradePayScale>
		implements
			IGradePayScaleService {

	public GradePayScaleService() {
		super();
	}

	public GradePayScaleService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<GradePayScale> getEntityClass() {
		return GradePayScale.class;
	}

	/**
	 * Find by reference: grade
	 */
	public List<GradePayScale> findByGrade(Grade grade) {
		return this.findByGradeId(grade.getId());
	}

	/**
	 * Find by ID of reference: grade.id
	 */
	public List<GradePayScale> findByGradeId(Long gradeId) {
		return (List<GradePayScale>) this
				.getEntityManager()
				.createQuery(
						"select e from GradePayScale e where e.clientId = :pClientId and e.grade.id = :pGradeId",
						GradePayScale.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pGradeId", gradeId).getResultList();
	}

	/**
	 * Find by reference: payScale
	 */
	public List<GradePayScale> findByPayScale(PayScale payScale) {
		return this.findByPayScaleId(payScale.getId());
	}

	/**
	 * Find by ID of reference: payScale.id
	 */
	public List<GradePayScale> findByPayScaleId(Long payScaleId) {
		return (List<GradePayScale>) this
				.getEntityManager()
				.createQuery(
						"select e from GradePayScale e where e.clientId = :pClientId and e.payScale.id = :pPayScaleId",
						GradePayScale.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPayScaleId", payScaleId).getResultList();
	}

	/**
	 * Find by reference: ceiling
	 */
	public List<GradePayScale> findByCeiling(PayScalePoint ceiling) {
		return this.findByCeilingId(ceiling.getId());
	}

	/**
	 * Find by ID of reference: ceiling.id
	 */
	public List<GradePayScale> findByCeilingId(Long ceilingId) {
		return (List<GradePayScale>) this
				.getEntityManager()
				.createQuery(
						"select e from GradePayScale e where e.clientId = :pClientId and e.ceiling.id = :pCeilingId",
						GradePayScale.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCeilingId", ceilingId).getResultList();
	}
}
