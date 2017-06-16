package com.github.Raouf16.model.utils.io.csv.read;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.github.Raouf16.model.main.Main;
import com.github.Raouf16.model.utils.teacher.Teacher;
import com.opencsv.CSVReader;

/***
 * This class will be used in case of searching a specific line in the csv files
 * @author Sonia ASSAM
 *
 */
public class CsvReader 
{
	/***
	 * This method is used to get teacher by it's numen
	 * @param fileName : Teacher's csv file path
	 * @param numen : The teacher's numen
	 * @return the teacher object if the numen exists, else null
	 * @throws Exception 
	 */
	public Teacher getTeacherByNumEn(String fileName, String numen) throws IOException, IllegalArgumentException
	{
		if (fileName == null) throw new IllegalArgumentException();
		for (Teacher t : getTeachers(fileName))
		{
			if (t!=null && t.getNumEn().equals(numen)) return t;
		}
		return null;
	}
	
	/***
	 * This method is used to read all the csv file input
	 * @param fileName : csv file path
	 * @return
	 * @throws IOException, IllegalArgumentException
	 */
	public ArrayList <Teacher> getTeachers(String filePath) throws IOException, IllegalArgumentException
	{
		ArrayList <Teacher> teachers = new ArrayList <>();
		FileReader reader = new FileReader(filePath);
		@SuppressWarnings("resource")
		CSVReader csv = new CSVReader(reader, ',');
		for (String [] teach : csv.readAll()) teachers.add(new Teacher(teach)) ;
		return teachers;
	}
	

}
