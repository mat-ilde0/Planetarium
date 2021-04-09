package it.unibs.arnaldo.planetarium.gruppo7;

import it.unibs.fp.mylib.InputDati;

public class Metodi{
	
	
	private static final double MASSA_MINIMA = 0.00000001;

	//METODI USATI NEL MAIN
	
	
	//metodo per saluto iniziale e introduzione
	public static void introduzionePlanetarium() {
		System.out.println("-----------------------------------------");
		System.out.println("|       Benvenuto in Planetarium!!      |");
		System.out.println("-----------------------------------------");
	}
	
	//metodo che stampa i comandi che possono essere scelti dall'utente
	public static void stampaComandi() {
		System.out.println("Scegli l'azione da compiere usando i comandi seguenti:\n");
		System.out.println("- 0 : esci dal programma\n- 1 : calcola CDM\n- 2 : trova un pianeta\n- 3 : trova una luna\n- 4 : aggiungi un pianeta\n- 5 : aggiungi una luna");
		System.out.println("- 6 : rimuovi un pianeta\n- 7 : rimuovi una luna\n- 8 : visualizza i corpi attualmente presenti\n- 9 : visualizza di nuovo i comandi");
	}
	
	
	//crea Stella con dati in input--> restituisce la stella creata
	public static Stella creaStella() {
		String nome_stella = InputDati.leggiStringa("Inserisci il nome della stella: ");
		double massa = InputDati.leggiDoubleConMinimo("Inserisci la massa della stella: ", MASSA_MINIMA);
		
		Stella stella_creata = new Stella(massa, nome_stella);
		return stella_creata;
	}

	
	//calcola il centro di massa
	public static void calcolaCdmMain(SistemaStellare sistema) {
		Coordinate centro_di_massa;
		centro_di_massa = sistema.centroDiMassa();
		System.out.println("Il centro di massa del sistema e': ");
		centro_di_massa.visualizzaCoordinate();
	}

	//rimuove una luna dal sistema  (comunica anche se il pianeta selezionato non esiste nel sistema)
	public static void rimuoviLunaInMain(SistemaStellare sistema) {
		String nome_pianeta_di_riferimento2;
		int indice_pianeta2, num_lune;
		
		nome_pianeta_di_riferimento2 = InputDati.leggiStringa("Da che pianeta vuoi rimuovere la luna? : ");
		indice_pianeta2 = sistema.getStella().trovaPianeta(nome_pianeta_di_riferimento2);
		
		if(indice_pianeta2 != -1) {
			num_lune = sistema.getStella().getPianetaDaLista(indice_pianeta2).rimuoviLuna();            
			System.out.println(String.format("\nAttualmente sono presenti %d lune attorno a %s", num_lune, nome_pianeta_di_riferimento2));
			
		}else System.out.println("Il pianeta non esiste nel sistema.");
	}
	
	//rimuove un pianeta dal sistema
	public static void rimuoviPianetaInMain(SistemaStellare sistema) {
		int num_pianeti;
		
		num_pianeti = sistema.getStella().rimuoviPianeta();     //rimuoviPianeta si occupa anche di stampare se il pianeta non è presente
		
		System.out.println(String.format("\nAttualmente sono presenti %d pianeti nel sistema", num_pianeti));
	}
	
	//aggiunge una Luna al sistema SE non è già presente
	public static void aggiungiLunaSeAssente(SistemaStellare sistema) {
		//richiesta e ricerca del pianeta al quale aggiungere la luna
		String nome_pianeta_di_riferimento;
		int indice_pianeta1, num_lune_aggiornato;
		
		nome_pianeta_di_riferimento = InputDati.leggiStringa("A che pianeta vuoi aggiungere la luna? : ");
		
		indice_pianeta1 = sistema.getStella().trovaPianeta(nome_pianeta_di_riferimento);
		
		if(indice_pianeta1 != -1) {
			//chiede i dati per creare la luna e aggiungere all'array del pianeta scelto
			String nome_luna = InputDati.leggiStringa("Inserisci il nome della nuova luna: ");
			
			if(sistema.getStella().getPianetaDaLista(indice_pianeta1).cercaLunaInPianeta(nome_luna) == -1) {  //controlla se la luna è già presente
				double massa_luna = InputDati.leggiDoubleConMinimo("Inserisci la massa della luna: ", MASSA_MINIMA);
				double x = InputDati.leggiDouble("Inserisci coordinata x: ");
				double y = InputDati.leggiDouble("Inserisci coordinata y: ");
				
				Luna nuova_luna = new Luna(massa_luna, nome_luna, x, y);
				num_lune_aggiornato = sistema.getStella().getPianetaDaLista(indice_pianeta1).aggiungiLuna(nuova_luna);
			
				System.out.println(String.format("%s è stata aggiunta al pianeta.\nAttualmente sono presenti %d lune attorno a %s.", nome_luna, num_lune_aggiornato, nome_pianeta_di_riferimento));
			
			}else System.out.println(String.format("\n%s è già presente nel sistema!", nome_luna));
			
			
		}else System.out.println("\nIl pianeta scelto non e' presente nel sistema.");
	}
	
	//aggiunge un pianeta SE non è già presente
	public static void aggiungiPianetaSeAssente(SistemaStellare sistema) {
		Pianeta nuovo_pianeta;
		Coordinate posizione_pianeta;
		String nome_pianeta; 
		double massa;
		int num_pianeti_aggiornato;
		
		
		nome_pianeta = InputDati.leggiStringaNonVuota("Inserisci il nome del nuovo pianeta: ");
		
		if(sistema.getStella().trovaPianeta(nome_pianeta) == -1) {
			
			massa = InputDati.leggiDoubleConMinimo("Indica la massa del pianeta: ", MASSA_MINIMA);
			posizione_pianeta = new Coordinate(InputDati.leggiDouble("Coordinata x: "), InputDati.leggiDouble("Coordinata y: ")); 
			
			nuovo_pianeta = new Pianeta(massa, nome_pianeta, posizione_pianeta);       
			
			num_pianeti_aggiornato = sistema.getStella().aggiungiPianeta(nuovo_pianeta);
			
			System.out.println(String.format("%s è stato aggiunto al sistema.\n\nAttualmente sono presenti %d pianeti.", nuovo_pianeta.getCodiceUnivoco(), num_pianeti_aggiornato));
			
		}else System.out.println(String.format("%s e' gia' presente nel sistema!", nome_pianeta));
	}
	
	//cerca una luna nel sistema
	public static void cercaLunaInMain(SistemaStellare sistema) {
		String luna_da_trovare;
		
		luna_da_trovare = InputDati.leggiStringa("Inserisci il nome della luna che desideri trovare: ");
		sistema.trovaLuna(luna_da_trovare);                                                                 //metodo di SistemaStellare che stampa direttamente la luna e il pianeta di riferimento
		sistema.percorsoLuna(luna_da_trovare);                                                              //stampa a video anche il percorso
	}

	//ricerca un pianeta
	public static void cercaPianetaInMain(SistemaStellare sistema) {
		String nome_pianeta_da_cercare;
		int indice_pianeta;
		
		nome_pianeta_da_cercare = InputDati.leggiStringa("Inserisci il nome del pianeta che desideri trovare: ");
		indice_pianeta = sistema.getStella().trovaPianeta(nome_pianeta_da_cercare);
		
		if(indice_pianeta != -1) {
			System.out.print(String.format("%s è presente nel sistema in posizione: ", nome_pianeta_da_cercare));                               
			sistema.getStella().getPianetaDaLista(indice_pianeta).stampaPosizione();                                          //visualizza la posizione del pianeta
			sistema.getStella().getPianetaDaLista(indice_pianeta).visualizzaLune();                                           //stampa tutte le sue lune
		
		}else System.out.println("Il pianeta non è presente nel sistema.");
	}

}
