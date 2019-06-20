package com.aspose.page.conversion;

import com.aspose.page.utilities.Utils;
import com.aspose.xps.XpsDocument;
import java.io.FileOutputStream;

public class XPStoJPEG {
    public static void main(String[] args) throws Exception {
        // ExStart:XPStoJPEG
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Initialize XPS input stream

        // Load XPS document form the stream
        XpsDocument document = new XpsDocument(dataDir + "input.xps");

        // Initialize options object with necessary parameters.
        com.aspose.xps.rendering.JpegSaveOptions options = new com.aspose.xps.rendering.JpegSaveOptions();
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
                FileOutputStream imageStream = new FileOutputStream(dataDir + "XPStoJPEG" + "_" + (i + 1) + "_" + (j + 1) + ".jpeg");
                // Write image
                imageStream.write(device.getResult()[i][j], 0, device.getResult()[i][j].length);
            }
        }
        // ExEnd:XPStoJPEG
    }
}
