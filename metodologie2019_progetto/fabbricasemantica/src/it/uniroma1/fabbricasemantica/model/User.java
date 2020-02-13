package it.uniroma1.fabbricasemantica.model;

import java.util.List;

/**
 * La rappresentazione di un utente
 * @author francescopioscognamiglio
 */
public class User {

	/** Il nome dell'utente */
	private String firstName;

	/** Il cognome dell'utente */
	private String lastName;

	/** L'email dell'utente */
	private String email;

	/** La password dell'utente */
	private String password;

	/** Le lingue parlate dall'utente */
	private List<Language> languages;

	/** I task compilati dall'utente */
	private List<Task> tasks;

	public User(String firstName, String lastName, String email, String password) {
		this(firstName, lastName, email, password, null, null);
	}

	public User(String firstName, String lastName, String email, String password, List<Language> languages) {
		this(firstName, lastName, email, password, languages, null);
	}

	public User(String firstName, String lastName, String email, String password, List<Language> languages, List<Task> tasks) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.languages = languages;
		this.tasks = tasks;
	}

	/** @return il nome dell'utente */
	public String getFirstName() { return firstName; }

	/** @param firstName il nome dell'utente da impostare */
	public void setFirstName(String firstName) { this.firstName = firstName; }

	/** @return il cognome dell'utente */
	public String getLastName() { return lastName; }

	/** @param lastName il cognome dell'utente da impostare */
	public void setLastName(String lastName) { this.lastName = lastName; }

	/** @return l'email dell'utente */
	public String getEmail() { return email; }

	/** @param email l'email dell'utente da impostare */
	public void setEmail(String email) { this.email = email; }

	/** @return la password dell'utente */
	public String getPassword() { return password; }

	/** @param password la password dell'utente da impostare */
	public void setPassword(String password) { this.password = password; }

	/** @return le lingue parlate dall'utente */
	public List<Language> getLanguages() { return languages; }

	/** @param languages le lingue parlate dall'utente */
	public void setLanguages(List<Language> languages) { this.languages = languages; }

	/** @return i task compilati dall'utente */
	public List<Task> getTasks() { return tasks; }

	/** @param tasks i task compilati dall'utente */
	public void setTasks(List<Task> tasks) { this.tasks = tasks; }
}
