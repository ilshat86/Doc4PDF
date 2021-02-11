package ru.isibagatullin.toPDF;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
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
