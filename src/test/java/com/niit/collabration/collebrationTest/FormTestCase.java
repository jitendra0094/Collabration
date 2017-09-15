package com.niit.collabration.collebrationTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FormTestCase {
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext 	annotationConfigApplicationContext= new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit.collabration");
		annotationConfigApplicationContext.refresh();
		
	}
	
	@Test
	public void test(){
		fail("not yet implemented");
		
	}

}
