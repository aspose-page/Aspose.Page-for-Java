package com.aspose.page.ex.merge;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsDocument;

public class XPStoXPS {
    public static void main(String[] args) throws Exception {
        // ExStart:XPStoXPS merge
    	
    	// Set license
  	  	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        // Load the first XPS file in a document
        XpsDocument document = new XpsDocument(dataDir + "input.xps");
        
        // Create an array of XPS files that will be merged with the first one
        String[] filesForMerge = new String[] { dataDir + "Demo.xps", dataDir + "sample.xps" };
        
        //merge and save to output XPS file
        document.merge(filesForMerge, dataDir + "mergedXPSfiles.xps");
        // ExEnd:XPStoPDF
    }
}