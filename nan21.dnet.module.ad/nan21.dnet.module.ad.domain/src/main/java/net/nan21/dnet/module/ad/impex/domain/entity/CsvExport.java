/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({@NamedQuery(name = CsvExport.NQ_FIND_BY_NAME, query = "SELECT e FROM CsvExport e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = CsvExport.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = CsvExport.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class CsvExport extends AbstractType {

	public static final String TABLE_NAME = "AD_CSV_EXP";
	public static final String SEQUENCE_NAME = "AD_CSV_EXP_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "CsvExport.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "DATASOURCE", nullable = false, length = 255)
	@NotBlank
	private String dataSource;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = CsvExportField.class, mappedBy = "csvExport", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<CsvExportField> fields;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = CsvExportSort.class, mappedBy = "csvExport", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<CsvExportSort> sorts;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public Collection<CsvExportField> getFields() {
		return this.fields;
	}

	public void setFields(Collection<CsvExportField> fields) {
		this.fields = fields;
	}

	public void addToFields(CsvExportField e) {
		if (this.fields == null) {
			this.fields = new ArrayList<CsvExportField>();
		}
		e.setCsvExport(this);
		this.fields.add(e);
	}

	public Collection<CsvExportSort> getSorts() {
		return this.sorts;
	}

	public void setSorts(Collection<CsvExportSort> sorts) {
		this.sorts = sorts;
	}

	public void addToSorts(CsvExportSort e) {
		if (this.sorts == null) {
			this.sorts = new ArrayList<CsvExportSort>();
		}
		e.setCsvExport(this);
		this.sorts.add(e);
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
