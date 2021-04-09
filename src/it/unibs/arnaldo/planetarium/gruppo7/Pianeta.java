package it.unibs.arnaldo.planetarium.gruppo7;

import java.util.*;

import it.unibs.fp.mylib.InputDati;

public class Pianeta extends CorpoCeleste {

	private ArrayList<Luna> listaLune;

	// Costruttore 1
	public Pianeta(double massa, String codice_univoco, Coordinate posizione) {
		super(massa, codice_univoco, posizione);
		this.listaLune = new ArrayList<Luna>();
	}

	// Calcola massa totale delle lune di un pianeta
	public double massaTotLune () {
		double totale = 0;
		for(Luna elemento: listaLune)
			totale += elemento.getMassa();
		return totale;
	}
	
	
	// Getters e setters
	public ArrayList<Luna> getListaLune() {
		return listaLune;
	}

	public void setListaLune(ArrayList<Luna> listaLune) {
		this.listaLune = listaLune;
	}

	
	//per aggiungere una luna (ritorna il numero di lune)
	public int aggiungiLuna(Luna nuova_luna)
	{
		listaLune.add(nuova_luna);
		return listaLune.size();
	}
	
	
	//verifica, tramite il nome, se la luna appartiene al pianeta
	public int cercaLunaInPianeta(String nome)
	{
		for(Luna elemento: listaLune) {
			if(elemento.getCodiceUnivoco().equals(nome)) return listaLune.indexOf(elemento);
		}
		return -1;
	}
	
	
	//visualizzazione lune
	public void visualizzaLune()
	{
		for(Luna element: this.listaLune) {
			System.out.print(String.format("--> %s", element.getCodiceUnivoco()));
			element.stampaPosizione();
		}
	}

	//rimuove una luna, dato il nome e restituisce la nuova lunghezza dell'array
	public int rimuoviLuna() {
		String nome = InputDati.leggiStringa("Inserisci il nome della luna da rimuovere: ");
		int indice_luna = cercaLunaInPianeta(nome);
		
		if(indice_luna != -1) {
			listaLune.remove(indice_luna);
			System.out.println("La luna è stata rimossa dal sistema.");
			return listaLune.size();
		
		}else {
			System.out.println("La luna non è presente nel sistema.");
			return listaLune.size();
		}
		
	}
	
}
