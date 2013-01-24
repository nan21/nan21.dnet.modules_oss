/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysFrameExtension;

@Ds(entity = SysFrameExtension.class)
public class SysFrameExtensionDs extends AbstractAuditableDs<SysFrameExtension> {

	public static final String f_frameFQN = "frameFQN";
	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_fileLocation = "fileLocation";
	public static final String f_relativePath = "relativePath";
	public static final String f_active = "active";
	public static final String f_description = "description";

	@DsField
	private String frameFQN;

	@DsField
	private Integer sequenceNo;

	@DsField
	private String fileLocation;

	@DsField
	private Boolean relativePath;

	@DsField
	private Boolean active;

	@DsField
	private String description;

	public SysFrameExtensionDs() {
		super();
	}

	public SysFrameExtensionDs(SysFrameExtension e) {
		super(e);
	}

	public String getFrameFQN() {
		return this.frameFQN;
	}

	public void setFrameFQN(String frameFQN) {
		this.frameFQN = frameFQN;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getFileLocation() {
		return this.fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public Boolean getRelativePath() {
		return this.relativePath;
	}

	public void setRelativePath(Boolean relativePath) {
		this.relativePath = relativePath;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
