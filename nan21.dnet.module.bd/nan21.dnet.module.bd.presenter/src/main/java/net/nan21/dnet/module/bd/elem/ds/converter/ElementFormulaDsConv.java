/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.elem.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.elem.business.service.IEngineService;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementFormula;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;
import net.nan21.dnet.module.bd.elem.ds.model.ElementFormulaDs;

public class ElementFormulaDsConv
		extends
			AbstractDsConverter<ElementFormulaDs, ElementFormula>
		implements
			IDsConverter<ElementFormulaDs, ElementFormula> {

	@Override
	protected void modelToEntityReferences(ElementFormulaDs ds,
			ElementFormula e, boolean isInsert) throws Exception {

		if (ds.getEngineId() == null) {
			Engine x = ((IEngineService) findEntityService(Engine.class))
					.findByName(ds.getEngine());
			ds.setEngineId(x.getId());
		}
		super.modelToEntityReferences(ds, e, isInsert);
	}
}
