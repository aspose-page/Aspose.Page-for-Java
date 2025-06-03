package com.aspose.page.ex.eps;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.page.DimensionF;
import com.aspose.page.License;
import com.aspose.page.Units;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;

public class ResizeEps {
    
	private void runPoints() throws Exception {
	  // ExStart:ResizeEpsPoints
		
	  // Set license
	  new License().setLicense(BaseExamplesTest.LICENSE_PATH);
		
      // The path to the documents directory.
      String dataDir = Utils.getDataDir();
      
      //Create an input stream for EPS file
      FileInputStream inputEpsStream = new FileInputStream(dataDir + "input.eps");
      
      //Initialize PsDocument object with input stream
      PsDocument doc = new PsDocument(inputEpsStream);

      //Get size of EPS image
      Dimension oldSize = doc.extractEpsSize();
      
      //Create output stream for PostScript document
      FileOutputStream outputEpsStream = new FileOutputStream(dataDir + "output_resize_points.eps");
      
      //Increase EPS size in 2 times and save to the output stream
      doc.resizeEps(outputEpsStream, new DimensionF(oldSize.width * 2, oldSize.height * 2), Units.Points);
      // ExEnd:ResizeEpsPoints
	}
	
	private void runInches() throws Exception {
	  // ExStart:ResizeEpsInches

      // The path to the documents directory.
      String dataDir = Utils.getDataDir();
      
      //Create an input stream for EPS file
      FileInputStream inputEpsStream = new FileInputStream(dataDir + "input.eps");
      
      //Initialize PsDocument object with input stream
      PsDocument doc = new PsDocument(inputEpsStream);

      //Get size of EPS image
      //Dimension oldSize = doc.extractEpsSize();
      
      //Create output stream for PostScript document
      FileOutputStream outputEpsStream = new FileOutputStream(dataDir + "output_resize_inches.eps");
      
      //Save EPS to the output stream with new size assigned in inches
      doc.resizeEps(outputEpsStream, new DimensionF(5.791f, 3.625f), Units.Inches);
      // ExEnd:ResizeEpsInches
	}
	
	private void runMms() throws Exception {
	  // ExStart:ResizeEpsMillimeters

      // The path to the documents directory.
      String dataDir = Utils.getDataDir();
      
      //Create an input stream for EPS file
      FileInputStream inputEpsStream = new FileInputStream(dataDir + "input.eps");
      
      //Initialize PsDocument object with input stream
      PsDocument doc = new PsDocument(inputEpsStream);
      
      //Create output stream for PostScript document
      FileOutputStream outputEpsStream = new FileOutputStream(dataDir + "output_resize_mms.eps");
      
      //Save EPS to the output stream with new size assigned in millimeters
      doc.resizeEps(outputEpsStream, new DimensionF(196, 123), Units.Millimeters);
      // ExEnd:ResizeEpsMillimeters
	}
	
	private void runPercents() throws Exception {
	  // ExStart:ResizeEpsPercents

      // The path to the documents directory.
      String dataDir = Utils.getDataDir();
      
      //Create an input stream for EPS file
      FileInputStream inputEpsStream = new FileInputStream(dataDir + "input.eps");
      
      //Initialize PsDocument object with input stream
      PsDocument doc = new PsDocument(inputEpsStream);
      
      //Create output stream for PostScript document
      FileOutputStream outputEpsStream = new FileOutputStream(dataDir + "output_resize_percents.eps");
      
      //Save EPS to the output stream with new size assigned in percents
      doc.resizeEps(outputEpsStream, new DimensionF(200, 200), Units.Percents);
      // ExEnd:ResizeEpsPercents
	}
	
	
	public static void main(String[] args) throws Exception {
		ResizeEps ex = new ResizeEps();
		
		ex.runPoints();
		ex.runInches();
		ex.runMms();
		ex.runPercents();
    }
}
