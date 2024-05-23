package com.aspose.page.ex.xmp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.eps.PsDocument;
import com.aspose.eps.xmp.XmpMetadata;
import com.aspose.eps.xmp.XmpValue;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;

public class ChangeValues {
    public static void main(String[] args) throws Exception {
        // ExStart:XMPMetadata
    	
    	// Set license
    	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        // Initialize input EPS file stream
        FileInputStream psStream = new FileInputStream(dataDir + "xmp1.eps");

        PsDocument document = new PsDocument(psStream);

        try {
            // Get XMP metadata. If EPS file doesn't contain XMP metadata we get new one filled with values from PS metadata comments (%%Creator, %%CreateDate, %%Title etc)
            XmpMetadata xmp = document.getXmpMetadata();

            // Change "ModifyDate" value
            TimeZone.setDefault( TimeZone.getTimeZone("UTC"));
            Date now = new Date();
            xmp.put("xmp:ModifyDate", new XmpValue(now));
            
            // Change "creator" value
            XmpValue value = new XmpValue("Aspose.Page");
            xmp.put("dc:creator", value);

            // Change "title" value
            value = new XmpValue("(PAGEJAVA-29.eps)");
            xmp.put("dc:title", value);
            
            
            // Initialize output EPS file stream
            FileOutputStream outPsStream = new FileOutputStream(dataDir + "xmp1_changed.eps");
            
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
