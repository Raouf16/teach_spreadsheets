package com.github.Raouf16.model.utils.io.spreadsheet.write;

import java.io.File;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import com.github.Raouf16.model.main.Main;
import com.github.Raouf16.model.utils.io.pdf.*;
import com.github.Raouf16.model.utils.io.pdf.GeneratePDF;
import com.github.Raouf16.model.utils.teacher.*;

/**
 * This class is to generate the "Fiche de service"
 * @author Raouf HADDAD
 */
public class GenerateFicheService {
	
	public static void generateEmptyFS(Teacher t) throws Exception{
			
		try{
            // Load the file and sheet
		 	final SpreadsheetDocument spreadSheet = SpreadsheetDocument.loadDocument(Main.fileFicheService);
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
            GeneratePDF.generateEmptyFS(t);
            	}catch(NullPointerException e){
			System.out.println("Fichier source introuvable");
		} 
	}
	
	public static void generateFullFS(Teacher t) throws Exception
	{
		try{
			// Load the file and sheet
		 	final SpreadsheetDocument spreadSheet = SpreadsheetDocument.loadDocument(Main.fileFicheService);
		 	final Table sheet = spreadSheet.getSheetByName("FService");
		 
	        
	        // Fill the Sheet
		 	System.out.println("MAIL : "+t.getDauphineEmail()+" /");
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
	        File outputFile = new File(Main.class.getResource(Main.canevasFolderPath+newFileName).getPath());
	        spreadSheet.save(outputFile);
	        
	        // Convert as PDF
	        GeneratePDF.generateFullFS(t);
		}catch(NullPointerException e){
			System.out.println("Fichier source introuvable");
		} 
	}

}