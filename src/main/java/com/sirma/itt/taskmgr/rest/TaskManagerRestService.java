package com.sirma.itt.taskmgr.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sirma.itt.taskmgr.model.Task;
import com.sirma.itt.taskmgr.util.TaskDB;

/**
 * Rest service that allows to add or delete tasks.
 * 
 * @author radoslav
 *
 */
@Path("/tasks")
public class TaskManagerRestService {

	@Inject
	private TaskDB tasks;

	/**
	 * Consumes json representation of {@Link Task} and adds it to the
	 * db.
	 * 
	 * @param task
	 *            The task.
	 * @return The task.
	 */
	@Path("/create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Task createPerson(Task task) {
		return tasks.insert(task);
	}

	/**
	 * Gets the tasks.
	 * 
	 * @return
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  String getPeople() {
		return tasks.getTasksAsJSON().toString();
	}

	/**
	 * Deletes a task given by json object.
	 * 
	 * @param task
	 *            The task
	 * @return Response 204 if the deletion was failed and 200 otherwise. @TODO
	 */
	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String removeTask(@PathParam("id") String id){
		tasks.removeById(id);
		return id;
	}
	
	@Path("/mark")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void markAsFinished(Task task){
		tasks.markAsFinished(task);
	}
	
}
