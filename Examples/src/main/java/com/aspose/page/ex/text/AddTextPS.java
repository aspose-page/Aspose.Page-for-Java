package com.aspose.page.ex.text;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;
import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.ExternalFontCache;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.page.font.DrFont;

public class AddTextPS {
    
    public static void main(String[] args) throws Exception
    {   
    	//ExStart:AddText
    	
    	// Set license
  	  	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        String FONTS_FOLDER = dataDir + "necessary_fonts/";
        
        //Create output stream for PostScript document
        FileOutputStream outPsStream = new FileOutputStream(dataDir + "AddText_outPS.ps");
        //Create save options with A4 size
        PsSaveOptions options = new PsSaveOptions();
        // Set custom fonts folder. It will be added to system fonts folders for finding needed font.
        options.setAdditionalFontsFolders(new String[] { FONTS_FOLDER });
        //A text to write to PS file
        String str = "ABCDEFGHIJKLMNO";
        int fontSize = 48;

        // Create new 1-paged PS Document
        PsDocument document = new PsDocument(outPsStream, options, false);
        
		//////////////////////////////////////Using sysem font (located in system fonts folders) for filling text //////////////////
		Font font = new Font("Times New Roman", Font.BOLD, fontSize);
		//Fill text with default or already defined color. In given case it is black.
		document.fillText(str, font, 50, 100);
		//Fill text with Blue color.
		document.fillText(str, font, 50, 150, Color.BLUE);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
		//////////////////////////////////////Using custom font (located in custom fonts folders) for filling text /////////////////
		DrFont drFont = ExternalFontCache.fetchDrFont("Palatino Linotype", fontSize, Font.PLAIN);
		//Fill text with default or already defined color. In given case it is black.
		document.fillText(str, drFont, 50, 200);
		//Fill text with Blue color.
		document.fillText(str, drFont, 50, 250, Color.BLUE);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Create stroke with width 2 points.
		Stroke stroke = new BasicStroke(2);
		Color strokeColor = new Color(138, 43, 226);
		
		//////////////////////////////////////Using sysem font (located in system fonts folders) for outlining text ////////////////
		//Outline text with default or already defined pen. In given case it is black colored 1-points width pen.
		document.outlineText(str, font, 50, 300);
		
		//Outline text with blue-violet colored 2-points width pen.
		document.outlineText(str, font, 50, 350, strokeColor, stroke);
		//Fill text with orange color and stroke with blue colored 2-points width pen.
		document.fillAndStrokeText(str, font, 50, 400, Color.YELLOW, strokeColor, stroke);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//////////////////////////////////////Using custom font (located in custom fonts folders) for outlining text /////////////////
		//Outline text with default or already defined pen. In given case it is black colored 1-points width pen.
		document.outlineText(str, drFont, 50, 450);
		//Outline text with blue-violet colored 2-points width pen.
		document.outlineText(str, drFont, 50, 500, strokeColor, stroke);
		//Fill text with orange color and stroke with blue colored 2-points width pen.
		document.fillAndStrokeText(str, drFont, 50, 550, Color.ORANGE, Color.BLUE, stroke);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/////////////////////////////// Using custom font (located in custom fonts folders) ang glyphs widths for filling text ////////
		drFont = ExternalFontCache.fetchDrFont("Palatino Linotype", fontSize, Font.PLAIN);
		//Glyphs widths
		float[] widths = new float[] { 87, 87, 87, 87, 34, 87, 87 };
		//Fill ASCII text using with assigning glyphs widths.
		document.fillText("BAMBOOK", widths, drFont, 50, 600, Color.BLUE);
		///////////////////////////// Using custom font (located in custom fonts folders) ang glyphs widths for filling unicode text //
		drFont = ExternalFontCache.fetchDrFont("Times New Roman", fontSize, Font.BOLD);
		widths = new float[] { 87, 34, 87, 87, 87, 87, 87 };
		//Fill Unicode text using with assigning glyphs widths.
		document.fillText("ЗООПАРК", widths, drFont, 50, 650, Color.ORANGE);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
		//Close current page
        document.closePage();

        //Save the document
        document.save();
        
        //ExEnd:AddText
    }
}
