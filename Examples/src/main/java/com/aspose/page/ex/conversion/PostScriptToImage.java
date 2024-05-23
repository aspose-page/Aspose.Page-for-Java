package com.aspose.page.ex.conversion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.ImageSaveOptions;
import com.aspose.page.ImageFormat;
import com.aspose.page.ex.utilities.Utils;

public class PostScriptToImage {
    public static void main(String[] args) throws Exception {
        // ExStart:PostScriptToImage
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        //Initialize image format
        ImageFormat imageFormat = ImageFormat.PNG;
        // Initialize PostScript input stream
        FileInputStream psStream = new FileInputStream(dataDir + "input.ps");

        PsDocument document = new PsDocument(psStream);

        // If you want to convert Postscript file despite of minor errors set this flag
        boolean suppressErrors = true;

        //Initialize options object with necessary parameters.
        ImageSaveOptions options = new ImageSaveOptions(suppressErrors);
        // If you want to add special folder where fonts are stored. Default fonts folder in OS is always included.
        //options.setAdditionalFontsFolders(new String [] {"FONTS_FOLDER"});

        // Default image format is PNG and it is not mandatory to set it in ImageDevice
        // Default image size is 595x842 and it is not mandatory to set it in ImageDevice
        com.aspose.eps.device.ImageDevice device = new com.aspose.eps.device.ImageDevice();
        // But if you need to specify size and image format use constructor with parameters
        //ImageDevice device = new ImageDevice(new Dimension(595, 842), com.aspose.eps.ImageFormat.Jpeg);

        try {
            document.save(device, options);
        } finally {
            psStream.close();
        }

        byte[][] imagesBytes = device.getImagesBytes();

        int i = 0;

        for (byte [] imageBytes : imagesBytes) {
            String imagePath = dataDir + "PSToImage" + i + "." + imageFormat.toString().toLowerCase();
            FileOutputStream fs = new FileOutputStream(imagePath);

            try {
                fs.write(imageBytes, 0, imageBytes.length);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } finally {
                fs.close();
            }
            i++;
        }

        //Review errors
        if (suppressErrors) {
            for (Exception ex : options.getExceptions()) {
                System.out.println(ex.getMessage());
            }
        }
        // ExEnd:PostScriptToImage
    }
}
