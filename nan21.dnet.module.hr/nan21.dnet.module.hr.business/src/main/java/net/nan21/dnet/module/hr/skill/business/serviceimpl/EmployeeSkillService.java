/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.skill.business.service.IEmployeeSkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.EmployeeSkill;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

/**
 * Repository functionality for {@link EmployeeSkill} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class EmployeeSkillService extends AbstractEntityService<EmployeeSkill>
		implements
			IEmployeeSkillService {

	public EmployeeSkillService() {
		super();
	}

	public EmployeeSkillService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<EmployeeSkill> getEntityClass() {
		return EmployeeSkill.class;
	}

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeSkill> findByEmployee(Employee employee) {
		return this.findByEmployeeId(employee.getId());
	}

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeSkill> findByEmployeeId(Long employeeId) {
		return (List<EmployeeSkill>) this.em
				.createQuery(
						"select e from EmployeeSkill e where e.clientId = :pClientId and e.employee.id = :pEmployeeId",
						EmployeeSkill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEmployeeId", employeeId).getResultList();
	}

	/**
	 * Find by reference: skill
	 */
	public List<EmployeeSkill> findBySkill(Skill skill) {
		return this.findBySkillId(skill.getId());
	}

	/**
	 * Find by ID of reference: skill.id
	 */
	public List<EmployeeSkill> findBySkillId(Long skillId) {
		return (List<EmployeeSkill>) this.em
				.createQuery(
						"select e from EmployeeSkill e where e.clientId = :pClientId and e.skill.id = :pSkillId",
						EmployeeSkill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSkillId", skillId).getResultList();
	}

	/**
	 * Find by reference: skillLevel
	 */
	public List<EmployeeSkill> findBySkillLevel(RatingLevel skillLevel) {
		return this.findBySkillLevelId(skillLevel.getId());
	}

	/**
	 * Find by ID of reference: skillLevel.id
	 */
	public List<EmployeeSkill> findBySkillLevelId(Long skillLevelId) {
		return (List<EmployeeSkill>) this.em
				.createQuery(
						"select e from EmployeeSkill e where e.clientId = :pClientId and e.skillLevel.id = :pSkillLevelId",
						EmployeeSkill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSkillLevelId", skillLevelId).getResultList();
	}
}
