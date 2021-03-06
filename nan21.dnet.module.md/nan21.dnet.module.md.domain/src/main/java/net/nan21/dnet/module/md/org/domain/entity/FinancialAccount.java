/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.org.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Payment account. Can be a bank account or cash account for a legal entity organization  
 */
@NamedQueries({@NamedQuery(name = FinancialAccount.NQ_FIND_BY_NAME, query = "SELECT e FROM FinancialAccount e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = FinancialAccount.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = FinancialAccount.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class FinancialAccount extends AbstractType {

	public static final String TABLE_NAME = "MD_FINACNT";
	public static final String SEQUENCE_NAME = "MD_FINACNT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "FinancialAccount.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "TYPE", nullable = false, length = 8)
	@NotBlank
	private String type;

	@Column(name = "ANALITICSEGMENT", length = 32)
	private String analiticSegment;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
	@JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
	private Organization org;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
	@JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID")
	private Currency currency;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AccJournal.class)
	@JoinColumn(name = "JOURNAL_ID", referencedColumnName = "ID")
	private AccJournal journal;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = FinancialAccountMethod.class, mappedBy = "financialAccount")
	private Collection<FinancialAccountMethod> methods;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnaliticSegment() {
		return this.analiticSegment;
	}

	public void setAnaliticSegment(String analiticSegment) {
		this.analiticSegment = analiticSegment;
	}

	public Organization getOrg() {
		return this.org;
	}

	public void setOrg(Organization org) {
		if (org != null) {
			this.__validate_client_context__(org.getClientId());
		}
		this.org = org;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		if (currency != null) {
			this.__validate_client_context__(currency.getClientId());
		}
		this.currency = currency;
	}

	public AccJournal getJournal() {
		return this.journal;
	}

	public void setJournal(AccJournal journal) {
		if (journal != null) {
			this.__validate_client_context__(journal.getClientId());
		}
		this.journal = journal;
	}

	public Collection<FinancialAccountMethod> getMethods() {
		return this.methods;
	}

	public void setMethods(Collection<FinancialAccountMethod> methods) {
		this.methods = methods;
	}

	public void addToMethods(FinancialAccountMethod e) {
		if (this.methods == null) {
			this.methods = new ArrayList<FinancialAccountMethod>();
		}
		e.setFinancialAccount(this);
		this.methods.add(e);
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
