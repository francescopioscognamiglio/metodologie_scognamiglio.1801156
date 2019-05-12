package it.uniroma1.metodologie2019.hw3;

/**
 * Un'enumerazione che contiene le quattro categorie sintattiche presenti in WordNet: nome, verbo, aggettivo e avverbio.
 * 
 * @author Francesco Pio Scognamiglio
 *
 */
public enum POS
{
	/**
	 * Nome
	 */
	NOUN("noun", "n"),
	/**
	 * Verbo
	 */
	VERB("verb", "v"),
	/**
	 * Aggettivo
	 */
	ADJECTIVE("adj", "a"),
	/**
	 * Avverbio
	 */
	ADVERB("adv", "r");
	
	/**
	 * Il nome della categoria sintattica
	 */
	private String name;
	/**
	 * Il valore della categoria sintattica
	 */
	private String value;
	
	/**
	 * Costruttore che prende in input il nome e il valore della categoria sintattica.
	 * @param name il nome della categoria sintattica
	 * @param value il valore della categoria sintattica
	 */
	POS(String name, String value)
	{
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Restituisce il nome della categoria sintattica.
	 * @return il nome della categoria sintattica.
	 */
	public String getName() { return name; }
	
	/**
	 * Restituisce il valore della categoria sintattica.
	 * @return il valore della categoria sintattica.
	 */
	public String getValue() { return value; }
	
	/**
	 * Dato un valore restituisce la categoria sintattica che lo contiene.
	 * @param value il valore della categoria sintattica
	 * @return la categoria sintattica che contiene il valore.
	 */
	public static POS fromValue(String value)
	{
		if (value.equalsIgnoreCase("s")) return POS.ADJECTIVE;
		
		for (POS pos : POS.values())
			if (pos.value.equalsIgnoreCase(value)) return pos;
		return null;
	}
}
