
package mz.co.scntech.messenger.resources;

import java.sql.SQLException;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mz.co.scntech.messenger.database.Connect;
import mz.co.scntech.messenger.model.User;

/**
 *
 * @author Sidónio Goenha on Aug 25, 2020
 *
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	@GET
	@Path("/{userId}")
	public User getUser(@PathParam("userId") int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connect connect = new Connect();
		User user = connect.getUser(id);
		connect.closeConnection();
		return user;
	}
	
	@POST
	public User addUser(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connect connect = new Connect();
		user = (User) connect.insertUser(user);
		connect.closeConnection();
		return user;
	}
	
	@PUT
	@Path("/{userId}")
	public User update(@PathParam("userId") int id, User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		user.setId(id);
		Connect connect = new Connect();
		connect.updateUser(user);
		connect.closeConnection();
		return user;
	}
	
	@DELETE
	@Path("/{userId}")
	public void deleteUser(@PathParam("userId") int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connect connect = new Connect();
		connect.deleteUser(id);
	}
}
