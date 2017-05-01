package com.github.Raouf16.model.createFile;

import java.io.File;


import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import com.github.Raouf16.model.teacherUtils.Teacher;

public class SpreadSheetFill {
	public void GenerateFS(Teacher t){
		
		try {
            // Load the file.
            File file = new File("./Fservice.ods");
            final Sheet sheet = SpreadSheet.createFromFile(file).getSheet("Feuille1");
            
            
           
            
            // Change strings.
            
            sheet.getCellAt("A4").setValue(t.getCity());
            sheet.getCellAt("B4").setValue(t.getFirstName());
            sheet.getCellAt("C4").setValue(t.getLastName());
            sheet.getCellAt("B6").setValue(t.getStatus());
            sheet.getCellAt("D6").setValue("");
            //System.out.println(t.getDauphineEmail());
            sheet.getCellAt("B8").setValue(t.getDauphineEmail());
            sheet.getCellAt("A11").setValue(t.getDauphinePhone());
            sheet.getCellAt("B11").setValue(t.getMobilePhone());
            sheet.getCellAt("C11").setValue(t.getOffice());
            
            // Save to file and open it.
            File outputFile = new File("test.ods");
            OOUtils.open(sheet.getSpreadSheet().saveAs(outputFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    public static void main(String[] args) throws Exception {
    	SpreadSheetFill s= new SpreadSheetFill();
    	Teacher t=new Teacher(args);
    	s.GenerateFS(t);
        
    }
}