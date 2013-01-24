/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.data.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.data.domain.entity.Attachment;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;

/**
 * Repository functionality for {@link Attachment} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AttachmentService extends AbstractEntityService<Attachment> {

	public AttachmentService() {
		super();
	}

	public AttachmentService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Attachment> getEntityClass() {
		return Attachment.class;
	}

	/**
	 * Find by reference: type
	 */
	public List<Attachment> findByType(AttachmentType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Attachment> findByTypeId(Long typeId) {
		return (List<Attachment>) this
				.getEntityManager()
				.createQuery(
						"select e from Attachment e where e.clientId = :pClientId and e.type.id = :pTypeId",
						Attachment.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}
}
