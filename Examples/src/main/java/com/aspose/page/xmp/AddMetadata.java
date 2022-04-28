package com.aspose.page.xmp;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.xmp.XmpMetadata;
import com.aspose.page.BaseExamplesTest;
import com.aspose.page.License;
import com.aspose.page.utilities.Utils;

public class AddMetadata {
    public static void main(String[] args) throws Exception {
        // ExStart:XMPMetadata
    	
    	// Set license
    	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        // Initialize input EPS file stream
        FileInputStream psStream = new FileInputStream(dataDir + "xmp2.eps");

        PsDocument document = new PsDocument(psStream);

        try {
            // Get XMP metadata. If EPS file doesn't contain XMP metadata we get new one filled with values from PS metadata comments (%%Creator, %%CreateDate, %%Title etc)
            XmpMetadata xmp = document.getXmpMetadata();

            // Get "CreatorTool" value
            if (xmp.containsKey("xmp:CreatorTool"))
                System.out.println("CreatorTool: " + xmp.get("xmp:CreatorTool").toStringValue());
            
            // Get "CreateDate" value
            if (xmp.containsKey("xmp:CreateDate"))
                System.out.println("CreateDate: " + xmp.get("xmp:CreateDate").toStringValue());

            // Get "Title" value
            if (xmp.containsKey("dc:title"))
                System.out.println("Title: " + xmp.get("dc:title").toArray()[0].toStringValue());

            // Get "format" value
            if (xmp.containsKey("dc:format"))
                System.out.println("Format: " + xmp.get("dc:format").toStringValue());

            // Get "creator" value
            if (xmp.containsKey("dc:creator"))
                System.out.println("Creator: " + xmp.get("dc:creator").toArray()[0].toStringValue());
            
            // Get "MetadataDate" value
            if (xmp.containsKey("xmp:MetadataDate"))
                System.out.println("MetadataDate: " + xmp.get("xmp:MetadataDate").toStringValue());
            
            
            // Initialize output EPS file stream
            FileOutputStream outPsStream = new FileOutputStream(dataDir + "xmp2_changed.eps");
            
            // Save document with new XMP metadata
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
