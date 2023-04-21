package com.aspose.page.hatch;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;

import com.aspose.eps.HatchPaintLibrary;
import com.aspose.eps.HatchStyle;
import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.utilities.Utils;

public class AddHatchPaternPS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "AddHatchPattern_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		// Create new multipaged PS Document with one page opened
        PsDocument document = new PsDocument(outPsStream, options, false);
		
        int x0 = 20;
        int y0 = 100;
        int squareSide = 32;
        int width = 500;
        int sumX = 0;

        //Restore graphics state
        document.writeGraphicsSave();

        //Translate to initial point
        document.translate(x0, y0);
        
        //Create a square for every pattern
        Rectangle2D.Float square = new Rectangle2D.Float(0, 0, squareSide, squareSide);
        
        //Create pen for outlining pattern square
        BasicStroke stroke = new BasicStroke(2);
        
        HatchStyle [] hatchStyles = HatchStyle.values();
        
        //For every hatch pattern style 
        for (int i = 0; i < hatchStyles.length; i++) {            
        	//Create a hatch texture pattern by hatch style, foreground and background colors
        	TexturePaint paint = HatchPaintLibrary.getHatchTexturePaint(hatchStyles[i], Color.BLACK, Color.WHITE);
        	//Set paint with the current hatch pattern
            document.setPaint(paint);

            //Calculate a displacement in order to don't go beyond the page bounds
            int x = squareSide;
            int y = 0;
            if (sumX >= width) {
                x = -(sumX - squareSide);
                y += squareSide;
            }

            //Translate current graphics state
            document.translate(x, y);
            //Fill pattern square
            document.fill(square);

            //Set current paint
            document.setPaint(Color.BLACK);
            //Set current stroke
            document.setStroke(stroke);
            //Draw square outline
            document.draw(square);

            //Calculate distance from X0
            if (sumX >= width)
                sumX = squareSide;
            else
                sumX += x;
        }
        
        //Restore graphics state
        document.writeGraphicsRestore();
        
        //Fill a text with the hatch pattern
        TexturePaint paint = HatchPaintLibrary.getHatchTexturePaint(HatchStyle.DiagonalCross, Color.RED, Color.YELLOW);
        Font font = new Font("Arial", Font.BOLD, 96);
        document.fillAndStrokeText("ABC", font, 200, 400, paint, Color.BLACK, stroke);

        //Outline the text with the hatch pattern
        paint = HatchPaintLibrary.getHatchTexturePaint(HatchStyle.Percent70, Color.BLUE, Color.WHITE);
        document.outlineText("ABC", font, 200, 600, paint, new BasicStroke(5));

        //Close current page
		document.closePage();
		//Save the document
		document.save();
	 }
}
