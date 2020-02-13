package it.uniroma1.fabbricasemantica.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.uniroma1.fabbricasemantica.dao.DataDao;
import it.uniroma1.fabbricasemantica.db.DatabaseService;
import it.uniroma1.fabbricasemantica.model.Data;

/**
 * Implementazione dell'interfaccia  {@link DataDao}
 * @author francescopioscognamiglio
 */
public class DataDaoImpl implements DataDao {

	/** La query per l'inserimento di un nuovo dato */
    private static final String CREATE_QUERY = "INSERT INTO data (value, task_id) VALUES (?, ?)";

    /** La query per la lettura di tutti i dati */
    private static final String READ_ALL_QUERY = "SELECT * FROM data";

    /** La query per la lettura dei dati presenti in un task */
    private static final String READ_BY_TASK_QUERY = "SELECT * FROM data WHERE task_id = ?";

    /** La query per l'aggiornamento di un dato */
    private static final String UPDATE_QUERY = "UPDATE data SET value = ? WHERE id = ?";

    /** La query per l'aggiornamento di un dato presente in un task */
    private static final String UPDATE_BY_TASK_QUERY = "UPDATE data SET value = ? WHERE id = ? AND task_id = ?";

    /** La query per la cancellazione di un dato */
    private static final String DELETE_QUERY = "DELETE FROM data WHERE id = ?";

    /** La query per la cancellazione di un dato presente in un task */
    private static final String DELETE_BY_TASK_QUERY = "DELETE FROM data WHERE id = ? AND task_id = ?";

    @Override
	public int createData(Data data, Integer taskId) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, data.getValue());
            pstmt.setInt(2, taskId);

            if (pstmt.executeUpdate() == 0) throw new SQLException("Creating user failed, no rows affected.");

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (!generatedKeys.next()) throw new SQLException("Creating data failed, no ID obtained.");

            int id = generatedKeys.getInt("id");
            data.setId(id);
            return id;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public List<Data> getAllData() {
		List<Data> data = new ArrayList<>();
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(READ_ALL_QUERY)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) data.add(new Data(rs.getString("value"), rs.getInt("id")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

		return data;
	}

	@Override
	public List<Data> getData(Integer taskId) {
		List<Data> data = new ArrayList<>();
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(READ_BY_TASK_QUERY)) {

			pstmt.setInt(1, taskId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) data.add(new Data(rs.getString("value"), rs.getInt("id")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

		return data;
	}

	@Override
	public boolean updateData(Data data) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY)) {

            pstmt.setString(1, data.getValue());
            pstmt.setInt(2, data.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean updateData(Data data, Integer taskId) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_BY_TASK_QUERY)) {

            pstmt.setString(1, data.getValue());
            pstmt.setInt(2, data.getId());
            pstmt.setInt(3, taskId);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean deleteData(Data data) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {

            pstmt.setInt(1, data.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean deleteData(Data data, Integer taskId) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(DELETE_BY_TASK_QUERY)) {

            pstmt.setInt(1, data.getId());
            pstmt.setInt(2, taskId);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}
}
