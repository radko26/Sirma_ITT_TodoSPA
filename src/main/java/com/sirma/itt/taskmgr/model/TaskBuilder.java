package com.sirma.itt.taskmgr.model;

/**
 * Builder class for {@link Task}
 * 
 * @author radoslav
 */
public class TaskBuilder {

	Task task;

	public TaskBuilder() {
		task = new Task();
	}

	public TaskBuilder setId(String id) {
		task.setId(id);
		return this;
	}

	public TaskBuilder setContent(String content) {
		task.setContent(content);
		return this;
	}

	public TaskBuilder setExpire(long expireDateInTimeStamp) {
		task.setExpire(expireDateInTimeStamp);
		return this;
	}

	public TaskBuilder setFinished(boolean finished) {
		task.setFinished(finished);
		return this;
	}

	public Task build() {
		return task;
	}
}
