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
import net.nan21.dnet.module.hr.grade.business.service.IPositionGradeService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.PositionGrade;
import net.nan21.dnet.module.hr.job.domain.entity.Position;

/**
 * Repository functionality for {@link PositionGrade} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PositionGradeService extends AbstractEntityService<PositionGrade>
		implements
			IPositionGradeService {

	public PositionGradeService() {
		super();
	}

	public PositionGradeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PositionGrade> getEntityClass() {
		return PositionGrade.class;
	}

	/**
	 * Find by reference: position
	 */
	public List<PositionGrade> findByPosition(Position position) {
		return this.findByPositionId(position.getId());
	}

	/**
	 * Find by ID of reference: position.id
	 */
	public List<PositionGrade> findByPositionId(Long positionId) {
		return (List<PositionGrade>) this
				.getEntityManager()
				.createQuery(
						"select e from PositionGrade e where e.clientId = :pClientId and e.position.id = :pPositionId",
						PositionGrade.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPositionId", positionId).getResultList();
	}

	/**
	 * Find by reference: grade
	 */
	public List<PositionGrade> findByGrade(Grade grade) {
		return this.findByGradeId(grade.getId());
	}

	/**
	 * Find by ID of reference: grade.id
	 */
	public List<PositionGrade> findByGradeId(Long gradeId) {
		return (List<PositionGrade>) this
				.getEntityManager()
				.createQuery(
						"select e from PositionGrade e where e.clientId = :pClientId and e.grade.id = :pGradeId",
						PositionGrade.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pGradeId", gradeId).getResultList();
	}
}
