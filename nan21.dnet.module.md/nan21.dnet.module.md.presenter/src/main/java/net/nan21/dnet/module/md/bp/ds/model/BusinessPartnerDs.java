/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.CompanyLegalForm;

@Ds(entity = BusinessPartner.class, sort = {@SortField(field = BusinessPartnerDs.f_name)})
@RefLookups({
		@RefLookup(refId = BusinessPartnerDs.f_countryId, namedQuery = Country.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = BusinessPartnerDs.f_countryCode)}),
		@RefLookup(refId = BusinessPartnerDs.f_legalFormId, namedQuery = CompanyLegalForm.NQ_FIND_BY_NAME_PRIMITIVE, params = {
				@Param(name = "pName", field = BusinessPartnerDs.f_legalForm),
				@Param(name = "pCountryId", field = BusinessPartnerDs.f_countryId)})})
public class BusinessPartnerDs extends AbstractTypeWithCodeDs<BusinessPartner> {

	public static final String f_type = "type";
	public static final String f_businessObject = "businessObject";
	public static final String f_countryId = "countryId";
	public static final String f_countryCode = "countryCode";
	public static final String f_taxPayerNo = "taxPayerNo";
	public static final String f_firstName = "firstName";
	public static final String f_lastName = "lastName";
	public static final String f_middleName = "middleName";
	public static final String f_gender = "gender";
	public static final String f_identityCardNo = "identityCardNo";
	public static final String f_passportNo = "passportNo";
	public static final String f_birthDate = "birthDate";
	public static final String f_companyName = "companyName";
	public static final String f_legalFormId = "legalFormId";
	public static final String f_legalForm = "legalForm";
	public static final String f_registrationNo = "registrationNo";
	public static final String f_registrationDate = "registrationDate";
	public static final String f_className = "className";

	@DsField
	private String type;

	@DsField(fetch = false)
	private String businessObject;

	@DsField(join = "left", path = "country.id")
	private Long countryId;

	@DsField(join = "left", path = "country.code")
	private String countryCode;

	@DsField
	private String taxPayerNo;

	@DsField
	private String firstName;

	@DsField
	private String lastName;

	@DsField
	private String middleName;

	@DsField
	private String gender;

	@DsField
	private String identityCardNo;

	@DsField
	private String passportNo;

	@DsField
	private Date birthDate;

	@DsField
	private String companyName;

	@DsField(join = "left", path = "legalForm.id")
	private Long legalFormId;

	@DsField(join = "left", path = "legalForm.name")
	private String legalForm;

	@DsField
	private String registrationNo;

	@DsField
	private Date registrationDate;

	@DsField(fetch = false)
	private String className;

	public BusinessPartnerDs() {
		super();
	}

	public BusinessPartnerDs(BusinessPartner e) {
		super(e);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBusinessObject() {
		return this.businessObject;
	}

	public void setBusinessObject(String businessObject) {
		this.businessObject = businessObject;
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getTaxPayerNo() {
		return this.taxPayerNo;
	}

	public void setTaxPayerNo(String taxPayerNo) {
		this.taxPayerNo = taxPayerNo;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdentityCardNo() {
		return this.identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getLegalFormId() {
		return this.legalFormId;
	}

	public void setLegalFormId(Long legalFormId) {
		this.legalFormId = legalFormId;
	}

	public String getLegalForm() {
		return this.legalForm;
	}

	public void setLegalForm(String legalForm) {
		this.legalForm = legalForm;
	}

	public String getRegistrationNo() {
		return this.registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
