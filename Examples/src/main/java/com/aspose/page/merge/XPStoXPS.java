package com.aspose.page.merge;
import java.io.FileOutputStream;

import com.aspose.page.utilities.Utils;
import com.aspose.xps.XpsDocument;

public class XPStoXPS {
    public static void main(String[] args) throws Exception {
        // ExStart:XPStoXPS merge
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Initialize XPS output stream
        FileOutputStream outStream = new FileOutputStream(dataDir + "mergedXPSfiles.xps");

        // Load the first XPS file in a document
        XpsDocument document = new XpsDocument(dataDir + "input.xps");
        
        // Create an array of XPS files that will be merged with the first one
        String[] filesForMerge = new String[] { dataDir + "Demo.xps", dataDir + "sample.xps" };
        
        //merge and save
        document.merge(filesForMerge, outStream);
        // ExEnd:XPStoPDF
    }
}