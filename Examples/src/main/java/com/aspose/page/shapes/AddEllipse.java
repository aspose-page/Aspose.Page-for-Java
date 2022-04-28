/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aspose.page.shapes;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import com.aspose.page.utilities.Utils;
import com.aspose.xps.XpsCanvas;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsGradientBrush;
import com.aspose.xps.XpsGradientStop;
import com.aspose.xps.XpsPath;
import com.aspose.xps.XpsPathGeometry;
import com.aspose.xps.XpsSpreadMethod;

public class AddEllipse {
    
    public static void main(String[] args) throws Exception
    {
        //ExStart:AddEllipse
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Create new XPS Document
        XpsDocument doc = new XpsDocument();
        // Radial gradient stroked ellipse in the lower left
        List<XpsGradientStop> stops = new LinkedList<XpsGradientStop>();

        // Radial gradient stroked ellipse in the lower left
        stops.add(doc.createGradientStop(doc.createColor(0, 0, 255), 0f));
        stops.add(doc.createGradientStop(doc.createColor(255, 0, 0), .25f));
        stops.add(doc.createGradientStop(doc.createColor(0, 255, 0), .5f));
        stops.add(doc.createGradientStop(doc.createColor(255, 255, 0), .75f));
        stops.add(doc.createGradientStop(doc.createColor(255, 0, 0), 1f));
        XpsPathGeometry pathGeometry = /*doc.addPath(*/doc.createPathGeometry("M 20,250 A 100,50 0 1 1 220,250 100,50 0 1 1 20,250");//);
        // New canvas
        XpsCanvas canvas = doc.addCanvas();
        XpsPath path = canvas.addPath(pathGeometry);
        path.setStroke(doc.createRadialGradientBrush(new Point2D.Float(575f, 125f), new Point2D.Float(575f, 100f), 75f, 50f));
        ((XpsGradientBrush)path.getStroke()).setSpreadMethod(XpsSpreadMethod.Reflect);
        ((XpsGradientBrush)path.getStroke()).getGradientStops().addAll(stops);
        stops.clear();
        path.setStrokeThickness(12f);
        // Save resultant XPS document
        doc.save(dataDir + "AddEllipse_out.xps");
        //ExEnd:AddEllipse
    }

    
}
