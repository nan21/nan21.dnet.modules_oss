/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.period.business.serviceext;

import java.util.Date;

import javax.persistence.NoResultException;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.period.business.service.IFiscalPeriodService;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;

/**
 * Business extensions specific for {@link FiscalPeriod} domain entity.
 * 
 */
public class FiscalPeriodService
		extends
		net.nan21.dnet.module.md.base.period.business.serviceimpl.FiscalPeriodService
		implements IFiscalPeriodService {

	@Override
	public FiscalPeriod getPostingPeriod(Date date, Organization org)
			throws BusinessException {
		try {
			FiscalPeriod period = (FiscalPeriod) this
					.getEntityManager()
					.createQuery(
							"select e from FiscalPeriod e "
									+ "	where e.clientId = :pClientId "
									+ "	  and :pDate between e.startDate and e.endDate "
									+ "	and e.active = true "
									+ "	and e.posting = true ",
							FiscalPeriod.class)
					.setParameter("pClientId", Session.user.get().getClientId())
					.setParameter("pDate", date).getSingleResult();
			return period;
		} catch (NoResultException e) {
			throw new BusinessException("No open posting period found for `"
					+ date.toString() + "`");
		}

	}

}
