/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.IDbChangeLogService;
import net.nan21.dnet.module.ad.system.domain.entity.DbChangeLog;

/**
 * Repository functionality for {@link DbChangeLog} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DbChangeLogService extends AbstractEntityService<DbChangeLog>
		implements
			IDbChangeLogService {

	public DbChangeLogService() {
		super();
	}

	public DbChangeLogService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DbChangeLog> getEntityClass() {
		return DbChangeLog.class;
	}
}
