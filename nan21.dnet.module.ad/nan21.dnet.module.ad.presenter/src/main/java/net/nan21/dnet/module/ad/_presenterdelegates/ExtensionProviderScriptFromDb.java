package net.nan21.dnet.module.ad._presenterdelegates;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.api.ui.extjs.ExtensionFile;
import net.nan21.dnet.core.api.ui.extjs.IExtensionProvider;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.system.ds.filter.SysFrameExtensionDsFilter;
import net.nan21.dnet.module.ad.system.ds.model.SysFrameExtensionDs;

public class ExtensionProviderScriptFromDb extends AbstractDsDelegate
		implements IExtensionProvider {

	@Override
	public List<ExtensionFile> getFiles(String targetFrame) throws Exception {

		List<ExtensionFile> files = new ArrayList<ExtensionFile>();

		IDsService<SysFrameExtensionDs, SysFrameExtensionDsFilter, ?> srv = this
				.findDsService("SysFrameExtensionDs");
		SysFrameExtensionDsFilter filter = new SysFrameExtensionDsFilter();
		filter.setFrameFQN(targetFrame);
		filter.setActive(true);
		List<SysFrameExtensionDs> extensions = srv.find(filter);

		for (SysFrameExtensionDs extension : extensions) {
			files.add(new ExtensionFile(extension.getFileLocation(), extension
					.getRelativePath()));
		}

		return files;

	}

}
