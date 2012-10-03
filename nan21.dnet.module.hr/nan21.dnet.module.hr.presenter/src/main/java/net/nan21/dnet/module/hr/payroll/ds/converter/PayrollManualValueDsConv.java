/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElementValue;
import net.nan21.dnet.module.hr.payroll.ds.model.PayrollManualValueDs;

public class PayrollManualValueDsConv extends AbstractDsConverter<PayrollManualValueDs, PayrollElementValue> 
		implements IDsConverter<PayrollManualValueDs, PayrollElementValue> {
    
    @Override
    protected void modelToEntityReferences(PayrollManualValueDs ds, PayrollElementValue e, boolean isInsert) throws Exception {
    }
}
