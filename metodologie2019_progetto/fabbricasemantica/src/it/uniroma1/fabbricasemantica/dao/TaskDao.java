package it.uniroma1.fabbricasemantica.dao;

import java.util.List;

import it.uniroma1.fabbricasemantica.model.Task;

/**
 * DAO per la rappresentazione della tabella task
 * @author francescopioscognamiglio
 *
 */
public interface TaskDao {

	/** Crea un task e restituisce l'id assegnato */
	public int createTask(Task task, String userEmail);

	/** Recupera tutti i task */
	public List<Task> getAllTasks();

	/** Recupera i task compilati da un utente a partire dall'email dell'utente */
	public List<Task> getTasks(String userEmail);

	/** Aggiorna un task */
	public boolean updateTask(Task task);

	/** Aggiorna un task compilato da un utente a partire dall'email dell'utente */
	public boolean updateTask(Task task, String userEmail);

	/** Cancella un task */
	public boolean deleteTask(Task task);

	/** Cancella un task compilato da un utente a partire dall'email dell'utente */
	public boolean deleteTask(Task task, String userEmail);
}
