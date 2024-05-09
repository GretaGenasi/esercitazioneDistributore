package distributore;
import java.util.*;
public class esercitazioneDistributore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		
		final int DISTRIBUTORE = 2;
		
		String [] codice = new String [DISTRIBUTORE];
		float [] prezzo = new float [DISTRIBUTORE];
		int [] quantità = new int [DISTRIBUTORE];
		
		int i;
		float soldi, resto, indiceProdotto = 0, quantitàProdotto = 0;
		boolean trovato;
		String daCercare, risposta;
		
		for (i = 0; i < codice.length; i++) {
			System.out.print("Inserisci il codice " + i+ ": ");
			codice [i] = sc.nextLine();
			
			System.out.print("Inserisci il prezzo di " + codice[i] +": ");
			prezzo [i] = sc.nextFloat();
			sc.nextLine();
			
			System.out.print("Inserisci la quantità di " + codice [i] +": ");
			quantità [i] = sc.nextInt();
			sc.nextLine();	
		}
		
		do {
			System.out.println("Quale prodotto vuoi acquistare?");
			daCercare = sc.nextLine();
			trovato=false;
			
			for  (i=0;i<codice.length;i++) {
				
				if (codice[i].equalsIgnoreCase(daCercare)) {
					trovato=true;
					System.out.println(" Prezzo: " + prezzo[i]);
					indiceProdotto=prezzo[i];
					quantitàProdotto=quantità[i];
				}
			}
			
			System.out.println("Inserire i soldi: ");
			soldi=sc.nextFloat();
			sc.nextLine();
			System.out.println("il denaro inserito è " +soldi);
			
			if (soldi==indiceProdotto) {
				System.out.println("Esce il prodotto");
				quantitàProdotto--;
			} else if (soldi>indiceProdotto) {
			System.out.println("Esce il prodotto con il resto");
			resto=soldi-indiceProdotto;
			quantitàProdotto--;
			System.out.println("Il resto è " +resto);
			} else if (soldi<indiceProdotto)
			System.out.println("I soldi non sono sufficienti, il prezzo è " + indiceProdotto);
			
			if (!trovato)   //trovato==false
				System.out.println("codice non trovato!");
			System.out.println("Vuoi cercare un altro codice (s/n)?: ");
				risposta=sc.nextLine();
			
			
		} while (risposta.equalsIgnoreCase("s"));
		

		
		
	
	} //chiusura main

}
