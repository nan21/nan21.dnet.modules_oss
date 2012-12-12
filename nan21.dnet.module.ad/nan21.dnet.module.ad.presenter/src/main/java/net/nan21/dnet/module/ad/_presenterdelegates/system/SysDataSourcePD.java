package net.nan21.dnet.module.ad._presenterdelegates.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.nan21.dnet.core.api.descriptor.IDsDefinition;
import net.nan21.dnet.core.api.descriptor.IDsDefinitions;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.model.DsDefinition;
import net.nan21.dnet.core.presenter.model.FieldDefinition;
import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.ad.system.business.service.ISysDataSourceService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;
import net.nan21.dnet.module.ad.system.ds.model.SysDataSourceDs;

public class SysDataSourcePD extends AbstractPresenterBaseService {

	@SuppressWarnings("unchecked")
	public void synchronizeCatalog(SysDataSourceDs filter) throws Exception {
		List<IDsDefinitions> list = (List<IDsDefinitions>) this
				.getApplicationContext().getBean("osgiDsDefinitions");
		ISysDataSourceService srv = (ISysDataSourceService) this
				.findEntityService(SysDataSource.class);

		List<SysDataSource> result = new ArrayList<SysDataSource>();
		for (IDsDefinitions dsdefs : list) {
			for (IDsDefinition def : dsdefs.getDsDefinitions()) {
				SysDataSource e = new SysDataSource();
				e.setName(def.getName());
				e.setModel(def.getModelClass().getCanonicalName());
				e.setActive(true);
				e.setIsAsgn(def.isAsgn());

				for (FieldDefinition fld : ((DsDefinition) def)
						.getModelFields()) {
					SysDsField f = new SysDsField();
					f.setName(fld.getName());
					f.setActive(true);
					f.setDataType(fld.getClassName());
					e.addToFields(f);
				}

				List<String> serviceMethods = def.getServiceMethods();
				if (serviceMethods != null) {
					for (String sm : serviceMethods) {
						SysDsService sme = new SysDsService();
						sme.setActive(true);
						sme.setDataSource(e);
						sme.setName(sm);
						e.addToServiceMethods(sme);
					}
				}

				result.add(e);
			}
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", Session.user.get().getClientId());

		srv.update("delete from " + SysDsField.class.getSimpleName()
				+ "  where clientId = :clientId", params);
		srv.update("delete from " + SysDsService.class.getSimpleName()
				+ "  where clientId = :clientId", params);
		srv.update("delete from " + SysDataSource.class.getSimpleName()
				+ "  where clientId = :clientId", params);
		srv.insert(result);
	}
}