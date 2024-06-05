package com.aspose.page.ex.printtickets;

import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.metadata.Duplex;
import com.aspose.xps.metadata.InputBin;
import com.aspose.xps.metadata.JobDuplexAllDocumentsContiguously;
import com.aspose.xps.metadata.JobInputBin;
import com.aspose.xps.metadata.JobOutputBin;
import com.aspose.xps.metadata.JobPrintTicket;
import com.aspose.xps.metadata.OutputBin;
import com.aspose.xps.metadata.PageOrientation;
import com.aspose.xps.metadata.PageOutputColor;

public class CreateCustomPrintTicket {
	public static void main(String[] args) throws Exception
	{ 
		// Set license
    	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
		//ExStart:CreateCustomPrintTicket
    	// For complete examples and data files, please go to https://github.com/aspose-page/Aspose.Page-for-Java
		// The path to the documents directory.
        String dataDir = Utils.getDataDir();
        
        // Create new XPS document
        final XpsDocument document = new XpsDocument();
        try {
            // Set a custom job-level print ticket
            document.setJobPrintTicket(new JobPrintTicket(
                // Specify input bin.
                new JobInputBin(InputBin.InputBinOption.Manual.clone().add(
                    InputBin.FeedFace.FaceDown, InputBin.FeedDirection.LongEdgeFirst, new InputBin.MediaSheetCapacity(100))),
                // Specify output bin.
                new JobOutputBin(new OutputBin.OutputBinOption(OutputBin.BinType.Sorter),
                    new OutputBin.OutputBinOption(OutputBin.BinType.Stacker, new OutputBin.MediaSheetCapacity(100))),
                // Specify page orientation.
                new PageOrientation(PageOrientation.PageOrientationOption.Landscape),
                // Specify duplex mode fof the output.
                new JobDuplexAllDocumentsContiguously(Duplex.DuplexOption.twoSidedLongEdge(Duplex.DuplexMode.Automatic)),
                // Specify the color settings for the output.
                new PageOutputColor(PageOutputColor.PageOutputColorOption.Grayscale(0, 8))));

            // Save the document with the custom job-level print ticket.
            document.save(dataDir + "output1.xps");
        } finally {
        	if (document != null)
        		document.close();
        }
        //ExEnd:CreateCustomPrintTicket
	}
}
