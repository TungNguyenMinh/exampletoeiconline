package com.minhtung.core.web.common.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UploadUitl {
    private final int maxMemory = 1024 * 1024 * 3; //3MB1
    private final int maxRequestSize = 1024 * 1024 * 50; //50MB

    public Object[] writeOrUpdateFile(HttpServletRequest request, Set<String> titleValue, String path) throws FileUploadException, Exception {
        ServletContext context = request.getServletContext();
        String address = context.getRealPath("image");
        boolean check = true;
        String filelocation = null;
        String name = null;
        Map<String, String> mapReturnValue = new HashMap<String, String>();
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            System.out.println("have not enctye multipart/form-data");
            check = false;
        }
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Set factory constraints
        factory.setSizeThreshold(maxMemory);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(maxRequestSize);
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            if (!item.isFormField()) {
                String fileName = item.getName();
                if (StringUtils.isNotBlank(fileName)) {
                    File uploadFile = new File(address + File.separator + path + File.separator + fileName);
                    filelocation = address + File.separator + path + File.separator + fileName;
                    name = fileName;
                    boolean isExist = uploadFile.exists();
                    if (isExist) {
                        if (uploadFile.delete()) {
                            item.write(uploadFile);
                        }
                        check = false;
                    } else {
                        item.write(uploadFile);
                    }
                }
            } else {
                if (titleValue != null) {
                    String nameField = item.getFieldName();
                    String valueField = item.getString();
                    if (titleValue.contains(nameField)) {
                        mapReturnValue.put(nameField, valueField);
                    }
                }
            }
        }
        return new Object[]{check, filelocation, name, mapReturnValue};
    }
}
