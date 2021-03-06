package net.nan21.dnet.module.ad._presenterdelegates.impex;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportSort;
import net.nan21.dnet.module.ad.impex.ds.model.CsvExportDs;
import net.nan21.dnet.module.ad.impex.ds.model.CsvExportDsParam;

public class ImpexUtilPD extends AbstractPresenterBaseService {

	public void cloneCsvExport(CsvExportDs ds, CsvExportDsParam params)
			throws Exception {

		ICsvExportService srv = (ICsvExportService) this
				.findEntityService(CsvExport.class);
		CsvExport source = srv
				.getEntityManager()
				.createQuery(
						"  select e from " + CsvExport.class.getSimpleName()
								+ " e where e.id = :id   ", CsvExport.class)
				.setParameter("id", ds.getId()).getSingleResult();

		CsvExport target = new CsvExport();
		target.setDataSource(source.getDataSource());
		target.setName(params.getCloneName());

		if (source.getFields() != null) {
			for (CsvExportField s : source.getFields()) {
				CsvExportField t = new CsvExportField();
				t.setCsvExport(target);
				t.setSequenceNo(s.getSequenceNo());
				t.setDsField(s.getDsField());
				t.setAlias(s.getAlias());
				t.setActive(s.getActive());
				target.addToFields(t);
			}
		}

		if (source.getSorts() != null) {
			for (CsvExportSort s : source.getSorts()) {
				CsvExportSort t = new CsvExportSort();
				t.setCsvExport(s.getCsvExport());
				t.setSequenceNo(s.getSequenceNo());
				t.setDsField(s.getDsField());
				t.setDescend(s.getDescend());
				target.addToSorts(t);
			}
		}

		List<CsvExport> list = new ArrayList<CsvExport>();
		list.add(target);
		srv.insert(list);
	}
}
