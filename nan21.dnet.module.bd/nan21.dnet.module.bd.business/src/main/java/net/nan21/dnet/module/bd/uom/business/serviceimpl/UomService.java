/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.uom.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

/**
 * Repository functionality for {@link Uom} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class UomService extends AbstractEntityService<Uom>
		implements
			IUomService {

	public UomService() {
		super();
	}

	public UomService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Uom> getEntityClass() {
		return Uom.class;
	}

	/**
	 * Find by unique key
	 */
	public Uom findByCode(String code) {
		return (Uom) this.getEntityManager()
				.createNamedQuery(Uom.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Uom findByName(String name) {
		return (Uom) this.getEntityManager()
				.createNamedQuery(Uom.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: type
	 */
	public List<Uom> findByType(UomType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Uom> findByTypeId(Long typeId) {
		return (List<Uom>) this
				.getEntityManager()
				.createQuery(
						"select e from Uom e where e.clientId = :pClientId and e.type.id = :pTypeId",
						Uom.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}
}
