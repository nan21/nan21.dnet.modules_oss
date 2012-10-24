package net.nan21.dnet.module.ad._presenterdelegates.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import net.nan21.dnet.core.api.action.IFileUploadResult;
import net.nan21.dnet.core.api.model.IUploadedFileDescriptor;
import net.nan21.dnet.core.api.service.IEntityServiceFactory;
import net.nan21.dnet.core.api.service.IFileUploadService;
import net.nan21.dnet.core.presenter.service.ServiceLocator;
import net.nan21.dnet.core.presenter.service.stream.AbstractFileUploadService;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentService;
import net.nan21.dnet.module.ad.data.domain.entity.Attachment;

public class AttachmentUploadDelegate extends AbstractFileUploadService
		implements IFileUploadService {

	/**
	 * Save an uploaded file as attachment. The p1 parameter is expected to send
	 * the ID of the Attachment record to which this upload belongs.
	 */
	@Override
	public IFileUploadResult execute(IUploadedFileDescriptor fileDescriptor,
			InputStream inputStream, Map<String, String> uploadParams)
			throws Exception {

		ServiceLocator sl = this.getServiceLocator();

		IAttachmentService s = (IAttachmentService) sl.findEntityService(
				Attachment.class, (List<IEntityServiceFactory>) sl
						.getAppContext().getBean("osgiEntityServiceFactories"));

		Long id = Long.decode(uploadParams.get("p1"));

		Attachment a = s.findById(id);

		String path = a.getType().getUploadPath();
		String extension = fileDescriptor.getOriginalName().substring(
				fileDescriptor.getOriginalName().lastIndexOf('.') + 1);
		String newFileName = id + "." + extension;

		File dir = new File (path);
		if (!dir.exists() ) {
			dir.mkdirs();
		}
		 
		OutputStream outputStream = new FileOutputStream(path + "/"
				+ newFileName);
		IOUtils.copy(inputStream, outputStream);
		outputStream.close();

		a.setLocation(newFileName);
		s.update(a);
		return null;
	}

}
