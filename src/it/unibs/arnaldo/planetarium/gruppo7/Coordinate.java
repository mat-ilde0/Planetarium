package it.unibs.arnaldo.planetarium.gruppo7;

public class Coordinate {

	private double x;
	private double y;

	// costruttore 1
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// Costruttore 2 (inizializzato con una posizione)
	public Coordinate(Coordinate p) {
		this.x = p.getX();
		this.y = p.getY();
	}

	// Costruttore 3(inizializzato a (0 ; 0))
	public Coordinate() {
		this.x = 0;
		this.y = 0;
	}

    // Metodo che ritorna la coordinata pesata
	public Coordinate posizionePesata(double massa) {
		Coordinate nuovoPunto = new Coordinate();
		nuovoPunto.setX(this.x * massa);
		nuovoPunto.setY(this.y * massa);
		return nuovoPunto;

	}

	// metodo somma coordinate
	public Coordinate sommaCoordinate(Coordinate p) {
		Coordinate somma = new Coordinate();
		somma.setX(this.x + p.getX());
		somma.setY(this.y + p.getY());
		return somma;
	}
	

	// Getters e setters
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	//stampa coordinate
	public void visualizzaCoordinate()
	{
		System.out.println(String.format("(%.2f ; %.2f)", this.x, this.y));
	}

}
