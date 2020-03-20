package ru.isibagatullin.toPDF;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.codec.TiffImage;
import java.io.FileOutputStream;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;

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
            i1.printStackTrace();
        }
    }
}
