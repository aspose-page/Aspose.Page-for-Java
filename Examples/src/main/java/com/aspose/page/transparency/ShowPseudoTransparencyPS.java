package com.aspose.page.transparency;

import java.awt.Color;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.utilities.Utils;

public class ShowPseudoTransparencyPS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "ShowPseudoTransparency_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		// Create new multipaged PS Document with one page opened
        PsDocument document = new PsDocument(outPsStream, options, false);
		
        float offsetX = 50;
        float offsetY = 100;
        float width = 200;
        float height = 100;
        
        ///////////////////////////////// Create rectangle with opaque gradient fill ////////////////////////////////////////////////////////
        Rectangle2D.Float rectangle = new Rectangle2D.Float(offsetX, offsetY, width, height);
        
        LinearGradientPaint paint = new LinearGradientPaint(new Point2D.Float(0, 0), new Point2D.Float(200, 100),
        		new float [] {0, 1}, new Color [] {new Color(0, 0, 0), new Color(40, 128, 70)},
        		MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB,
        		new AffineTransform(width, 0, 0, height, offsetX, offsetY));
        
        //Set paint
        document.setPaint(paint);
        //Fill the rectangle
        document.fill(rectangle);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        offsetX = 350;
        
		///////////////////////////////// Create rectangle with translucent gradient fill ///////////////////////////////////////////////////
		rectangle = new Rectangle2D.Float(offsetX, offsetY, width, height);
		
		paint = new LinearGradientPaint(new Point2D.Float(0, 0), new Point2D.Float(200, 100),
		new float [] {0, 1}, new Color [] {new Color(0, 0, 0, 150), new Color(40, 128, 70, 50)},
		MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB,
		new AffineTransform(width, 0, 0, height, offsetX, offsetY));
		
		//Set paint
		document.setPaint(paint);
		//Fill the rectangle
		document.fill(rectangle);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        

        //Close current page
		document.closePage();
		//Save the document
		document.save();
	 }
}
