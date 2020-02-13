package it.uniroma1.fabbricasemantica.model;

/**
 * La rappresentazione di un dato
 * @author francescopioscognamiglio
 */
public class Data {

	/** L'id del dato */
	private Integer id;

	/** Il valore del dato */
	private String value;

	public Data(String value) {
		this(value, null);
	}

	public Data(String value, Integer id) {
		this.value = value;
		this.id = id;
	}

	/** @return l'id del dato */
	public Integer getId() { return id; }

	/** @param id l'id del dato da impostare */
	public void setId(Integer id) { this.id = id; }

	/** @return il valore del dato */
	public String getValue() { return value; }

	/** @param value il valore del dato da impostare */
	public void setValue(String value) { this.value = value; }
}
