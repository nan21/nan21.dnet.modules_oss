/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.data.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.data.business.service.INoteService;
import net.nan21.dnet.module.ad.data.domain.entity.Note;

/**
 * Repository functionality for {@link Note} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class NoteService extends AbstractEntityService<Note>
		implements
			INoteService {

	public NoteService() {
		super();
	}

	public NoteService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<Note> getEntityClass() {
		return Note.class;
	}
}
