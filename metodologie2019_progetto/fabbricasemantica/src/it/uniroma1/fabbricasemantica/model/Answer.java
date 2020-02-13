package it.uniroma1.fabbricasemantica.model;

/**
 * La rappresentazione di una risposta
 * @author francescopioscognamiglio
 */
public class Answer {

	/** L'id della risposta */
	private Integer id;

	/** Il valore della risposta */
	private String value;

	public Answer(String value) {
		this(value, null);
	}

	public Answer(String value, Integer id) {
		this.value = value;
		this.id = id;
	}

	/** @return l'id della risposta */
	public Integer getId() { return id; }

	/** @param id l'id della risposta da impostare */
	public void setId(Integer id) { this.id = id; }

	/** @return il valore della risposta */
	public String getValue() { return value; }

	/** @param name il valore della risposta da impostare */
	public void setValue(String value) { this.value = value; }
}
