package com.aspose.page.ex.shapes;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsPath;

public class UseShapeUtilitiesXPS {
	public static void main(String[] args) throws Exception
	{ 
		// Set license
    	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
		//ExStart:UsingShapeUtils
    	// For complete examples and data files, please go to https://github.com/aspose-page/Aspose.Page-for-Java
		// The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Create new XPS Document
        final XpsDocument doc = new XpsDocument();
        try {
        	// Set first page's size.
            doc.getPage().setWidth(650f);
            doc.getPage().setHeight(240f);

            // Draw a circle with center (120, 120) and radius 100.
            XpsPath path = doc.createPath(doc.getUtils().createCircle(new Point2D.Float(120f, 120f), 100f));
            path.setFill(doc.createSolidColorBrush(Color.GREEN));
            doc.add(path);

            // Inscribe a regular pentagon in the circle.
            path = doc.createPath(doc.getUtils().createRegularInscribedNGon(5, new Point2D.Float(120f, 120f), 100f));
            path.setFill(doc.createSolidColorBrush(Color.RED));
            doc.add(path);

            // Circumscribe a regular hexagon around the circle.
            path = doc.createPath(doc.getUtils().createRegularCircumscribedNGon(6, new Point2D.Float(120f, 120f), 100f));
            path.setStroke(doc.createSolidColorBrush(Color.MAGENTA));
            path.setStrokeThickness(3f);
            doc.add(path);

            // Draw a sector of the circle centered at (340, 120), starting at -45 degrees and ending at +45 degrees.
            path = doc.createPath(doc.getUtils().createPieSlice(new Point2D.Float(340f, 120f), 100f, -45f, 45f));
            path.setStroke(doc.createSolidColorBrush(Color.RED));
            path.setStrokeThickness(5f);
            doc.add(path);

            // Draw a segment of the circle centered at (340, 120), starting at -45 degrees and ending at +45 degrees.
            path = doc.createPath(doc.getUtils().createCircularSegment(new Point2D.Float(340f, 120f), 100f, -45f, 45f));
            path.setFill(doc.createSolidColorBrush(Color.BLACK));
            doc.add(path);

            // Draw a rectangle with the top left vertex (530, 20), width 100 units and height 200 units.
            path = doc.createPath(doc.getUtils().createRectangle(new Rectangle2D.Float(530f, 20f, 100f, 200f)));
            path.setStroke(doc.createSolidColorBrush(Color.RED));
            doc.add(path);

            // Draw an ellipse with center (580, 120) and radii 50 and 100.
            path = doc.createPath(doc.getUtils().createEllipse(new Point2D.Float(580f, 120f), 50f, 100f));
            path.setFill(doc.createSolidColorBrush(Color.YELLOW));
            doc.add(path);

            doc.save(dataDir + "UseShapeUtilsXPS_out.xps");
        } finally {
        	if (doc != null)
        		doc.close();
        }
		//ExStart:UsingShapeUtils
	 }
}
