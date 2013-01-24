/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDateFormat;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

/**
 * Interface to expose business functions specific for {@link User} domain
 * entity.
 */
public interface IUserService extends IEntityService<User> {

	public void doChangePassword(Long userId, String newPassword)
			throws BusinessException;

	/**
	 * Find by unique key
	 */
	public User findByCode(String code);

	/**
	 * Find by reference: dateFormat
	 */
	public List<User> findByDateFormat(SysDateFormat dateFormat);

	/**
	 * Find by ID of reference: dateFormat.id
	 */
	public List<User> findByDateFormatId(Long dateFormatId);

	/**
	 * Find by reference: accountType
	 */
	public List<User> findByAccountType(UserType accountType);

	/**
	 * Find by ID of reference: accountType.id
	 */
	public List<User> findByAccountTypeId(Long accountTypeId);

	/**
	 * Find by reference: roles
	 */
	public List<User> findByRoles(Role roles);

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<User> findByRolesId(Long rolesId);

	/**
	 * Find by reference: groups
	 */
	public List<User> findByGroups(UserGroup groups);

	/**
	 * Find by ID of reference: groups.id
	 */
	public List<User> findByGroupsId(Long groupsId);
}
