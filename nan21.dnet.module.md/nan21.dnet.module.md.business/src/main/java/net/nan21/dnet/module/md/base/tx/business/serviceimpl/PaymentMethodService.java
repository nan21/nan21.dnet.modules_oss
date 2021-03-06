/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tx.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentMethodService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;

/**
 * Repository functionality for {@link PaymentMethod} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PaymentMethodService extends AbstractEntityService<PaymentMethod>
		implements
			IPaymentMethodService {

	public PaymentMethodService() {
		super();
	}

	public PaymentMethodService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PaymentMethod> getEntityClass() {
		return PaymentMethod.class;
	}

	/**
	 * Find by unique key
	 */
	public PaymentMethod findByName(String name) {
		return (PaymentMethod) this.getEntityManager()
				.createNamedQuery(PaymentMethod.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: docType
	 */
	public List<PaymentMethod> findByDocType(TxDocType docType) {
		return this.findByDocTypeId(docType.getId());
	}

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<PaymentMethod> findByDocTypeId(Long docTypeId) {
		return (List<PaymentMethod>) this
				.getEntityManager()
				.createQuery(
						"select e from PaymentMethod e where e.clientId = :pClientId and e.docType.id = :pDocTypeId",
						PaymentMethod.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDocTypeId", docTypeId).getResultList();
	}
}
