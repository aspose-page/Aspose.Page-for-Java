package com.aspose.page.ex.gradient;

import java.awt.Color;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;

public class AddDiagonalGradientPS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		
		// Set license
		new License().setLicense(BaseExamplesTest.LICENSE_PATH);
		
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "DiagonalGradient_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		// Create new PS Document with the page opened
        PsDocument document = new PsDocument(outPsStream, options, false);
		
        //Create a rectangle
        Rectangle2D.Float rectangle = new Rectangle2D.Float(200, 100, 200, 100);
        
        //Create the gradient transform. Scale components in the transform must be equal to width and heigh of the rectangle.
        //Translation components are offsets of the rectangle.
        AffineTransform transform = new AffineTransform(200, 0, 0, 100, 200, 100);
        //Rotate gradient, than scale and translate to get visible color transition in required rectangle
        transform.rotate(-45 * (Math.PI / 180));
        float hypotenuse = (float) Math.sqrt(200 * 200 + 100 * 100);
        float ratio = hypotenuse / 200;
        transform.scale(-ratio, 1);
        transform.translate(100 / transform.getScaleX(), 0);
        
        //Create diagonal linear gradient paint.
        LinearGradientPaint paint = new LinearGradientPaint(new Point2D.Float(0, 0), new Point2D.Float(200, 100),
        		new float [] {0, 1}, new Color [] {Color.RED, Color.BLUE}, MultipleGradientPaint.CycleMethod.NO_CYCLE,
        		MultipleGradientPaint.ColorSpaceType.SRGB, transform);
        
        //Set paint
        document.setPaint(paint);
        //Fill the rectangle
        document.fill(rectangle);

        //Close current page
		document.closePage();
		//Save the document
		document.save();
	 }
}
