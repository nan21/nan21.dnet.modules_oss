/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.uom.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.business.service.IUomTypeService;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

/**
 * Repository functionality for {@link UomType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class UomTypeService extends AbstractEntityService<UomType>
		implements
			IUomTypeService {

	public UomTypeService() {
		super();
	}

	public UomTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<UomType> getEntityClass() {
		return UomType.class;
	}

	/**
	 * Find by unique key
	 */
	public UomType findByName(String name) {
		return (UomType) this.getEntityManager()
				.createNamedQuery(UomType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
