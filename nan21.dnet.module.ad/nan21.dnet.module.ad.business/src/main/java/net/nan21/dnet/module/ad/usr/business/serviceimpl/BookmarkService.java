/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IBookmarkService;
import net.nan21.dnet.module.ad.usr.domain.entity.Bookmark;

/**
 * Repository functionality for {@link Bookmark} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BookmarkService extends AbstractEntityService<Bookmark>
		implements
			IBookmarkService {

	public BookmarkService() {
		super();
	}

	public BookmarkService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Bookmark> getEntityClass() {
		return Bookmark.class;
	}

	/**
	 * Find by unique key
	 */
	public Bookmark findByName(String owner, String name) {
		return (Bookmark) this.getEntityManager()
				.createNamedQuery(Bookmark.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOwner", owner).setParameter("pName", name)
				.getSingleResult();
	}

	/**
	 * Find by reference: parent
	 */
	public List<Bookmark> findByParent(Bookmark parent) {
		return this.findByParentId(parent.getId());
	}

	/**
	 * Find by ID of reference: parent.id
	 */
	public List<Bookmark> findByParentId(Long parentId) {
		return (List<Bookmark>) this
				.getEntityManager()
				.createQuery(
						"select e from Bookmark e where e.clientId = :pClientId and e.parent.id = :pParentId",
						Bookmark.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pParentId", parentId).getResultList();
	}
}
