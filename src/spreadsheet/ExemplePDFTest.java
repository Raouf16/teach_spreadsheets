package spreadsheet;

 
 
import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
 
 
public class ExemplePDFTest{
 
    public static void main(String[] args) throws DocumentException, IOException {
 
    	// Define the size of the pages
        Rectangle pagesize = new Rectangle(216f, 720f);
        Document document = new Document(pagesize, 36f, 72f, 108f, 180f);
        // Create a  PDF file
        PdfWriter.getInstance(document, new FileOutputStream("java.pdf"));
        // open the file
        document.open();
        // writing in the file 
        document.add(new Paragraph("FICHE DE SERVICE 2016-2017"));
        
        // to close the file
        document.close();
    }
    
}
