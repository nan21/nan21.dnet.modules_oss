package net.nan21.dnet.module.md._businessdelegates.tx.fin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccOperation;

public class AccDocToAccOperationBD extends AbstractBusinessDelegate {

	/**
	 * Post the given accounting document to great-ledger.
	 * 
	 * @param doc
	 * @throws BusinessException
	 */
	public void unPost(AccDoc doc) throws BusinessException {
		this.em.createQuery(
				"delete from " + AccOperation.class.getSimpleName() + " t "
						+ " where t.accDoc.id = :accDocId")
				.setParameter("accDocId", doc.getId()).executeUpdate();
		doc.setPosted(false);
		this.em.merge(doc);
	}

	/**
	 * Un-post the given accounting document.
	 * 
	 * @param doc
	 * @throws BusinessException
	 */
	public void post(AccDoc doc) throws BusinessException {
		Collection<AccDocLine> lines = doc.getLines();
		List<AccOperation> ops = new ArrayList<AccOperation>();
		AccDocLine hline = null;
		AccOperation op = null;
		for (AccDocLine line : lines) {

			op = new AccOperation();

			if (line.getCrAccount() != null) {
				op.setCrAccount(line.getCrAccount());
				op.setCrAmount(line.getCrAmount());
				op.setDbAmount(line.getCrAmount());
			} else {
				op.setDbAccount(line.getDbAccount());
				op.setCrAmount(line.getDbAmount());
				op.setDbAmount(line.getDbAmount());
			}

			op.setAccSchema(doc.getAccSchema());
			op.setOrg(doc.getOrg());
			op.setPeriod(doc.getPeriod());
			op.setAccDoc(doc);
			op.setAccDocLine(line);
			op.setEventDate(doc.getDocDate());
			op.setHeaderLine(line.getHeaderLine());

			if (line.getHeaderLine()) {
				hline = line;
			}
			ops.add(op);
		}
		if (hline != null) {
			boolean isDb = false;
			if (hline.getDbAccount() != null) {
				isDb = true;
			}
			for (AccOperation op1 : ops) {
				if (isDb) {
					op1.setDbAccount(hline.getDbAccount());
				} else {
					op1.setCrAccount(hline.getCrAccount());
				}
			}
		} else {
			throw new RuntimeException(
					"Invalid accounting document. No header line defined.");
		}

		this.findEntityService(AccOperation.class).insert(ops);
		doc.setPosted(true);
		this.getEntityManager().merge(doc);
	}
}
