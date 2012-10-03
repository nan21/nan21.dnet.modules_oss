/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({
	@NamedQuery(
		name=PositionSkill.NQ_FIND_BY_ID,
		query="SELECT e FROM PositionSkill e WHERE e.clientId = :pClientId and e.id = :pId ",
		hints=@QueryHint(name=QueryHints.BIND_PARAMETERS, value=HintValues.TRUE)
	)
	,@NamedQuery(
		name=PositionSkill.NQ_FIND_BY_IDS,
		query="SELECT e FROM PositionSkill e WHERE e.clientId = :pClientId and e.id in :pIds",
		hints=@QueryHint(name=QueryHints.BIND_PARAMETERS, value=HintValues.TRUE)
	)
})
@Entity
@Table(
	name=PositionSkill.TABLE_NAME
)
@Customizer(DefaultEventHandler.class)
public class PositionSkill extends AbstractAuditable  {
	
	public static final String TABLE_NAME = "HR_POS_SKILL";
	public static final String SEQUENCE_NAME = "HR_POS_SKILL_SEQ";
	
	private static final long serialVersionUID = -8865917134914502125L;
	
	/**
	 * Named query find by ID.
	 */ 
	public static final String NQ_FIND_BY_ID = "PositionSkill.findById";
	
	/**
	 * Named query find by IDs.
	 */     
	public static final String NQ_FIND_BY_IDS = "PositionSkill.findByIds";
	
	/**
			 * System generated unique identifier.
			 */
	@Column(name="ID", nullable=false)
	@NotNull
	@Id
	@GeneratedValue(generator=SEQUENCE_NAME)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Position.class)
	@JoinColumn(name="POSITION_ID", referencedColumnName="ID")
	private Position position;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Skill.class)
	@JoinColumn(name="SKILL_ID", referencedColumnName="ID")
	private Skill skill;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=RatingLevel.class)
	@JoinColumn(name="REQUIREDLEVEL_ID", referencedColumnName="ID")
	private RatingLevel requiredLevel;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public void setPosition(Position position) {
		if (position != null ) {
			this.__validate_client_context__(position.getClientId());
		}
		this.position = position;
	}
	
	public Skill getSkill() {
		return this.skill;
	}
	
	public void setSkill(Skill skill) {
		if (skill != null ) {
			this.__validate_client_context__(skill.getClientId());
		}
		this.skill = skill;
	}
	
	public RatingLevel getRequiredLevel() {
		return this.requiredLevel;
	}
	
	public void setRequiredLevel(RatingLevel requiredLevel) {
		if (requiredLevel != null ) {
			this.__validate_client_context__(requiredLevel.getClientId());
		}
		this.requiredLevel = requiredLevel;
	}
	
	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);
	
	}
}
