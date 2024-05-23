package com.aspose.page.ex.merge;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PdfSaveOptions;
import com.aspose.page.ex.utilities.Utils;

public class PostScriptToPDF {
    public static void main(String[] args) throws Exception {
        // ExStart:PostScriptToPDF

        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        // Create an array of PostScript files that will be merged with the first one
        String[] filesForMerge = new String[] { dataDir + "input2.ps", dataDir + "input3.ps" };

        PsDocument document = new PsDocument(dataDir + "input.ps");

        // If you want to merge PostScript file despite of minor errors set this flag
        boolean suppressErrors = true;

        //Initialize options object with necessary parameters.
        PdfSaveOptions options = new PdfSaveOptions(suppressErrors);
        // If you want to add special folder where fonts are stored. Default fonts folder in OS is always included.
        //options.setAdditionalFontsFolders(new String [] {"FONTS_FOLDER"});
        // Default page size is 595x842 and it is not mandatory to set it in PdfSaveOptions
        // But if you need to specify size use following line
        // PdfSaveOptions options = new PdfSaveOptions(suppressErrors, new Dimension(595, 842));

        // Merge files with initialized PsDocument and save it as PDF
        document.mergeToPdf(dataDir + "mergePStoPDF.pdf", filesForMerge, options);

        //Review errors
        if (suppressErrors) {
            for (Exception ex : options.getExceptions()) {
                System.out.println(ex.getMessage());
            }
        }
        // ExEnd:PostScriptToPDF
    }
}
