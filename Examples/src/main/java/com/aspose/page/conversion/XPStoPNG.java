package com.aspose.page.conversion;

import com.aspose.page.utilities.Utils;
import com.aspose.xps.XpsDocument;
import java.io.FileOutputStream;

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

        // Create rendering device for PDF format
        com.aspose.xps.rendering.ImageDevice device = new com.aspose.xps.rendering.ImageDevice();

        document.save(device, options);

        // Iterate through document partitions (fixed documents, in XPS terms)
        for (int i = 0; i < device.getResult().length; i++) {
            // Iterate through partition pages
            for (int j = 0; j < device.getResult()[i].length; j++) {
                // Initialize image output stream
                FileOutputStream imageStream = new FileOutputStream(dataDir + "XPStoPNG" + "_" + (i + 1) + "_" + (j + 1) + ".png");
                // Write image
                imageStream.write(device.getResult()[i][j], 0, device.getResult()[i][j].length);
            }
        }
        // ExEnd:XPStoPNG
    }
}
