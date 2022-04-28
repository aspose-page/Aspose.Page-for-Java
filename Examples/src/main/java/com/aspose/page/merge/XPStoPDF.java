package com.aspose.page.merge;
import java.io.FileOutputStream;

import com.aspose.page.utilities.Utils;
import com.aspose.xps.XpsDocument;

public class XPStoPDF {
    public static void main(String[] args) throws Exception {
        // ExStart:XPStoPDF
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Initialize PDF output stream
        FileOutputStream pdfStream = new FileOutputStream(dataDir + "XPStoPDF.pdf");

        // Load the first XPS file in a document
        XpsDocument document = new XpsDocument(dataDir + "input.xps");
        
        // Create an array of XPS files that will be merged with the first one
        String[] filesForMerge = new String[] { dataDir + "Demo.xps", dataDir + "sample.xps" };

        // Initialize options object with necessary parameters.
        com.aspose.xps.rendering.PdfSaveOptions options = new com.aspose.xps.rendering.PdfSaveOptions();
        options.setJpegQualityLevel(100);
        options.setImageCompression(com.aspose.xps.rendering.PdfImageCompression.Jpeg);
        options.setTextCompression(com.aspose.xps.rendering.PdfTextCompression.Flate);
        options.setPageNumbers(new int[] { 1, 2, 6 });

        // Create rendering device for PDF format
        com.aspose.xps.rendering.PdfDevice device = new com.aspose.xps.rendering.PdfDevice(pdfStream);

        document.merge(filesForMerge, device, options);
        // ExEnd:XPStoPDF
    }
}