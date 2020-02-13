package it.uniroma1.fabbricasemantica.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.uniroma1.fabbricasemantica.dao.LanguageDao;
import it.uniroma1.fabbricasemantica.db.DatabaseService;
import it.uniroma1.fabbricasemantica.model.Language;

/**
 * Implementazione dell'interfaccia {@link LanguageDao}
 * @author francescopioscognamiglio
 */
public class LanguageDaoImpl implements LanguageDao {

	/** La query per l'inserimento di una nuova lingua */
    private static final String CREATE_QUERY = "INSERT INTO \"language\" (name, user_email) VALUES (?, ?)";

    /** La query per la lettura di tutte le lingue */
    private static final String READ_ALL_QUERY = "SELECT * FROM \"language\"";

    /** La query per la lettura delle lingue parlate da un utente */
    private static final String READ_BY_USER_QUERY = "SELECT * FROM \"language\" WHERE user_email = ?";

    /** La query per l'aggiornamento di una lingua */
    private static final String UPDATE_QUERY = "UPDATE \"language\" SET name = ? WHERE name = ?";

    /** La query per l'aggiornamento di una lingua parlata da un utente */
    private static final String UPDATE_BY_USER_QUERY = "UPDATE \"language\" SET name = ? WHERE name = ? AND user_email = ?";

    /** La query per la cancellazione di una lingua */
    private static final String DELETE_QUERY = "DELETE FROM \"language\" WHERE name = ?";

    /** La query per la cancellazione di una lingua parlata da un utente */
    private static final String DELETE_BY_USER_QUERY = "DELETE FROM \"language\" WHERE name = ? AND user_email = ?";

	@Override
	public int createLanguage(Language language, String userEmail) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, language.getName());
            pstmt.setString(2, userEmail);

            if (pstmt.executeUpdate() == 0) throw new SQLException("Creating user failed, no rows affected.");

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (!generatedKeys.next()) throw new SQLException("Creating language failed, no ID obtained.");

            int id = generatedKeys.getInt("id");
            language.setId(id);
            return id;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public List<Language> getAllLanguages() {
		List<Language> languages = new ArrayList<>();
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(READ_ALL_QUERY)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) languages.add(new Language(rs.getString("name"), rs.getInt("id")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

		return languages;
	}

	@Override
	public List<Language> getLanguage(String userEmail) {
		List<Language> languages = new ArrayList<>();
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(READ_BY_USER_QUERY)) {

			pstmt.setString(1, userEmail);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) languages.add(new Language(rs.getString("name"), rs.getInt("id")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

		return languages;
	}

	@Override
	public boolean updateLanguage(Language language) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY)) {

            pstmt.setString(1, language.getName());
            pstmt.setString(2, language.getName());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean updateLanguage(Language language, String userEmail) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_BY_USER_QUERY)) {

            pstmt.setString(1, language.getName());
            pstmt.setString(2, language.getName());
            pstmt.setString(3, userEmail);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean deleteLanguage(Language language) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {

            pstmt.setString(1, language.getName());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}

	@Override
	public boolean deleteLanguage(Language language, String userEmail) {
		try (Connection conn = DatabaseService.connect();
                PreparedStatement pstmt = conn.prepareStatement(DELETE_BY_USER_QUERY)) {

            pstmt.setString(1, language.getName());
            pstmt.setString(2, userEmail);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
	}
}
