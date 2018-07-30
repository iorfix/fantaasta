package org.fasta.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileUtils {

	private final static String CLASS_NAME = FileUtils.class.getName();
	private static final Logger log = LogUtil.LOGCMN;

	
	static void closeQuietly(Reader reader) {
	       final String METHOD_NAME = "closeQuietly";
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e) {
	                log.logp(Level.WARNING, CLASS_NAME, METHOD_NAME,
	                        "Unable to close Reader resource", e);
	            }
	        }
	}





    public static Reader makeUtf8FileReader(File file) throws FileNotFoundException {
    	FileInputStream fis = new FileInputStream(file);
    	InputStreamReader isr;
		try {
			isr = new InputStreamReader(fis, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// Could not happen
			throw new IllegalArgumentException(e);
		}
    	return isr;
    }


}
