package com.aspose.page.xmp;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.xmp.XmpMetadata;
import com.aspose.eps.xmp.XmpValue;
import com.aspose.page.BaseExamplesTest;
import com.aspose.page.License;
import com.aspose.page.utilities.Utils;

public class CahngeArrayItems {
    public static void main(String[] args) throws Exception {
        // ExStart:XMPMetadata
    	
    	// Set license
    	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        // Initialize input EPS file stream
        FileInputStream psStream = new FileInputStream(dataDir + "xmp3.eps");

        PsDocument document = new PsDocument(psStream);

        try {
            // Get XMP metadata. If EPS file doesn't contain XMP metadata we get new one filled with values from PS metadata comments (%%Creator, %%CreateDate, %%Title etc)
            XmpMetadata xmp = document.getXmpMetadata();

            // Set "dc:title" array item by index 0 
            xmp.setArrayItem("dc:title", 0, new XmpValue("NewTitle"));
            
            // Set "dc:creator" array item by index 0
            xmp.setArrayItem("dc:creator", 0, new XmpValue("NewCreator"));
            
            
            // Initialize output EPS file stream
            FileOutputStream outPsStream = new FileOutputStream(dataDir + "xmp3_changed.eps");
            
            // Save document with changed XMP metadata
    		try {			
    			document.save(outPsStream);
    		} finally {
    			outPsStream.close();
    		}

        } finally {
            // close input EPS stream
        	psStream.close();
        }
        
        // ExEnd:XMPMetadata
    }
}
