/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.inventory.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.tx.inventory.business.service.IInvTransactionTypeService;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;

/**
 * Repository functionality for {@link InvTransactionType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class InvTransactionTypeService
		extends
			AbstractEntityService<InvTransactionType>
		implements
			IInvTransactionTypeService {

	public InvTransactionTypeService() {
		super();
	}

	public InvTransactionTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<InvTransactionType> getEntityClass() {
		return InvTransactionType.class;
	}

	/**
	 * Find by unique key
	 */
	public InvTransactionType findByName(String name) {
		return (InvTransactionType) this.getEntityManager()
				.createNamedQuery(InvTransactionType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: docType
	 */
	public List<InvTransactionType> findByDocType(TxDocType docType) {
		return this.findByDocTypeId(docType.getId());
	}

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<InvTransactionType> findByDocTypeId(Long docTypeId) {
		return (List<InvTransactionType>) this
				.getEntityManager()
				.createQuery(
						"select e from InvTransactionType e where e.clientId = :pClientId and e.docType.id = :pDocTypeId",
						InvTransactionType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDocTypeId", docTypeId).getResultList();
	}
}
