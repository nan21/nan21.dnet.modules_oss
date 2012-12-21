/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = DbChangeLog.TABLE_NAME)
@ReadOnly
@Cache(type = CacheType.NONE)
@Customizer(DefaultEventHandler.class)
public class DbChangeLog implements Serializable {

	public static final String TABLE_NAME = "DATABASECHANGELOG";
	public static final String SEQUENCE_NAME = "DATABASECHANGELOG_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "ID", nullable = false, length = 255)
	@NotBlank
	@Id
	private String txid;

	@Column(name = "AUTHOR", length = 255)
	private String author;

	@Column(name = "FILENAME", length = 255)
	private String filename;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATEEXECUTED")
	private Date dateExecuted;

	@Column(name = "ORDEREXECUTED")
	private Integer orderExecuted;

	@Column(name = "MD5SUM", length = 255)
	private String md5sum;

	@Column(name = "DESCRIPTION", length = 400)
	private String description;

	@Column(name = "COMMENTS", length = 400)
	private String comments;

	@Column(name = "TAG", length = 255)
	private String tag;

	@Column(name = "LIQUIBASE", length = 255)
	private String liquibase;

	@Transient
	public String getId() {
		return this.txid + "-" + this.author + "-" + this.filename;
	}

	public void setId(String id) {
	}

	public String getTxid() {
		return this.txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getDateExecuted() {
		return this.dateExecuted;
	}

	public void setDateExecuted(Date dateExecuted) {
		this.dateExecuted = dateExecuted;
	}

	public Integer getOrderExecuted() {
		return this.orderExecuted;
	}

	public void setOrderExecuted(Integer orderExecuted) {
		this.orderExecuted = orderExecuted;
	}

	public String getMd5sum() {
		return this.md5sum;
	}

	public void setMd5sum(String md5sum) {
		this.md5sum = md5sum;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLiquibase() {
		return this.liquibase;
	}

	public void setLiquibase(String liquibase) {
		this.liquibase = liquibase;
	}

	public void aboutToInsert(DescriptorEvent event) {

	}

	public void aboutToUpdate(DescriptorEvent event) {
	}
}
