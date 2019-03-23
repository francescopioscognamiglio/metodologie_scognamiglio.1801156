
/**
 * Esercizio: mescolare e distribuire un mazzo di carte da gioco
 * 
 * enumerazione che rappresenta il valore della carta
 * 
 * @author francescopioscognamiglio
 *
 */
public enum ValoreCarta
{
	ASSO(1),
	DUE(2),
	TRE(3),
	QUATTRO(4),
	CINQUE(5),
	SEI(6),
	SETTE(7),
	OTTO(8),
	NOVE(9),
	DIECI(10),
	JACK(11),
	DONNA(12),
	RE(13);
	
	private int valore;
	
	ValoreCarta(int valore)
	{
		this.valore = valore;
	}
	
	public int toInt()
	{
		return valore;
	}
}
