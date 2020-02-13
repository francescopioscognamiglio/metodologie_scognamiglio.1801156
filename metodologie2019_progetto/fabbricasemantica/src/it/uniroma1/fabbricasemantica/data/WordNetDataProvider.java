package it.uniroma1.fabbricasemantica.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import it.uniroma1.metodologie2019.hw3.POS;
import it.uniroma1.metodologie2019.hw3.Relation;
import it.uniroma1.metodologie2019.hw3.Synset;
import it.uniroma1.metodologie2019.hw3.WordNet;

/**
 * Questa classe restituisce i dati necessari per il task ricevuto in input
 * mediante l'uso delle API di WordNet sviluppate nel terzo homework.
 * Il metodo {@link #getData(Task)} restituira' una stringa in formato JSON
 * che le pagine in JSweet andranno a formattare.
 * @author francescopioscognamiglio
 */
public class WordNetDataProvider implements DataProvider<String> {

	@Override
	public String getData(Task task) {
		WordNet wordNet = WordNet.getInstance("3.1");
		if (task == StandardTask.TRANSLATION_ANNOTATION) {
			Synset synset = getRandomSynset(wordNet);

			return "{" +
					"\"word\": \"" + synset.getSynonyms().get(0) + "\"," +
					"\"description\": \"" + synset.getGloss() + "\"" +
					"}";
		}else if (task == StandardTask.WORD_ANNOTATION) {
			Synset synset = getRandomSynset(wordNet);

			return "{" +
					"\"description\": \"" + synset.getGloss() + "\"" +
					"}";
		}else if (task == StandardTask.DEFINITION_ANNOTATION) {
			Synset synset = getRandomSynset(wordNet);
			List<String> hypernyms = synset.getPointers().get(Relation.HYPERNYM.getValue());
			while (hypernyms == null || hypernyms.size() == 0)
				hypernyms = getRandomSynset(wordNet).getPointers().get(Relation.HYPERNYM.getValue());
			Synset retrievedSynset = wordNet.getSynsetFromID(hypernyms.get(0));

			return "{" +
					"\"word\": \"" + synset.getSynonyms().get(0) + "\"," +
					"\"hypernym\": \"" + retrievedSynset.getSynonyms().get(0) + "\"" +
					"}";
		}else if (task == StandardTask.SENSE_ANNOTATION) {
			Synset synset = getRandomSynset(wordNet);
			while (synset.getExamples() == null || synset.getExamples().size() == 0) synset = getRandomSynset(wordNet);
			List<String> descriptions = new ArrayList<>();
			for (int i = 0; i < 3; i++) descriptions.add(getRandomSynset(wordNet).getGloss());
			descriptions.add(new Random().nextInt(3), synset.getGloss());

			return "{" +
					"\"word\": \"" + synset.getSynonyms().get(0) + "\"," +
					"\"example\": \"" + synset.getExamples().get(0) + "\"," +
					"\"senses\": [\"" + String.join("\",\"", descriptions) + "\"]" +
					"}";
		}else if (task == StandardTask.TRANSLATION_VALIDATION) {
			// use default method, because WordNet not contain translations
			return "{" +
					"\"word\": \"rock\"," +
					"\"description\": \"A lump or mass of hard consolidated mineral matter\"," + 
					"\"translations\": [\"Un grumo o una massa di materia minerale consolidata dura\"," +
							"\"Materiale costituito dall'aggregato di minerali come quelli che formano la crosta terrestre\"," +
							"\"Un'associazione non ufficiale di persone o gruppi\"]" +
					"}";
		}else if (task == StandardTask.SENSE_VALIDATION) {
			Synset synset = getRandomSynset(wordNet);
			while (synset.getExamples() == null || synset.getExamples().size() == 0) {
				synset = getRandomSynset(wordNet);
			}
			String description = new Random().nextBoolean() ? synset.getGloss() : getRandomSynset(wordNet).getGloss();

			return "{" +
					"\"word\": \"" + synset.getSynonyms().get(0) + "\"," +
					"\"example\": \"" + synset.getExamples().get(0) + "\"," +
					"\"sense\": \"" + description + "\"" +
					"}";
		}
		else if (task == MyTask.MY_TEXT_ANNOTATION) {
			List<String> wordAnswers = new ArrayList<>();
			List<ArrayList<String>> wordOptions = new ArrayList<>();
			List<String> examples = new ArrayList<>();
			for (int i = 0; i < 8; i++) {
				Synset synset = getRandomSynset(wordNet);
				while (synset.getExamples() == null || synset.getExamples().size() == 0 || synset.getExamples().get(0).length() < 50) {
					synset = getRandomSynset(wordNet);
				}
				wordAnswers.add(synset.getSynonyms().get(0));
				ArrayList<String> words = new ArrayList<>();
				words.add(synset.getSynonyms().get(0));
				words.add(getRandomSynset(wordNet).getSynonyms().get(0));
				words.add(getRandomSynset(wordNet).getSynonyms().get(0));
				Collections.shuffle(words);
				wordOptions.add(words);
				examples.add(synset.getExamples().get(0));
			}
			String sWords = "[";
			for (ArrayList<String> wordOption : wordOptions) {
				sWords += "[\"" + String.join("\",\"", wordOption) + "\"],";
			}
			sWords = sWords.substring(0, sWords.length()-1) + "]";

			return "{" +
					"\"wordAnswers\": [\"" + String.join("\",\"", wordAnswers) + "\"]," +
					"\"words\": " + sWords + "," +
					"\"examples\": [\"" + String.join("\",\"", examples) + "\"]" +
					"}";
		}

		return null;
	}

	private Synset getRandomSynset(WordNet wordNet) {
		while(true) {
			String id = String.valueOf(new Random().nextInt(99999999));
			for (int i = 0; i < 8-id.length(); i++) id = "0" + id;
			String pos = POS.values()[new Random().nextInt(POS.values().length)].getValue();
			Synset synset = wordNet.getSynsetFromID(id + pos);

			if (synset == null) continue;

			return synset;
		}
	}
}
