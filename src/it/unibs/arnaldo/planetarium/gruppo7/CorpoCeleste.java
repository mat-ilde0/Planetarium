package it.unibs.arnaldo.planetarium.gruppo7;


public class CorpoCeleste {

	private double massa;
	private String codice_univoco;
	private Coordinate posizione;

	// Metodo stampa
	public void stampaPosizione() {
		posizione.visualizzaCoordinate();

	}
	
	//Costruttore 1 : oggetto Posizione come parametro
	public CorpoCeleste(double massa, String codice_univoco, double coordinata_x, double coordinata_y) {
		this.massa = massa;
		this.codice_univoco = codice_univoco;
		this.posizione = new Coordinate(coordinata_x, coordinata_y);
	}
	
	//Costruttore 2 :  Posizione come parametro
	public CorpoCeleste(double massa, String codice_univoco, Coordinate posizione) {
		this.massa = massa;
		this.codice_univoco = codice_univoco;
		this.posizione = new Coordinate(posizione);
	}
	
	//Costruttore 3: imposta automaticamente a 0,0 la posizione (per la creazione della stella)
	public CorpoCeleste(double massa, String codice_univoco){
		this.massa = massa;
		this.codice_univoco = codice_univoco;
		this.posizione = new Coordinate();
	}
	


	// Metodo che ritorna la coordinata pesata

	public Coordinate posizionePesata() {
		Coordinate nuovoPunto = new Coordinate();
		nuovoPunto.setX(posizione.getX() * this.massa);
		nuovoPunto.setY(posizione.getY() * this.massa);
		return nuovoPunto;
	}

	// Metodo somma coordinate
	public Coordinate sommaCoordinate(Coordinate p) {
		Coordinate somma = new Coordinate();
		somma.setX(posizione.getX() + p.getX());
		somma.setY(posizione.getY() + p.getY());
		return somma;
	}

	// Metodo somma coordinate pesate
	public Coordinate sommaCoordinatePesate(CorpoCeleste p) {
		Coordinate somma = new Coordinate(p.posizionePesata().sommaCoordinate(posizione.posizionePesata(this.massa)));
		return somma;
	}
	
	// Getters e setters
	public double getMassa() {
		return massa;
	}

	public void setMassa(double massa) {
		this.massa = massa;
	}

	public String getCodiceUnivoco() {
		return codice_univoco;
	}

	public void setCodiceUnivoco(String codiceUnivoco) {
		this.codice_univoco = codiceUnivoco;
	}

	public Coordinate getPosizione() {
		return posizione;
	}

	public void setPosizione(Coordinate posizione) {
		this.posizione = posizione;
	}

}
