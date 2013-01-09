package net.nan21.dnet.module.md._businessapi;

import java.util.ArrayList;
import java.util.Collection;

import net.nan21.dnet.core.api.descriptor.ISysParamDefinitions;
import net.nan21.dnet.core.api.descriptor.SysParamDefinition;

public class SysParamsMD implements ISysParamDefinitions {

	public static final String MM_PRODCATEG_ICON_BASEURL = "MM_PRODCATEG_ICON_BASEURL";
	public static final String MM_PRODCATEG_ICON_BASEURL_DEFVAL = "http://dnet.nan21.net/static-demo-resources/MM/product-categories";

	public static final String MM_PRODCATEG_ICON_EXT = "MM_PRODCATEG_ICON_EXT";
	public static final String MM_PRODCATEG_ICON_EXT_DEFVAL = "jpg";

	public static final String MM_MANUFACT_ICON_BASEURL = "MM_MANUFACT_ICON_BASEURL";
	public static final String MM_MANUFACT_ICON_BASEURL_DEFVAL = "http://dnet.nan21.net/static-demo-resources/MM/product-manufacturers";

	public static final String MM_MANUFACT_ICON_EXT = "MM_MANUFACT_ICON_EXT";
	public static final String MM_MANUFACT_ICON_EXT_DEFVAL = "jpg";

	public static final String MM_PRODUCT_ICON_BASEURL = "MM_PRODUCT_ICON_BASEURL";
	public static final String MM_PRODUCT_ICON_BASEURL_DEFVAL = "http://dnet.nan21.net/static-demo-resources/MM/products";

	public static final String MM_PRODUCT_ICON_EXT = "MM_PRODUCT_ICON_EXT";
	public static final String MM_PRODUCT_ICON_EXT_DEFVAL = "jpg";

	public static final String MM_PRODUCT_ICON_SUFFIX = "MM_PRODUCT_ICON_SUFFIX";
	public static final String MM_PRODUCT_ICON_SUFFIX_DEFVAL = "-small";

	public static final String MM_PRODUCT_IMAGE_BASEURL = "MM_PRODUCT_IMAGE_BASEURL";
	public static final String MM_PRODUCT_IMAGE_BASEURL_DEFVAL = "http://dnet.nan21.net/static-demo-resources/MM/products";

	public static final String MM_PRODUCT_IMAGE_EXT = "MM_PRODUCT_IMAGE_EXT";
	public static final String MM_PRODUCT_IMAGE_EXT_DEFVAL = "jpg";

	public static final String MM_PRODUCT_IMAGE_SUFFIX = "MM_PRODUCT_IMAGE_SUFFIX";
	public static final String MM_PRODUCT_IMAGE_SUFFIX_DEFVAL = "";

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

			// product categories

			params.add(new SysParamDefinition(MM_PRODCATEG_ICON_BASEURL,
					"Product category icon base url", "",
					SysParamDefinition.TYPE_STRING,
					MM_PRODCATEG_ICON_BASEURL_DEFVAL, null));

			params.add(new SysParamDefinition(MM_PRODCATEG_ICON_EXT,
					"Product category icon default extension", "",
					SysParamDefinition.TYPE_STRING,
					MM_PRODCATEG_ICON_EXT_DEFVAL, null));

			// product manufacturers

			params.add(new SysParamDefinition(MM_MANUFACT_ICON_BASEURL,
					"Manufacturer icon base url", "",
					SysParamDefinition.TYPE_STRING,
					MM_MANUFACT_ICON_BASEURL_DEFVAL, null));

			params.add(new SysParamDefinition(MM_MANUFACT_ICON_EXT,
					"Manufacturer icon default extension", "",
					SysParamDefinition.TYPE_STRING,
					MM_MANUFACT_ICON_EXT_DEFVAL, null));

			// products

			params.add(new SysParamDefinition(MM_PRODUCT_ICON_BASEURL,
					"Product icon base url", "",
					SysParamDefinition.TYPE_STRING,
					MM_PRODUCT_ICON_BASEURL_DEFVAL, null));

			params.add(new SysParamDefinition(MM_PRODUCT_ICON_EXT,
					"Product icon default extension", "",
					SysParamDefinition.TYPE_STRING, MM_PRODUCT_ICON_EXT_DEFVAL,
					null));

			params.add(new SysParamDefinition(MM_PRODUCT_ICON_SUFFIX,
					"Product icon default suffix", "",
					SysParamDefinition.TYPE_STRING,
					MM_PRODUCT_ICON_SUFFIX_DEFVAL, null));

			params.add(new SysParamDefinition(MM_PRODUCT_IMAGE_BASEURL,
					"Product image base url", "",
					SysParamDefinition.TYPE_STRING,
					MM_PRODUCT_IMAGE_BASEURL_DEFVAL, null));

			params.add(new SysParamDefinition(MM_PRODUCT_IMAGE_EXT,
					"Product image default extension", "",
					SysParamDefinition.TYPE_STRING,
					MM_PRODUCT_IMAGE_EXT_DEFVAL, null));

			params.add(new SysParamDefinition(MM_PRODUCT_IMAGE_SUFFIX,
					"Product image default suffix", "",
					SysParamDefinition.TYPE_STRING,
					MM_PRODUCT_IMAGE_SUFFIX_DEFVAL, null));

		}
	}

}
