package net.nan21.dnet.module.ad._presenterdelegates.impex;

import java.util.List;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.ad.impex.business.service.IImportMapItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapDs;

public class ImportFromMapPD extends AbstractPresenterBaseService {

	public void execute(ImportMapDs ds) throws Exception {

		IImportMapItemService srv = (IImportMapItemService) this
				.findEntityService(ImportMapItem.class);
		List<ImportMapItem> items = srv
				.getEntityManager()
				.createQuery(
						"select e from "
								+ ImportMapItem.class.getSimpleName()
								+ " e where e.active = true and e.importMap.id = :pImportMapId order by e.sequenceNo ",
						ImportMapItem.class)
				.setParameter("pImportMapId", ds.getId()).getResultList();

		for (ImportMapItem item : items) {

			String fileName = ImportFromMapItemPD.resolveFileName(item);
			String dsName = item.getDataSourceName() + "Ds";

			if (item.getUkFieldName() != null
					&& !item.getUkFieldName().equals("")) {
				this.findDsService(dsName).doImport(fileName,
						item.getUkFieldName(), 0);
			} else {
				this.findDsService(dsName).doImport(fileName);
			}
		}

	}

}
