package com.github.Raouf16.model.utils.io.pdf;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.github.Raouf16.model.utils.teacher.Teacher;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Document;

public class GeneratePDFTest {

	@Test
	public void test() throws FileNotFoundException, DocumentException {
		Teacher t1 = new Teacher();
		Teacher t2 = new Teacher();
		GeneratePDF pdf1=new GeneratePDF();
		GeneratePDF pdf2=new GeneratePDF();
		Document d1=pdf1.createPDF(t1);
		Document d2=pdf2.createPDF(t2);
		assertNotSame(d1,d2);
	}

}
