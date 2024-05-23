package com.aspose.page.ex.license;

import java.io.FileOutputStream;
import java.io.IOException;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.ImageSaveOptions;
import com.aspose.page.ImageFormat;
import com.aspose.page.ex.utilities.Utils;

public class SetMeteredLicense {

	public static void main(String[] args) throws Exception {
        // ExStart:SetMeteredLicense

		// set metered public and private keys
        com.aspose.page.Metered metered = new com.aspose.page.Metered();
        // Access the setMeteredKey property and pass public and private keys as parameters
        metered.setMeteredKey(
        		"<type public key here>",
        		"<type private key here>");
		
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        //Initialize Ps document with PostScript file
        PsDocument document = new PsDocument(dataDir + "input.ps");
        
        //check if document is licensed
        if (document.isLicensed())
            System.out.println("Metered License is set successfully.");
        else
        	System.out.println("Metered License is not set.");

        //Initialize options object with default parameters.
        ImageSaveOptions options = new ImageSaveOptions(ImageFormat.PNG);

        //Save EPS file as images bytes. One bytes array for one page. In our case we have one page.
        byte[][] imagesBytes = document.saveAsImage(options);

        //Save image bytes to file
        FileOutputStream fs = new FileOutputStream(dataDir + "eps_out." + options.getImageFormat().toString().toLowerCase());
        try {
            fs.write(imagesBytes[0], 0, imagesBytes[0].length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            fs.close();
        }
        
        //Now we can check visually if Metered License is applied.
        //If resulting image doesn't contain red evaluation message It means Metered License is applied successfully.
        // ExEnd:SetMeteredLicense
	}
}
