package ru.isibagatullin.toPDF;

import org.docx4j.Docx4J;
import org.docx4j.convert.in.Doc;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.*;


public class DocToPDFConverter {

	public void ConvertDocToPDF(String docPath, String pdfPath) throws Exception{
		try {
			InputStream iStream = new FileInputStream(new File(docPath));
			WordprocessingMLPackage wordMLPackage = getMLPackage(iStream);
			FileOutputStream outStream = new FileOutputStream(new File(pdfPath));
			Docx4J.toPDF(wordMLPackage, outStream);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	protected WordprocessingMLPackage getMLPackage(InputStream iStream) throws Exception{
		PrintStream originalStdout = System.out;

		//Disable stdout temporarily as Doc convert produces alot of output
		System.setOut(new PrintStream(new OutputStream() {
			public void write(int b) {
				//DO NOTHING
			}
		}));

		WordprocessingMLPackage mlPackage = Doc.convert(iStream);

		System.setOut(originalStdout);
		return mlPackage;
	}
}
