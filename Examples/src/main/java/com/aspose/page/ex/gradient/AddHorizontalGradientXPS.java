/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aspose.page.ex.gradient;


import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsGradientBrush;
import com.aspose.xps.XpsGradientStop;
import com.aspose.xps.XpsPath;

public class AddHorizontalGradientXPS {
    public static void main(String[] args) throws Exception
    {
        //ExStart:HorizontalGradient
    	
    	// Set license
  	  	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        //Initialize document
        XpsDocument doc = new XpsDocument();
        
        // Horizontal gradient
        List<XpsGradientStop> stops = new LinkedList<XpsGradientStop>();
        stops.add(doc.createGradientStop(doc.createColor(255, 244, 253, 225), 0.0673828f));
        stops.add(doc.createGradientStop(doc.createColor(255, 251, 240, 23), 0.314453f));
        stops.add(doc.createGradientStop(doc.createColor(255, 252, 209, 0), 0.482422f));
        stops.add(doc.createGradientStop(doc.createColor(255, 241, 254, 161), 0.634766f));
        stops.add(doc.createGradientStop(doc.createColor(255, 53, 253, 255), 0.915039f));
        stops.add(doc.createGradientStop(doc.createColor(255, 12, 91, 248), 1f));

        XpsPath path = doc.addPath(doc.createPathGeometry("M 30,20 l 258.24,0 0,56.64 -258.24,0 Z"));
        path = doc.addPath(doc.createPathGeometry("M 10,210 L 228,210 228,300 10,300"));
        path.setRenderTransform(doc.createMatrix(1f, 0f, 0f, 1f, 20f, 70f));
        path.setFill(doc.createLinearGradientBrush(new Point2D.Float(10f, 0f), new Point2D.Float(228f, 0f)));
        ((XpsGradientBrush)path.getFill()).getGradientStops().addAll(stops);
        stops.clear();

        doc.save(dataDir + "HorizontalGradient.xps");    
        //ExEnd:HorizontalGradient
    }
}