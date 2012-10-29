/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.bp.business.service.IBankService;
import net.nan21.dnet.module.md.bp.domain.entity.Bank;


public class BankService extends AbstractEntityService<Bank>
		implements IBankService {
 
	public BankService() {
		super();
	}

	public BankService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<Bank> getEntityClass() {
		return Bank.class;
	}
	
	public Bank findByCode(String code) {		 
		return (Bank) this.em
			.createNamedQuery(Bank.NQ_FIND_BY_CODE)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pCode", code)
			.getSingleResult(); 
	}
	
	public Bank findByName(String name) {		 
		return (Bank) this.em
			.createNamedQuery(Bank.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
