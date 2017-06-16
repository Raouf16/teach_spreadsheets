package com.github.Raouf16.model.utils.io;

import java.io.FileReader;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import com.github.Raouf16.model.utils.teacher.*;


/***
 * 
 * @author Sonia ASSAM
 * Class that read a file of teacher's data
 *
 */
public class TeacherReader 
{
	
	
	@SuppressWarnings("resource")
	/***
	 * 
	 * @param fileName : name or path of the file
	 * @return list of the read teachers
	 * @throws FileNotFoundException
	 */
	public Teacher readTeacherData(String fileName) throws Exception
	{
		FileReader reader = new FileReader(fileName);
		CSVReader csv = new CSVReader(reader, ',');
		return new Teacher(csv.readNext());	
	}
	
	public ArrayList <Teacher> readTeachersData(String fileName) throws Exception
	{
		ArrayList <Teacher> teachers = new ArrayList <>();
		FileReader reader = new FileReader(fileName);
		@SuppressWarnings("resource")
		CSVReader csv = new CSVReader(reader, ',');
		
		for (String [] teach : csv.readAll()) teachers.add(new Teacher(teach)) ;
		return teachers;
	}
}
