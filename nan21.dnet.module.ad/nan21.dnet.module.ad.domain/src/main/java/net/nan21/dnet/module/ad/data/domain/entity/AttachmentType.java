/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.data.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Product attachment type definition.*/
@NamedQueries({@NamedQuery(name = AttachmentType.NQ_FIND_BY_NAME, query = "SELECT e FROM AttachmentType e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AttachmentType.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = AttachmentType.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class AttachmentType extends AbstractType {

	public static final String TABLE_NAME = "AD_ATCH_TYPE";
	public static final String SEQUENCE_NAME = "AD_ATCH_TYPE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "AttachmentType.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "CATEGORY", nullable = false, length = 8)
	@NotBlank
	private String category;

	@Column(name = "USEINCONTEXT", nullable = false, length = 255)
	@NotBlank
	private String useInContext;

	/** Physical location where attachments of this type should be copied if they are uploaded. */
	@Column(name = "UPLOADPATH", length = 400)
	private String uploadPath;

	/**Base URL to use when the attachment is requested. Is ignored if the attachment specifies an absolute URL*/
	@Column(name = "BASEURL", nullable = false, length = 255)
	@NotBlank
	private String baseUrl;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUseInContext() {
		return this.useInContext;
	}

	public void setUseInContext(String useInContext) {
		this.useInContext = useInContext;
	}

	public String getUploadPath() {
		return this.uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
