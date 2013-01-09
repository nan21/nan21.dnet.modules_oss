package net.nan21.dnet.module.ad._businessdelegates;

import java.util.Date;
import java.util.List;

import net.nan21.dnet.core.api.ISystemConfig;
import net.nan21.dnet.core.api.setup.IStartupParticipant;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.ad.client.domain.entity.Client;
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;
import net.nan21.dnet.module.ad.system.domain.entity.SysParamValue;

public class Startup_AD extends AbstractBusinessDelegate implements
		IStartupParticipant {

	public void execute() throws Exception {
		ISystemConfig syscfg = this.getSystemConfig();

		List<Client> clients = this
				.getEntityManager()
				.createQuery(
						"select e from " + Client.class.getSimpleName() + " e",
						Client.class).getResultList();

		for (Client client : clients) {
			List<SysParam> params = this
					.getEntityManager()
					.createQuery(
							"select e from " + SysParam.class.getSimpleName()
									+ " e" + " where e.active = true",
							SysParam.class).getResultList();
			for (SysParam param : params) {

				List<SysParamValue> values = this
						.getEntityManager()
						.createQuery(
								"select e from "
										+ SysParamValue.class.getSimpleName()
										+ " e "
										+ " where e.sysParam = :pSysParam and :pDate between e.validFrom and e.validTo order by e.validFrom desc",
								SysParamValue.class)
						.setParameter("pSysParam", param.getCode())
						.setParameter("pDate", new Date()).getResultList();
				if (values.size() >= 1) {
					syscfg.addSysParam(client.getCode(), param.getCode(),
							values.get(0).getValue());
				} else {
					syscfg.addSysParam(client.getCode(), param.getCode(),
							param.getDefaultValue());
				}

			}
		}
	}

}
