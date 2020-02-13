package it.uniroma1.fabbricasemantica.dao;

import java.util.List;

import it.uniroma1.fabbricasemantica.model.Answer;

/**
 * DAO per la rappresentazione della tabella answer
 * @author francescopioscognamiglio
 *
 */
public interface AnswerDao {

	/** Crea una risposta e restituisce l'id assegnato */
	public int createAnswer(Answer answer, Integer taskId);

	/** Recupera tutte le risposte */
	public List<Answer> getAllAnswers();

	/** Recupera le risposte al task a partire dall'id del task */
	public List<Answer> getAnswers(Integer taskId);

	/** Aggiorna una risposta */
	public boolean updateAnswer(Answer answer);

	/** Aggiorna una risposta presente in un task a partire dall'id del task */
	public boolean updateAnswer(Answer answer, Integer taskId);

	/** Cancella una risposta */
	public boolean deleteAnswer(Answer answer);

	/** Cancella una risposta presente in un task a partire dall'id del task */
	public boolean deleteAnswer(Answer answer, Integer taskId);
}
