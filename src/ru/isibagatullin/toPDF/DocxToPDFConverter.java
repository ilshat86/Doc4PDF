package ru.isibagatullin.toPDF;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


import java.io.*;

public class DocxToPDFConverter {

	public void ConvertDocxToPDF(String docPath, String pdfPath) {
		try {
			InputStream doc = new FileInputStream(new File(docPath));
			XWPFDocument document = new XWPFDocument(doc);
			PdfOptions options = PdfOptions.create();
			OutputStream out = new FileOutputStream(new File(pdfPath));
			PdfConverter.getInstance().convert(document, out, options);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
