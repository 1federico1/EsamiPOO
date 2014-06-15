package guru.mfilippi.febbraio2007;

public class Libro {
	private Editore editore;
	private int annoPubblicazione;
	private String titolo;
	private String codice;

	public Libro(Editore editore, int annoPubblicazione, String titolo,
			String codice) {
		this.editore = editore;
		this.annoPubblicazione = annoPubblicazione;
		this.titolo = titolo;
		this.codice = codice;
	}

	public Libro(int annoPubblicazione, String titolo, String codice) {
		this(null, annoPubblicazione, titolo, codice);
	}

	public Editore getEditore() {
		return this.editore;
	}

	public int getAnnoPubblicazione() {
		return this.annoPubblicazione;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public String getCodice() {
		return this.codice;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annoPubblicazione;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		result = prime * result + ((editore == null) ? 0 : editore.hashCode());
		result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
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
		Libro other = (Libro) obj;
		if (annoPubblicazione != other.annoPubblicazione)
			return false;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		if (editore == null) {
			if (other.editore != null)
				return false;
		} else if (!editore.equals(other.editore))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}
	
	
}
