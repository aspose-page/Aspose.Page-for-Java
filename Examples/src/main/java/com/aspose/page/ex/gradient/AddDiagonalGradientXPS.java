/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aspose.page.ex.gradient;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsGradientBrush;
import com.aspose.xps.XpsGradientStop;
import com.aspose.xps.XpsPath;


public class AddDiagonalGradientXPS {

    public static void main(String[] args) throws Exception
    {
        //ExStart:LinearGradient
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();


        XpsDocument doc = new XpsDocument();

        XpsPath path = doc.addPath(doc.createPathGeometry("M 30,20 l 258.24,0 0,56.64 -258.24,0 Z"));

        // Linear gradient
        List<XpsGradientStop> stops = new LinkedList<XpsGradientStop>();
        stops.add(doc.createGradientStop(doc.createColor(0, 142, 4), 0f));
        stops.add(doc.createGradientStop(doc.createColor(255, 202, 0), 0.144531f));
        stops.add(doc.createGradientStop(doc.createColor(255, 250, 0), 0.264648f));
        stops.add(doc.createGradientStop(doc.createColor(255, 0, 0), 0.414063f));
        stops.add(doc.createGradientStop(doc.createColor(233, 0, 255), 0.544922f));
        stops.add(doc.createGradientStop(doc.createColor(107, 27, 190), 0.694336f));
        stops.add(doc.createGradientStop(doc.createColor(63, 0, 255), 0.844727f));
        stops.add(doc.createGradientStop(doc.createColor(0, 199, 80), 1f));

        path = doc.addPath(doc.createPathGeometry("M 10,10 L 228,10 228,100 10,100"));
        path.setRenderTransform(doc.createMatrix(1f, 0f, 0f, 1f, 20f, 70f));
        path.setFill(doc.createLinearGradientBrush(new Point2D.Float(10f, 10f), new Point2D.Float(228f, 100f)));
        ((XpsGradientBrush)path.getFill()).getGradientStops().addAll(stops);
        stops.clear();

        doc.save(dataDir + "LinearGradient.xps");
        //ExEnd:LinearGradient

}
}
