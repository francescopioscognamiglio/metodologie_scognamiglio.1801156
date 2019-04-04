
/**
 * Esercizio: Espressioni matematiche
 * 
 * Ogni tipo di espressione (costante, variabile, espressioni composte) deve essere modellata mediante una classe separata
 * 
 * Progettare la classe EspressioneComposta
 * 
 * @author francescopioscognamiglio
 *
 */
public class EspressioneComposta extends Espressione
{
	
	public enum Operatore
	{
		ADDIZIONE,
		SOTTRAZIONE,
		MOLTIPLICAZIONE,
		DIVISIONE,
		MODULO
	}
	
	public EspressioneComposta(Espressione e1, Operatore op, Espressione e2)
	{
		super(calcolaValore(e1, op, e2));
	}
	
	public static double calcolaValore(Espressione e1, Operatore op, Espressione e2)
	{
		switch(op)
		{
		case ADDIZIONE: return e1.getValore() + e2.getValore();
		case SOTTRAZIONE: return e1.getValore() - e2.getValore();
		case MOLTIPLICAZIONE: return e1.getValore() * e2.getValore();
		case DIVISIONE: return e1.getValore() / e2.getValore();
		case MODULO: return e1.getValore() % e2.getValore();
		}
		return 0.0;
	}
	
}
