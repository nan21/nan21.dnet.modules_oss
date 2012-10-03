/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.attr.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Attribute category definition.*/
@NamedQueries({
	@NamedQuery(
		name=AttributeCategory.NQ_FIND_BY_ID,
		query="SELECT e FROM AttributeCategory e WHERE e.clientId = :pClientId and e.id = :pId ",
		hints=@QueryHint(name=QueryHints.BIND_PARAMETERS, value=HintValues.TRUE)
	)
	,@NamedQuery(
		name=AttributeCategory.NQ_FIND_BY_IDS,
		query="SELECT e FROM AttributeCategory e WHERE e.clientId = :pClientId and e.id in :pIds",
		hints=@QueryHint(name=QueryHints.BIND_PARAMETERS, value=HintValues.TRUE)
	)
	,@NamedQuery(
		name=AttributeCategory.NQ_FIND_BY_NAME,
		query="SELECT e FROM AttributeCategory e WHERE e.clientId = :pClientId and e.name = :pName",
		hints=@QueryHint(name=QueryHints.BIND_PARAMETERS, value=HintValues.TRUE)
	)
})
@Entity
@Table(
	name=AttributeCategory.TABLE_NAME
	,uniqueConstraints={
		@UniqueConstraint( 
			name=AttributeCategory.TABLE_NAME+"_UK1"
			,columnNames={"CLIENTID","NAME"}
		)
	}
)
@Customizer(DefaultEventHandler.class)
public class AttributeCategory extends AbstractType  {
	
	public static final String TABLE_NAME = "BD_ATTR_CTG";
	public static final String SEQUENCE_NAME = "BD_ATTR_CTG_SEQ";
	
	private static final long serialVersionUID = -8865917134914502125L;
	
	/**
	 * Named query find by ID.
	 */ 
	public static final String NQ_FIND_BY_ID = "AttributeCategory.findById";
	
	/**
	 * Named query find by IDs.
	 */     
	public static final String NQ_FIND_BY_IDS = "AttributeCategory.findByIds";
	
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "AttributeCategory.findByName";
	
	/**
			 * System generated unique identifier.
			 */
	@Column(name="ID", nullable=false)
	@NotNull
	@Id
	@GeneratedValue(generator=SEQUENCE_NAME)
	private Long id;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);
	
	}
}
