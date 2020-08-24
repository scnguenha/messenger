
package mz.co.scntech.messenger.model;

import java.util.Date;

/**
 *
 * @author Sidónio Goenha on Aug 20, 2020
 *
 */

public class Message {

	private long id;
	private String message;
	private Date created;
	private String author;

	public Message() {

	}

	public Message(long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
