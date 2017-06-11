package com.github.Raouf16.model.pdf.generate;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.github.Raouf16.model.main.Main;
import com.github.Raouf16.model.utils.teacher.Teacher;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.log4j;


public class GeneratePDF
{
	private final static Logger logger = Logger.getLogger(GeneratePDF.class);
	
	/**
	 * @author Lynda BOULILA, Katia SERSOUR, Haya COHEN
	 * 
	 */
	public Document createPDF(Teacher t)throws DocumentException, FileNotFoundException{
		
		// define rectangle sizes
		Rectangle pagesize = new Rectangle(500f, 720f);
        Document document = new Document(pagesize, 20f, 20f, 10f, 60f); 
        // Create the pdf file
        String pdfFileName = t.getFirstName()+"_"+t.getLastName()+"_FicheService.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(Main.canevasFolderPath+pdfFileName));
        // open then file
        document.open();
        logger.info("file opened");
        return document;
	}
 
	/**
	 * @author Raouf HADDAD
	 * Generate fiche de service without personal informations
	 */
public static void generateEmptyFS(Teacher teacher) throws DocumentException, IOException {
    	
        GeneratePDF pdf = new GeneratePDF();
    	Document document = pdf.createPDF(teacher);
    	logger.info("PDF created");
        
        // Set the Title 
    	//Font titre = new Font(FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
        Paragraph paragraph = new Paragraph("FICHE DE SERVICE 2016-2017");
        //paragraph.setAlignment(Element.ALIGN_CENTER);
        //paragraph.setFont(titre);
       
        //Font for paragraph writings
        Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 6, Font.BOLD, new BaseColor(0, 0, 0)); 
        
 
        // Set the Grid
        float[] columnWidths = {200f, 500f,200f,200f};
        PdfPTable table = new PdfPTable(columnWidths);
        // set table width a percentage of the page width
        table.setWidthPercentage(100f);
      
        //insert column headings
        pdf.insertCell(table, "ANNEE", Element.ALIGN_CENTER, 1, bfBold12);
        pdf.insertCell(table, "ENSEIGNEMENTS", Element.ALIGN_CENTER, 1, bfBold12);
        pdf.insertCell(table, "TYPE", Element.ALIGN_CENTER, 1, bfBold12);
        pdf.insertCell(table, "NbrH", Element.ALIGN_CENTER, 1, bfBold12);
        for(int i=0;i<18;i++){
    	  
       	//insert an empty row
       	   pdf.insertCell(table, "", Element.ALIGN_LEFT, 1, bfBold12);
       	   
       	   pdf.insertCell(table, "", Element.ALIGN_LEFT, 1, bfBold12);
       	   //double orderTotal, total = 0;
      }
       
      paragraph.add("\n\n\n CIV ");
      paragraph.add("                 NOM ");
      paragraph.add("                                        PRENOM");
      
      paragraph.add("\n");
     
      paragraph.add("");
      paragraph.add("                      ");
      paragraph.add(teacher.getLastName());
      paragraph.add("                                              ");
      paragraph.add(teacher.getFirstName());
      
      paragraph.add("\n\n");
      
      paragraph.add("                 STATUT ");
      paragraph.add("                                        DISCIPLINE");
      
      paragraph.add("\n\n");
      
      paragraph.add("                        ");
      if(teacher.getStatus() != null) paragraph.add(teacher.getStatus());
      paragraph.add("                                                  ");
      paragraph.add("");
      
      paragraph.add("\n\n");
      
      paragraph.add("                 EMAIL : ");
      if(teacher.getDauphineEmail() != null) paragraph.add(teacher.getDauphineEmail());
      
      paragraph.add("\n\n");
      
      paragraph.add("PORTABLE");
      paragraph.add("                 FIXE");
      paragraph.add("                                        POSTE");
      
      paragraph.add("\n");
      
      
  	paragraph.add(table);
        document.add(paragraph);
        // close the file
        document.close();
        
    }

		/**
		* @author Raouf HADDAD
		* Generate Fiche de service with personal informations
		*/
    public static void generateFullFS(Teacher teacher) throws DocumentException, IOException {
    	
        GeneratePDF pdf = new GeneratePDF();
    	Document document = pdf.createPDF(teacher);
    	logger.info("PDF with personnal information created");
        
        // Set the Title 
    	//Font titre = new Font(FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
        Paragraph paragraph = new Paragraph("FICHE DE SERVICE 2016-2017");
        //paragraph.setAlignment(Element.ALIGN_CENTER);
       // paragraph.setFont(titre);
       
        //Font for paragraph writings
        Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 6, Font.BOLD, new BaseColor(0, 0, 0)); 
        
 
        // Set the Grid
        float[] columnWidths = {200f, 500f,200f,200f};
        PdfPTable table = new PdfPTable(columnWidths);
        // set table width a percentage of the page width
        table.setWidthPercentage(100f);
      
        //insert column headings
        pdf.insertCell(table, "ANNEE", Element.ALIGN_CENTER, 1, bfBold12);
        pdf.insertCell(table, "ENSEIGNEMENTS", Element.ALIGN_CENTER, 1, bfBold12);
        pdf.insertCell(table, "TYPE", Element.ALIGN_CENTER, 1, bfBold12);
        pdf.insertCell(table, "NbrH", Element.ALIGN_CENTER, 1, bfBold12);
        for(int i=0;i<18;i++){
    	  
       	//insert an empty row
       	   pdf.insertCell(table, "", Element.ALIGN_LEFT, 1, bfBold12);
       	   
       	   pdf.insertCell(table, "", Element.ALIGN_LEFT, 1, bfBold12);
       	   //double orderTotal, total = 0;
      }
       
      paragraph.add("\n\n\n CIV ");
      paragraph.add("                 NOM ");
      paragraph.add("                                        PRENOM");
      
      paragraph.add("\n");
     
      paragraph.add("");
      paragraph.add("                      ");
      paragraph.add(teacher.getLastName());
      paragraph.add("                                              ");
      paragraph.add(teacher.getFirstName());
      
      paragraph.add("\n\n");
      
      paragraph.add("                 STATUT ");
      paragraph.add("                                        DISCIPLINE");
      
      paragraph.add("\n\n");
      
      paragraph.add("                        ");
      if(teacher.getStatus() != null) paragraph.add(teacher.getStatus());
      paragraph.add("                                                  ");
      paragraph.add("");
      
      paragraph.add("\n\n");
      
      paragraph.add("                 EMAIL : ");
      if(teacher.getDauphineEmail() != null) paragraph.add(teacher.getDauphineEmail());
      
      paragraph.add("\n\n");
      
      paragraph.add("PORTABLE");
      paragraph.add("                 FIXE");
      paragraph.add("                                        POSTE");
      
      paragraph.add("\n");
      
      if(teacher.getMobilePhone() != null) paragraph.add(teacher.getMobilePhone());
      paragraph.add("                              ");
      if(teacher.getPersonalPhone() != null) paragraph.add(teacher.getPersonalPhone());
      paragraph.add("                                             ");
      if(teacher.getOffice() != null) paragraph.add(teacher.getOffice());
      
  	paragraph.add(table);
        document.add(paragraph);
        // close the file
        document.close();
        logger.info("Document closed");
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
    	   cell.setMinimumHeight(30f);
    	  }
    	  //add the call to the table
    	  table.addCell(cell);
    	   
    	 }
}
