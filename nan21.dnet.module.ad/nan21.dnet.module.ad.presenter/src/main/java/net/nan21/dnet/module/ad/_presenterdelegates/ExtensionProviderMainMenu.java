package net.nan21.dnet.module.ad._presenterdelegates;

import java.util.List;

import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.api.ui.extjs.IExtensionContentProvider;
import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.ad.usr.ds.filter.MenuRtLovDsFilter;
import net.nan21.dnet.module.ad.usr.ds.model.MenuRtLovDs;

public class ExtensionProviderMainMenu extends AbstractPresenterBaseService
		implements IExtensionContentProvider {

	@Override
	public String getContent(String targetName) throws Exception {
		StringBuffer sb = new StringBuffer();
		this.addNavigationTreeMenus(sb);
		return sb.toString();
	}

	protected void addNavigationTreeMenus(StringBuffer sb) throws Exception {
		IDsService<MenuRtLovDs, MenuRtLovDsFilter, ?> srv = this.findDsService("MenuRtLovDs");
		List<MenuRtLovDs> menus = srv.find(new MenuRtLovDsFilter());
		int i = 0;
		sb.append("Dnet.navigationTreeMenus = [");
		for (MenuRtLovDs menu : menus) {
			if (i > 0) {
				sb.append(",");
			}
			sb.append("{name:\"" + menu.getName() + "\", title:\""
					+ menu.getTitle() + "\"}");
			i++;
		}
		sb.append("];");
	}

}
