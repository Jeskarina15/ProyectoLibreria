package ups.edu.ec.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Likes")
public class Like {
	@Id
	@Column(name="lik_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lik_id;
	
	@Column(name="lik_isbn")
	private String lik_isbn;
	
	@Column(name="lik_estado")
	private int estado;
	
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private Usuarios lik_usuario;

	public int getLik_id() {
		return lik_id;
	}

	public void setLik_id(int lik_id) {
		this.lik_id = lik_id;
	}

	public String getLik_isbn() {
		return lik_isbn;
	}

	public void setLik_isbn(String lik_isbn) {
		this.lik_isbn = lik_isbn;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Usuarios getLik_usuario() {
		return lik_usuario;
	}

	public void setLik_usuario(Usuarios lik_usuario) {
		this.lik_usuario = lik_usuario;
	}

	@Override
	public String toString() {
		return "Like [lik_id=" + lik_id + ", lik_isbn=" + lik_isbn + ", estado=" + estado + ", lik_usuario="
				+ lik_usuario + "]";
	}
}
