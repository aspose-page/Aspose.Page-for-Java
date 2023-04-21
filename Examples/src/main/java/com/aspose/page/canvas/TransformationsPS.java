package com.aspose.page.canvas;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.utilities.Utils;

public class TransformationsPS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "Tranformations_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		// Create new multipaged PS Document with one page opened
        PsDocument document = new PsDocument(outPsStream, options, false);
		
        document.translate(100, 100);

        //Create a rectangle
        Shape shape = new Rectangle2D.Float(0, 0, 150, 100);

        //////////////////////////////////////No transformations ///////////////////////////////////////////////////////////////
        //Set paint in graphics state on upper level
        document.setPaint(Color.ORANGE);

        //Fill the first rectangle that is on on upper level graphics state and that is without any transformations.
        document.fill(shape);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        

        //////////////////////////////////////Translation //////////////////////////////////////////////////////////////////////

        //Save graphics state in order to return back to this state after transformation
        document.writeGraphicsSave();

        //Displace current graphics state on 250 to the right. So we add translation component to the current transformation.
        document.translate(250, 0);

        //Set paint in the current graphics state
        document.setPaint(Color.BLUE);

        //Fill the second rectangle in the current graphics state (has translation transformation)
        document.fill(shape);

        //Restore graphics state to the previus (upper) level
        document.writeGraphicsRestore();
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //Displace on 200 to the bottom.
        document.translate(0, 200);

        //////////////////////////////////////Scaling //////////////////////////////////////////////////////////////////////////
        //Save graphics state in order to return back to this state after transformation
        document.writeGraphicsSave();

        //Scale current graphics state on 0.5 in X axis and on 0.75f in Y axis. So we add scale component to the current transformation.
        document.scale(0.5f, 0.75f);

        //Set paint in the current graphics state
        document.setPaint(Color.RED);

        //Fill the third rectangle in the current graphics state (has scale transformation)
        document.fill(shape);

        //Restore graphics state to the previus (upper) level
        document.writeGraphicsRestore();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //Displace upper level graphics state on 250 to the right.
        document.translate(250, 0);


        //////////////////////////////////////Rotation //////////////////////////////////////////////////////////////////////
        //Save graphics state in order to return back to this state after transformation
        document.writeGraphicsSave();

        //Rotate current graphics state on 45 degrees around origin of current graphics state (350, 300). So we add rotation component to the current transformation.
        document.rotate(45);

        //Set paint in the current graphics state
        document.setPaint(Color.GREEN);

        //Fill the fourth rectangle in the current graphics state (has rotation transformation)
        document.fill(shape);

        //Restore graphics state to the previus (upper) level
        document.writeGraphicsRestore();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //Returns upper level graphics state back to the left and displace on 200 to the bottom.
        document.translate(-250, 200);


        //////////////////////////////////////Shearing //////////////////////////////////////////////////////////////////////
        //Save graphics state in order to return back to this state after transformation
        document.writeGraphicsSave();

        //Shear current graphics state. So we add shear component to the current transformation.
        document.shear(0.1f, 0.2f);

        //Set paint in the current graphics state
        document.setPaint(new Color(255,192,203));

        //Fill the fifth rectangle in the current graphics state (has shear transformation)
        document.fill(shape);

        //Restore graphics state to the previous (upper) level
        document.writeGraphicsRestore();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //Displace upper level graphics state on 250 to the right.
        document.translate(250, 0);


        //////////////////////////////////////Complex transformation ////////////////////////////////////////////////////////
        //Save graphics state in order to return back to this state after transformation
        document.writeGraphicsSave();

        //Transform current graphics state with complex transformation. So we add translation, scale and rotation components to the current transformation.
        document.transform(new AffineTransform(1.2f, -0.965925f, 0.258819f, 1.5f, 0f, 50));

        //Set paint in the current graphics state
        document.setPaint(new Color(127,255,212));

        //Fill the sixth rectangle in the current graphics state (has complex transformation)
        document.fill(shape);

        //Restore graphics state to the previus (upper) level
        document.writeGraphicsRestore();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //Returns upper level graphics state back to the left and displace on 200 to the bottom.
        document.translate(-250, 200);


        //////////////////////////////////////Again no transformation ////////////////////////////////////////////////////////
        // Demonstrates that current graphics state's color is orange that was set up at the beginning of the code. 
        //Fill the seventh rectangle in the current graphics state (has no transformation)
        document.fill(shape);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Close current page
        document.closePage();

        //Save the document
        document.save();
	 }
}
