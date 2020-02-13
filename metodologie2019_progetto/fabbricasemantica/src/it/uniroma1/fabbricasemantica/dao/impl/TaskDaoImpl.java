package it.uniroma1.fabbricasemantica.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.uniroma1.fabbricasemantica.dao.TaskDao;
import it.uniroma1.fabbricasemantica.db.DatabaseService;
import it.uniroma1.fabbricasemantica.model.Task;

/**
 * Implementazione dell'interfaccia {@link TaskDao}
 * @author francescopioscognamiglio
 */
public class TaskDaoImpl implements TaskDao {

	/** La query per l'inserimento di un nuovo task */
    private static final String CREATE_QUERY = "INSERT INTO task (type, user_email) VALUES (?, ?)";

    /** La query per la lettura di tutti i task */
    private static final String READ_ALL_QUERY = "SELECT * FROM task";

    /** La query per la lettura dei task compilati da un utente */
    private static final String READ_BY_USER_QUERY = "SELECT * FROM task WHERE user_email = ?";

    /** La query per l'aggiornamento di un task */
    private static final String UPDATE_QUERY = "UPDATE task SET type = ? WHERE id = ?";

    /** La query per l'aggiornamento di un task compilato da un utente */
    private static final String UPDATE_BY_USER_QUERY = "UPDATE task SET type = ? WHERE id = ? AND user_email = ?";

    /** La query per la cancellazione di un task */
    private static final String DELETE_QUERY = "DELETE FROM task WHERE id = ?";

    /** La query per la cancellazione di un task compilato da un utente */
    private static final String DELETE_BY_USER_QUERY = "DELETE FROM task WHERE id = ? AND user_email = ?";

    @Override
	public int createTask(Task task, String userEmail) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, task.getType());
            pstmt.setString(2, userEmail);

            if (pstmt.executeUpdate() == 0) throw new SQLException("Creating user failed, no rows affected.");

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (!generatedKeys.next()) throw new SQLException("Creating task failed, no ID obtained.");

            int id = generatedKeys.getInt("id");
            task.setId(id);
            return id;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<>();
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(READ_ALL_QUERY)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) tasks.add(new Task(rs.getString("type"), rs.getInt("id")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

		return tasks;
	}

	@Override
	public List<Task> getTasks(String userEmail) {
		List<Task> tasks = new ArrayList<>();
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(READ_BY_USER_QUERY)) {

			pstmt.setString(1, userEmail);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) tasks.add(new Task(rs.getString("type"), rs.getInt("id")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

		return tasks;
	}

	@Override
	public boolean updateTask(Task task) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY)) {

            pstmt.setString(1, task.getType());
            pstmt.setInt(2, task.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean updateTask(Task task, String userEmail) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_BY_USER_QUERY)) {

            pstmt.setString(1, task.getType());
            pstmt.setInt(2, task.getId());
            pstmt.setString(3, userEmail);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean deleteTask(Task task) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {

            pstmt.setInt(1, task.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean deleteTask(Task task, String userEmail) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(DELETE_BY_USER_QUERY)) {

            pstmt.setInt(1, task.getId());
            pstmt.setString(2, userEmail);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}
}
