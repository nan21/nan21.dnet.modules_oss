/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroupAcct;

public interface IProductAccountGroupService extends IEntityService<ProductAccountGroup> {
	
	public ProductAccountGroup findByCode(String code);
	
	public ProductAccountGroup findByName(String name);
	
	public List<ProductAccountGroup> findByAccounts(ProductAccountGroupAcct accounts);
	
	public List<ProductAccountGroup> findByAccountsId(Long accountsId);
	
}
