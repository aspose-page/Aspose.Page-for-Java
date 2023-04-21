package com.aspose.page.transparency;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.utilities.Utils;

public class AddTransparentImagePS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "AddTransparentImage_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		// Create new multipaged PS Document with one page opened
        PsDocument document = new PsDocument(outPsStream, options, false);
		
        //Add red rectangle under images to see the difference between addImage() and addTransparentImage() methods 
        document.setPaint(new Color(211, 8, 48));
        document.fill(new Rectangle2D.Float(0, 0, (int) options.getPageSize().getWidth(), 300));
        
        document.writeGraphicsSave();
        document.translate(20, 100);
        
        //Create an image from translucent image file
        BufferedImage image = ImageIO.read(new File(dataDir + "mask1.png"));        
        
        //Add this image to document as usual opaque RGB image
        document.drawImage(image, new AffineTransform(1, 0, 0, 1, 100, 0), null);
        
        //Add this image to document as transparent image
        document.drawTransparentImage(image, new AffineTransform(1, 0, 0, 1, 350, 0), 255);
        
        document.writeGraphicsRestore();

        //Close current page
		document.closePage();
		//Save the document
		document.save();
	 }
}
