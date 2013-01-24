/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Bookmark;

/**
 * Interface to expose business functions specific for {@link Bookmark} domain
 * entity.
 */
public interface IBookmarkService extends IEntityService<Bookmark> {

	/**
	 * Find by unique key
	 */
	public Bookmark findByName(String owner, String name);

	/**
	 * Find by reference: parent
	 */
	public List<Bookmark> findByParent(Bookmark parent);

	/**
	 * Find by ID of reference: parent.id
	 */
	public List<Bookmark> findByParentId(Long parentId);
}
