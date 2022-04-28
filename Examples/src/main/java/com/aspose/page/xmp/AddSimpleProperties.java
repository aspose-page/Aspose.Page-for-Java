package com.aspose.page.xmp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.eps.PsDocument;
import com.aspose.eps.xmp.XmpMetadata;
import com.aspose.eps.xmp.XmpValue;
import com.aspose.page.BaseExamplesTest;
import com.aspose.page.License;
import com.aspose.page.utilities.Utils;

public class AddSimpleProperties {
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

            // Add date property "xmp:Date1" value
            TimeZone.setDefault( TimeZone.getTimeZone("UTC"));
            Date now = new Date();            
            xmp.put("xmp:Date1", new XmpValue(now));
            
            // Add integer property "xmp:Intg1" value
            xmp.put("xmp:Intg1", new XmpValue(111));
            
            // Add double property "xmp:Double1" value
            xmp.put("xmp:Double1", new XmpValue(111.11D));
            
            // Add string property "xmp:String1" value
            xmp.put("xmp:String1", new XmpValue("ABC"));
            
            
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
