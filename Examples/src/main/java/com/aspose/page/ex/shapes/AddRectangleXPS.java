/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.page.ex.shapes;

import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsPath;

public class AddRectangleXPS {
    
    public static void main(String[] args) throws Exception
    {   //ExStart:AddRectangle
    	
    	// Set license
  	  	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Create new XPS Document
        XpsDocument doc = new XpsDocument();
        // CMYK (blue) solid color stroked rectangle in the lower left
        XpsPath path = doc.addPath(doc.createPathGeometry("M 20,10 L 220,10 220,100 20,100 Z"));
        path.setStroke(doc.createSolidColorBrush(
            doc.createColor(dataDir + "uswebuncoated.icc", 1.0f, 1.000f, 0.000f, 0.000f, 0.000f)));
        path.setStrokeThickness(12f);
        // Save resultant XPS document
        doc.save(dataDir + "AddRectangle_out.xps");
        //ExEnd:AddRectangle
    }

    
}
