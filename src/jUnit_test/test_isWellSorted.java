package jUnit_test;

import static  org.junit.Assert.*;

import org.junit.Test;

import classes.TaskSorter;

import org.junit.Assert;

public class test_isWellSorted {

	@Test
	
	public void Test() {
		TaskSorter t = new TaskSorter();
		int zahl = t.hallo(2);
		assertTrue("Multiplikation falsch",zahl == 4);
		
	}

}
