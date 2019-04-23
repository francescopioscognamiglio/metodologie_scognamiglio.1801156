import java.util.ArrayList;
import java.util.List;

/**
 * Esercizio: Disney vs. Marvel
 * 
 * • Modellare uno scontro su campo tra personaggi Disney e personaggi Marvel
 * 
 * Progettare una classe che contenga i componenti della squadra di supereroi
 * 
 * @author francescopioscognamiglio
 *
 */
public class SquadraSupereroi
{
	/**
	 * lista dei componenti della squadra di supereroi
	 */
	List<Supereroe> supereroi = new ArrayList<>();
	
	/**
	 * aggiunge uno specifico supereroe alla squadra
	 * @param s il supereroe supereroe
	 */
	public void add(Supereroe s)
	{
		supereroi.add(s);
	}
	
	/**
	 * restituisce il supereroe presente in una determinata posizione
	 * @param i la posizione
	 * @return il supereroe
	 */
	public Supereroe get(int i)
	{
		if (i < 0 || i >= supereroi.size()) return null;
		return supereroi.get(i);
	}
	
	/**
	 * restituisce il numero di componenti della squadra di supereroi
	 * @return il numero di componenti della squadra di supereroi
	 */
	public int size()
	{
		return supereroi.size();
	}
}
