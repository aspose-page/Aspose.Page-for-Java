/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aspose.page.text;

import com.aspose.page.utilities.Utils;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsFontStyle;
import com.aspose.xps.XpsGlyphs;
import com.aspose.xps.XpsSolidColorBrush;
import java.awt.Color;

public class AddText {
    
    public static void main(String[] args) throws Exception
    {   //ExStart:AddText
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Create new XPS Document
        XpsDocument doc = new XpsDocument();
        //Create a brush 
        XpsSolidColorBrush textFill = doc.createSolidColorBrush(Color.BLACK);
        //Add glyph to the document
        XpsGlyphs glyphs = doc.addGlyphs("Arial", 12, XpsFontStyle.Regular, 300f, 450f, "Hello World!");
        glyphs.setFill(textFill);
        // Save resultant XPS document
        doc.save(dataDir + "AddText_out.xps");
        //ExEnd:AddText
    }
}
