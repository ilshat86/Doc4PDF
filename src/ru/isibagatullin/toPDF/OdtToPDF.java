package ru.isibagatullin.toPDF;

import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
import org.odftoolkit.odfdom.doc.OdfTextDocument;

import java.io.*;


public class OdtToPDF {

	public void ConvertOdtToPDF(String docPath, String pdfPath) throws Exception {
		try {
			InputStream doc = new FileInputStream(new File(docPath));
			OdfTextDocument document = OdfTextDocument.loadDocument(doc);

			FileOutputStream outStream = new FileOutputStream(new File(pdfPath));
			PdfOptions options = PdfOptions.create();
			PdfConverter.getInstance().convert(document, outStream, options);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
