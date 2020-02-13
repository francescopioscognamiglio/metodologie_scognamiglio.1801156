package it.uniroma1.fabbricasemantica.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe che permette di interagire col Database
 * @author francescopioscognamiglio
 */
public class DatabaseService {

	/** Driver di connessione */
	private static final String DRIVER = "org.postgresql.Driver";

	/** URL di connessione al Database */
	private static final String URL = "jdbc:postgresql://localhost:5433/project";

	/** Username del proprietario del Database */
	private static final String USERNAME = "francescopio";

	/** Password del proprietario del Database */
	private static final String PASSWORD = "francescopio";

	static {
		try {
			checkDriver();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void checkDriver() throws ClassNotFoundException
	{
		Class.forName(DRIVER);
	}

	/**
	 * Apre una connessione al Database
	 * @return una connessione al Database
	 * @throws SQLException
	 */
	public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
