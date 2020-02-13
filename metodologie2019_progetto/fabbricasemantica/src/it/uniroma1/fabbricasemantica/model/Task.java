package it.uniroma1.fabbricasemantica.model;

import java.util.List;

/**
 * La rappresentazione di un task
 * @author francescopioscognamiglio
 */
public class Task {

	/** L'id del task */
	private Integer id;

	/** Il tipo del task */
	private String type;

	/** I dati del task */
	List<Data> data;

	/** Le risposte al task */
	List<Answer> answers;

	public Task(String type, Integer id) {
		this(type, null, null, id);
	}

	public Task(String type, List<Data> data, List<Answer> answers) {
		this(type, data, answers, null);
	}

	public Task(String type, List<Data> data, List<Answer> answers, Integer id) {
		this.type = type;
		this.answers = answers;
		this.data = data;
		this.id = id;
	}

	/** @return l'id del task da impostare */
	public Integer getId() { return id; }

	/** @param id l'id del task */
	public void setId(Integer id) { this.id = id; }

	/** @return il tipo del task */
	public String getType() { return type; }

	/** @param type il tipo del task da impostare */
	public void setType(String type) { this.type = type; }

	/** @return le risposte al task */
	public List<Answer> getAnswers() { return answers; }

	/** @param answers le risposte al task da impostare */
	public void setAnswers(List<Answer> answers) { this.answers = answers; }

	/** @return i dati del task */
	public List<Data> getData() { return data; }

	/** @param data i dati del task da impostare */
	public void setData(List<Data> data) { this.data = data; }
}
