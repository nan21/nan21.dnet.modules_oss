/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.acc.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.acc.business.service.IAccountService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

/**
 * Repository functionality for {@link Account} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccountService extends AbstractEntityService<Account>
		implements
			IAccountService {

	public AccountService() {
		super();
	}

	public AccountService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Account> getEntityClass() {
		return Account.class;
	}

	/**
	 * Find by unique key
	 */
	public Account findByCode(String code) {
		return (Account) this.getEntityManager()
				.createNamedQuery(Account.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by reference: accSchema
	 */
	public List<Account> findByAccSchema(AccSchema accSchema) {
		return this.findByAccSchemaId(accSchema.getId());
	}

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<Account> findByAccSchemaId(Long accSchemaId) {
		return (List<Account>) this
				.getEntityManager()
				.createQuery(
						"select e from Account e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
						Account.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccSchemaId", accSchemaId).getResultList();
	}
}
