package com.aspose.page.conversion;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PdfSaveOptions;
import com.aspose.page.License;
import com.aspose.page.utilities.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PostScriptToPDF {
    public static void main(String[] args) throws Exception {
        // ExStart:PostScriptToPDF

        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Initialize PDF output stream
        FileOutputStream pdfStream = new FileOutputStream(dataDir + "PStoPDF.pdf");

        // Initialize PostScript input stream
        FileInputStream psStream = new FileInputStream(dataDir + "input.ps");

        PsDocument document = new PsDocument(psStream);

        // If you want to convert Postscript file despite of minor errors set this flag
        boolean suppressErrors = true;

        //Initialize options object with necessary parameters.
        PdfSaveOptions options = new PdfSaveOptions(suppressErrors);
        // If you want to add special folder where fonts are stored. Default fonts folder in OS is always included.
        //options.setAdditionalFontsFolders(new String [] {"FONTS_FOLDER"});

        // Default page size is 595x842 and it is not mandatory to set it in PdfDevice
        com.aspose.eps.device.PdfDevice device = new com.aspose.eps.device.PdfDevice(pdfStream);
        // But if you need to specify size and image format use following line
        //com.aspose.eps.device.PdfDevice device = new com.aspose.eps.device.PdfDevice(pdfStream, new Dimension(595, 842));

        try {
            document.save(device, options);
        } finally {
            psStream.close();
            pdfStream.close();
        }

        //Review errors
        if (suppressErrors) {
            for (Exception ex : options.getExceptions()) {
                System.out.println(ex.getMessage());
            }
        }
        // ExEnd:PostScriptToPDF
    }
}
