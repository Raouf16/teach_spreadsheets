package com.github.Raouf16.model.utils.io.csv.write;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.github.Raouf16.model.utils.teacher.Teacher;
import com.github.Raouf16.model.utils.io.csv.read.*;
 
public class CsvWriterReaderTest {
	//this test is for CsvWriter and CsvReader
    @Test
    public void test() throws Exception {
        CsvWriter test= new CsvWriter();
        Teacher t = new Teacher ();
        t.setFirstName("lynda");
		t.setLastName("Boulila");
        t.setNumEn("1236"); 
        
        test.writeTeacher("./sorties/csv/teachers",t);
        Teacher t2 = new Teacher();
        t2= CsvReader.ReadTeacher("./sorties/csv/teachers", "1236");
        assertEquals(t.numEn, t2.numEn);
    }
    
    public void testGetTeachers() throws NullPointerException, IOException {
    	CsvWriter test= new CsvWriter();
    	
    	Teacher t = new Teacher ();
        t.setFirstName("Yasmine");
		t.setLastName("Sersour");
        t.setNumEn("1237");
        test.writeTeacher("./sorties/csv/teachers",t);
        ArrayList  <Teacher> list= CsvReader.getTeachers("./sorties/csv/teachers");
    	boolean check = false;
    	// we test if the teacher t in in the ArrayList
    	for (int i=0;i<list.size();i++){
    		if((t.equals(list.get(i)))){
    			check = true;
    		}
    	}
    	assertTrue(check);
    }
    
}