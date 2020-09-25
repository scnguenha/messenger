
package mz.co.scntech.messenger.dao;

import java.util.Map;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import mz.co.scntech.messenger.model.Comment;
import mz.co.scntech.messenger.model.ErrorMessage;
import mz.co.scntech.messenger.model.Message;
import mz.co.scntech.messenger.persistence.Data;

/**
 *
 * @author Sidónio Goenha on Sep 25, 2020
 *
 */
public class CommentDAO extends Data {

	public static Comment getComment(long messageId, long commentId) {

		ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "http://javabrains.koushick.org");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();

		Message message = MessageDAO.findById(Message.class, messageId);
		if (message == null) {
			throw new WebApplicationException(response);
		}

		Map<Long, Comment> comments = message.getComments();
		Comment comment = comments.get(commentId);
		if (comment == null) {
			throw new WebApplicationException(response);
		}

		return comment;
	}

	public static Comment addComment(long messageId, Comment comment) {
		ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "http://javabrains.koushick.org");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();

		Message message = MessageDAO.findById(Message.class, messageId);
		if (message == null) {
			throw new WebApplicationException(response);
		}

		Map<Long, Comment> comments = message.getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);

		message.setComments(comments);
		

		MessageDAO.update(message);

		return comment;
	}

	public static Comment updateComment(long messageId, Comment comment) {

		ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "http://javabrains.koushick.org");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();

		Message message = MessageDAO.findById(Message.class, messageId);
		if (message == null) {
			throw new WebApplicationException(response);
		}

		Map<Long, Comment> comments = message.getComments();
		if (comment.getId() <= 0) {
			return null;
		}

		comments.put(comment.getId(), comment);

		message.setComments(comments);

		MessageDAO.update(message);

		return comment;
	}

	public static Comment removeComment(long messageId, long commentId) {
		ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "http://javabrains.koushick.org");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();

		Message message = MessageDAO.findById(Message.class, messageId);
		if (message == null) {
			throw new WebApplicationException(response);
		}

		Map<Long, Comment> comments = message.getComments();

		message.getComments().remove(commentId);

		MessageDAO.update(message);

		return comments.remove(commentId);
	}
}
