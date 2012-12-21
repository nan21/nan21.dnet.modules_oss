/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.elem.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.elem.business.service.IEngineService;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementInput;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;
import net.nan21.dnet.module.bd.elem.ds.model.ElementInputDs;

public class ElementInputDsConv
		extends
			AbstractDsConverter<ElementInputDs, ElementInput>
		implements
			IDsConverter<ElementInputDs, ElementInput> {

	@Override
	protected void modelToEntityReferences(ElementInputDs ds, ElementInput e,
			boolean isInsert) throws Exception {

		if (ds.getEngineId() == null) {
			Engine x = ((IEngineService) findEntityService(Engine.class))
					.findByName(ds.getEngine());
			ds.setEngineId(x.getId());
		}
		super.modelToEntityReferences(ds, e, isInsert);
	}
}
