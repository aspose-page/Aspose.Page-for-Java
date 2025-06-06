package com.aspose.page.ex.conversion;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PdfSaveOptions;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;

public class PostScriptToPDF {
    public static void main(String[] args) throws Exception {
        // ExStart:PostScriptToPDF
    	
    	// Set license
  	  	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        // Initialize PS document with PostScript file
        PsDocument document = new PsDocument(dataDir + "input.ps");

        // If you want to convert Postscript file despite of minor errors set this flag
        boolean suppressErrors = true;

        //Initialize options object with necessary parameters.
        PdfSaveOptions options = new PdfSaveOptions(suppressErrors);
        // Default page size is 595x842 and it is not mandatory to set it in PdfDevice
        // But if you need to specify size and image format use following line
        // PdfSaveOptions options = new PdfSaveOptions(suppressErrors, new Dimension(595, 842));
        // If you want to add special folder where fonts are stored. Default fonts folder in OS is always included.
        //options.setAdditionalFontsFolders(new String [] {"FONTS_FOLDER"});
        //If PostScript file contains some graphics written as Type3 font glyphs, but it is not actual glyphs
        //the resulting PDF may be incorrect because of default value of options.ConvertFontsToTTF = true
        //Try to set this
        //options.ConvertFontsToTTF = false;

        // Save PS document to PDF file
        document.saveAsPdf(dataDir + "PStoPDF_out.pdf", options);

        //Review errors
        if (suppressErrors) {
            for (Exception ex : options.getExceptions()) {
                System.out.println(ex.getMessage());
            }
        }
        // ExEnd:PostScriptToPDF
    }
}
