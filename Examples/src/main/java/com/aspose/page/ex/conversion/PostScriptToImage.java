package com.aspose.page.ex.conversion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.ImageSaveOptions;
import com.aspose.page.ImageFormat;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;

public class PostScriptToImage {
    public static void main(String[] args) throws Exception {
        // ExStart:PostScriptToImage
        
    	// Set license
  	  	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
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

        // Default image format is PNG and it is not mandatory to set it in ImageSaveOptions
        // Default image size is 595x842 and it is not mandatory to set it in ImageSaveOptions
        
        // But if you need to specify size and image format use constructor with parameters
        //ImageSaveOptions options = new ImageSaveOptions(new Dimension(600, 800), ImageFormat.JPEG);

        byte[][] imagesBytes = document.saveAsImage(options);

        int i = 0;

        for (byte [] imageBytes : imagesBytes) {
            String imagePath = dataDir + "PSToImage_out_" + i + "." + imageFormat.toString().toLowerCase();
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
