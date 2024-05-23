package com.aspose.page.ex.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.ex.utilities.Utils;

public class AddRectanglePS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "AddRectangle_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		// Create new PS Document with the page opened
        PsDocument document = new PsDocument(outPsStream, options, false);
		
        //Set paint for filling rectangle
        document.setPaint(Color.ORANGE);        
        //Fill the first rectangle
        document.fill(new Rectangle2D.Float(250, 100, 150, 100));
        
        //Set paint for stroking rectangle
        document.setPaint(Color.RED);
        //Set stroke
        document.setStroke(new BasicStroke(3));
        //Stroke (outline) the second rectangle
        document.draw(new Rectangle2D.Float(250, 300, 150, 100));

        //Close current page
		document.closePage();
		//Save the document
		document.save();
	 }
}
