package it.uniroma1.metodologie2019.hw3;

/**
 * Un'enumerazione che contiene le relazioni presenti in WordNet.
 * 
 * @author Francesco Pio Scognamiglio
 *
 */
public enum Relation implements WordNetRelation
{
	ANTONYM("!"),
	HYPERNYM("@"),
	INSTANCE_HYPERNYM("@i"),
	HYPONYM("~"),
	INSTANCE_HYPONYM("~i"),
	MEMBER_HOLONYM("#m"),
	SUBSTANCE_HOLONYM("#s"),
	PART_HOLONYM("#p"),
	MEMBER_MERONYM("%m"),
	SUBSTANCE_MERONYM("%s"),
	PART_MERONYM("%p"),
	ATTRIBUTE("="),
	DERIVATIONALLY_RELATED_FORM("+"),
	DOMAIN_OF_SYNSET_TOPIC(";c"),
	MEMBER_OF_THIS_DOMAIN_TOPIC("-c"),
	DOMAIN_OF_SYNSET_REGION(";r"),
	MEMBER_OF_THIS_DOMAIN_REGION("-r"),
	DOMAIN_OF_SYNSET_USAGE(";u"),
	MEMBER_OF_THIS_DOMAIN_USAGE("-u"),
	ENTAILMENT("*"),
	CAUSE(">"),
	ALSO_SEE("^"),
	VERB_GROUP("$"),
	SIMILAR_TO("&"),
	PARTICIPLE_OF_VERB("<"),
	PERTAINYM("\\");
	
	/**
	 * Il valore della relazione
	 */
	private String value;
	
	/**
	 * Costruttore che prende in input il valore della relazione.
	 * @param value il valore della relazione
	 */
	Relation(String value) { this.value = value; }
	
	/**
	 * Restituisce il valore della relazione.
	 * @return il valore della relazione.
	 */
	@Override
	public String getValue() { return value; }
	
	/**
	 * Dato un valore restituisce la relazione che lo contiene.
	 * @param value il valore della relazione
	 * @return la relazione che contiene il valore.
	 */
	public static Relation fromValue(String value)
	{
		for (Relation relation : Relation.values())
			if (relation.value.equalsIgnoreCase(value)) return relation;
		return null;
	}
}
