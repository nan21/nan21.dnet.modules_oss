/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.acc.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;

/**
 * Repository functionality for {@link AccDoc} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccDocService extends AbstractEntityService<AccDoc> {

	public AccDocService() {
		super();
	}

	public AccDocService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AccDoc> getEntityClass() {
		return AccDoc.class;
	}

	/**
	 * Find by reference: org
	 */
	public List<AccDoc> findByOrg(Organization org) {
		return this.findByOrgId(org.getId());
	}

	/**
	 * Find by ID of reference: org.id
	 */
	public List<AccDoc> findByOrgId(Long orgId) {
		return (List<AccDoc>) this
				.getEntityManager()
				.createQuery(
						"select e from AccDoc e where e.clientId = :pClientId and e.org.id = :pOrgId",
						AccDoc.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrgId", orgId).getResultList();
	}

	/**
	 * Find by reference: accSchema
	 */
	public List<AccDoc> findByAccSchema(AccSchema accSchema) {
		return this.findByAccSchemaId(accSchema.getId());
	}

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<AccDoc> findByAccSchemaId(Long accSchemaId) {
		return (List<AccDoc>) this
				.getEntityManager()
				.createQuery(
						"select e from AccDoc e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
						AccDoc.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccSchemaId", accSchemaId).getResultList();
	}

	/**
	 * Find by reference: period
	 */
	public List<AccDoc> findByPeriod(FiscalPeriod period) {
		return this.findByPeriodId(period.getId());
	}

	/**
	 * Find by ID of reference: period.id
	 */
	public List<AccDoc> findByPeriodId(Long periodId) {
		return (List<AccDoc>) this
				.getEntityManager()
				.createQuery(
						"select e from AccDoc e where e.clientId = :pClientId and e.period.id = :pPeriodId",
						AccDoc.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPeriodId", periodId).getResultList();
	}

	/**
	 * Find by reference: journal
	 */
	public List<AccDoc> findByJournal(AccJournal journal) {
		return this.findByJournalId(journal.getId());
	}

	/**
	 * Find by ID of reference: journal.id
	 */
	public List<AccDoc> findByJournalId(Long journalId) {
		return (List<AccDoc>) this
				.getEntityManager()
				.createQuery(
						"select e from AccDoc e where e.clientId = :pClientId and e.journal.id = :pJournalId",
						AccDoc.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJournalId", journalId).getResultList();
	}

	/**
	 * Find by reference: bpartner
	 */
	public List<AccDoc> findByBpartner(BusinessPartner bpartner) {
		return this.findByBpartnerId(bpartner.getId());
	}

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<AccDoc> findByBpartnerId(Long bpartnerId) {
		return (List<AccDoc>) this
				.getEntityManager()
				.createQuery(
						"select e from AccDoc e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
						AccDoc.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpartnerId", bpartnerId).getResultList();
	}

	/**
	 * Find by reference: docCurrency
	 */
	public List<AccDoc> findByDocCurrency(Currency docCurrency) {
		return this.findByDocCurrencyId(docCurrency.getId());
	}

	/**
	 * Find by ID of reference: docCurrency.id
	 */
	public List<AccDoc> findByDocCurrencyId(Long docCurrencyId) {
		return (List<AccDoc>) this
				.getEntityManager()
				.createQuery(
						"select e from AccDoc e where e.clientId = :pClientId and e.docCurrency.id = :pDocCurrencyId",
						AccDoc.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDocCurrencyId", docCurrencyId).getResultList();
	}

	/**
	 * Find by reference: docType
	 */
	public List<AccDoc> findByDocType(TxDocType docType) {
		return this.findByDocTypeId(docType.getId());
	}

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<AccDoc> findByDocTypeId(Long docTypeId) {
		return (List<AccDoc>) this
				.getEntityManager()
				.createQuery(
						"select e from AccDoc e where e.clientId = :pClientId and e.docType.id = :pDocTypeId",
						AccDoc.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDocTypeId", docTypeId).getResultList();
	}

	/**
	 * Find by reference: lines
	 */
	public List<AccDoc> findByLines(AccDocLine lines) {
		return this.findByLinesId(lines.getId());
	}

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<AccDoc> findByLinesId(Long linesId) {
		return (List<AccDoc>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from AccDoc e, IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
						AccDoc.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLinesId", linesId).getResultList();
	}
}
