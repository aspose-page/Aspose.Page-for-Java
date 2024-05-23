package com.aspose.page.ex.conversion;

import java.io.FileOutputStream;

import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsDocument;

public class XPStoPNG {
    public static void main(String[] args) throws Exception {
        // ExStart:XPStoPNG
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Load XPS document
        XpsDocument document = new XpsDocument(dataDir + "input.xps");
        // Initialize options object with necessary parameters.
        com.aspose.xps.rendering.PngSaveOptions options = new com.aspose.xps.rendering.PngSaveOptions();
        options.setSmoothingMode(com.aspose.xps.rendering.SmoothingMode.HighQuality);
        options.setResolution(300);
        options.setPageNumbers(new int[] { 1, 2, 6 });

        // Save XPS document as images bytes array. One bytes array for one page of every parttion in the document
        byte [][][] imagesBytes = document.saveAsImage(options);

        // Iterate through document partitions (fixed documents, in XPS terms)
        for (int i = 0; i < imagesBytes.length; i++) {
            // Iterate through partition pages
            for (int j = 0; j < imagesBytes[i].length; j++) {
                // Initialize image output stream
                FileOutputStream imageStream = new FileOutputStream(dataDir + "XPStoPNG" + "_" + (i + 1) + "_" + (j + 1) + ".png");
                // Write image
                imageStream.write(imagesBytes[i][j], 0, imagesBytes[i][j].length);
                
                imageStream.close();
            }
        }
        // ExEnd:XPStoPNG
    }
}
