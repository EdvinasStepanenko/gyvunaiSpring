package gyvunai;

public class Ataskaita {

	// id
	private String dieta;
	private int kiek_kokios_dietos;

	public Ataskaita() {

	}		

	public Ataskaita(String dieta, int kiek_kokios_dietos) {
		super();
		this.dieta = dieta;
		this.kiek_kokios_dietos = kiek_kokios_dietos;

	}

	public String getDieta() {
		return dieta;
	}

	public void setDieta(String dieta) {
		this.dieta = dieta;
	}

	public int getKiek_kokios_dietos() {
		return kiek_kokios_dietos;
	}

	public void setKiek_kokios_dietos(int kiek_kokios_dietos) {
		this.kiek_kokios_dietos = kiek_kokios_dietos;
	}

}