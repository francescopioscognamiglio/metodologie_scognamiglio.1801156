package it.uniroma1.fabbricasemantica.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.uniroma1.fabbricasemantica.data.utils.DataProviderUtils;
import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelNetQuery;
import it.uniroma1.lcl.babelnet.BabelSynset;
import it.uniroma1.lcl.babelnet.data.BabelPointer;
import it.uniroma1.lcl.jlt.util.Language;

/**
 * Questa classe restituisce i dati necessari per il task ricevuto in input
 * mediante l'uso delle API di BabelNet.
 * Il metodo {@link #getData(Task)} restituira' una stringa in formato JSON
 * che le pagine in JSweet andranno a formattare.
 * @author francescopioscognamiglio
 */
public class BabelNetDataProvider implements DataProvider<String> {

	@Override
	public String getData(Task task) {
		BabelNet bn = BabelNet.getInstance();
		if (task == StandardTask.TRANSLATION_ANNOTATION) {
			BabelSynset synset = getSynset(bn);
			String word = synset.getLemmas(Language.EN).get(0).getLemma();
			String description = synset.getMainGloss().get().getGloss();

			return "{" +
					"\"word\": \"" + word + "\"," +
					"\"description\": \"" + description + "\"" +
					"}";
		}else if (task == StandardTask.WORD_ANNOTATION) {
			BabelSynset synset = getSynset(bn);
			String description = synset.getMainGloss().get().getGloss();

			return "{" +
					"\"description\": \"" + description + "\"" +
					"}";
		}else if (task == StandardTask.DEFINITION_ANNOTATION) {
			BabelSynset synset = getSynset(bn);
			String word = synset.getLemmas(Language.EN).get(0).getLemma();
			String hypernym = synset.getOutgoingEdges(BabelPointer.ANY_HYPERNYM).get(0).getBabelSynsetIDTarget().toSynset().getLemmas(Language.EN).get(0).getLemma();

			return "{" +
					"\"word\": \"" + word + "\"," +
					"\"hypernym\": \"" + hypernym + "\"" +
					"}";
		}else if (task == StandardTask.SENSE_ANNOTATION) {
			BabelSynset synset = getSynset(bn);
			while (synset.getMainExample().orElse(null) == null) synset = getSynset(bn);
			String word = synset.getLemmas(Language.EN).get(0).getLemma();
			String example = synset.getMainExample().get().getExample();
			List<String> senses = new ArrayList<>();
			senses.add(synset.getMainSense(Language.EN).get().getFullLemma());

			for (int i = 0; i < 3; i++) {
				synset = getSynset(bn);
				word = synset.getLemmas(Language.EN).get(0).getLemma();
				senses.add(synset.getMainSense(Language.EN).get().getFullLemma());
			}

			return "{" +
					"\"word\":\"" + word + "\"," +
					"\"example\":\"" + example + "\"," +
					"\"senses\": [\"" + String.join("\",\"", senses) + "\"]" +
					"}";
		}else if (task == StandardTask.TRANSLATION_VALIDATION) {
			BabelSynset synset = getSynset(bn, new Language[] { Language.IT });
			while (synset.getMainGloss(Language.IT).orElse(null) == null) synset = getSynset(bn, new Language[] { Language.IT });
			String word = synset.getLemmas(Language.EN).get(0).getLemma();
			String description = synset.getMainGloss(Language.EN).get().getGloss();
			List<String> translations = new ArrayList<>();
			translations.add(synset.getMainGloss(Language.IT).get().getGloss());

			synset = getSynset(bn, new Language[] { Language.IT });
			while (synset.getMainGloss(Language.IT).orElse(null) == null) synset = getSynset(bn, new Language[] { Language.IT });
			translations.add(synset.getMainGloss(Language.IT).get().getGloss());

			return "{" +
					"\"word\": \"" + word + "\"," +
					"\"description\": \"" + description + "\"," +
					"\"translations\": [\"" + String.join("\",\"", translations) + "\"]" +
					"}";
		}else if (task == StandardTask.SENSE_VALIDATION) {
			BabelSynset synset = getSynset(bn);
			while (synset.getMainExample().orElse(null) == null) synset = getSynset(bn);
			String word = synset.getLemmas(Language.EN).get(0).getLemma();
			String example = synset.getMainExample().get().getExample();
			String sense = "";
			if (new Random().nextBoolean()) {
				sense = synset.getMainSense(Language.EN).get().getFullLemma();
			}
			else {
				synset = getSynset(bn);
				while (synset.getMainExample().orElse(null) == null) synset = getSynset(bn);
				sense = synset.getMainSense(Language.EN).get().getFullLemma();
			}

			return "{" +
					"\"word\": \"" + word + "\"," +
					"\"example\": \"" + example + "\"" +
					"\"sense\": \"" + sense + "\"" +
					"}";
		}
		else if (task == MyTask.MY_TEXT_ANNOTATION) {
			List<String> wordAnswers = new ArrayList<>();
			List<ArrayList<String>> wordOptions = new ArrayList<>();
			List<String> examples = new ArrayList<>();
			for (int i = 0; i < 8; i++) {
				BabelSynset synset = getSynset(bn);
				while (synset.getMainExample().orElse(null) == null) synset = getSynset(bn);
				String word = synset.getLemmas(Language.EN).get(0).getLemma();
				wordAnswers.add(word);
				ArrayList<String> words = new ArrayList<>();
				words.add(synset.getLemmas(Language.EN).get(0).getLemma());
				for (int j = 0; j < 2; j++) {
					synset = getSynset(bn);
					words.add(synset.getLemmas(Language.EN).get(0).getLemma());
				}
				wordOptions.add(words);
				examples.add(synset.getMainExample().get().getExample());
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

	private BabelSynset getSynset(BabelNet bn) {
		return getSynset(bn, null);
	}

	private BabelSynset getSynset(BabelNet bn, Language[] toLanguages) {
		String word = DataProviderUtils.getRandomWord();
		BabelNetQuery.Builder queryBuilder = new BabelNetQuery.Builder(word)
				.from(Language.EN);
		if (toLanguages != null && toLanguages.length > 0) queryBuilder.to(toLanguages);
		BabelNetQuery query = queryBuilder.build();

		List<BabelSynset> synsets = bn.getSynsets(query);

		if (synsets == null || synsets.size() == 0) return getSynset(bn, toLanguages);

		return synsets.get(0);
	}
}
