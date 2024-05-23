package com.aspose.page.ex.images;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.ex.utilities.Utils;

public class AddImagePS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "AddImage_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		// Create new PS Document with the page opened
        PsDocument document = new PsDocument(outPsStream, options, false);
		
        
        document.writeGraphicsSave();
        document.translate(100, 100);
        
        //Create a BufferedImage object from image file
        BufferedImage image = ImageIO.read(new File(dataDir + "TestImage Format24bppRgb.jpg"));
        
        //Create image transform
        AffineTransform transform = new AffineTransform();
        transform.translate(35, 300);
        transform.scale(3, 3);
        transform.rotate(-45);
      
        //Add image to document
        document.drawImage(image, transform, null);
        
        document.writeGraphicsRestore();

        //Close current page
		document.closePage();
		//Save the document
		document.save();
	 }
}
