package it.uniroma1.metodologie2019.hw3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Una classe iterabile sui Synset contenente un insieme di Singleton che rappresentano le versioni disponibili di WordNet.
 * Ogni versione lavora su quattro categorie sintattiche (ovvero nome, verbo, aggettivo e avverbio) e le rappresenta attraverso due file:
 * <ul>
 * <li>data.POS, contiene informazioni dettagliate relative ai Synset che ricoprono una specifica parte del discorso;</li>
 * <li>index.POS, contiene un elenco in ordine alfabetico di tutte le parole presenti in WordNet scritte in minuscolo e che ricoprono una specifica parte del discorso.
 * Ogni parola contiene dei puntatori ai Synset che la presentano tra i propri sinonimi.</li>
 * </ul>
 * POS corrisponde ad una delle quattro categorie sintattiche.
 * 
 * @author Francesco Pio Scognamiglio
 *
 */
public class WordNet implements Iterable<Synset>
{
	/**
	 * Percorso alla cartella che contiene le versioni di WordNet
	 */
	public static String RELEASES_FOLDER = "wordnet-releases/releases/WordNet-";
	/**
	 * Cartella che contiene i file
	 */
	public static String DICT_FOLDER = "dict";
	/**
	 * Nome del file data
	 */
	public static String DATA_FILENAME = "data";
	/**
	 * Nome del file index
	 */
	public static String INDEX_FILENAME = "index";
	
	/**
	 * Mappa contenente le versioni di WordNet caricate in memoria
	 */
	private static Map<String, WordNet> versions = new HashMap<String, WordNet>();
	
	/**
	 * Mappa contenente tutti i Synset presenti in WordNet letti dai file data.POS
	 */
	private Map<String, Synset> synsetsData = new HashMap<String, Synset>();
	/**
	 * Mappa contenente tutte le parole presenti in WordNet lette dai file index.POS
	 */
	private Map<String, Word> wordsIndex = new HashMap<String, Word>();
	
	/**
	 * La versione corrente
	 */
	private String version;
	
	/**
	 * Costruttore privato che, data in input una versione, ne crea il relativo Singleton.
	 * @param version la versione
	 */
	private WordNet(String version)
	{
		String versionFolder = RELEASES_FOLDER + version + File.separator + DICT_FOLDER + File.separator;
		for (POS pos : POS.values())
		{
			try(Stream<String> lines = Files.lines(Paths.get(versionFolder + DATA_FILENAME + "." + pos.getName())))
			{
				lines.filter(line -> !line.startsWith(" "))
					.forEach(line ->
					{
						Synset s = new Synset(line.split(" "), line.split("\\|")[1].trim());
						synsetsData.put(s.getID(), s);
					}
				);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			try(Stream<String> lines = Files.lines(Paths.get(versionFolder + INDEX_FILENAME + "." + pos.getName())))
			{
				lines.filter(line -> !line.startsWith(" "))
					.forEach(line -> {
						Word s = new Word(line.split(" "));
						wordsIndex.put(s.getID(), s);
					});
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		this.version = version;
		versions.put(version, this);
		
	}
	
	/**
	 * Data in input una versione, restituisce la corrispondente istanza di WordNet.
	 * Se la versione non é disponibile nella cartella wordnet-releases, il metodo restituisce null.
	 * @param version la versione
	 * @return l'istanza di WordNet di una determinata versione, o null se essa non é disponibile nella cartella wordnet-releases.
	 */
	public static WordNet getInstance(String version)
	{
		if (!new File(RELEASES_FOLDER + version).isDirectory()) return null;
		if (versions.containsKey(version)) return versions.get(version);
		
		return new WordNet(version);
	}
	
	/**
	 * Restituisce un Iterator che permette l'iterazione sui Synset.
	 * @return un Iterator che permette l'iterazione sui Synset.
	 */
	public Iterator<Synset> iterator()
	{
		return synsetsData.values().iterator();
	}
	
	/**
	 * Dato in input un lemma restituisce la lista di Synset che lo contengono.
	 * @param lemma la parola nella sua forma base, se composta da più parole si assume che esse siano separate da "_"
	 * @return la lista di Synset che contengono il lemma, vuota se nessun Synset contiene il lemma.
	 */
	public List<Synset> getSynsets(String lemma)
	{
		List<Synset> synsets = new ArrayList<Synset>();
		for (POS pos : POS.values()) synsets.addAll(getSynsets(lemma, pos));
		
		return synsets;
	}
	
	/**
	 * Dati in input un lemma e una parte del discorso restituisce la lista di Synset che lo contengono filtrata sulla parte del discorso.
	 * @param lemma la parola nella sua forma base, se composta da più parole si assume che esse siano separate da "_"
	 * @param pos la parte del discorso
	 * @return la lista di Synset che contengono il lemma filtrata sulla parte del discorso, vuota se nessun Synset della parte del discorso specificata contiene il lemma.
	 */
	public List<Synset> getSynsets(String lemma, POS pos)
	{
		List<Synset> synsets = new ArrayList<Synset>();
		Word synset = wordsIndex.get(lemma.toLowerCase() + "[" + pos.getValue() + "]");
		if (synset != null)
		{
			for (String offset : (synset).getOffsets())
			{
				Synset result = synsetsData.get(offset + pos.getValue());
				if (result != null) synsets.add(result);
			}
		}
		return synsets;
	}
	
	/**
	 * Dato in input l'id restituisce il Synset corrispondente, null se non presente.
	 * @param id l'identificativo univoco del Synset formato dall'unione dell'offset e della parte del discorso (es. 00001740n)
	 * @return il Synset corrispondente, null se non presente.
	 */
	public Synset getSynsetFromID(String id)
	{
		return synsetsData.get(id);
	}
	
	/**
	 * Dato in input l'id restituisce la parola corrispondente, null se non presente.
	 * @param id l'identificativo univoco della parola formato dall'unione del lemma e della parte del discorso (es. parola[n])
	 * @return la parola corrispondente, null se non presente.
	 */
	public Word getWordFromID(String id)
	{
		return wordsIndex.get(id);
	}
	
	/**
	 * Restituisce uno stream di Synset.
	 * @return uno stream di Synset.
	 */
	public Stream<Synset> stream()
	{
		return synsetsData.values().stream();
	}
	
	/**
	 * Restituisce la versione di WordNet.
	 * @return la versione di WordNet.
	 */
	public String getVersion()
	{
		return version;
	}
	
	/**
	 * Dati in input un Synset e una relazione restituisce una collezione di Synset correlati.
	 * @param synset il Synset
	 * @param relation la relazione sotto forma di WordNetRelation
	 * @return una collezione di Synset correlati, vuota se la relazione non esiste o non ci sono Synset correlati.
	 */
	public Collection<Synset> getRelatedSynsets(Synset synset, WordNetRelation relation)
	{
		return getRelatedSynsets(synset, relation.getValue());
	}
	
	/**
	 * Dati in input un Synset e una relazione restituisce una collezione di Synset correlati.
	 * @param synset il Synset
	 * @param relation la relazione sotto forma di String
	 * @return una collezione di Synset correlati, vuota se la relazione non esiste o non ci sono Synset correlati.
	 */
	public Collection<Synset> getRelatedSynsets(Synset synset, String relation)
	{
		List<Synset> relatedSynsets = new ArrayList<Synset>();
		for (String relatedSynsetID : synset.getPointers().getOrDefault(relation, new ArrayList<String>()))
			relatedSynsets.add(getSynsetFromID(relatedSynsetID));
		
		return relatedSynsets;
	}
}
