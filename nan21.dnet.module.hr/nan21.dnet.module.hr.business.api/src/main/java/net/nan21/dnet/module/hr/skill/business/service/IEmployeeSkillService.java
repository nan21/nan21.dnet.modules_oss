/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.skill.domain.entity.EmployeeSkill;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

/**
 * Interface to expose business functions specific for {@link EmployeeSkill} domain
 * entity.
 */
public interface IEmployeeSkillService extends IEntityService<EmployeeSkill> {

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeSkill> findByEmployee(Employee employee);

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeSkill> findByEmployeeId(Long employeeId);

	/**
	 * Find by reference: skill
	 */
	public List<EmployeeSkill> findBySkill(Skill skill);

	/**
	 * Find by ID of reference: skill.id
	 */
	public List<EmployeeSkill> findBySkillId(Long skillId);

	/**
	 * Find by reference: skillLevel
	 */
	public List<EmployeeSkill> findBySkillLevel(RatingLevel skillLevel);

	/**
	 * Find by ID of reference: skillLevel.id
	 */
	public List<EmployeeSkill> findBySkillLevelId(Long skillLevelId);
}
