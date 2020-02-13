package it.uniroma1.fabbricasemantica.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.uniroma1.fabbricasemantica.dao.AnswerDao;
import it.uniroma1.fabbricasemantica.db.DatabaseService;
import it.uniroma1.fabbricasemantica.model.Answer;

/**
 * Implementazione dell'interfaccia  {@link AnswerDao}
 * @author francescopioscognamiglio
 */
public class AnswerDaoImpl implements AnswerDao {

	/** La query per l'inserimento di una nuova risposta */
    private static final String CREATE_QUERY = "INSERT INTO answer (value, task_id) VALUES (?, ?)";

    /** La query per la lettura di tutte le risposte */
    private static final String READ_ALL_QUERY = "SELECT * FROM answer";

    /** La query per la lettura delle risposte presenti in un task */
    private static final String READ_BY_TASK_QUERY = "SELECT * FROM answer WHERE task_id = ?";

    /** La query per l'aggiornamento di una risposta */
    private static final String UPDATE_QUERY = "UPDATE answer SET value = ? WHERE id = ?";

    /** La query per l'aggiornamento di una risposta presente in un task */
    private static final String UPDATE_BY_TASK_QUERY = "UPDATE answer SET value = ? WHERE id = ? AND task_id = ?";

    /** La query per la cancellazione di una risposta */
    private static final String DELETE_QUERY = "DELETE FROM answer WHERE id = ?";

    /** La query per la cancellazione di una risposta presente in un task */
    private static final String DELETE_BY_TASK_QUERY = "DELETE FROM answer WHERE id = ? AND task_id = ?";

    @Override
	public int createAnswer(Answer answer, Integer taskId) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, answer.getValue());
            pstmt.setInt(2, taskId);

            if (pstmt.executeUpdate() == 0) throw new SQLException("Creating user failed, no rows affected.");

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (!generatedKeys.next()) throw new SQLException("Creating answer failed, no ID obtained.");

            int id = generatedKeys.getInt("id");
            answer.setId(id);
            return id;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public List<Answer> getAllAnswers() {
		List<Answer> answers = new ArrayList<>();
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(READ_ALL_QUERY)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) answers.add(new Answer(rs.getString("value"), rs.getInt("id")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

		return answers;
	}

	@Override
	public List<Answer> getAnswers(Integer taskId) {
		List<Answer> answers = new ArrayList<>();
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(READ_BY_TASK_QUERY)) {

			pstmt.setInt(1, taskId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) answers.add(new Answer(rs.getString("value"), rs.getInt("id")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

		return answers;
	}

	@Override
	public boolean updateAnswer(Answer answer) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY)) {

            pstmt.setString(1, answer.getValue());
            pstmt.setInt(2, answer.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean updateAnswer(Answer answer, Integer taskId) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_BY_TASK_QUERY)) {

            pstmt.setString(1, answer.getValue());
            pstmt.setInt(2, answer.getId());
            pstmt.setInt(3, taskId);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean deleteAnswer(Answer answer) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {

            pstmt.setInt(1, answer.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean deleteAnswer(Answer answer, Integer taskId) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(DELETE_BY_TASK_QUERY)) {

            pstmt.setInt(1, answer.getId());
            pstmt.setInt(2, taskId);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}
}
