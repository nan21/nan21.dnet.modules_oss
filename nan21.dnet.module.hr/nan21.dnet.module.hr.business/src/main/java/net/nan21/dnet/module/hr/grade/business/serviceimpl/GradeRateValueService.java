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
import net.nan21.dnet.module.hr.grade.business.service.IGradeRateValueService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRateValue;

/**
 * Repository functionality for {@link GradeRateValue} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class GradeRateValueService
		extends
			AbstractEntityService<GradeRateValue>
		implements
			IGradeRateValueService {

	public GradeRateValueService() {
		super();
	}

	public GradeRateValueService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<GradeRateValue> getEntityClass() {
		return GradeRateValue.class;
	}

	/**
	 * Find by reference: gradeRate
	 */
	public List<GradeRateValue> findByGradeRate(GradeRate gradeRate) {
		return this.findByGradeRateId(gradeRate.getId());
	}

	/**
	 * Find by ID of reference: gradeRate.id
	 */
	public List<GradeRateValue> findByGradeRateId(Long gradeRateId) {
		return (List<GradeRateValue>) this
				.getEntityManager()
				.createQuery(
						"select e from GradeRateValue e where e.clientId = :pClientId and e.gradeRate.id = :pGradeRateId",
						GradeRateValue.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pGradeRateId", gradeRateId).getResultList();
	}

	/**
	 * Find by reference: grade
	 */
	public List<GradeRateValue> findByGrade(Grade grade) {
		return this.findByGradeId(grade.getId());
	}

	/**
	 * Find by ID of reference: grade.id
	 */
	public List<GradeRateValue> findByGradeId(Long gradeId) {
		return (List<GradeRateValue>) this
				.getEntityManager()
				.createQuery(
						"select e from GradeRateValue e where e.clientId = :pClientId and e.grade.id = :pGradeId",
						GradeRateValue.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pGradeId", gradeId).getResultList();
	}
}
