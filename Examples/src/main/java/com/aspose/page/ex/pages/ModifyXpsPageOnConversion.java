package com.aspose.page.ex.pages;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.aspose.page.License;
import com.aspose.page.ex.BaseExamplesTest;
import com.aspose.page.ex.utilities.Utils;
import com.aspose.xps.XpsDocument;
import com.aspose.xps.XpsFont;
import com.aspose.xps.XpsGlyphs;
import com.aspose.xps.XpsPageLinkTarget;
import com.aspose.xps.features.EventBasedModifications.BeforePageSavingEventHandler;
import com.aspose.xps.features.EventBasedModifications.BeforeSavingEventArgs;
import com.aspose.xps.features.EventBasedModifications.PageAPI;
import com.aspose.xps.rendering.PdfSaveOptions;

public class ModifyXpsPageOnConversion {
	public static void main(String[] args) throws Exception
	{ 
		// Set license
    	new License().setLicense(BaseExamplesTest.LICENSE_PATH);
    	
    	// ExStart:ModifyingXpsPageOnConversion
    	// For complete examples and data files, please go to https://github.com/aspose-page/Aspose.Page-for-Java
        // The path to the documents directory.
    	String dataDir = Utils.getDataDir();
    	String fontDir = dataDir + "necessary_fonts/";
        // Open an XPS document
        final XpsDocument doc = new XpsDocument(dataDir + "Sample3.xps");
        try {
        	// Create a font
        	final InputStream fontStream = new FileInputStream(fontDir + "arialbd.ttf");
        	try {
        		// Create options for conversion to PDF
        		PdfSaveOptions options = new PdfSaveOptions();
        		// Set the filter for the pages that need conversion
        		options.setPageNumbers(new int[] { 2, 6, 7, 13 });
        		// Add the event handler that will execute right before the conversion of each page
        		options.getBeforePageSavingEventHandlers().add(new NavigationInjector(doc.createFont(fontStream), options.getPageNumbers()));
        		// Save resultant XPS document
        		doc.saveAsPdf(dataDir + "ModifyPageOnConversion_out.pdf", options);
        	} finally {
        		if (fontStream != null)
        			fontStream.close();
        	}
        } finally {
        	if (doc != null)
        		doc.close();
        }
        // ExEnd:ModifyingXpsPageOnConversion
	}
	
	// ExStart:OnXpsPageConversionEventHandler
	/**
	 * The class to handle the before-page event while converting an XPS document.
	 */
    public static class NavigationInjector extends BeforePageSavingEventHandler
    {
        private final XpsFont _font;
        private List<Integer> _pageNumbers;

        public NavigationInjector(XpsFont font, int[] pageNumbers)
        {
            _font = font;
            if (pageNumbers == null || pageNumbers.length == 0)
                return;
            
            // Turn the page number array into a sorted collection of unique values.
            SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for (int pn : pageNumbers)
                map.put(pn, 0);
            _pageNumbers = new ArrayList<Integer>(map.keySet());
        }

        /**
         * The action itself to be triggered on a before-page event.
         * @param args The even arguments.
         */
        @Override
        public void handle(BeforeSavingEventArgs<PageAPI> args)
        {
            PageAPI api = args.getElementAPI();

            XpsGlyphs glyphs;
            // For all pages in the output PDF except the first one...
            if (args.getOutputPageNumber() > 1)
            {
            	// ...insert a hyperlink to the first page...
                glyphs = api.createGlyphs(_font, 15f, 5f, api.getHeight() - 10f, "[First]");
                glyphs.setFill(api.createSolidColorBrush(Color.BLUE));
                glyphs.setHyperlinkTarget(new XpsPageLinkTarget(_pageNumbers == null ? 1 : _pageNumbers.get(0)));
                api.add(glyphs);

                // ...and to the previous page.
                glyphs = api.createGlyphs(_font, 15f, 60f, api.getHeight() - 10f, "[Prev]");
                glyphs.setFill(api.createSolidColorBrush(Color.BLUE));
                glyphs.setHyperlinkTarget(new XpsPageLinkTarget(
                		_pageNumbers == null ? args.getAbsolutePageNumber() - 1 : _pageNumbers.get(args.getOutputPageNumber() - 2)));
                api.add(glyphs);
            }

            // For all pages in the output PDF except the last one...
            if ((_pageNumbers != null && args.getOutputPageNumber() < _pageNumbers.size()) ||
            		(_pageNumbers == null && args.getOutputPageNumber() < api.getTotalPageCount()))
            {
            	// ...insert a hyperlink to the next page...
                glyphs = api.createGlyphs(_font, 15f, 110f, api.getHeight() - 10f, "[Next]");
                glyphs.setFill(api.createSolidColorBrush(Color.BLUE));
                glyphs.setHyperlinkTarget(new XpsPageLinkTarget(
                		_pageNumbers == null ? args.getAbsolutePageNumber() + 1 : _pageNumbers.get(args.getOutputPageNumber())));
                api.add(glyphs);

                // ...and to the last page.
                glyphs = api.createGlyphs(_font, 15f, 160f, api.getHeight() - 10f, "[Last]");
                glyphs.setFill(api.createSolidColorBrush(Color.BLUE));
                glyphs.setHyperlinkTarget(new XpsPageLinkTarget(
                		_pageNumbers == null ? api.getTotalPageCount() : _pageNumbers.get(_pageNumbers.size() - 1)));
                api.add(glyphs);
            }

            // Insert a page number in the bottom-right corner.
            glyphs = api.createGlyphs(_font, 15f, api.getWidth() - 20f, api.getHeight() - 10f, Integer.toString(args.getOutputPageNumber()));
            glyphs.setFill(api.createSolidColorBrush(Color.BLACK));
            api.add(glyphs);

            // Add an outline entry to display the links to the converted pages in the navigation pane of a PDF viewer.
            api.addOutlineEntry(MessageFormat.format("Page {0}", args.getOutputPageNumber()), 1, args.getAbsolutePageNumber());
        }
    }
    // ExEnd:OnXpsPageConversionEventHandler
}
