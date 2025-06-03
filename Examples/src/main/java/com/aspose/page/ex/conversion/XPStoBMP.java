package com.aspose.page.ex.conversion;

import java.io.FileOutputStream;

import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsDocument;

public class XPStoBMP {
    public static void main(String[] args) throws Exception {
        // ExStart:XPStoBMP
        
    	// Set license
  	    new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
    	// The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Load XPS document
        XpsDocument document = new XpsDocument(dataDir + "input.xps");
        // Initialize options object with necessary parameters.
        com.aspose.xps.rendering.BmpSaveOptions options = new com.aspose.xps.rendering.BmpSaveOptions();
        options.setSmoothingMode(com.aspose.xps.rendering.SmoothingMode.HighQuality);
        options.setResolution(300);
        options.setPageNumbers(new int[]{1, 2, 6});

        // Save XPS document as images bytes array. One bytes array for one page of every parttion in the document
        byte [][][] imagesBytes = document.saveAsImage(options);

        // Iterate through document partitions (fixed documents, in XPS terms)
        for (int i = 0; i < imagesBytes.length; i++) {
            // Iterate through partition pages
            for (int j = 0; j < imagesBytes[i].length; j++) {
                // Initialize image output stream
                FileOutputStream imageStream = new FileOutputStream(dataDir + "XPStoBMP_out" + "_" + (i + 1) + "_" + (j + 1) + ".bmp");
                // Write image
                imageStream.write(imagesBytes[i][j], 0, imagesBytes[i][j].length);
                
                imageStream.close();
            }
        }
        // ExEnd:XPStoBMP
    }
}

