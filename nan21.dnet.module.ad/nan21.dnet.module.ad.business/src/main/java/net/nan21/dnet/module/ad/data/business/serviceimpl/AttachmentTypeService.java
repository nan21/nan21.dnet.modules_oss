/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.data.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentTypeService;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;


public class AttachmentTypeService extends AbstractEntityService<AttachmentType>
		implements IAttachmentTypeService {
 
	public AttachmentTypeService() {
		super();
	}

	public AttachmentTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<AttachmentType> getEntityClass() {
		return AttachmentType.class;
	}
	
	public AttachmentType findByName(String name) {		 
		return (AttachmentType) this.em
			.createNamedQuery(AttachmentType.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
