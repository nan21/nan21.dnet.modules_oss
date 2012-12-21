/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.md.bp.domain.entity.BpClassification;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

@Ds(entity = BpClassification.class)
@RefLookups({
		@RefLookup(refId = BpClassificationDs.f_businessPartnerId, namedQuery = BusinessPartner.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = BpClassificationDs.f_businessPartner)}),
		@RefLookup(refId = BpClassificationDs.f_classificationSystemId, namedQuery = ClassificationSystem.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = BpClassificationDs.f_classificationSystem)}),
		@RefLookup(refId = BpClassificationDs.f_classificationId, namedQuery = ClassificationItem.NQ_FIND_BY_SYSCODE_PRIMITIVE, params = {
				@Param(name = "pClassSystemId", field = BpClassificationDs.f_classificationSystemId),
				@Param(name = "pCode", field = BpClassificationDs.f_classificationCode)})})
public class BpClassificationDs extends AbstractAuditableDs<BpClassification> {

	public static final String f_businessPartnerId = "businessPartnerId";
	public static final String f_businessPartner = "businessPartner";
	public static final String f_businessPartnerBO = "businessPartnerBO";
	public static final String f_classificationSystemId = "classificationSystemId";
	public static final String f_classificationSystem = "classificationSystem";
	public static final String f_classificationId = "classificationId";
	public static final String f_classificationCode = "classificationCode";
	public static final String f_classificationName = "classificationName";

	@DsField(join = "left", path = "bp.id")
	private Long businessPartnerId;

	@DsField(join = "left", path = "bp.code")
	private String businessPartner;

	@DsField(join = "left", fetch = false, path = "bp.businessObject")
	private String businessPartnerBO;

	@DsField(join = "left", path = "classSystem.id")
	private Long classificationSystemId;

	@DsField(join = "left", path = "classSystem.code")
	private String classificationSystem;

	@DsField(join = "left", path = "classCode.id")
	private Long classificationId;

	@DsField(join = "left", path = "classCode.code")
	private String classificationCode;

	@DsField(join = "left", path = "classCode.name")
	private String classificationName;

	public BpClassificationDs() {
		super();
	}

	public BpClassificationDs(BpClassification e) {
		super(e);
	}

	public Long getBusinessPartnerId() {
		return this.businessPartnerId;
	}

	public void setBusinessPartnerId(Long businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}

	public String getBusinessPartner() {
		return this.businessPartner;
	}

	public void setBusinessPartner(String businessPartner) {
		this.businessPartner = businessPartner;
	}

	public String getBusinessPartnerBO() {
		return this.businessPartnerBO;
	}

	public void setBusinessPartnerBO(String businessPartnerBO) {
		this.businessPartnerBO = businessPartnerBO;
	}

	public Long getClassificationSystemId() {
		return this.classificationSystemId;
	}

	public void setClassificationSystemId(Long classificationSystemId) {
		this.classificationSystemId = classificationSystemId;
	}

	public String getClassificationSystem() {
		return this.classificationSystem;
	}

	public void setClassificationSystem(String classificationSystem) {
		this.classificationSystem = classificationSystem;
	}

	public Long getClassificationId() {
		return this.classificationId;
	}

	public void setClassificationId(Long classificationId) {
		this.classificationId = classificationId;
	}

	public String getClassificationCode() {
		return this.classificationCode;
	}

	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
	}

	public String getClassificationName() {
		return this.classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}
}
