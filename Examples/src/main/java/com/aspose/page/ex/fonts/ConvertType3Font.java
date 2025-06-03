package com.aspose.page.ex.fonts;

import com.aspose.eps.PsDocument;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;

public class ConvertType3Font {
    
	public static void main(String[] args) throws Exception {
	  // ExStart:ConvertType13ont
	
	  // Set license
	  new License().setLicense(BaseExamplesTest.LICENSE_PATH);
	
      // The path to the documents directory.
      String dataDir = Utils.getDataDir();
      
      //Create new PsDocument object with
      PsDocument doc = new PsDocument();
      
      //Convert outline Type3 font from the file 'Type3_outline.ps' to TTF font in dataDir folder.
      //Exstension of file can be ".ps" or something else. The main thing is that there is a font Type3 inside.
      doc.convertType3FontToTTF(dataDir + "Type3_outline.ps", dataDir);
      
      //Convert bitmap Type3 font from the file 'Type3_bitmap.ps' to TTF font in dataDir folder.
      doc.convertType3FontToTTF(dataDir + "Type3_bitmap.ps", dataDir);
      
      // ExEnd:ConvertType3Font
    }
}
