package com.github.Raouf16.model.spreadsheet.write;

import java.io.File;


import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import com.github.Raouf16.model.utils.teacher.*;

/**
 * This class is able to generate a service card with information about a teacher
 * @author MODIFIED by Raouf HADDAD
 */
public class SpreadSheetFill {
	public void GenerateFS(Teacher t) throws Exception{
			
            // Load the file.
            File file = new File("src/main/resources/com/github/Raouf16/Fservice.ods");
            SpreadsheetDocument spreadSheet = SpreadsheetDocument.loadDocument(file);
            Table sheet = spreadSheet.getSheetByName("Feuille1"); 
            // Change strings.
            
            sheet.getCellByPosition("A4").setDisplayText(t.getCity());
            sheet.getCellByPosition("B4").setDisplayText(t.getFirstName());
            sheet.getCellByPosition("C4").setDisplayText(t.getLastName());
            sheet.getCellByPosition("B6").setDisplayText(t.getStatus());
            sheet.getCellByPosition("D6").setDisplayText("");
            sheet.getCellByPosition("B8").setDisplayText(t.getDauphineEmail());
            sheet.getCellByPosition("A11").setDisplayText(t.getDauphinePhone());
            sheet.getCellByPosition("B11").setDisplayText(t.getMobilePhone());
            sheet.getCellByPosition("C11").setDisplayText(t.getOffice());
            
            // Save 
            File outputFile = new File("src/main/resources/com/github/Raouf16/test2.ods");
            spreadSheet.save(outputFile);
	}

}