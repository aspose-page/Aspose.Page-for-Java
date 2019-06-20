package com.aspose.page.images;
import com.aspose.page.utilities.Utils;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsPath;
import java.awt.geom.Rectangle2D;

public class AddImage {
        /**
     * The main entry point for the application.
     */
    public static void main(String[] args) throws Exception
    {       
        // ExStart:AddImage
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Create new XPS Document
        XpsDocument doc = new XpsDocument();
        // Add Image
        XpsPath path = doc.addPath(doc.createPathGeometry("M 30,20 l 258.24,0 0,56.64 -258.24,0 Z"));
        // Creating a matrix is optional, it can be used for proper positioning
        path.setRenderTransform(doc.createMatrix(0.7f, 0f, 0f, 0.7f, 0f, 20f));
        // Create Image Brush
        path.setFill(doc.createImageBrush(dataDir + "QL_logo_color.tif", new Rectangle2D.Double(0f, 0f, 258.24f, 56.64f), new Rectangle2D.Double(50f, 20f, 193.68f, 42.48f)));
        // Save resultant XPS document
        doc.save(dataDir + "AddImage_out.xps");
        //ExEnd:AddImage   
        
    }
}
