/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;

@Ds(entity = RatingLevel.class, sort = {@SortField(field = RatingLevelDs.f_name)})
@RefLookups({@RefLookup(refId = RatingLevelDs.f_ratingScaleId, namedQuery = RatingScale.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = RatingLevelDs.f_ratingScale)})})
public class RatingLevelDs extends AbstractTypeDs<RatingLevel> {

	public static final String f_value = "value";
	public static final String f_ratingScaleId = "ratingScaleId";
	public static final String f_ratingScale = "ratingScale";

	@DsField
	private Integer value;

	@DsField(join = "left", path = "ratingScale.id")
	private Long ratingScaleId;

	@DsField(join = "left", path = "ratingScale.name")
	private String ratingScale;

	public RatingLevelDs() {
		super();
	}

	public RatingLevelDs(RatingLevel e) {
		super(e);
	}

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Long getRatingScaleId() {
		return this.ratingScaleId;
	}

	public void setRatingScaleId(Long ratingScaleId) {
		this.ratingScaleId = ratingScaleId;
	}

	public String getRatingScale() {
		return this.ratingScale;
	}

	public void setRatingScale(String ratingScale) {
		this.ratingScale = ratingScale;
	}
}
