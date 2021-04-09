package it.unibs.arnaldo.planetarium.gruppo7;


public class SistemaStellare {

	private Stella stella;
	
	// Costruttore 1
	public SistemaStellare(Stella s){
		this.stella = s;
	}

	// Metodo somma masse totali
	public double massaTotale() {
		double totale = stella.getMassa();
		totale += stella.massaTotPianeti();
		for (Pianeta elemento : stella.getListaPianeti())
			totale += elemento.massaTotLune();
		return totale;
	}

	// Metodo somma coordinate pesate totali
	public Coordinate sommaCoordinatePesate() {
		// Inizializzo la coordinata con la posizione pesata della stella
		Coordinate totale = new Coordinate(stella.posizionePesata());
		for (Pianeta elemento : stella.getListaPianeti()) {
			totale.setX(totale.getX() + elemento.posizionePesata().getX());
			totale.setY(totale.getY() + elemento.posizionePesata().getY());
			for (Luna _elemento : elemento.getListaLune()) {
				totale.setX(totale.getX() + _elemento.posizionePesata().getX());
				totale.setY(totale.getY() + _elemento.posizionePesata().getY());
			}

		}
		return totale;
	}

	// Metodo calcola centro di massa
	public Coordinate centroDiMassa() {
		Coordinate cdm = new Coordinate();
		cdm.setX(sommaCoordinatePesate().getX() / massaTotale());
		cdm.setY(sommaCoordinatePesate().getY() / massaTotale());
		return cdm;
	}
	
	//Data una Luna visualizza il percorso stella > pianeta > luna
	public void percorsoLuna(String nome_luna)
	{
		for(Pianeta elemento: stella.getListaPianeti()) {
			if(elemento.cercaLunaInPianeta(nome_luna) != -1) {
				System.out.println(String.format("Il percorso per raggiungere %s è [ %s --> %s --> %s ]", nome_luna, stella.getCodiceUnivoco(), elemento.getCodiceUnivoco(), nome_luna));
			}
		}
	}
	

	// Cerca una luna fra tutti i pianeti (stampa i dati del pianeta attorno a quale orbita)
	public void trovaLuna(String nome_luna) {
		for (Pianeta element : stella.getListaPianeti()) {
			if (element.cercaLunaInPianeta(nome_luna) != -1) {
				System.out.println(String.format("%s e' presente nel sistema e orbita attorno a %s", nome_luna,
						element.getCodiceUnivoco()));
			}
		}
	}

	public Stella getStella() {
		return stella;
	}
	
	//metodo che visualizza la stella, tutti i pianeti e le lune di ogni pianeta
	public void visualizzaPianetiELune() {
			
		    System.out.print(String.format("STELLA: %s", this.stella.getCodiceUnivoco()));
			this.stella.stampaPosizione();
		
		
		if(this.stella.getListaPianeti().size() != 0) {         //controlla che ci siano effettivamente pianeti
			System.out.println(String.format("Attualmente sono presenti %d pianeti e %d lune.\n", this.stella.getListaPianeti().size(), this.stella.numLuneTotali()));
				
			for(Pianeta elemento: this.stella.getListaPianeti()) {
				System.out.print(String.format("====> %s", elemento.getCodiceUnivoco()));
				elemento.stampaPosizione();
				
				if(elemento.getListaLune().size() != 0) {          //controlla che ci siano effettivamente delle lune
					System.out.println("Le sue lune sono: ");
					elemento.visualizzaLune();
				
				}else System.out.println("Non ha lune."); 
				
				System.out.println("\n");
			}
		}else System.out.println(String.format("Attualmente non sono presenti altri corpi oltre la stella %s", this.stella.getCodiceUnivoco()));
	}

}
