package utilitarios;

import java.io.File;

public class FileUtils {
	 public static boolean checkPDF(String file) {
	        String fileName = file.toUpperCase();
	        return fileName.endsWith(".PDF");
	    }
	    public static boolean checkDOCX(String file) {
	        String fileName = file.toUpperCase();
	        return fileName.endsWith(".DOCX");
	    }
	    public static boolean checkTXT(String file) {
	        String fileName = file.toUpperCase();
	        return fileName.endsWith(".TXT");
	    }
}
