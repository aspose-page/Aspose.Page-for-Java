/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aspose.page.ex.transparency;

import java.awt.Color;

import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsPath;

public class AddTransparentObjectXPS {
    
    public static void main(String[] args) throws Exception
    {
        //ExStart:TransparentObject
    	
    	// Set license
  	  	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Initialize document
        XpsDocument doc = new XpsDocument();
        // Just to demonstrate transparency
        doc.addPath(doc.createPathGeometry("M120,0 H400 v1000 H120")).setFill(doc.createSolidColorBrush(Color.GRAY));
        doc.addPath(doc.createPathGeometry("M300,120 h600 V420 h-600")).setFill(doc.createSolidColorBrush(Color.GRAY));

        // Create path with closed rectangle geometry
        XpsPath path1 = doc.createPath(doc.createPathGeometry("M20,20 h200 v200 h-200 z"));
        // Set blue solid brush to fill path1
        path1.setFill(doc.createSolidColorBrush(Color.BLUE));
        // Add it to the current page
        XpsPath path2 = doc.add(path1);

        // path1 and path2 are the same as soon as path1 hasn't been placed inside any other element
        // (which means that path1 had no parent element).
        // Because of that rectangle's color on the page effectively turns to green
        path2.setFill(doc.createSolidColorBrush(Color.GREEN));

        // Now add path2 once again. Now path2 has parent. So path3 won't be the same as path2.
        // Thus a new rectangle is painted on the page ...
        XpsPath path3 = doc.add(path2);
        // ... and we shift it 300 units lower ...
        path3.setRenderTransform(doc.createMatrix(1, 0, 0, 1, 0, 300));
        // ... and set red solid brush to fill it
        path3.setFill(doc.createSolidColorBrush(Color.RED));

        // Create new path4 with path2's geometry ...
        XpsPath path4 = doc.addPath(path2.getData());
        // ... shift it 300 units to the right ...
        path4.setRenderTransform(doc.createMatrix(1, 0, 0, 1, 300, 0));
        // ... and set blue solid fill
        path4.setFill(doc.createSolidColorBrush(Color.BLUE));

        // Add path4 once again.
        XpsPath path5 = doc.add(path4);
        // path4 and path5 are not the same again ...
        // (move path5 300 units lower)
        path5.setRenderTransform(path5.getRenderTransform().deepClone()); // to disconnect RenderTransform value from path4 (see next comment about Fill property)
        path5.getRenderTransform().translate(0, 300);
        // ... but if we set the opacity of Fill property, it will take effect on both path5 and path4
        // because brush is a complex property value which remains the same for path5 and path4
        path5.getFill().setOpacity(0.8f);

        // Create new path6 with path2's geometry ...
        XpsPath path6 = doc.addPath(path2.getData());
        // ... shift it 600 units to the right ...
        path6.setRenderTransform(doc.createMatrix(1, 0, 0, 1, 600, 0));
        // ... and set yellow solid fill
        path6.setFill(doc.createSolidColorBrush(Color.YELLOW));

        // Now add path6's clone ...
        XpsPath path7 = doc.add(path6.deepClone());
        // (move path5 300 units lower)
        path7.setRenderTransform(path7.getRenderTransform().deepClone());
        path7.getRenderTransform().translate(0, 300);
        // ... and set opacity for path7
        path7.getFill().setOpacity(0.8f);
        // Now opacity effects independently as soon as property values are cloned along with the element

        // The following code block is equivalent to the previous one.
        // Add path6 itself. path6 and path7 are not the same. Although their Fill property values are the same 
        //XpsPath path7 = doc.Add(path6);
        //path7.RenderTransform = path7.RenderTransform.Clone();
        //path7.RenderTransform.Translate(0, 300);
        // To "disconnect" path7's Fill property from path6's Fill property reassign it to its clone (or path6's Fill clone)
        //path7.Fill = ((XpsSolidColorBrush)path7.Fill).Clone();
        //path7.Fill.Opacity = 0.8f;

        doc.save(dataDir + "WorkingWithTransparency_out.xps");
        //ExEnd:TransparentObject
    }
}
