package com.sirma.itt.taskmgr.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Base object that represents simple task structure.
 * 
 * @author radoslav
 *
 */
@XmlRootElement
public class Task {

	private String content;
	private long expire;
	private String id;
	private boolean finished;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getExpire() {
		return expire;
	}

	public void setExpire(long expireDateInTimeStamp) {
		this.expire = expireDateInTimeStamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

}
