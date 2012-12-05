/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.md.tx.fin.business.service.IPaymentService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

/**
 * Repository functionality for {@link Payment} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PaymentService extends AbstractEntityService<Payment>
		implements
			IPaymentService {

	public PaymentService() {
		super();
	}

	public PaymentService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Payment> getEntityClass() {
		return Payment.class;
	}

	/**
	 * Find by reference: currency
	 */
	public List<Payment> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<Payment> findByCurrencyId(Long currencyId) {
		return (List<Payment>) this
				.getEntityManager()
				.createQuery(
						"select e from Payment e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
						Payment.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCurrencyId", currencyId).getResultList();
	}

	/**
	 * Find by reference: paymentMethod
	 */
	public List<Payment> findByPaymentMethod(PaymentMethod paymentMethod) {
		return this.findByPaymentMethodId(paymentMethod.getId());
	}

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<Payment> findByPaymentMethodId(Long paymentMethodId) {
		return (List<Payment>) this
				.getEntityManager()
				.createQuery(
						"select e from Payment e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
						Payment.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentMethodId", paymentMethodId)
				.getResultList();
	}

	/**
	 * Find by reference: fromOrg
	 */
	public List<Payment> findByFromOrg(Organization fromOrg) {
		return this.findByFromOrgId(fromOrg.getId());
	}

	/**
	 * Find by ID of reference: fromOrg.id
	 */
	public List<Payment> findByFromOrgId(Long fromOrgId) {
		return (List<Payment>) this
				.getEntityManager()
				.createQuery(
						"select e from Payment e where e.clientId = :pClientId and e.fromOrg.id = :pFromOrgId",
						Payment.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFromOrgId", fromOrgId).getResultList();
	}

	/**
	 * Find by reference: toOrg
	 */
	public List<Payment> findByToOrg(Organization toOrg) {
		return this.findByToOrgId(toOrg.getId());
	}

	/**
	 * Find by ID of reference: toOrg.id
	 */
	public List<Payment> findByToOrgId(Long toOrgId) {
		return (List<Payment>) this
				.getEntityManager()
				.createQuery(
						"select e from Payment e where e.clientId = :pClientId and e.toOrg.id = :pToOrgId",
						Payment.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pToOrgId", toOrgId).getResultList();
	}

	/**
	 * Find by reference: fromAccount
	 */
	public List<Payment> findByFromAccount(FinancialAccount fromAccount) {
		return this.findByFromAccountId(fromAccount.getId());
	}

	/**
	 * Find by ID of reference: fromAccount.id
	 */
	public List<Payment> findByFromAccountId(Long fromAccountId) {
		return (List<Payment>) this
				.getEntityManager()
				.createQuery(
						"select e from Payment e where e.clientId = :pClientId and e.fromAccount.id = :pFromAccountId",
						Payment.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFromAccountId", fromAccountId).getResultList();
	}

	/**
	 * Find by reference: toAccount
	 */
	public List<Payment> findByToAccount(FinancialAccount toAccount) {
		return this.findByToAccountId(toAccount.getId());
	}

	/**
	 * Find by ID of reference: toAccount.id
	 */
	public List<Payment> findByToAccountId(Long toAccountId) {
		return (List<Payment>) this
				.getEntityManager()
				.createQuery(
						"select e from Payment e where e.clientId = :pClientId and e.toAccount.id = :pToAccountId",
						Payment.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pToAccountId", toAccountId).getResultList();
	}

	/**
	 * Find by reference: bpartner
	 */
	public List<Payment> findByBpartner(BusinessPartner bpartner) {
		return this.findByBpartnerId(bpartner.getId());
	}

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<Payment> findByBpartnerId(Long bpartnerId) {
		return (List<Payment>) this
				.getEntityManager()
				.createQuery(
						"select e from Payment e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
						Payment.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpartnerId", bpartnerId).getResultList();
	}

	/**
	 * Find by reference: lines
	 */
	public List<Payment> findByLines(PaymentItem lines) {
		return this.findByLinesId(lines.getId());
	}

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<Payment> findByLinesId(Long linesId) {
		return (List<Payment>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Payment e, IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
						Payment.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLinesId", linesId).getResultList();
	}
}
