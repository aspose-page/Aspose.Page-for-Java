package com.aspose.page.ex;

import com.aspose.page.License;

public class BaseExamplesTest {

	public final static String LICENSE_PATH = "d:\\Aspose.Page.Java.lic";
	
	public static void setLicense() {
		try {
        	new License().setLicense(LICENSE_PATH);
        } catch (Exception ex) {
        	throw new RuntimeException(ex);
        }
	}
}
