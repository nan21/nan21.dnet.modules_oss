/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;

@Ds(entity = MenuItem.class, sort = {@SortField(field = MenuItemDs.f_name)})
@RefLookups({
		@RefLookup(refId = MenuItemDs.f_menuItemId, namedQuery = MenuItem.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = MenuItemDs.f_menuItem)}),
		@RefLookup(refId = MenuItemDs.f_menuId, namedQuery = Menu.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = MenuItemDs.f_menu)})})
public class MenuItemDs extends AbstractTypeDs<MenuItem> {

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_menuItemId = "menuItemId";
	public static final String f_menuItem = "menuItem";
	public static final String f_menuId = "menuId";
	public static final String f_menu = "menu";
	public static final String f_title = "title";
	public static final String f_frame = "frame";
	public static final String f_bundle = "bundle";
	public static final String f_iconUrl = "iconUrl";
	public static final String f_separatorBefore = "separatorBefore";
	public static final String f_separatorAfter = "separatorAfter";

	@DsField
	private Integer sequenceNo;

	@DsField(join = "left", path = "menuItem.id")
	private Long menuItemId;

	@DsField(join = "left", path = "menuItem.name")
	private String menuItem;

	@DsField(join = "left", path = "menu.id")
	private Long menuId;

	@DsField(join = "left", path = "menu.name")
	private String menu;

	@DsField
	private String title;

	@DsField
	private String frame;

	@DsField
	private String bundle;

	@DsField
	private String iconUrl;

	@DsField
	private Boolean separatorBefore;

	@DsField
	private Boolean separatorAfter;

	public MenuItemDs() {
		super();
	}

	public MenuItemDs(MenuItem e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public Long getMenuItemId() {
		return this.menuItemId;
	}

	public void setMenuItemId(Long menuItemId) {
		this.menuItemId = menuItemId;
	}

	public String getMenuItem() {
		return this.menuItem;
	}

	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}

	public Long getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenu() {
		return this.menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFrame() {
		return this.frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getBundle() {
		return this.bundle;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}

	public String getIconUrl() {
		return this.iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Boolean getSeparatorBefore() {
		return this.separatorBefore;
	}

	public void setSeparatorBefore(Boolean separatorBefore) {
		this.separatorBefore = separatorBefore;
	}

	public Boolean getSeparatorAfter() {
		return this.separatorAfter;
	}

	public void setSeparatorAfter(Boolean separatorAfter) {
		this.separatorAfter = separatorAfter;
	}
}
