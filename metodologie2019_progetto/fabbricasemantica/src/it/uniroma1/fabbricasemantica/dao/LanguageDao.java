package it.uniroma1.fabbricasemantica.dao;

import java.util.List;

import it.uniroma1.fabbricasemantica.model.Language;

/**
 * DAO per la rappresentazione della tabella language
 * @author francescopioscognamiglio
 *
 */
public interface LanguageDao {

	/** Crea una lingua e restituisce l'id assegnato */
	public int createLanguage(Language language, String userEmail);

	/** Recupera tutte le lingue */
	public List<Language> getAllLanguages();

	/** Recupera le lingue parlate da un utente a partire dall'email dell'utente */
	public List<Language> getLanguage(String userEmail);

	/** Aggiorna una lingua */
	public boolean updateLanguage(Language language);

	/** Aggiorna una lingua parlata da un utente a partire dall'email dell'utente */
	public boolean updateLanguage(Language language, String userEmail);

	/** Cancella una lingua */
	public boolean deleteLanguage(Language language);

	/** Cancella una lingua parlata da un utente a partire dall'email dell'utente */
	public boolean deleteLanguage(Language language, String userEmail);
}
