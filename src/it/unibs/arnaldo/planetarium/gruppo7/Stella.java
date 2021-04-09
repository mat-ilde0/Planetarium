package it.unibs.arnaldo.planetarium.gruppo7;

import java.util.*;

import it.unibs.fp.mylib.InputDati;

public class Stella extends CorpoCeleste {

	private ArrayList<Pianeta> listaPianeti;

	// Costruttore 1
	public Stella(double massa, String codiceUnivoco) {
		super(massa, codiceUnivoco);
		this.listaPianeti = new ArrayList<Pianeta>();
	}

	// Calcolo della massa totale dei pianeti di un sistema stellare
	public double massaTotPianeti() {
		double totale = 0;
		for (Pianeta elemento : listaPianeti)
			totale += elemento.getMassa();
		return totale;
	}


	// Cerca un pianeta dato il suo nome
		public int trovaPianeta(String nome_pianeta) {
			for (Pianeta elemento : listaPianeti) {
				if (elemento.getCodiceUnivoco().equals(nome_pianeta))
					return listaPianeti.indexOf(elemento);
			}
			return -1;
		}

	// Aggiunta di un nuovo pianeta: ritorna il numero di pianeti nell'array
	public int aggiungiPianeta(Pianeta nuovo_pianeta) {
		listaPianeti.add(nuovo_pianeta);
		return listaPianeti.size();
	}

	// getters e setters
	public ArrayList<Pianeta> getListaPianeti() {
		return listaPianeti;
	}
	
	//metodo get che ritorna il pianeta all'indice desiderato
	public Pianeta getPianetaDaLista(int indice) {
		return listaPianeti.get(indice);
	}

	public void setListaPianeti(ArrayList<Pianeta> listaPianeti) {
		this.listaPianeti = listaPianeti;
	}
	
	//metodo che rimuove un pianeta: restituisce il numero aggiornato di pianeti
	public int rimuoviPianeta() {
		int indice_pianeta;
		String nome;
		
		nome = InputDati.leggiStringa("Inserisci il nome del pianeta da eliminare: ");
		
		indice_pianeta = trovaPianeta(nome);
		
		if(indice_pianeta != -1) {
			listaPianeti.remove(indice_pianeta);
			System.out.println("\nIl pianeta è stato rimosso dal sistema.");
			return listaPianeti.size();
		
		}else {
			System.out.println("Il pianeta non è presente nel sistema.");
			return listaPianeti.size();
		}
	}
	
	//metodo che ritorna il numero di lune totali
	public int numLuneTotali() {
		int num_lune = 0;
		for(Pianeta elemento : listaPianeti) {
			num_lune += elemento.getListaLune().size();
		}
		return num_lune;
	}
	
	
}