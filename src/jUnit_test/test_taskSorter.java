package jUnit_test;

import classes.TaskSorter;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class test_taskSorter {

	@Test
	public void level_1() {
		String[] testString1 = {"A","B"};				//This string is used in isWellSorted(testString1)
		String[][] testSeq1 = {{"A"} , {"B"}};			//This is for the constructor of TaskSorter
		TaskSorter t1 = new TaskSorter(testSeq1);		//This instanciates a new TaskSorter for testing
		boolean test1 = t1.isWellSorted(testString1);   //This will run the method with the given parameters

		assertTrue("simple input test for independent tasks",test1);
		// This compares expected outcome with actual outcome
	}

	@Test
	public void level_2() {
		String[] testString2_1 = {"A","B"};
		String[] testString2_2 = {"B","A"};
		String[][] testSeq2 = {{"A" , "B"}};
		TaskSorter t2 = new TaskSorter(testSeq2);
		boolean test2_1 = t2.isWellSorted(testString2_1);
		boolean test2_2 = t2.isWellSorted(testString2_2);

		assertTrue("simple test for 2 tasks with dependency",test2_1);
		assertEquals("simple test for 2 tasks with dependency",false,test2_2);
	}

	@Test
	public void level_3(){
		String[] testString3_1 = {"A","B","C"};
		String[] testString3_2 = {"A","C","B"};
		String[][] testSeq3 = {{"A","C"},{"B","C"}};
		TaskSorter t3 = new TaskSorter(testSeq3);
		boolean test3_1 = t3.isWellSorted(testString3_1);
		boolean test3_2 = t3.isWellSorted(testString3_2);
		assertTrue("simple dependency test for multiple tasks",test3_1);
		assertEquals("simple dependency test for multiple tasks",false,test3_2);
	}

	@Test
	public void level_4(){
		String[] testString4_1 = {"A","B","C","D"};
		String[] testString4_2 = {"A","C","B","D"};
		String[][] testSeq4 = {{ "A" , "C" }, { "C", "D" }, { "B", "C" }};
		TaskSorter t4 = new TaskSorter(testSeq4);
		boolean test4_1 = t4.isWellSorted(testString4_1);
		boolean test4_2 = t4.isWellSorted(testString4_2);
		assertTrue("complex dependency test for multiple tasks",test4_1);
		assertEquals("complex dependency test for multiple tasks",false,test4_2);
	}
}
