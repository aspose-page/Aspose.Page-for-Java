package com.aspose.page.eps;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.aspose.eps.PsDocument;
import com.aspose.page.utilities.Utils;

public class CropEps {
    
	public static void main(String[] args) throws Exception {
	  // ExStart:CropEps

      // The path to the documents directory.
      String dataDir = Utils.getDataDir();
      
      //Create an input stream for EPS file
      FileInputStream inputEpsStream = new FileInputStream(dataDir + "input.eps");
      
      //Initialize PsDocument object with input stream
      PsDocument doc = new PsDocument(inputEpsStream);
      
      //Get initial bounding box of EPS image
      int [] initialBoundingBox = doc.extractEpsBoundingBox();
      
      //Create output stream for PostScript document
      FileOutputStream outputEpsStream = new FileOutputStream(dataDir + "output_crop.eps");
      
      //Create new bounding box
      //Bounding box is represented by 4 numbers: x0, y0, x, y, where x0 - left margin, y0 - top margin, x - (x0 + width), y - (y0 + height)
      float[] newBoundingBox = new float[] { 260, 300, 480, 432 };
      
      //Crop EPS image and save to the output stream                   
      //Croping of image is changing of its bounding box so that new values of bounding box will be within initial bounding box, that is
      //initialBoundingBox[0] <= newBoundingBox[0] <= initialBoundingBox[2]
      //initialBoundingBox[1] <= newBoundingBox[1] <= initialBoundingBox[3]
      //initialBoundingBox[0] <= newBoundingBox[2] <= initialBoundingBox[2]
      //initialBoundingBox[1] <= newBoundingBox[3] <= initialBoundingBox[3]
      doc.cropEps(outputEpsStream, newBoundingBox);
      // ExEnd:CropEps
    }
}
