package com.aspose.page.ex.pages;

import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.eps.device.PsSaveOptions;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;

public class AddPages2PS {

	public static void main(String[] args) throws Exception
	{ 
		//ExStart:AddText
		
		// Set license
		new License().setLicense(BaseExamplesTest.LICENSE_PATH);
		
		// The path to the documents directory.
		String dataDir = Utils.getDataDir();
		
		//Create output stream for PostScript document
		FileOutputStream outPsStream = new FileOutputStream(dataDir + "AddPages2_outPS.ps");
		//Create save options with A4 size
		PsSaveOptions options = new PsSaveOptions();
		
		//Set variable that indicates if resulting PostScript document will be multipaged
        boolean multiPaged = true;

        // Create new multipaged PS Document with one page opened
        PsDocument document = new PsDocument(outPsStream, options, multiPaged);
		
        //Add content

        //Close the first page
        document.closePage();

        //Add the second page with the different size
        document.openPage(500, 300);

        //Add content
		
		//Close current page
		document.closePage();
		//Save the document
		document.save();
	 }
}
