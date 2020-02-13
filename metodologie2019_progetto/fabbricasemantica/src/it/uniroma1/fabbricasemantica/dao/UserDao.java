package it.uniroma1.fabbricasemantica.dao;

import java.util.List;

import it.uniroma1.fabbricasemantica.model.User;

/**
 * DAO per la rappresentazione della tabella user
 * @author francescopioscognamiglio
 *
 */
public interface UserDao {

	/** Crea un utente */
	public boolean createUser(User user);

	/** Recupera tutti gli utenti */
	public List<User> getAllUsers();

	/** Recupera un utente a partire dall'email dell'utente */
	public User getUser(String email);

	/** Aggiorna un utente */
	public boolean updateUser(User user);

	/** Cancella un utente */
	public boolean deleteUser(User user);
}
