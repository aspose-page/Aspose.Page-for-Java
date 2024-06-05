package com.aspose.page.ex.images;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.ImageMode;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsImageBrush;
import com.aspose.xps.XpsPath;
import com.aspose.xps.XpsTileMode;

public class UseImageUtilitiesXPS {
	public static void main(String[] args) throws Exception
	{ 
		// Set license
    	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
		//ExStart:UsingImageUtils
    	// For complete examples and data files, please go to https://github.com/aspose-page/Aspose.Page-for-Java
		// The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Create new XPS Document
        final XpsDocument doc = new XpsDocument();
        try {
        	// Set first page's size.
        	doc.getPage().setWidth(540f);
            doc.getPage().setHeight(220f);
            
            // Draw the image box.
            Rectangle2D imageBox = new Rectangle2D.Float(10f, 10f, 200f, 200f);
            XpsPath path = doc.addPath(doc.getUtils().createRectangle(imageBox));
            path.setStroke(doc.createSolidColorBrush(Color.BLACK));
            // Add an image to fit width.
            path = doc.getUtils().createImage(dataDir + "R08LN_NN.jpg", imageBox, ImageMode.FitToWidth);
            // Prevent tiling.
            ((XpsImageBrush)path.getFill()).setTileMode(XpsTileMode.None);
            doc.add(path);

            // Add an image to fit width.
            doc.add(doc.getUtils().createImage(
            		dataDir + "R08LN_NN.jpg", new Rectangle2D.Float(220f, 10f, 200f, 100f), ImageMode.FitToHeight));

            // Add an image to fit width.
            doc.add(doc.getUtils().createImage(
            		dataDir + "R08LN_NN.jpg", new Rectangle2D.Float(430f, 10f, 100f, 200f), ImageMode.FitToBox));

            // Save resultant XPS document 
            doc.save(dataDir + "UseImageUtilsXPS_out.xps");
        } finally {
        	if (doc != null)
        		doc.close();
        }
		//ExStart:UsingImageUtils
	 }
}
