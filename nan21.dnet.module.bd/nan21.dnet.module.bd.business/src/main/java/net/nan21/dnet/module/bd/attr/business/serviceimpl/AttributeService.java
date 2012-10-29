/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.attr.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.attr.business.service.IAttributeService;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeCategory;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;


public class AttributeService extends AbstractEntityService<Attribute>
		implements IAttributeService {
 
	public AttributeService() {
		super();
	}

	public AttributeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<Attribute> getEntityClass() {
		return Attribute.class;
	}
	
	public Attribute findByName(String name) {		 
		return (Attribute) this.em
			.createNamedQuery(Attribute.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
	
	public List<Attribute> findByCategory(AttributeCategory category) {
		return this.findByCategoryId(category.getId()); 
	}
	
	public List<Attribute> findByCategoryId(Long categoryId) {
		return (List<Attribute>) this.em
			.createQuery("select e from Attribute e where e.clientId = :pClientId and e.category.id = :pCategoryId", Attribute.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pCategoryId", categoryId)			 	
			.getResultList(); 
	}
	
	public List<Attribute> findByUom(Uom uom) {
		return this.findByUomId(uom.getId()); 
	}
	
	public List<Attribute> findByUomId(Long uomId) {
		return (List<Attribute>) this.em
			.createQuery("select e from Attribute e where e.clientId = :pClientId and e.uom.id = :pUomId", Attribute.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pUomId", uomId)			 	
			.getResultList(); 
	}
}
