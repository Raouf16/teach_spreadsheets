

package writeInFile;

import java.io.File;


import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import teacherUtils.Teacher;

public class SpreadSheetFill {
	public void GenerateFS(Teacher t){
		
		try {
            // Load the file.
            File file = new File("./Fservice.ods");
            final Sheet sheet = SpreadSheet.createFromFile(file).getSheet("Feuille1");
            
            
           
            
            // Change strings.
            
            sheet.getCellAt("A3").setValue(t.CIV);
            sheet.getCellAt("B3").setValue(t.getFirstName());
            sheet.getCellAt("C3").setValue(t.getLastName());
            sheet.getCellAt("B4").setValue(t.getStatus());
            
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