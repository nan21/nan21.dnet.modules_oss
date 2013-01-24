/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.hr.training.domain.entity.Course;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

@Ds(entity = Course.class, sort = {@SortField(field = CourseDs.f_name)})
@RefLookups({@RefLookup(refId = CourseDs.f_typeId, namedQuery = CourseType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = CourseDs.f_type)})})
public class CourseDs extends AbstractTypeWithCodeDs<Course> {

	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_intendedAudience = "intendedAudience";
	public static final String f_deliveredCompetences = "deliveredCompetences";
	public static final String f_requirements = "requirements";

	@DsField(join = "left", path = "type.id")
	private Long typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	@DsField
	private String intendedAudience;

	@DsField
	private String deliveredCompetences;

	@DsField
	private String requirements;

	public CourseDs() {
		super();
	}

	public CourseDs(Course e) {
		super(e);
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIntendedAudience() {
		return this.intendedAudience;
	}

	public void setIntendedAudience(String intendedAudience) {
		this.intendedAudience = intendedAudience;
	}

	public String getDeliveredCompetences() {
		return this.deliveredCompetences;
	}

	public void setDeliveredCompetences(String deliveredCompetences) {
		this.deliveredCompetences = deliveredCompetences;
	}

	public String getRequirements() {
		return this.requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
}
