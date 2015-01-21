package com.sirma.itt.taskmgr.itest.rest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.taskmgr.model.TaskBuilder;
import com.sirma.itt.taskmgr.util.TaskDB;

public class TaskManagerRestServiceTest {


	@Test
	public void testAddTask() {

		TaskDB db = new TaskDB();
		db.insert(new TaskBuilder().setContent("as").build());
		assertTrue(true);
	}

	@Test
	public void testGetTasks() {

		
	}

}
