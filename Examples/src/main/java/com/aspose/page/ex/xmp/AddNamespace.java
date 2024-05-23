package com.aspose.page.ex.xmp;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.xmp.XmpMetadata;
import com.aspose.eps.xmp.XmpValue;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;

public class AddNamespace {
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

            // Add new XML namespace "http://www.some.org/schema/tmp#" with prefix "tmp"
            xmp.registerNamespaceURI("tmp", "http://www.some.org/schema/tmp#");
            
            //Add new property "tmp:newKey" in new XML namespace
            xmp.put("tmp:newKey", new XmpValue("NewValue"));
            
            
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
