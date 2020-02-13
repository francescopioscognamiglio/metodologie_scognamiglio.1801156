package it.uniroma1.fabbricasemantica.data;

/**
 * Enum che contiene i Task standard
 * @author francescopioscognamiglio
 */
public enum StandardTask implements Task {
	TRANSLATION_ANNOTATION,
	WORD_ANNOTATION,
	DEFINITION_ANNOTATION,
	SENSE_ANNOTATION,
	TRANSLATION_VALIDATION,
	SENSE_VALIDATION
}
