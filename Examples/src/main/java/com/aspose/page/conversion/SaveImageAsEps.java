package com.aspose.page.conversion;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.utilities.Utils;

public class SaveImageAsEps {
    public static void main(String[] args) throws Exception {
        // ExStart:PostScriptToPDF

        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        // Create default options
        PsSaveOptions options = new PsSaveOptions();

        // Save JPEG image to EPS file
        PsDocument.saveImageAsEps(dataDir + "input1.jpg", dataDir + "output1.eps", options);
        
        // ExEnd:PostScriptToPDF
    }
}
