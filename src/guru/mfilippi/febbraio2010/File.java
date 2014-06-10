package guru.mfilippi.febbraio2010;


public class File extends Risorsa{
	private int dimensioni;

	public File(String nome, int dimensioni, Utente proprietario) {
		super(nome, proprietario);
		this.dimensioni = dimensioni;
	}
	
	@Override
	public int getDimensioni() {
		return this.dimensioni;
	}

	public void setDimensioni(int dimensioni) {
		this.dimensioni = dimensioni;
	}

	public int hashcode() {
		return this.getNome().hashCode();
	}

	public boolean equals(Object that) {
		File f = (File) that;
		return this.getNome().equals(f.getNome());
	}
}
