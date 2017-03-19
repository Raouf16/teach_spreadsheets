package writeCsv;

import java.io.*;
import java.util.Scanner;

/**
 * This class is able to write information about a teacher in a csv file which called test.txt
 * @author haya
 *
 */
public class CsvFile {

	public static void WriteTeacher (String fileName) throws Exception{
			FileWriter fichier = new FileWriter(fileName);
			String line="";
			Scanner word;
			
			System.out.println("Fisrt Name? ");
			word= new Scanner (System.in);
			if (word==null ) throw new Exception ("The first name can't be null");
			line+= word.nextLine();
			line+=",";
			
			System.out.println("Last Name? ");
			word= new Scanner (System.in);
			if (word==null ) throw new Exception ("The last name can't be null");
			line+= word.nextLine();
			line+=",";
			
			
			
			
			
			
			fichier.write (line);
			fichier.close();
	}
	
	
	public static void main (String [] args) throws Exception{
		WriteTeacher("test.txt");
	}
}
