package com.aspose.page.texture;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.utilities.Utils;

public class AddTextureTilingPaternPS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "AddTextureTilingPattern_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		// Create new multipaged PS Document with one page opened
        PsDocument document = new PsDocument(outPsStream, options, false);
		
        
        document.writeGraphicsSave();
        document.translate(200, 100);
        
        //Create a BufferedImage object from image file
        BufferedImage image = ImageIO.read(new File(dataDir + "TestTexture.bmp"));
        
        //Create image area doubled in width
        Rectangle2D.Float imageArea = new Rectangle2D.Float(0, 0, image.getWidth() * 2, image.getHeight());
        //Create texture brush from the image
        TexturePaint paint = new TexturePaint(image, imageArea);
        
        //Create rectangle
        Rectangle2D.Float shape = new Rectangle2D.Float(0, 0, 200, 100);
        
        //Set this texture brush as current paint
        document.setPaint(paint);
        //Fill rectangle
        document.fill(shape);
        
        
        document.setPaint(Color.RED);
        document.setStroke(new BasicStroke(2));
        document.draw(shape);
        
        document.writeGraphicsRestore();
        
        //Fill the text with the texture pattern
        Font font = new Font("Arial", Font.BOLD, 96);
        document.fillAndStrokeText("ABC", font, 200, 300, paint, Color.BLACK, new BasicStroke(2));

        //Outline the text with the texture pattern
        document.outlineText("ABC", font, 200, 400, paint, new BasicStroke(5));

        //Close current page
		document.closePage();
		//Save the document
		document.save();
	 }
}
