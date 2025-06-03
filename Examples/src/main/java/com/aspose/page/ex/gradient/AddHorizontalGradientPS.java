package com.aspose.page.ex.gradient;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
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

public class AddHorizontalGradientPS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		
		// Set license
		new License().setLicense(BaseExamplesTest.LICENSE_PATH);
		
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "HorizontalGradient_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		//Create new PS Document with the page opened
        PsDocument document = new PsDocument(outPsStream, options, false);
		
        //Create a rectangle
        Rectangle2D.Float rectangle = new Rectangle2D.Float(200, 100, 200, 100);
        
        //Create horizontal linear gradient paint. Scale components in the transform must be equal to width and heigh of the rectangle.
        //Translation components are offsets of the rectangle.
        LinearGradientPaint paint = new LinearGradientPaint(new Point2D.Float(0, 0), new Point2D.Float(200, 100),
        		new float [] {0, 1}, new Color [] {new Color(0, 0, 0, 150), new Color(40, 128, 70, 50)},
        		MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB,
        		new AffineTransform(200, 0, 0, 100, 200, 100));
        
        //Set paint
        document.setPaint(paint);
      //Fill the rectangle
        document.fill(rectangle);

        //Fill a text with the gradient
        Font font = new Font("Arial", Font.BOLD, 96);
        document.fillAndStrokeText("ABC", font, 200, 300, paint, Color.BLACK, new BasicStroke(2));
        
        //Stroke a text with the gradient
        document.outlineText("ABC", font, 200, 400, paint, new BasicStroke(5));

        //Close current page
		document.closePage();
		//Save the document
		document.save();
	 }
}
