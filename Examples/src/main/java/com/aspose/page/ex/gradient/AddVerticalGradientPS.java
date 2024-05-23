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
import com.aspose.page.ex.utilities.Utils;

public class AddVerticalGradientPS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "VerticalGradient_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		//Create new PS Document with the page opened
        PsDocument document = new PsDocument(outPsStream, options, false);
		
        //Create a rectangle
        Rectangle2D.Float rectangle = new Rectangle2D.Float(200, 100, 200, 100);
        
        //Create arrays of colors and fractions for the gradient.
        Color[] colors = { Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, new Color(85,107,47) };
        float[] fractions = { 0.0f, 0.1873f, 0.492f, 0.734f, 1.0f };
        
        //Create the gradient transform. Scale components in the transform must be equal to width and heigh of the rectangle.
        //Translation components are offsets of the rectangle.
        AffineTransform transform = new AffineTransform(200, 0, 0, 100, 200, 100);
        //Rotate the gradient on 90 degrees around an origin
        transform.rotate(90 * (Math.PI / 180));
        
        //Create vertical linear gradient paint.
        LinearGradientPaint paint = new LinearGradientPaint(new Point2D.Float(0, 0), new Point2D.Float(200, 100),
        		fractions, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB,
        		transform);
        
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
