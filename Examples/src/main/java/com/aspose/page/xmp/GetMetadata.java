package com.aspose.page.xmp;

import java.io.FileInputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.xmp.XmpMetadata;
import com.aspose.eps.xmp.XmpValue;
import com.aspose.page.BaseExamplesTest;
import com.aspose.page.License;
import com.aspose.page.utilities.Utils;

public class GetMetadata {
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

            // Get "CreatorTool" value
            if (xmp.containsKey("xmp:CreatorTool"))
                System.out.println("CreatorTool: " + xmp.get("xmp:CreatorTool").toStringValue());
            
            // Get "CreateDate" value
            if (xmp.containsKey("xmp:CreateDate"))
                System.out.println("CreateDate: " + xmp.get("xmp:CreateDate").toStringValue());

            // Get a width of a thumbnail image if exists
            if (xmp.containsKey("xmp:Thumbnails") && xmp.get("xmp:Thumbnails").isArray()) {
                XmpValue val = xmp.get("xmp:Thumbnails").toArray()[0];
                if (val.isNamedValues() && val.toNamedValues().containsKey("xmpGImg:width"))
                    System.out.println("Thumbnail Width: " + val.toNamedValues().get("xmpGImg:width").toInteger());
            }

            // Get "format" value
            if (xmp.containsKey("dc:format"))
                System.out.println("Format: " + xmp.get("dc:format").toStringValue());

            // Get "DocumentID" value
            if (xmp.containsKey("xmpMM:DocumentID"))
                System.out.println("DocumentID: " + xmp.get("xmpMM:DocumentID").toStringValue());

        } finally {
            // close input EPS stream
        	psStream.close();
        }        
        // ExEnd:XMPMetadata
    }
}
