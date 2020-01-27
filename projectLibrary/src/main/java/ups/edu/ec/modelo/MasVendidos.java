package ups.edu.ec.modelo;

public class MasVendidos {
	
	private int repetidos;
	private String libro;
	public int getRepetidos() {
		return repetidos;
	}
	public void setRepetidos(int repetidos) {
		this.repetidos = repetidos;
	}
	public String getLibro() {
		return libro;
	}
	public void setLibro(String libro) {
		this.libro = libro;
	}
	@Override
	public String toString() {
		return "MasVendidos [repetidos=" + repetidos + ", libro=" + libro + "]";
	}
	
	

}
