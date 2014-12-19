package com.sirma.itt.taskmgr.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import com.sirma.itt.taskmgr.model.Task;
import com.sirma.itt.taskmgr.model.TaskBuilder;
import com.sirma.itt.taskmgr.util.TaskDB;

/**
 * Unit tests of {@link TaskDB}
 * 
 * @author radoslav
 */

public class TaskDBTest {
	TaskDB db = new TaskDB();

	@Test
	public void testInsert() {
		Task mockTask = new TaskBuilder().setId("1").build();
		db.insert(mockTask);
		assertEquals(db.getTasks().size(), 1);
	}

	@Test
	public void testDelete() {
		Task mockTask = new TaskBuilder().setId("1").build();
		db.remove(mockTask);
		assertEquals(db.getTasks().size(), 0);
	}

	@Test
	public void testMarkAsFinish() {
		Task mockTask = new TaskBuilder().setFinished(true).build();
		db.insert(mockTask);
		db.markAsFinished(mockTask);
		assertTrue(db.getTasks().get(mockTask.getId()).isFinished());
	}

	@Test
	public void testSortedOutputAsJson() {

		List<Task> sorted = new ArrayList<Task>();

		for (int i = 0; i < 20; i++) {
			sorted.add(new TaskBuilder().setExpire(1).build());
		}

		for (int i = 0; i < 20; i++) {
			sorted.add(new TaskBuilder().setExpire(2).build());
		}

		for (int i = 0; i < 20; i++) {
			sorted.add(new TaskBuilder().setExpire(0).build());
		}

		for (int i = 0; i < 20; i++) {
			db.insert(new TaskBuilder().setExpire(0).build());
		}
		for (int i = 0; i < 20; i++) {
			db.insert(new TaskBuilder().setExpire(2).build());
		}
		for (int i = 0; i < 20; i++) {
			db.insert(new TaskBuilder().setExpire(1).build());
		}

		List<Task> tasksFromTheDB = db.getSortedTasksAsList();
		int counter = 0;
		for (Task mockTask : sorted) {
			assertEquals(mockTask.getExpire(), tasksFromTheDB.get(counter).getExpire());
			counter++;
		}
	}
}
