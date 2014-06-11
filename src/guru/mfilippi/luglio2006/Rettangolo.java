package guru.mfilippi.luglio2006;

public class Rettangolo extends Forma{
	private Punto vertice;
	private int larghezza;
	private int altezza;

	public Rettangolo(Colore colore, Punto vertice, int altezza, int larghezza) {
		super(colore);
		this.vertice = vertice;
		this.altezza = altezza;
		this.larghezza = larghezza;
	}

	public Punto getVertice() {
		return this.vertice;
	}

	public int getAltezza() {
		return this.altezza;
	}

	public int getLarghezza() {
		return this.larghezza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + altezza;
		result = prime * result + larghezza;
		result = prime * result + ((vertice == null) ? 0 : vertice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rettangolo other = (Rettangolo) obj;
		if (altezza != other.altezza)
			return false;
		if (larghezza != other.larghezza)
			return false;
		if (vertice == null) {
			if (other.vertice != null)
				return false;
		} else if (!vertice.equals(other.vertice))
			return false;
		return true;
	}

	
}