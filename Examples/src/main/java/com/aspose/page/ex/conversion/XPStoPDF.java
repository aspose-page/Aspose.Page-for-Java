package com.aspose.page.ex.conversion;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsDocument;

public class XPStoPDF {
    public static void main(String[] args) throws Exception {
        // ExStart:XPStoPDF
        
    	// Set license
  	  	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
    	// The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        // Load XPS document
        XpsDocument document = new XpsDocument(dataDir + "input.xps");

        // Initialize options object with necessary parameters.
        com.aspose.xps.rendering.PdfSaveOptions options = new com.aspose.xps.rendering.PdfSaveOptions();
        options.setJpegQualityLevel(100);
        options.setImageCompression(com.aspose.xps.rendering.PdfImageCompression.Jpeg);
        options.setTextCompression(com.aspose.xps.rendering.PdfTextCompression.Flate);
        options.setPageNumbers(new int[] { 1, 2, 6 });

        // Save XPS document as PDF
        document.saveAsPdf(dataDir + "XPStoPDF_out.pdf", options);
        // ExEnd:XPStoPDF
    }
}