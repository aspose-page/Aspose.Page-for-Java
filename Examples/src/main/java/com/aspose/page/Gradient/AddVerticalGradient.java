/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aspose.page.Gradient;

import com.aspose.page.utilities.Utils;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsGradientBrush;
import com.aspose.xps.XpsGradientStop;
import com.aspose.xps.XpsPath;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class AddVerticalGradient {
    
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        //ExStart:VerticalGradient
        //Initialize document
        XpsDocument doc = new XpsDocument();
        XpsPath path = doc.addPath(doc.createPathGeometry("M 30,20 l 258.24,0 0,56.64 -258.24,0 Z"));

        // Vertical gradient
        List<XpsGradientStop> stops = new LinkedList<XpsGradientStop>();
 
        // Vertical gradient bellow
        stops.add(doc.createGradientStop(doc.createColor(253, 255, 12, 0), 0f));
        stops.add(doc.createGradientStop(doc.createColor(252, 255, 154, 0), 0.359375f));
        stops.add(doc.createGradientStop(doc.createColor(252, 255, 56, 0), 0.424805f));
        stops.add(doc.createGradientStop(doc.createColor(253, 255, 229, 0), 0.879883f));
        stops.add(doc.createGradientStop(doc.createColor(252, 255, 255, 234), 1f));

        path = doc.addPath(doc.createPathGeometry("M 10,110 L 228,110 228,200 10,200"));
        path.setRenderTransform(doc.createMatrix(1f, 0f, 0f, 1f, 20f, 70f));
        path.setFill(doc.createLinearGradientBrush(new Point2D.Float(10f, 110f), new Point2D.Float(10f, 200f)));
        ((XpsGradientBrush)path.getFill()).getGradientStops().addAll(stops);
        stops.clear();
        
        doc.save(dataDir + "VrticalGradient.xps");
        //ExEnd:VerticalGradient
}
}