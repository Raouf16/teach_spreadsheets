package writeCsv;

import java.io.*;

import teacherUtils.Teacher;

/**
 * This class is able to write information about a teacher in a csv file which called test.txt
 * @author haya
 *
 */
public class CsvFile {

	public static void WriteTeacher (String fileName, Teacher t) throws Exception{
			FileWriter fichier = new FileWriter(fileName);
			String line="";
			//Scanner word;
			
			//System.out.println("Fisrt Name? ");
			//word= new Scanner (System.in);
			//if (word==null ) throw new Exception ("The first name can't be null");
			line+= t.getFirstName();
			line+=",";
			line+= t.getLastName();
			line+=",";
			line+= t.getNumEn();
			line+=",";
			line+= t.getPostalCode();
			line+=",";
			line+= t.getCity();
			line+=",";
			line+= t.getStatus();
			line+=",";
			line+= t.getDauphineEmail();
			line+=",";
			line+= t.getPersonalEmail();
			line+=",";
			line+= t.getMobilePhone();
			line+=",";
			line+= t.getDauphinePhone();
			line+=",";
			line+= t.getOffice();
		
			
			
			
			/*System.out.println("Last Name? ");
			word= new Scanner (System.in);
			if (word==null ) throw new Exception ("The last name can't be null");
			line+= word.nextLine();
			line+=",";
			*/
			
			
			fichier.write (line);
			fichier.close();
	}
	
	
	public static void main (String [] args) throws Exception{
		Teacher t= new Teacher();
		WriteTeacher("test.txt",t);
	}
}
