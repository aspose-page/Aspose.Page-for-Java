package com.aspose.page.ex.pages;

import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.ex.utilities.Utils;

public class AddPages1PS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "AddPages1_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		// Create new 2-paged PS Document
        PsDocument document = new PsDocument(outPsStream, options, 2);
		
        //Add the first page with the document's page size
        document.openPage(null);

        //Add content

        //Close the first page
        document.closePage();

        //Add the second page with the different size
        document.openPage(400, 700);

        //Add content
		
		//Close current page
		document.closePage();
		//Save the document
		document.save();
	 }
}
