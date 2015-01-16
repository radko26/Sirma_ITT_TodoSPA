package com.sirma.itt.taskmgr.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.taskmgr.model.Task;

/**
 * Unit test of {@link Task}.
 * @author radoslav
 *
 */
public class TaskTest {

	@Test
	public void test() {
		String content = "ala";
		long expire = System.currentTimeMillis();
		
		Task mockTask = new Task();
		mockTask.setContent(content);
		mockTask.setExpire(expire);
		
		assertEquals(mockTask.getContent(), content);
		assertEquals(mockTask.getExpire(),expire);
		
	}

}
