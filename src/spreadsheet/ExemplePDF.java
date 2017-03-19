package spreadsheet;





import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 


public class ExemplePDF{
	public Document createPDF()throws DocumentException, FileNotFoundException{
		// define rectangle sizes
		Rectangle pagesize = new Rectangle(500f, 720f);
        Document document = new Document(pagesize, 36f, 72f, 108f, 180f);
        // Create the pdf file
        PdfWriter.getInstance(document, new FileOutputStream("fr.pdf"));
        // open then file
        document.open();
        return document;
	}
 
    public static void main(String[] args)
         throws DocumentException, IOException {
        ExemplePDF pdf=new ExemplePDF();
    	Document document=pdf.createPDF();
        
        // writing in the pdf file
        Paragraph paragraph=new Paragraph("FICHE DE SERVICE 2016-2017");
      //special font sizes
        Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 8, Font.BOLD, new BaseColor(0, 0, 0)); 
        //Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 
        document.addAuthor("Lynda");
        document.addCreationDate();
        document.addProducer();
        document.addCreator("MySampleCode.com");
        document.addTitle("Report with Column Headings");
        document.setPageSize(PageSize.LETTER);
        
        
      //specify column widths
        float[] columnWidths = {200f, 500f,200f,200f};
        //create PDF table with the given widths
        PdfPTable table = new PdfPTable(columnWidths);
        // set table width a percentage of the page width
        table.setWidthPercentage(100f);
      
        //insert column headings
        pdf.insertCell(table, "ANNEE", Element.ALIGN_RIGHT, 1, bfBold12);
        pdf.insertCell(table, "ENSEIGNEMENTS", Element.ALIGN_LEFT, 1, bfBold12);
        pdf.insertCell(table, "TYPE", Element.ALIGN_LEFT, 1, bfBold12);
       pdf.insertCell(table, "NbrH", Element.ALIGN_RIGHT, 1, bfBold12);
      for(int i=0;i<3;i++){
    	  
       	//insert an empty row
       	   pdf.insertCell(table, "", Element.ALIGN_LEFT, 4, bfBold12);
       	   //create section heading by cell merging
       	   pdf.insertCell(table, "", Element.ALIGN_LEFT, 4, bfBold12);
       	   //double orderTotal, total = 0;
      }
  	paragraph.add(table);
        document.add(paragraph);
        // close the file
        document.close();
        
    }
   
    private void insertCell(PdfPTable table, String text, int align, int colspan, Font font){
    	   
    	  //create a new cell with the specified Text and Font
    	  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
    	  //set the cell alignment
    	  cell.setHorizontalAlignment(align);
    	  //set the cell column span in case you want to merge two or more cells
    	  cell.setColspan(colspan);
    	  //in case there is no text and you wan to create an empty row
    	  if(text.trim().equalsIgnoreCase("")){
    	   cell.setMinimumHeight(10f);
    	  }
    	  //add the call to the table
    	  table.addCell(cell);
    	   
    	 }
}
