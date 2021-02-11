package ru.isibagatullin.toPDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


import java.io.*;

public class DocxToPDFConverter {

	public void ConvertDocxToPDF(String docPath, String pdfPath) throws DocumentException, IOException {
		try {
			InputStream doc = new FileInputStream(new File(docPath));
			XWPFDocument document = new XWPFDocument(doc);
			PdfOptions options = PdfOptions.create();
			OutputStream out = new FileOutputStream(new File(pdfPath));
			PdfConverter.getInstance().convert(document, out, options);
		} catch (Exception ex) {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(pdfPath));

			document.open();
			final BaseFont bf = BaseFont.createFont("c:\\Windows\\Fonts\\tahoma.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

			//Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.RED);
			Font font = new Font(bf, 16,0, BaseColor.RED);
			document.add(new Paragraph("Ошибка преобразования файла в pdf. ", font));
			document.add(new Paragraph(ex.toString(), font));
			document.add(new Paragraph("Обратитесь к разработчику приложения!", font));
			document.close();
		}
	}

}
