/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aspose.page.ex.transparency;
import java.awt.geom.Rectangle2D;

import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsCanvas;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsImageBrush;
import com.aspose.xps.XpsPath;
import com.aspose.xps.XpsTileMode;

public class SetOpacityMaskXPS {

    public static void main(String[] args) throws Exception
    {
        //ExStart:SetOpacityMask
    	
    	// Set license
  	  	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Create a new XPS document
        XpsDocument doc = new XpsDocument();
        // New canvas
        XpsCanvas canvas = doc.addCanvas();
        // Rectangle in the middle left with opacity masked by ImageBrush
        XpsPath path = canvas.addPath(doc.createPathGeometry("M 10,180 L 228,180 228,285 10,285"));
        path.setFill(doc.createSolidColorBrush(doc.createColor(1.0f, 0.0f, 0.0f)));
        path.setOpacityMask(doc.createImageBrush(dataDir +  "R08SY_NN.tif", 
                        new Rectangle2D.Float(0f, 0f, 128f, 192f),	new Rectangle2D.Float(0f, 0f, 64f, 96f)));
        ((XpsImageBrush)path.getOpacityMask()).setTileMode(XpsTileMode.Tile);
        // Save resultant XPS document
        doc.save(dataDir + "OpacityMask_out.xps");
        //ExEnd:SetOpacityMask
    }    
    
}
