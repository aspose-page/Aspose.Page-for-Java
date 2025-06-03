package com.aspose.page.ex.gradient;

import java.awt.Color;
import java.awt.MultipleGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;

public class AddRadialGradient2PS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		
		// Set license
		new License().setLicense(BaseExamplesTest.LICENSE_PATH);
		
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "RadialGradient2_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		//Create new PS Document with the page opened
        PsDocument document = new PsDocument(outPsStream, options, false);
		
        //Create a circle
        Ellipse2D.Float circle = new Ellipse2D.Float(200, 100, 200, 200);
        
        //Create arrays of colors and fractions for the gradient.
        Color[] colors = { Color.WHITE, Color.WHITE, Color.BLUE };
        float[] fractions = { 0.0f, 0.2f, 1.0f };
        
        //Create horizontal linear gradient paint. Scale components in the transform must be equal to width and heigh of the rectangle.
        //Translation components are offsets of the rectangle.
        AffineTransform transform = new AffineTransform(200, 0, 0, 200, 200, 100);
        
        //Create radial gradient paint.
        RadialGradientPaint paint = new RadialGradientPaint(new Point2D.Float(64, 64), 68, new Point2D.Float(24, 24),
        		fractions, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB,
        		transform);
        
        //Set paint
        document.setPaint(paint);
        //Fill the circle
        document.fill(circle);
        
        //Close current page
		document.closePage();
		//Save the document
		document.save();
	 }
}
