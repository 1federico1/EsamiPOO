package guru.mfilippi.luglio2006;

public class Cerchio extends Forma{
	private Punto centro;
	private int diametro;

	public Cerchio(Colore colore, Punto centro, int diametro) {
		super(colore);
		this.centro = centro;
		this.diametro = diametro;
	}


	public Punto getCentro() {
		return this.centro;
	}

	public int getDiametro() {
		return this.diametro;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
		result = prime * result + diametro;
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
		Cerchio other = (Cerchio) obj;
		if (centro == null) {
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		if (diametro != other.diametro)
			return false;
		return true;
	}

	
}
