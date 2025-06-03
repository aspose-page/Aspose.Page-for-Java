package com.aspose.page.ex.canvas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;

public class ClippingPS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		
		// Set license
		new License().setLicense(BaseExamplesTest.LICENSE_PATH);
		
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "Clipping_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		// Create new PS Document with the page opened
        PsDocument document = new PsDocument(outPsStream, options, false);
        
        //Create a rectangle
        Shape rectangle = new Rectangle2D.Float(0, 0, 300, 200);
        
        //Set paint in the upper level graphics state
      	document.setPaint(Color.BLUE);
		
		//////////////////////////////////////Clipping by shape //////////////////////////////////////////////////////////////////////
		
		//Save graphics state in order to return back to this state after transformation
		document.writeGraphicsSave();
		
		//Displace current graphics state on 100 points to the right and 100 points to the bottom.
		document.translate(100, 100);
		
		//Create circle
		Shape circle = new Ellipse2D.Float(50, 0, 200, 200);
		
		//Add clipping by circle to the current graphics state
		document.clip(circle);
		
		//Fill the rectangle in the current graphics state (with clipping)
		document.fill(rectangle);
		
		//Restore graphics state to the previus (upper) level
		document.writeGraphicsRestore();
		
		//Displace upper level graphics state on 100 points to the right and 100 points to the bottom.
		document.translate(100, 100);
		
		BasicStroke stroke = new BasicStroke(2,
		        BasicStroke.CAP_BUTT,
		        BasicStroke.JOIN_MITER,
		        10.0f, new float []{5.0f}, 0.0f);
		
		document.setStroke(stroke);
		
		//Draw the rectangle in the current graphics state (has no clipping) above clipped rectangle
		document.draw(rectangle);
		
		//////////////////////////////////////Clipping by text //////////////////////////////////////////////////////////////////////
		
		//Save graphics state in order to return back to this state after transformation
		document.writeGraphicsSave();
		
		//Displace current graphics state on 100 points to the right and 100 points to the bottom.
		document.translate(0, 350);
		
		int fontSize = 120;
		Font font = new Font("Arial", Font.BOLD, fontSize);
		
		//Clip rectangle by text's outline
		document.clipText("ABC", font, 20, fontSize + 10);		
		document.fill(rectangle);
		
		document.writeGraphicsRestore();
		
		document.translate(0, 350);
		
		document.setStroke(stroke);
		//Draw the rectangle in the current graphics state (has no clipping) above clipped rectangle
		document.draw(rectangle);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Close current page
		document.closePage();
		//Save the document
		document.save();
	 }
}
