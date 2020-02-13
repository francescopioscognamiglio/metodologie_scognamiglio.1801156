package it.uniroma1.fabbricasemantica.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.uniroma1.fabbricasemantica.dao.UserDao;
import it.uniroma1.fabbricasemantica.db.DatabaseService;
import it.uniroma1.fabbricasemantica.model.User;

/**
 * Implementazione dell'interfaccia  {@link UserDao}
 * @author francescopioscognamiglio
 */
public class UserDaoImpl implements UserDao {

	/** La query per l'inserimento di un nuovo utente */
    private static final String CREATE_QUERY = "INSERT INTO \"user\" (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";

    /** La query per la lettura di tutti gli utenti */
    private static final String READ_ALL_QUERY = "SELECT * FROM \"user\"";

    /** La query per la lettura di un utente */
    private static final String READ_QUERY = "SELECT * FROM \"user\" WHERE email = ?";

    /** La query per l'aggiornamento di un utente */
    private static final String UPDATE_QUERY = "UPDATE \"user\" SET first_name = ?, last_name = ?, password = ? WHERE email = ?";

    /** La query per la cancellazione di un utente */
    private static final String DELETE_QUERY = "DELETE FROM \"user\" WHERE email = ?";

	@Override
	public boolean createUser(User user) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(CREATE_QUERY)) {

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(READ_ALL_QUERY)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	users.add(new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("password")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

		return users;
	}

	@Override
	public User getUser(String email) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(READ_QUERY)) {

			pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) return null;

            return new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("password"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean updateUser(User user) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY)) {

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getEmail());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean deleteUser(User user) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {

            pstmt.setString(1, user.getEmail());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}
}
