/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.asgn;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractAsgnModel;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;

@Ds(entity=MenuItem.class, sort={@SortField(field=RoleMenuItemsAsgn.fNAME)})
public class RoleMenuItemsAsgn extends AbstractAsgnModel<MenuItem> {
	
	public static final String fID = "id";
	public static final String fNAME = "name";
	public static final String fTITLE = "title";
	
	@DsField(path="id")
	private Long  id;
	
	@DsField(path="name")
	private String  name;
	
	@DsField(path="title")
	private String  title;

	public RoleMenuItemsAsgn() {
	}

	public RoleMenuItemsAsgn(MenuItem e) {
		super();
		this.id = e.getId();
		this.name = e.getName();
		this.title = e.getTitle();
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
