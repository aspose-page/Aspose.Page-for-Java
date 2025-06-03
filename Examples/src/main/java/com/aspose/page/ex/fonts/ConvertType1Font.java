package com.aspose.page.ex.fonts;

import com.aspose.eps.PsDocument;
import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;

public class ConvertType1Font {
    
	public static void main(String[] args) throws Exception {
	  // ExStart:ConvertType1Font

	  // Set license
	  new License().setLicense(BaseExamplesTest.LICENSE_PATH);
		
	  // The path to the documents directory.
      String dataDir = Utils.getDataDir();
      
      //Create new PsDocument object with
      PsDocument doc = new PsDocument();
      
      //Convert Type1 font from the file 'Type1_Arial_Bold.ps' to TTF font in dataDir folder.
      //Extension of file can be ".pfa", ".pfb", ".ps" or something else. The main thing is that there is a font Type1 inside.
      doc.convertType1FontToTTF(dataDir + "Type1_Arial_Bold.ps", dataDir);
      
      // ExEnd:ConvertType1Font
    }
}
