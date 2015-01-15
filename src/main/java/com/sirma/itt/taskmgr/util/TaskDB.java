package com.sirma.itt.taskmgr.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import javax.enterprise.context.ApplicationScoped;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sirma.itt.taskmgr.model.Task;

/**
 * HashMap that hold all current tasks;
 * 
 * @author radoslav
 */
@ApplicationScoped
public class TaskDB {
	private Map<String, Task> tasks = new HashMap<String, Task>();
	private int idSeed;

	/**
	 * Generates key 'id' to each task
	 * 
	 * @return The id
	 */
	private String generateId() {
		return Integer.toString(++idSeed);
	}

	/**
	 * Inserts new task.
	 * 
	 * @param task
	 *            The task
	 */
	public Task insert(Task task) {
		task.setId(generateId());
		tasks.put(task.getId(), task);
		return task;
	}

	/**
	 * Removes task from the map.
	 * 
	 * @param task
	 *            The task
	 */
	public void remove(Task task) {
		tasks.remove(task.getId());
	}

	/**
	 * Sorts all tasks by putting them into priority queue with custom comparator.
	 * 
	 * @return the sorted set.
	 */
	private PriorityQueue<Task> getSortedTasks() {
		PriorityQueue<Task> queue = new PriorityQueue<Task>(new Comparator<Task>() {

			@Override
			public int compare(Task task1, Task task2) {
				if (task1.getExpire() == 0 && task2.getExpire() == 0) {
					return 0;
				} else if (task1.getExpire() == 0 && task2.getExpire() != 0) {
					return 1;
				} else if (task1.getExpire() != 0 && task2.getExpire() == 0) {
					return -1;
				} else
					return Long.compare(task1.getExpire(), task2.getExpire());
			}
		});

		for (String key : tasks.keySet()) {
			queue.add(tasks.get(key));
		}

		return queue;
	}

	public Map<String, Task> getTasks() {
		return tasks;
	}

	/**
	 * Polls the tasks from the priority queue into a list.
	 * 
	 * @return The list containing the sorted tasks.
	 */
	public List<Task> getSortedTasksAsList() {
		List<Task> sortedTasks = new ArrayList<>();
		PriorityQueue<Task> heap = getSortedTasks();
		while (!heap.isEmpty()) {
			sortedTasks.add(heap.poll());
		}
		return sortedTasks;
	}

	/**
	 * Constructs JSONArray that contains the tasks.
	 * 
	 * @return The JSONArray
	 */
	public JSONArray getTasksAsJSON() {
		JSONArray array = new JSONArray();
		List<Task> taskList = getSortedTasksAsList();
		for (Task task : taskList) {
			JSONObject object = new JSONObject(task);
			array.put(object);
		}
		return array;
	}

	/**
	 * Removes a task by its id/key.
	 * 
	 * @param id
	 *            The key.
	 */
	public void removeById(String id) {
		tasks.remove(id);
	}

	/**
	 * Marks the task as finished/
	 * 
	 * @param task
	 *            The task.
	 */
	public void markAsFinished(Task task) {
		tasks.remove(task.getId());
		task.setFinished(true);
		tasks.put(task.getId(), task);
	}

}
