/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.standards.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

@Ds(entity = ClassificationItem.class, sort = {@SortField(field = ClassificationItemDs.f_name)})
@RefLookups({@RefLookup(refId = ClassificationItemDs.f_classSystemId, namedQuery = ClassificationSystem.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ClassificationItemDs.f_classSystem)})})
public class ClassificationItemDs
		extends
			AbstractTypeWithCodeDs<ClassificationItem> {

	public static final String f_classSystemId = "classSystemId";
	public static final String f_classSystem = "classSystem";

	@DsField(join = "left", path = "classSystem.id")
	private Long classSystemId;

	@DsField(join = "left", path = "classSystem.code")
	private String classSystem;

	public ClassificationItemDs() {
		super();
	}

	public ClassificationItemDs(ClassificationItem e) {
		super(e);
	}

	public Long getClassSystemId() {
		return this.classSystemId;
	}

	public void setClassSystemId(Long classSystemId) {
		this.classSystemId = classSystemId;
	}

	public String getClassSystem() {
		return this.classSystem;
	}

	public void setClassSystem(String classSystem) {
		this.classSystem = classSystem;
	}
}
