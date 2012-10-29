package net.nan21.dnet.module.md.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.nan21.dnet.core.api.IProductInfo;
import net.nan21.dnet.core.api.ISystemConfig;
import net.nan21.dnet.core.api.session.Params;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.api.session.User;
import net.nan21.dnet.core.api.session.UserPreferences;
import net.nan21.dnet.core.presenter.service.ServiceLocator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AbstractWebController implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	/**
	 * System configuration. May be null, use the getter.
	 */
	private ISystemConfig systemConfig;

	/**
	 * Product information to be displayed on client.
	 */
	protected IProductInfo productInfo;
	/**
	 * Presenter service locator. May be null, use the getter.
	 */
	private ServiceLocator serviceLocator;

	final static Logger logger = LoggerFactory
			.getLogger(AbstractWebController.class);

	protected void prepareRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String username = "Guest";
		String displayName = "Guest";

		UserPreferences preferences = null;

		boolean accountExpired = false;
		boolean accountLocked = false;
		boolean credentialsExpired = false;
		boolean enabled = true;

		String clientCode = this.getSystemConfig().getPortalClientCode();
		Long clientId = Long.parseLong(this.getSystemConfig().getPortalClientId());

		String employeeCode = "xxx";
		Long employeeId = 0L;

		User user;
		Params params;
		try {

			user = new User(username, displayName, "", accountExpired,
					accountLocked, credentialsExpired, enabled, clientCode,
					clientId, preferences, employeeCode, employeeId, null, null);
			params = new Params();

		} catch (ClassCastException e) {
			throw new Exception("<b>Session expired.</b>"
					+ "<br> Logout from application and login again.");
		}
		Session.user.set(user);
		Session.params.set(params);

	}

	protected void finishRequest() {
		Session.user.set(null);
		Session.params.set(null);
	}

	/* ================= GETTERS - SETTERS ================== */

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	/**
	 * Get system configuration object. If it is null attempts to retrieve it
	 * from Spring context.
	 * 
	 * @return
	 */
	public ISystemConfig getSystemConfig() {
		if (this.systemConfig == null) {
			this.systemConfig = this.getApplicationContext().getBean(
					ISystemConfig.class);
		}
		return systemConfig;
	}

	/**
	 * Set system configuration object
	 * 
	 * @param systemConfig
	 */
	public void setSystemConfig(ISystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

	/**
	 * Get product info object. If it is null attempts to retrieve it from
	 * Spring context.
	 * 
	 * @return
	 */
	public IProductInfo getProductInfo() {
		if (this.productInfo == null) {
			this.productInfo = this.getApplicationContext().getBean(
					IProductInfo.class);
		}
		return productInfo;
	}

	public void setProductInfo(IProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	/**
	 * Get presenter service locator. If it is null attempts to retrieve it from
	 * Spring context.
	 * 
	 * @return
	 */
	public ServiceLocator getServiceLocator() {
		if (this.serviceLocator == null) {
			this.serviceLocator = this.getApplicationContext().getBean(
					ServiceLocator.class);
		}
		return serviceLocator;
	}

	/**
	 * Set presenter service locator.
	 * 
	 * @param serviceLocator
	 */
	public void setServiceLocator(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

}
