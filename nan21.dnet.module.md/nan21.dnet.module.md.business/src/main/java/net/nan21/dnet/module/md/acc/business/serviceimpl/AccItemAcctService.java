/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.acc.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.acc.domain.entity.AccItemAcct;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

/**
 * Repository functionality for {@link AccItemAcct} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccItemAcctService extends AbstractEntityService<AccItemAcct> {

	public AccItemAcctService() {
		super();
	}

	public AccItemAcctService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<AccItemAcct> getEntityClass() {
		return AccItemAcct.class;
	}

	/**
	 * Find by unique key
	 */
	public AccItemAcct findByItem_schema(AccItem accItem, AccSchema accSchema) {
		return (AccItemAcct) this.em
				.createNamedQuery(AccItemAcct.NQ_FIND_BY_ITEM_SCHEMA)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccItem", accItem)
				.setParameter("pAccSchema", accSchema).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public AccItemAcct findByItem_schema(Long accItemId, Long accSchemaId) {
		return (AccItemAcct) this.em
				.createNamedQuery(AccItemAcct.NQ_FIND_BY_ITEM_SCHEMA_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccItemId", accItemId)
				.setParameter("pAccSchemaId", accSchemaId).getSingleResult();
	}

	/**
	 * Find by reference: accItem
	 */
	public List<AccItemAcct> findByAccItem(AccItem accItem) {
		return this.findByAccItemId(accItem.getId());
	}

	/**
	 * Find by ID of reference: accItem.id
	 */
	public List<AccItemAcct> findByAccItemId(Long accItemId) {
		return (List<AccItemAcct>) this.em
				.createQuery(
						"select e from AccItemAcct e where e.clientId = :pClientId and e.accItem.id = :pAccItemId",
						AccItemAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccItemId", accItemId).getResultList();
	}

	/**
	 * Find by reference: accSchema
	 */
	public List<AccItemAcct> findByAccSchema(AccSchema accSchema) {
		return this.findByAccSchemaId(accSchema.getId());
	}

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<AccItemAcct> findByAccSchemaId(Long accSchemaId) {
		return (List<AccItemAcct>) this.em
				.createQuery(
						"select e from AccItemAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
						AccItemAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccSchemaId", accSchemaId).getResultList();
	}

	/**
	 * Find by reference: crAccount
	 */
	public List<AccItemAcct> findByCrAccount(Account crAccount) {
		return this.findByCrAccountId(crAccount.getId());
	}

	/**
	 * Find by ID of reference: crAccount.id
	 */
	public List<AccItemAcct> findByCrAccountId(Long crAccountId) {
		return (List<AccItemAcct>) this.em
				.createQuery(
						"select e from AccItemAcct e where e.clientId = :pClientId and e.crAccount.id = :pCrAccountId",
						AccItemAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCrAccountId", crAccountId).getResultList();
	}

	/**
	 * Find by reference: dbAccount
	 */
	public List<AccItemAcct> findByDbAccount(Account dbAccount) {
		return this.findByDbAccountId(dbAccount.getId());
	}

	/**
	 * Find by ID of reference: dbAccount.id
	 */
	public List<AccItemAcct> findByDbAccountId(Long dbAccountId) {
		return (List<AccItemAcct>) this.em
				.createQuery(
						"select e from AccItemAcct e where e.clientId = :pClientId and e.dbAccount.id = :pDbAccountId",
						AccItemAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDbAccountId", dbAccountId).getResultList();
	}
}
