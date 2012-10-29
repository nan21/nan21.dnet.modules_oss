/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtxParam;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;


public class SysJobCtxParamService extends AbstractEntityService<SysJobCtxParam>
		{
 
	public SysJobCtxParamService() {
		super();
	}

	public SysJobCtxParamService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SysJobCtxParam> getEntityClass() {
		return SysJobCtxParam.class;
	}
	
	public List<SysJobCtxParam> findByJobCtx(SysJobCtx jobCtx) {
		return this.findByJobCtxId(jobCtx.getId()); 
	}
	
	public List<SysJobCtxParam> findByJobCtxId(Long jobCtxId) {
		return (List<SysJobCtxParam>) this.em
			.createQuery("select e from SysJobCtxParam e where e.clientId = :pClientId and e.jobCtx.id = :pJobCtxId", SysJobCtxParam.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pJobCtxId", jobCtxId)			 	
			.getResultList(); 
	}
	
	public List<SysJobCtxParam> findByJobParam(SysJobParam jobParam) {
		return this.findByJobParamId(jobParam.getId()); 
	}
	
	public List<SysJobCtxParam> findByJobParamId(Long jobParamId) {
		return (List<SysJobCtxParam>) this.em
			.createQuery("select e from SysJobCtxParam e where e.clientId = :pClientId and e.jobParam.id = :pJobParamId", SysJobCtxParam.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pJobParamId", jobParamId)			 	
			.getResultList(); 
	}
}
