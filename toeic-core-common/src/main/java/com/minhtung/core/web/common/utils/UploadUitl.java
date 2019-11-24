package com.minhtung.core.web.common.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class UploadUitl {
    private final int maxMemory = 1024 * 1024 * 3; //3MB1
    private final int maxRequestSize = 1024 * 1024 * 50; //50MB

    public void writeOrUpdateFile(HttpServletRequest request) throws FileUploadException, Exception {
        ServletContext context = request.getServletContext();
        String address = context.getRealPath("image");
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            System.out.println("have not enctye multipart/form-data");
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
                File uploadFile = new File(address + File.separator + "listenguideline" + File.separator + fileName);
                System.out.println(address + File.separator + "listenguideline" + File.separator);
                try {
                    boolean isExist = uploadFile.exists();
                    if (isExist) {
                        uploadFile.delete();
                        item.write(uploadFile);
                    } else {
                        item.write(uploadFile);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
