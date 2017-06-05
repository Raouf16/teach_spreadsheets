package com.github.Raouf16.model.spreadsheet.write;

import java.io.File;
import java.io.FileOutputStream;

import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import com.github.Raouf16.model.main.Main;
import com.github.Raouf16.model.utils.teacher.*;

/**
 * This class is to generate the "Fiche de service"
 * @author Raouf HADDAD
 */
public class GenerateFicheService {
	// Main to remove
	public static void main(String[] args) throws Exception{
		final SpreadsheetDocument spreadSheet = SpreadsheetDocument.loadDocument(Main.fileReadingData);
	 	
		File outputFile = new File(Main.canevasFolderPath+"TESTFICHESERVICE.ods");
        spreadSheet.save(outputFile);
        String pdfFileName = "_FSVide_PDF.pdf";
        

        OdfDocument document = OdfDocument.loadDocument(outputFile);
        PdfOptions options=null;
        PdfConverter.getInstance().convert(document,new FileOutputStream(Main.canevasFolderPath+pdfFileName),options);
	}
	public static void generateEmptyFS(Teacher t) throws Exception{
			
		try{
            // Load the file and sheet
		 	final SpreadsheetDocument spreadSheet = SpreadsheetDocument.loadDocument(Main.fileReadingData);
		 	final Table sheet = spreadSheet.getSheetByName("FService");
			 
	        
	        // Fill the Sheet
		 	
	        if(t.getFirstName() != null) sheet.getCellByPosition("H6").setDisplayText(t.getFirstName());
	        if(t.getLastName() != null) sheet.getCellByPosition("E6").setDisplayText(t.getLastName());
	        if(t.getStatus() != null) sheet.getCellByPosition("C10").setDisplayText(t.getStatus());
	        if(t.getDauphineEmail() != null) sheet.getCellByPosition("E13").setDisplayText(t.getDauphineEmail());
	        
	        
            // Save
	        String newFileName = t.getFirstName()+"_"+t.getLastName()+"_FicheServiceVide.ods";
            File outputFile = new File(Main.canevasFolderPath+newFileName);
            spreadSheet.save(outputFile);
            
            // Convert as PDF
            String pdfFileName = t.getFirstName()+"_"+t.getLastName()+"_FSVide_PDF.pdf";
            
            
            OdfDocument document = OdfDocument.loadDocument(outputFile);
            PdfOptions options=null;
            PdfConverter.getInstance().convert(document,new FileOutputStream(Main.canevasFolderPath+pdfFileName),options);
		}catch(NullPointerException e){
			System.out.println("Fichier source introuvable");
		} 
	}
	
	public static void generateFullFS(Teacher t) throws Exception
	{
		try{
			// Load the file and sheet
		 	final SpreadsheetDocument spreadSheet = SpreadsheetDocument.loadDocument(Main.fileReadingData);
		 	final Table sheet = spreadSheet.getSheetByName("FService");
		 
	        
	        // Fill the Sheet
		 	
	        if(t.getCity() != null) sheet.getCellByPosition("C6").setDisplayText(t.getCity());
	        if(t.getFirstName() != null) sheet.getCellByPosition("H6").setDisplayText(t.getFirstName());
	        if(t.getLastName() != null) sheet.getCellByPosition("E6").setDisplayText(t.getLastName());
	        if(t.getStatus() != null) sheet.getCellByPosition("C10").setDisplayText(t.getStatus());
	        if(t.getDauphineEmail() != null) sheet.getCellByPosition("E13").setDisplayText(t.getDauphineEmail());
	        if(t.getDauphinePhone() != null) sheet.getCellByPosition("F18").setDisplayText(t.getDauphinePhone());
	        if(t.getMobilePhone() != null) sheet.getCellByPosition("C18").setDisplayText(t.getMobilePhone());
	        if(t.getOffice() != null) sheet.getCellByPosition("H18").setDisplayText(t.getOffice());
	        sheet.getCellByPosition("F10").setDisplayText("N/A");
	        
	        // Save 
	        String newFileName = t.getFirstName()+"_"+t.getLastName()+"_FicheServiceRemplie.ods";
	        File outputFile = new File(Main.canevasFolderPath+newFileName);
	        spreadSheet.save(outputFile);
	        
	        // Convert as PDF
	        String pdfFileName = t.getFirstName()+"_"+t.getLastName()+"_FSRemplie_PDF.pdf";
	        
	        OdfDocument document = OdfDocument.loadDocument(outputFile);
	        PdfOptions options=null;
	        PdfConverter.getInstance().convert(document,new FileOutputStream(Main.canevasFolderPath+pdfFileName),options);
		}catch(NullPointerException e){
			System.out.println("Fichier source introuvable");
		} 
	}

}