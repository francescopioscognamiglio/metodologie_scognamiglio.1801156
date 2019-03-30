
import java.util.Arrays;

/**
 * Esercizio: BarraDiEnergia
 * 
 * In un videogioco si vuole progettare la classe BarraDiEnergia che rappresenta la quantità
 * di energia di un giocatore (in un intervallo di valori tra 0 e 1).
 * 
 * Gli oggetti della classe vengono costruiti specificando la quantità iniziale di energia,
 * oppure, se non si specifica nulla in input, l'energia massima.
 * 
 * La classe implementa i seguenti metodi:
 * 	- getEnergia() che restituisce la quantità di energia rimasta
 * 	- azzera() che azzera la quantità d'energia sulla barra
 * 	- isPiena() che restituisce true se la barra é al massimo
 * 	- toString() che restituisce una stringa contenente da 0 a 10 asterischi secondo il valore della barra di energia
 * 	- incrementaEnergia() che, presa in input un'altra barra di energia, incrementa la quantità di energia della barra
 * 	  su cui viene chiamato il metodo della quantità presente nella barra d'energia in input
 * 	- toArray() che restituisce un array dello storico dei valori dell'energia a ogni modifica.
 * 	  Ad esempio, BarraDiEnergia b = new BarraDiEnergia(); b.azzera(); b.incrementaEnergia(new BarraDiEnergia(0.5));
 * 	    System.out.println(Arrays.toString(b.toArray())); stampa l'array [ 1.0, 0.0, 0.5 ]
 * 
 * @author francescopioscognamiglio
 *
 */
public class BarraDiEnergiaEsonero
{
	
	/**
	 * la lunghezza della barra
	 */
	public static final double MAX = 1.0;
	
	/**
	 * energia attuale della barra
	 */
	private double energia;
	
	/**
	 * storico dei valori della barra
	 */
	private double[] storico = new double[0];
	
	/**
	 * costruttore che permette di impostare l'energia iniziale della barra
	 * @param energiaIniziale l'energia iniziale della barra
	 */
	public BarraDiEnergiaEsonero(double energiaIniziale)
	{
		setEnergia(energiaIniziale);
	}
	
	/**
	 * costruttore vuoto che imposta l'energia della barra al massimo
	 */
	public BarraDiEnergiaEsonero()
	{
		this(MAX);
	}
	
	/**
	 * metodo getter che restituisce la quantità di energia rimasta
	 * @return la quantità di energia rimasta
	 */
	public double getEnergia()
	{
		return energia;
	}
	
	/**
	 * metodo setter che imposta l'energia della barra
	 */
	private void setEnergia(double nuovaEnergia)
	{
		if (nuovaEnergia > MAX) energia = MAX;
		else if (nuovaEnergia < 0.0) energia = 0.0;
		else energia = nuovaEnergia;
		
		double[] storicoCopia = new double[storico.length+1];
		int i;
		for (i = 0; i < storico.length; i++) storicoCopia[i] = storico[i];
		storicoCopia[i] = energia;
		storico = storicoCopia;
	}
	
	/**
	 * metodo che azzera la quantità d'energia sulla barra
	 */
	public void azzera()
	{
		setEnergia(0.0);
	}
	
	/**
	 * metodo che restituisce true se la barra é al massimo
	 * @return true se la barra é al massimo
	 */
	public boolean isPiena()
	{
		return energia == MAX;
	}
	
	/**
	 * metodo che restituisce una stringa contenente da 0 a 10 asterischi secondo il valore della barra di energia
	 * @return una stringa contenente da 0 a 10 asterischi secondo il valore della barra di energia
	 */
	public String toString()
	{
		int numeroAsterischi = (int)(energia/MAX*10.0);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numeroAsterischi; i++) sb.append("*");
		return sb.toString();
	}
	
	/**
	 * metodo che, presa in input un'altra barra di energia, incrementa la quantità di energia della barra
	 * su cui viene chiamato il metodo della quantità presente nella barra d'energia in input
	 */
	public void incrementaEnergia(BarraDiEnergiaEsonero barraInput)
	{
		setEnergia(energia + barraInput.energia);
	}
	
	/**
	 * metodo che restituisce un array dello storico dei valori dell'energia a ogni modifica
	 * Ad esempio, BarraDiEnergia b = new BarraDiEnergia(); b.azzera(); b.incrementaEnergia(new BarraDiEnergia(0.5));
	 * System.out.println(Arrays.toString(b.toArray())); stampa l'array [ 1.0, 0.0, 0.5 ]
	 * @return un array dello storico dei valori dell'energia a ogni modifica
	 */
	public double[] toArray()
	{
		double[] storicoCopia = new double[storico.length];
		for (int i = 0; i < storico.length; i++) storicoCopia[i] = storico[i];
		return storicoCopia;
	}
	
	public static void main(String[] args)
	{
		BarraDiEnergiaEsonero b1 = new BarraDiEnergiaEsonero();
		BarraDiEnergiaEsonero b2 = new BarraDiEnergiaEsonero(0.5);
		
		b2.incrementaEnergia(new BarraDiEnergiaEsonero(0.2));
		
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(Arrays.toString(b2.toArray()));
		
		BarraDiEnergiaEsonero b = new BarraDiEnergiaEsonero();
		b.azzera();
		b.incrementaEnergia(new BarraDiEnergiaEsonero(0.5));
		System.out.println(Arrays.toString(b.toArray()));
	}
	
}
