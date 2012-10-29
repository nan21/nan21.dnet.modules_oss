/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountGroupService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroupAcct;


public class ProductAccountGroupService extends AbstractEntityService<ProductAccountGroup>
		implements IProductAccountGroupService {
 
	public ProductAccountGroupService() {
		super();
	}

	public ProductAccountGroupService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ProductAccountGroup> getEntityClass() {
		return ProductAccountGroup.class;
	}
	
	public ProductAccountGroup findByCode(String code) {		 
		return (ProductAccountGroup) this.em
			.createNamedQuery(ProductAccountGroup.NQ_FIND_BY_CODE)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pCode", code)
			.getSingleResult(); 
	}
	
	public ProductAccountGroup findByName(String name) {		 
		return (ProductAccountGroup) this.em
			.createNamedQuery(ProductAccountGroup.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
	
	public List<ProductAccountGroup> findByAccounts(ProductAccountGroupAcct accounts) {
		return this.findByAccountsId(accounts.getId()); 
	}
	
	public List<ProductAccountGroup> findByAccountsId(Long accountsId) {
		return (List<ProductAccountGroup>) this.em
			.createQuery("select distinct e from ProductAccountGroup e, IN (e.accounts) c where e.clientId = :pClientId and c.id = :pAccountsId", ProductAccountGroup.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pAccountsId", accountsId)			 	
			.getResultList(); 
	}
}
