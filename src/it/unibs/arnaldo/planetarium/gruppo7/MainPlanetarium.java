package it.unibs.arnaldo.planetarium.gruppo7;

import it.unibs.fp.mylib.InputDati;


public class MainPlanetarium {

	private static final String COMANDO_NON_VALIDO = "\nIl comando inserito non è valido";
	private static final String COMANDO = "\nSeleziona comando: ";
	private static final String ARRIVEDERCI = "\n\nGrazie per aver usato Planetarium, arrivederci!";

	public static void main(String[] args) {

		SistemaStellare sistema; 
		
		// Introduzione al Programma
		Metodi.introduzionePlanetarium();
		
		// Inserimento della stella da parte dell'utente
		sistema = new SistemaStellare(Metodi.creaStella());                            //metodo che invoca il costruttore chiedendo i dati in input

		
		

		
												                // PANNELLO DI CONTROLLO 
															/*
															 * 0- esci
															 * 1- calcola centro di massa
															 * 2- trova Pianeta
															 * 3- trova luna
															 * 4- aggiungi pianeta
															 * 5- aggiungi luna
															 * 6- rimuovi pianeta
															 * 7- rimuovi luna
															 * 8- visualizza tutti i corpi (i nomi, le posizioni, le rispettive lune)
															 * 9- ristampa i comandi disponibili
															 * 
															 * */
		
		//VISUALIZZAZIONE COMANDI
		Metodi.stampaComandi();
		
		int comando;
		
		do {
			 comando = InputDati.leggiIntero(COMANDO);
			
			switch (comando) {
			
			case 0 : //esce dal programma
				System.out.println(ARRIVEDERCI);
				break;
			
			case 1:   //calcola cdm
				
				Metodi.calcolaCdmMain(sistema);
				
				break;
			
			case 2 : //ricerca un Pianeta (prendendo in considerazione solo il suo nome): visualizza la sua posizione e tutte le sue lune
				Metodi.cercaPianetaInMain(sistema);
				
				break;
			
			case 3:     //trova luna e stampa il percorso (stella, pianeta, luna)
				Metodi.cercaLunaInMain(sistema);
				
				break;
				
			case 4: //aggiungi pianeta SE non è già presente
				
				Metodi.aggiungiPianetaSeAssente(sistema);
				
				break;
				
			case 5:  //aggiungi una luna SE non esiste già    
				
				Metodi.aggiungiLunaSeAssente(sistema);
				
				break;
				
			case 6:   //rimuovi pianeta
				Metodi.rimuoviPianetaInMain(sistema);
				
				break;
			
			case 7: //rimuovi luna
				Metodi.rimuoviLunaInMain(sistema);
				
				break;
				
			case 8: //visualizza tutti i corpi (i loro nomi), oltre alla stella, presenti nel sistema
				
				sistema.visualizzaPianetiELune();
				
				break;
				
			case 9: //ristampa i comandi disponibili
				
				Metodi.stampaComandi();
				
				break;
				
			default: 
				System.out.println(COMANDO_NON_VALIDO);
				break;
			}
			
			
		}while(comando != 0);

	}


}
