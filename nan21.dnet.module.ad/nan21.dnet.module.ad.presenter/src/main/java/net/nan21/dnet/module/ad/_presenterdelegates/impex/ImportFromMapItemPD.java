package net.nan21.dnet.module.ad._presenterdelegates.impex;

import java.io.File;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.ad.impex.business.service.IImportMapItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDsParam;

public class ImportFromMapItemPD extends AbstractPresenterBaseService {

	public static String resolveFileName(ImportMapItem item) {
		
		String fileName = item.getFileName();

		if (fileName == null || fileName.equals("")) {
			fileName = item.getDataSourceName() + ".csv";
		}
		if (!(new File(fileName)).isAbsolute()) {
			String _path = item.getPath();
			if (_path != null && !_path.equals("")) {
				fileName = _path + File.separator + fileName;
			}
			if (!(new File(fileName)).isAbsolute()) {
				_path = item.getImportMap().getPath();
				if (_path != null && !_path.equals("")) {
					fileName = _path + File.separator + fileName;
				}
				if (!(new File(fileName)).isAbsolute()) {
					fileName = Session.params.get().getDefaultImportPath()
							+ File.separator + fileName;
				}
			}
		}
		return fileName;
	}

	public void execute(ImportMapItemDs ds) throws Exception {
		IImportMapItemService srv = (IImportMapItemService) this
				.findEntityService(ImportMapItem.class);

		ImportMapItem item = srv.getEntityManager().find(ImportMapItem.class,
				ds.getId());

		String fileName = resolveFileName(item);
		String dsName = item.getDataSourceName() + "Ds";

		if (ds.getUkFieldName() != null && !ds.getUkFieldName().equals("")) {
			this.findDsService(dsName).doImport(fileName, ds.getUkFieldName(),
					0);
		} else {
			this.findDsService(dsName).doImport(fileName);
		}
	}

	public void importFile(ImportMapItemDs filter, ImportMapItemDsParam params)
			throws Exception {
		String fileName = params.getImportFileLocation();
		String dsName = params.getImportDataSource() + "Ds";

		if (params.getImportUkFieldName() != null
				&& !params.getImportUkFieldName().equals("")) {
			this.findDsService(dsName).doImport(fileName,
					params.getImportUkFieldName(), 0);
		} else {
			this.findDsService(dsName).doImport(fileName);
		}

	}
}
