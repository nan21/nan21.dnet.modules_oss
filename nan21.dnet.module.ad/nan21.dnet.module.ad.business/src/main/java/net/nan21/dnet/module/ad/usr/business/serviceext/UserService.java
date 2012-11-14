/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.serviceext;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.ad.usr.business.service.IUserService;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

/**
 * Business extensions specific for {@link User} domain entity.
 * 
 */
public class UserService extends
		net.nan21.dnet.module.ad.usr.business.serviceimpl.UserService implements
		IUserService {

	@Override
	public void doChangePassword(Long userId, String newPassword)
			throws BusinessException {
		User u = this.findById(userId);
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new BusinessException(
					"Cannot change password. No `MD5` algorithm found.");
		}
		messageDigest.update(newPassword.getBytes(), 0, newPassword.length());
		String hashedPass = new BigInteger(1, messageDigest.digest())
				.toString(16);
		if (hashedPass.length() < 32) {
			hashedPass = "0" + hashedPass;
		}
		u.setPassword(hashedPass);
		this.em.merge(u);

	}

}
