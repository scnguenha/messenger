
package mz.co.scntech.messenger.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import mz.co.scntech.messenger.model.User;

/**
 *
 * @author Sidónio Goenha on Aug 25, 2020
 *
 */
public class Connect {
	private Connection con = null;

	public Connect() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/messenger";
		String user = "root";
		String password = "";

		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(url, user, password);
	}

	public void closeConnection() throws SQLException {
		con.close();
	}

	public User insertUser(User user) {

		try {

			PreparedStatement preparedStatement = con
					.prepareStatement("insert user(user_name, password, address, email) values(?,?,?,?)");
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.execute();

			user = getLastUser();
			
			System.out.println("Created: " + user.toString());

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connect.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		}

		return user;
	}

	public void updateUser(User user) {

		try {

			PreparedStatement preparedStatement = con.prepareStatement(
					"update user set user_name = ?, password = ?, address = ?, email = ? where id = ?");
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setInt(5, user.getId());
			preparedStatement.execute();

			System.out.println("Updated: " + user.toString());
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connect.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		}
	}

	public User getLastUser() {

		User user = null;
		try {

			PreparedStatement preparedStatement = con.prepareStatement("select * from user order by id desc limit 1");

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {

				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setEmail(rs.getString(5));

			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connect.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		}
		return user;
	}

	public User getUser(int id) {

		User user = null;
		try {

			PreparedStatement preparedStatement = con.prepareStatement("select * from user where id = ?");
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {

				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setEmail(rs.getString(5));

			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connect.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		}
		return user;
	}
	
	public List<User> getUsers() {

		List<User> users = new ArrayList<User>();
		try {

			PreparedStatement preparedStatement = con.prepareStatement("select * from user");
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setEmail(rs.getString(5));
				users.add(user);

			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connect.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		}
		return users;
	}

	public void deleteUser(int id) {

		try {

			PreparedStatement preparedStatement = con.prepareStatement("delete from user where id = ?");
			preparedStatement.setInt(1, id);

			preparedStatement.execute();

			System.out.println("Deleted: user with id = " + id);
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connect.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		}
	}
}
