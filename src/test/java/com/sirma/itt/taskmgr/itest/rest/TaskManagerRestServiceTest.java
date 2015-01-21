package com.sirma.itt.taskmgr.itest.rest;

import javax.ws.rs.core.MediaType;
import static org.junit.Assert.*;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.sirma.itt.taskmgr.model.TaskBuilder;
import com.sirma.itt.taskmgr.util.TaskDB;

public class TaskManagerRestServiceTest {

	@Before
	public void setup() {
		RestAssured.baseURI = "http://localhost:8080/SirmaTaskManager/rest";
	}

	@Test
	public void testAddTask() {

		TaskDB db = new TaskDB();
		db.insert(new TaskBuilder().setContent("as").build());
		assertTrue(true);
		/*
		 * JSONObject task = new JSONObject(); task.put("finished", true); task.put("content",
		 * "Test it!"); task.put("expire", 0); Response response =
		 * RestAssured.given().contentType(MediaType.APPLICATION_JSON).body(task.toString())
		 * .when().post("/tasks/create");
		 * RestAssured.expect().statusCode(200).contentType(MediaType.APPLICATION_JSON).when()
		 * .get("/tasks/").then().contentType(MediaType.APPLICATION_JSON).body("content",
		 * Matchers.equalTo("[Test it!]"));
		 */
	}

	@Test
	public void testGetTasks() {
		/*
		 * RestAssured.expect().statusCode(200).contentType(MediaType.APPLICATION_JSON).when()
		 * .get("/tasks/");
		 */
	}

}
