package ups.edu.ec.jsfbean;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.primefaces.model.chart.PieChartModel;

import ups.edu.ec.accesosDatos.FacturaDAO;
import ups.edu.ec.modelo.FacturaDetalles;
import ups.edu.ec.modelo.Libro;
import ups.edu.ec.modelo.MasVendidos;
import ups.edu.ec.modelo.Usuarios;

@ManagedBean
@RequestScoped
public class FacturaBean implements Serializable{
	private PieChartModel pieModel;
	private PieChartModel pieModelmv;
	private PieChartModel pieModelu; 
	@Inject
	private FacturaDAO facturaDAO;
	private List<Libro> listal;
	private List<Libro> listap;
	private List<Usuarios> listau;
	@PostConstruct  
	public void init() {
	listal=facturaDAO.desclibrosMeG();
	listap=facturaDAO.repetidoscomprados();
	listau=facturaDAO.usuariosmascomprados();
	createPieModel(); 
	createPieModelmasvend();
	createPieusuarios();
	}  
		public void createPieModel() {  
			pieModel = new PieChartModel();  
			for (int i = 0; i <5; i++) {
			pieModel.set(listal.get(i).getTitulolibro(), listal.get(i).getMegusta());	
			}
			pieModel.setTitle("libros mas votados");  
			pieModel.setLegendPosition("c");  
		}
		public void createPieModelmasvend() {  
			pieModelmv = new PieChartModel();  
			for (int i = 0; i < listap.size(); i++) {
				pieModelmv.set(listap.get(i).getTitulolibro(),i);
			}
			pieModelmv.setTitle("libros mas comprados");  
			pieModelmv.setLegendPosition("c");  
		}
		public void createPieusuarios() {  
			pieModelu = new PieChartModel();  
			for (int i = 0; i < listau.size(); i++) {
				pieModelu.set(listau.get(i).getNombreu(),i);
			}
			pieModelu.setTitle("usuarios mas destacados");  
			pieModelu.setLegendPosition("c");  
		}
		public PieChartModel getPieModel() {
			return pieModel;
		}
		public void setPieModel(PieChartModel pieModel) {
			this.pieModel = pieModel;
		}
		public List<Libro> getListal() {
			return listal;
		}
		public void setListal(List<Libro> listal) {
			this.listal = listal;
		}
		public PieChartModel getPieModelmv() {
			return pieModelmv;
		}
		public void setPieModelmv(PieChartModel pieModelmv) {
			this.pieModelmv = pieModelmv;
		}
		public List<Libro> getListap() {
			return listap;
		}
		public void setListap(List<Libro> listap) {
			this.listap = listap;
		}
		public PieChartModel getPieModelu() {
			return pieModelu;
		}
		public void setPieModelu(PieChartModel pieModelu) {
			this.pieModelu = pieModelu;
		}
		public List<Usuarios> getListau() {
			return listau;
		}
		public void setListau(List<Usuarios> listau) {
			this.listau = listau;
		}
	
	}
