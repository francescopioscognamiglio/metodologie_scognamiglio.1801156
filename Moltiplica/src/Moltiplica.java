
/**
 * Esercizi per cominciare
 * 
 * Scrivere una classe Moltiplica che, dati in input 2 numeri interi,
 * ne restituisca a video il prodotto
 * 
 * @author francescopioscognamiglio
 *
 */
public class Moltiplica
{
	
	public static int moltiplica(int num1, int num2)
	{
		return num1*num2;
	}
	
	public static void main(String[] args)
	{
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		System.out.println("Il prodotto tra i numeri " + num1 + " e " + num2 + " e': " + moltiplica(num1, num2));
	}
	
}
