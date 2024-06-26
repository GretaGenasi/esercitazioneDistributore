package distributore;
import java.util.*;
public class esercitazioneDistributore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Distributore di bevande, gruppo: Adriano,Gabriele,Greta,Federica

				Scanner sc = new Scanner(System.in);
				// variabili e array
				final int DISTRIBUTORE = 2;

				String[] codice = new String[DISTRIBUTORE];
				float[] prezzo = new float[DISTRIBUTORE];
				int[] quantità = new int[DISTRIBUTORE];

				int i, j = 0, inputGest;
				float soldi, resto, indiceProdotto = 0, quantitàProdotto = 0, saldo=100, restoMax=5;
				boolean trovato;
				String daCercare, risposta, codiceinserito = "#0000", codiceg = "#0852", rispostaGest = "null";

				System.out.println("BENVENUTO, SELEZIONARE IL PRODOTTO");

				//INSERIMENTO CODICE GESTORE PER ACCEDERE ALLA PARTE GESTIONALE

				do {
					System.out.print("Digitare il codice gestore: "); // eliminare
					codiceinserito = sc.nextLine();
					if (codiceinserito.equals("#0852")) {
						System.out.println("Benvenuto gestore");
					} else {
						System.out.println("Codice errato passerai al lato utente");
						break;
						
						//APERTURA MENÙ A TENDINA CON LE 7 SCELTE 
					}
					System.out.println("Cosa vuoi fare oggi? ");
					int[] numeroMenu = { 1, 2, 3, 4, 5, 6, 7 };
					String[] nomiMenu = { "modificaSlot", "incasso", "restoMax", "resetSlot", "qtaVenduta", "disabilita",
							"reset" };

					for (j = 0; j < numeroMenu.length; j++)
						System.out.println(+numeroMenu[j] + " " + nomiMenu[j]);

					//INSERIMENTO OPZIONE CHE SI VUOLE SCEGLIERE
					
					do {
						System.out.println("Inserisci numero del menù: ");
						inputGest = sc.nextInt();
						sc.nextLine();

						//SCELTA 1)MODIFICA SLOT DEL PRODOTTO
						
						if (inputGest == 1) {

							for (i = 0; i < codice.length; i++) {
								System.out.println("Inserisci il codice da dare al prodotto " + i + ": ");
								codice[i] = sc.nextLine();

								System.out.println("Inserisci il prezzo di " + codice[i] + ": ");
								prezzo[i] = sc.nextFloat();

								System.out.println("Inserisci la quantità di " + codice[i] + ": ");
								quantità[i] = sc.nextInt();
								sc.nextLine();
								quantitàProdotto = quantità[i];
							}
						}
						
						// SCELTA 2)PRELEVARE IL SALDO ATTUALE
						
						else if (inputGest == 2) {
							System.out.println("Il saldo totale è: " +saldo +" vuoi prelevarlo?");
							rispostaGest =sc.next();
							if(rispostaGest.equalsIgnoreCase("si")) {
						 System.out.println("Hai prelevato " +saldo);
							} else {
						}
							
						}
						
						// SCELTA 3)MODIFICA IL RESTO MAX
						
						
						else if (inputGest == 3) {
							System.out.println("Il resto massimo attuale è: " +restoMax +" vuoi modificarlo?");
							rispostaGest =sc.next();
							if(rispostaGest.equalsIgnoreCase("si")) {
						    System.out.println("Inserisci nuovo resto massimo: " );
							restoMax=sc.nextFloat();
							sc.nextLine();
							System.out.println("Il nuovo resto massimo è " +restoMax);
							} else {
							}
						}
					
						
						
						
						
						System.out.println("Vuoi tornare al menù? ");
						rispostaGest = sc.next();
					} while (rispostaGest.equals("si"));
					
				} while (!codiceinserito.equals("#0852"));

				// parte il ciclo do - while per la selezione dei prodotti
				

					do {

						daCercare = sc.nextLine();
						trovato = false;
						for (i = 0; i < codice.length; i++) {
							if (codice[i].equalsIgnoreCase(daCercare)) {
								trovato = true;
								System.out.println(" Prezzo: " + prezzo[i]);
								indiceProdotto = prezzo[i];
						}

					} 

					do {

						System.out.println("Inserire i soldi: ");
						soldi = sc.nextFloat();
						sc.nextLine();
						System.out.println("il denaro inserito è " + soldi);

						if (soldi == indiceProdotto) {
							System.out.println("Esce il prodotto");
							quantitàProdotto--;
							saldo=saldo+indiceProdotto;
						} else if (soldi > indiceProdotto) {
							System.out.println("Esce il prodotto con il resto");
							resto = soldi - indiceProdotto;
							quantitàProdotto--;
							System.out.println("Il resto è " + resto);
						} else if (soldi < indiceProdotto)
							System.out.println("I soldi non sono sufficienti, il prezzo è " + indiceProdotto);

					} while (soldi < indiceProdotto);

					System.out.println("La quantità di prodotto rimasta è " + quantitàProdotto);

					System.out.println("Vuoi cercare un altro codice (s/n)?: ");
					risposta = sc.nextLine();

				} while (risposta.equalsIgnoreCase("s"));
	} //chiusura main

}