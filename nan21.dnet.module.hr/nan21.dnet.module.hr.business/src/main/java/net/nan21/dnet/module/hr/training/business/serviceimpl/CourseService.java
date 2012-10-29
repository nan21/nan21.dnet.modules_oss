/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.training.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.training.business.service.ICourseService;
import net.nan21.dnet.module.hr.training.domain.entity.Course;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;


public class CourseService extends AbstractEntityService<Course>
		implements ICourseService {
 
	public CourseService() {
		super();
	}

	public CourseService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<Course> getEntityClass() {
		return Course.class;
	}
	
	public Course findByCode(String code) {		 
		return (Course) this.em
			.createNamedQuery(Course.NQ_FIND_BY_CODE)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pCode", code)
			.getSingleResult(); 
	}
	
	public Course findByName(String name) {		 
		return (Course) this.em
			.createNamedQuery(Course.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
	
	public List<Course> findByType(CourseType type) {
		return this.findByTypeId(type.getId()); 
	}
	
	public List<Course> findByTypeId(Long typeId) {
		return (List<Course>) this.em
			.createQuery("select e from Course e where e.clientId = :pClientId and e.type.id = :pTypeId", Course.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pTypeId", typeId)			 	
			.getResultList(); 
	}
}
