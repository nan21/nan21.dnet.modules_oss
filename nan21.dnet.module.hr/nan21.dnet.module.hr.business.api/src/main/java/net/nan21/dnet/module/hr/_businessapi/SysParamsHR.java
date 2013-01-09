package net.nan21.dnet.module.hr._businessapi;

import java.util.ArrayList;
import java.util.Collection;

import net.nan21.dnet.core.api.descriptor.ISysParamDefinitions;
import net.nan21.dnet.core.api.descriptor.SysParamDefinition;

public class SysParamsHR implements ISysParamDefinitions {

	public static final String HR_EMPL_PHOTO_BASEURL = "HR_EMPL_PHOTO_BASEURL";
	public static final String HR_EMPL_PHOTO_BASEURL_DEFVAL = "http://dnet.nan21.net/static-demo-resources/HR/employee";

	public static final String HR_EMPL_PHOTO_EXT = "HR_EMPL_PHOTO_EXT";
	public static final String HR_EMPL_PHOTO_EXT_DEFVAL = "jpg";

	public static final String HR_EMPL_PHOTO_SUFFIX = "HR_EMPL_PHOTO_SUFFIX";
	public static final String HR_EMPL_PHOTO_SUFFIX_DEFVAL = "-small";

	private Collection<SysParamDefinition> params;

	@Override
	public Collection<SysParamDefinition> getSysParamDefinitions()
			throws Exception {
		if (this.params == null) {
			this.initParams();
		}
		return params;
	}

	synchronized private void initParams() {
		if (this.params == null) {

			this.params = new ArrayList<SysParamDefinition>();

			params.add(new SysParamDefinition(HR_EMPL_PHOTO_BASEURL,
					"Employee photo base url", "",
					SysParamDefinition.TYPE_STRING,
					HR_EMPL_PHOTO_BASEURL_DEFVAL, null));

			params.add(new SysParamDefinition(HR_EMPL_PHOTO_EXT,
					"Employee photo default extension", "",
					SysParamDefinition.TYPE_STRING, HR_EMPL_PHOTO_EXT_DEFVAL,
					null));

			params.add(new SysParamDefinition(HR_EMPL_PHOTO_SUFFIX,
					"Employee photo default suffix", "",
					SysParamDefinition.TYPE_STRING,
					HR_EMPL_PHOTO_SUFFIX_DEFVAL, null));

		}
	}
}
