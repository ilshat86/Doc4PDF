package ru.isibagatullin.toPDF;

public class MainClass {

    public static void main(String[] args) throws Exception {
        MainClass cwoWord = new MainClass();
        for (int i = 0; i < args.length; i++) {
            String inputFile = args[i];
            String lowerCaseInPath = inputFile.toLowerCase();

            if (lowerCaseInPath.endsWith("doc")) {
//                String outputFile = inputFile.replace("doc", "pdf");
//                DocToPDFConverter docToPDFConverter = new DocToPDFConverter();
//                docToPDFConverter.ConvertDocToPDF(inputFile, outputFile);
            } else if (lowerCaseInPath.endsWith("docx")) {
                String outputFile = inputFile.replace("docx", "pdf");
                DocxToPDFConverter docxToPDFConverter = new DocxToPDFConverter();
                docxToPDFConverter.ConvertDocxToPDF(inputFile, outputFile);
            } else if (lowerCaseInPath.endsWith("ppt")) {
                //  cwoWord.ConvertDocToPDF(inputFile, outputFile);
            } else if (lowerCaseInPath.endsWith("pptx")) {
                // cwoWord.ConvertDocToPDF(inputFile, outputFile);
            } else if (lowerCaseInPath.endsWith("tiff")) {
                String outputFile = inputFile.replace("tiff", "pdf");
                TiffToPDF tiffToPDFConverter = new TiffToPDF();
                tiffToPDFConverter.ConvertTiffToPDF(inputFile, outputFile);
            } else if (lowerCaseInPath.endsWith("tif")) {
                String outputFile = inputFile.replace("tif", "pdf");
                TiffToPDF tiffToPDFConverter = new TiffToPDF();
                tiffToPDFConverter.ConvertTiffToPDF(inputFile, outputFile);
            } else if (lowerCaseInPath.endsWith("odt")) {
                String outputFile = inputFile.replace("odt", "pdf");
                OdtToPDF odtToPDF = new OdtToPDF();
                odtToPDF.ConvertOdtToPDF(inputFile, outputFile);
            } else {
            }
        }
    }
}