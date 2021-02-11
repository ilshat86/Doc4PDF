package ru.isibagatullin.toPDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.codec.TiffImage;
import java.io.FileOutputStream;

import com.itextpdf.text.pdf.PdfWriter;

public class TiffToPDF {

    public void ConvertTiffToPDF(String docPath, String pdfPath) throws Exception {

        try{
            //Read the Tiff File
            RandomAccessFileOrArray myTiffFile=new RandomAccessFileOrArray(docPath);
            //Find number of images in Tiff file
            int numberOfPages=TiffImage.getNumberOfPages(myTiffFile);
            Document TifftoPDF=new Document();
            PdfWriter.getInstance(TifftoPDF, new FileOutputStream(pdfPath));
            TifftoPDF.open();
            Image tempImage;
            for (int i = 1; i <= numberOfPages; i++) {
                tempImage = TiffImage.getTiffImage(myTiffFile, i);
                Rectangle pageSize = new Rectangle(tempImage.getWidth()+20, tempImage.getHeight()+20) ;
                TifftoPDF.setPageSize(pageSize);
                TifftoPDF.newPage();
                TifftoPDF.add(tempImage);
            }
            TifftoPDF.close();
        }
        catch (Exception i1){
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));

            document.open();
            final BaseFont bf = BaseFont.createFont("c:\\Windows\\Fonts\\tahoma.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            //Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.RED);
            Font font = new Font(bf, 16,0, BaseColor.RED);
            document.add(new Paragraph("Ошибка преобразования файла в pdf. ", font));
            document.add(new Paragraph(i1.toString(), font));
            document.add(new Paragraph("Обратитесь к разработчику приложения!", font));
            document.close();
        }
    }
}
