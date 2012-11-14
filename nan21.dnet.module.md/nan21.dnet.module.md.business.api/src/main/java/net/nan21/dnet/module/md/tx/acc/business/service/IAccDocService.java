/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.acc.business.service;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
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
 * Interface to expose business functions specific for {@link AccDoc} domain
 * entity.
 */
public interface IAccDocService extends IEntityService<AccDoc> {

	public void doPost(AccDoc doc) throws BusinessException;

	public void doUnPost(AccDoc doc) throws BusinessException;

	/**
	 * Find by reference: org
	 */
	public List<AccDoc> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<AccDoc> findByOrgId(Long orgId);

	/**
	 * Find by reference: accSchema
	 */
	public List<AccDoc> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<AccDoc> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: period
	 */
	public List<AccDoc> findByPeriod(FiscalPeriod period);

	/**
	 * Find by ID of reference: period.id
	 */
	public List<AccDoc> findByPeriodId(Long periodId);

	/**
	 * Find by reference: journal
	 */
	public List<AccDoc> findByJournal(AccJournal journal);

	/**
	 * Find by ID of reference: journal.id
	 */
	public List<AccDoc> findByJournalId(Long journalId);

	/**
	 * Find by reference: bpartner
	 */
	public List<AccDoc> findByBpartner(BusinessPartner bpartner);

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<AccDoc> findByBpartnerId(Long bpartnerId);

	/**
	 * Find by reference: docCurrency
	 */
	public List<AccDoc> findByDocCurrency(Currency docCurrency);

	/**
	 * Find by ID of reference: docCurrency.id
	 */
	public List<AccDoc> findByDocCurrencyId(Long docCurrencyId);

	/**
	 * Find by reference: docType
	 */
	public List<AccDoc> findByDocType(TxDocType docType);

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<AccDoc> findByDocTypeId(Long docTypeId);

	/**
	 * Find by reference: lines
	 */
	public List<AccDoc> findByLines(AccDocLine lines);

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<AccDoc> findByLinesId(Long linesId);
}
