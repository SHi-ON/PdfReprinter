import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PdfReprinter {

    public static void main(String[] args) {
        try {
            String inputFile = "input.pdf";
            String outputFile = "output.pdf";

            Document document = new Document();
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(outputFile));
            document.open();

            PdfReader reader = new PdfReader(inputFile);
            int n = reader.getNumberOfPages();

            for (int page = 0; page < n; ) {
                PdfImportedPage importedPage = copy.getImportedPage(reader, ++page);
                copy.addPage(importedPage);
            }

            document.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
