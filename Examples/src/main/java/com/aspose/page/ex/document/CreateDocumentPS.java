package com.aspose.page.ex.document;

import java.io.FileOutputStream;

import com.aspose.eps.PageConstants;
import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.ex.utilities.Utils;

public class CreateDocumentPS {

	 public static void main(String[] args) throws Exception
	 { 
		//ExStart:AddText
	    // The path to the documents directory.
	    String dataDir = Utils.getDataDir();
	    
	    String FONTS_FOLDER = dataDir + "necessary_fonts/";
	    
	    //Create output stream for PostScript document
	    FileOutputStream outPsStream = new FileOutputStream(dataDir + "CreateDocument_outPS.ps");
	    //Create save options with A4 size
	    PsSaveOptions options = new PsSaveOptions();
	    
	    //If you want to aassign page size other than A4, set page size in options
        options.setPageSize(PageConstants.getSize(PageConstants.SIZE_A4, PageConstants.ORIENTATION_PORTRAIT));
        //If you want to aassign page margins other empty, set page margins in options
        options.setMargins(PageConstants.getMargins(PageConstants.MARGINS_ZERO));
        //If you plan to use fonts that located in non system folders, set additional fonts folders in options
        options.setAdditionalFontsFolders(new String[] { FONTS_FOLDER });

        //Set variable that indicates if resulting PostScript document will be multipaged
        boolean multiPaged = false;

        // Create new multipaged PS Document with one page opened
        PsDocument document = new PsDocument(outPsStream, options, multiPaged);

        //Close current page
        document.closePage();
        //Save the document
        document.save();
	 }
}
