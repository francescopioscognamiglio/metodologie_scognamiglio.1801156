package it.uniroma1.fabbricasemantica.model;

/**
 * La rappresentazione di una lingua
 * @author francescopioscognamiglio
 */
public class Language {

	/** L'id della lingua */
	private Integer id;

	/** Il nome della lingua */
	private String name;

	public Language(String name) {
		this(name, null);
	}

	public Language(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	/** @return l'id della lingua */
	public Integer getId() { return id; }

	/** @param id l'id della lingua da impostare */
	public void setId(Integer id) { this.id = id; }

	/** @return il nome della lingua */
	public String getName() { return name; }

	/** @param name il nome della lingua da impostare */
	public void setName(String name) { this.name = name; }
}
