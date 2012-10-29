/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.data.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentService;
import net.nan21.dnet.module.ad.data.domain.entity.Attachment;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;


public class AttachmentService extends AbstractEntityService<Attachment>
		implements IAttachmentService {
 
	public AttachmentService() {
		super();
	}

	public AttachmentService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<Attachment> getEntityClass() {
		return Attachment.class;
	}
	
	public List<Attachment> findByType(AttachmentType type) {
		return this.findByTypeId(type.getId()); 
	}
	
	public List<Attachment> findByTypeId(Long typeId) {
		return (List<Attachment>) this.em
			.createQuery("select e from Attachment e where e.clientId = :pClientId and e.type.id = :pTypeId", Attachment.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pTypeId", typeId)			 	
			.getResultList(); 
	}
}
