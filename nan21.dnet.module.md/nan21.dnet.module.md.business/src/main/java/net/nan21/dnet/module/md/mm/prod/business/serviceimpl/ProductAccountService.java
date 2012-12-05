/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;

/**
 * Repository functionality for {@link ProductAccount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductAccountService
		extends
			AbstractEntityService<ProductAccount>
		implements
			IProductAccountService {

	public ProductAccountService() {
		super();
	}

	public ProductAccountService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProductAccount> getEntityClass() {
		return ProductAccount.class;
	}

	/**
	 * Find by unique key
	 */
	public ProductAccount findByProd_org(Product product, Organization org) {
		return (ProductAccount) this.getEntityManager()
				.createNamedQuery(ProductAccount.NQ_FIND_BY_PROD_ORG)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProduct", product).setParameter("pOrg", org)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ProductAccount findByProd_org(Long productId, Long orgId) {
		return (ProductAccount) this.getEntityManager()
				.createNamedQuery(ProductAccount.NQ_FIND_BY_PROD_ORG_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId)
				.setParameter("pOrgId", orgId).getSingleResult();
	}

	/**
	 * Find by reference: org
	 */
	public List<ProductAccount> findByOrg(Organization org) {
		return this.findByOrgId(org.getId());
	}

	/**
	 * Find by ID of reference: org.id
	 */
	public List<ProductAccount> findByOrgId(Long orgId) {
		return (List<ProductAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductAccount e where e.clientId = :pClientId and e.org.id = :pOrgId",
						ProductAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrgId", orgId).getResultList();
	}

	/**
	 * Find by reference: group
	 */
	public List<ProductAccount> findByGroup(ProductAccountGroup group) {
		return this.findByGroupId(group.getId());
	}

	/**
	 * Find by ID of reference: group.id
	 */
	public List<ProductAccount> findByGroupId(Long groupId) {
		return (List<ProductAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductAccount e where e.clientId = :pClientId and e.group.id = :pGroupId",
						ProductAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pGroupId", groupId).getResultList();
	}

	/**
	 * Find by reference: product
	 */
	public List<ProductAccount> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}

	/**
	 * Find by ID of reference: product.id
	 */
	public List<ProductAccount> findByProductId(Long productId) {
		return (List<ProductAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductAccount e where e.clientId = :pClientId and e.product.id = :pProductId",
						ProductAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId).getResultList();
	}
}
