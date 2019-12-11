package ups.edu.ec.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="autor")
public class Autor {

@Id
private int idAutor;
private String nombreAutor;

public int getIdAutor() {
	return idAutor;
}
public void setIdAutor(int idAutor) {
	this.idAutor = idAutor;
}
public String getNombreAutor() {
	return nombreAutor;
}
public void setNombreAutor(String nombreAutor) {
	this.nombreAutor = nombreAutor;
}
@Override
public String toString() {
	return "Autor [idAutor=" + idAutor + ", nombreAutor=" + nombreAutor + "]";
}

}
