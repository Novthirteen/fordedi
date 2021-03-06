package com.yfkey.webapp.action;

import org.apache.struts2.ServletActionContext;
import com.yfkey.Constants;
import com.yfkey.model.UserAuthority;
import com.yfkey.qad.QADConfg;
import com.yfkey.webapp.util.SecurityContextHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Sample action that shows how to do file upload with Struts 2.
 */
public class FileUploadAction extends BaseAction {
    private static final long serialVersionUID = -9208910183310010569L;
    private File file;
    private String fileContentType;
    private String fileFileName;
    private String name;

    private Boolean canUploadTest;
	private Boolean canUploadProd;
	private Boolean canUploadTraining;
	
	

    public Boolean getCanUploadTest() {
		return canUploadTest;
	}

	public void setCanUploadTest(Boolean canUploadTest) {
		this.canUploadTest = canUploadTest;
	}

	public Boolean getCanUploadProd() {
		return canUploadProd;
	}

	public void setCanUploadProd(Boolean canUploadProd) {
		this.canUploadProd = canUploadProd;
	}

	public Boolean getCanUploadTraining() {
		return canUploadTraining;
	}

	public void setCanUploadTraining(Boolean canUploadTraining) {
		this.canUploadTraining = canUploadTraining;
	}

	public String list()
    {
		// 按钮权限
    	canUploadTest = false;
    	canUploadProd = false;
    	canUploadTraining = false;
		
    	List<UserAuthority> userButtons = (List<UserAuthority>) SecurityContextHelper.getRemoteUserButtons();
		if (userButtons != null && userButtons.size() > 0) {
			for (UserAuthority u : userButtons) {
				if (!canUploadTest && u.getAuthority().equals("UploadTest")) {
					canUploadTest = true;
				}
				if (!canUploadProd && u.getAuthority().equals("UploadProd")) {
					canUploadProd = true;
				}
				if(!canUploadTraining && u.getAuthority().equals("UploadTraining"))
				{
					canUploadTraining = true;
				}
			}
		}
    	return SUCCESS;
    }
    
    public String uploadTest() throws Exception{
    	return uploadQad(QADConfg.getQadUploadPathTest());
    }
    
    public String uploadProd() throws Exception{
    	return uploadQad(QADConfg.getQadUploadPathProd());
    }
    
    public String uploadTraining() throws Exception{
    	return uploadQad(QADConfg.getQadUploadPathTraining());
    }
    
    public String uploadQad(String uploadDir) throws Exception {
    	
    
		
		
        if (this.cancel != null) {
            return "cancel";
        }

        // write the file to the file specified
        File dirPath = new File(uploadDir);

        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }

        //retrieve the file data
        InputStream stream = new FileInputStream(file);

        //write the file to the file specified
        OutputStream bos = new FileOutputStream(uploadDir + fileFileName);
        int bytesRead;
        byte[] buffer = new byte[8192];

        while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bos.close();
        stream.close();

        // place the data into the request for retrieval on next page
        getRequest().setAttribute("location", dirPath.getAbsolutePath()
                + Constants.FILE_SEP + fileFileName);

        String link = getRequest().getContextPath() + "/resources" + "/"
                + getRequest().getRemoteUser() + "/";

        getRequest().setAttribute("link", link + fileFileName);

        return SUCCESS;
    }
    /**
     * Upload the file
     *
     * @return String with result (cancel, input or sucess)
     * @throws Exception if something goes wrong
     */
    public String upload() throws Exception {
        if (this.cancel != null) {
            return "cancel";
        }

        // the directory to upload to
        String uploadDir = ServletActionContext.getServletContext().getRealPath("/resources")
                + "/" + getRequest().getRemoteUser() + "/";

        // write the file to the file specified
        File dirPath = new File(uploadDir);

        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }

        //retrieve the file data
        InputStream stream = new FileInputStream(file);

        //write the file to the file specified
        OutputStream bos = new FileOutputStream(uploadDir + fileFileName);
        int bytesRead;
        byte[] buffer = new byte[8192];

        while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bos.close();
        stream.close();

        // place the data into the request for retrieval on next page
        getRequest().setAttribute("location", dirPath.getAbsolutePath()
                + Constants.FILE_SEP + fileFileName);

        String link = getRequest().getContextPath() + "/resources" + "/"
                + getRequest().getRemoteUser() + "/";

        getRequest().setAttribute("link", link + fileFileName);

        return SUCCESS;
    }

    /**
     * Default method - returns "input"
     *
     * @return "input"
     */
    public String execute() {
        return INPUT;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public File getFile() {
        return file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            getFieldErrors().clear();
            if ("".equals(fileFileName) || file == null) {
                super.addFieldError("file", getText("errors.requiredField", new String[] {getText("uploadForm.file")}));
            } else if (file.length() > 2097152) {
                addActionError(getText("maxLengthExceeded"));
            }
        }
    }
}
