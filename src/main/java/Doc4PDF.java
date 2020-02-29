import java.io.*;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Doc4PDF {
    public static void main(String[] args) {
        Doc4PDF cwoWord = new Doc4PDF();

        for (int i=0; i<args.length;  i++) {
            String inputFile = args[i];
            String outputFile = inputFile.replace("docx", "pdf");
            cwoWord.ConvertToPDF(inputFile, outputFile);
        }
    }

    public void ConvertToPDF(String docPath, String pdfPath) {
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