package com.aspose.page.ex.conversion;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;

public class SaveImageAsEps {
    public static void main(String[] args) throws Exception {
        // ExStart:PostScriptToPDF

    	// Set license
  	  	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        // Create default options
        PsSaveOptions options = new PsSaveOptions();

        // Save JPEG image to EPS file
        PsDocument.saveImageAsEps(dataDir + "input1.jpg", dataDir + "output1.eps", options);
        
        // ExEnd:PostScriptToPDF
    }
}
