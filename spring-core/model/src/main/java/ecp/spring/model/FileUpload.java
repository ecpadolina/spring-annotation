package ecp.spring.model;

import org.springframework.web.multipart.MultipartFile;
 
public class FileUpload {
 
	private MultipartFile file;

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }    
 
}
