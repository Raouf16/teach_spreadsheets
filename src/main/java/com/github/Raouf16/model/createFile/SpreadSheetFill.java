package com.github.Raouf16.model.createFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import com.github.Raouf16.model.teacherUtils.Teacher;
import com.github.Raouf16.model.writeCsv.*;
/**
 * This class is able to generate a service card with information about a teacher
 *
 */
public class SpreadSheetFill {
	public void GenerateFS(Teacher t) throws FileNotFoundException, IOException{
		
            // Load the file.
            File file = new File("src/main/resources/com/github/Raouf16/Fservice.ods");
            
            final Sheet sheet = SpreadSheet.createFromFile(file).getSheet("Feuille1"); 
            // Change strings.
            
            sheet.getCellAt("A4").setValue(t.getCity());
            sheet.getCellAt("B4").setValue(t.getFirstName());
           sheet.getCellAt("C4").setValue(t.getLastName());
            sheet.getCellAt("B6").setValue(t.getStatus());
            sheet.getCellAt("D6").setValue("");
            sheet.getCellAt("B8").setValue(t.getDauphineEmail());
            sheet.getCellAt("A11").setValue(t.getDauphinePhone());
            sheet.getCellAt("B11").setValue(t.getMobilePhone());
            sheet.getCellAt("C11").setValue(t.getOffice());
            
            // Save to file and open it.
            File outputFile = new File("src/main/resources/com/github/Raouf16/test2.ods");
            OOUtils.open(sheet.getSpreadSheet().saveAs(outputFile));
	}

    public static void main(String[] args) throws Exception {
    	SpreadSheetFill s= new SpreadSheetFill();
    	Teacher t = new Teacher (); 
    	t.setFirstName("testnom");
    	s.GenerateFS(t);
        
    }
}