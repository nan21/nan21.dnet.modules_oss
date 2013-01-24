/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

/**
 * Interface to expose business functions specific for {@link Payment} domain
 * entity.
 */
public interface IPaymentService extends IEntityService<Payment> {

	/**
	 * Find by reference: currency
	 */
	public List<Payment> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<Payment> findByCurrencyId(Long currencyId);

	/**
	 * Find by reference: paymentMethod
	 */
	public List<Payment> findByPaymentMethod(PaymentMethod paymentMethod);

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<Payment> findByPaymentMethodId(Long paymentMethodId);

	/**
	 * Find by reference: fromOrg
	 */
	public List<Payment> findByFromOrg(Organization fromOrg);

	/**
	 * Find by ID of reference: fromOrg.id
	 */
	public List<Payment> findByFromOrgId(Long fromOrgId);

	/**
	 * Find by reference: toOrg
	 */
	public List<Payment> findByToOrg(Organization toOrg);

	/**
	 * Find by ID of reference: toOrg.id
	 */
	public List<Payment> findByToOrgId(Long toOrgId);

	/**
	 * Find by reference: fromAccount
	 */
	public List<Payment> findByFromAccount(FinancialAccount fromAccount);

	/**
	 * Find by ID of reference: fromAccount.id
	 */
	public List<Payment> findByFromAccountId(Long fromAccountId);

	/**
	 * Find by reference: toAccount
	 */
	public List<Payment> findByToAccount(FinancialAccount toAccount);

	/**
	 * Find by ID of reference: toAccount.id
	 */
	public List<Payment> findByToAccountId(Long toAccountId);

	/**
	 * Find by reference: bpartner
	 */
	public List<Payment> findByBpartner(BusinessPartner bpartner);

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<Payment> findByBpartnerId(Long bpartnerId);

	/**
	 * Find by reference: lines
	 */
	public List<Payment> findByLines(PaymentItem lines);

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<Payment> findByLinesId(Long linesId);
}
