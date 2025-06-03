/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aspose.page.ex.text;

import java.awt.Color;

import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsFontStyle;
import com.aspose.xps.XpsGlyphs;
import com.aspose.xps.XpsSolidColorBrush;

public class AddTextUsingUnicodeString {
    
    public static void main(String[] args) throws Exception
    {
        //ExStart:AddTextUsingUnicodeString
    	
    	// Set license
  	  	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Create new XPS Document
        XpsDocument doc = new XpsDocument();
        // Add Text
        XpsSolidColorBrush textFill = doc.createSolidColorBrush(Color.BLACK);
        XpsGlyphs glyphs = doc.addGlyphs("Arial", 20, XpsFontStyle.Regular, 400f, 200f, "AVAJ rof SPX.esopsA");
        glyphs.setBidiLevel(1);
        glyphs.setFill(textFill);
        // Save resultant XPS document
        doc.save(dataDir + "AddEncodingText_out.xps");
        //ExEnd:AddTextUsingUnicodeString
    }

    
}
