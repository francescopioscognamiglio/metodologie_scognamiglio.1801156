package it.uniroma1.fabbricasemantica.data.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

import it.uniroma1.fabbricasemantica.data.DataProvider;

/**
 * Classe di utilita' che contiene dei metodi comuni
 * e che potrebbero essere adoperati da diversi {@link DataProvider}
 * @author francescopioscognamiglio
 */
public class DataProviderUtils {

	public static final String PATH_VOCABULARY = "vocabulary/vocabulary.txt";

	public static String getRandomWord() {
		try (Stream<String> stream = Files.lines(Paths.get(PATH_VOCABULARY))) {
			return stream.skip(
					new Random().nextInt(
							Files.readAllLines(Paths.get(PATH_VOCABULARY)).size()))
					.findAny()
					.get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
