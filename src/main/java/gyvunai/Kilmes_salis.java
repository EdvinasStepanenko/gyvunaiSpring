package gyvunai;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Entity
	public class Kilmes_salis implements Serializable {
	
  /*  @ManyToOne
    @JoinColumn(name="pav", referencedColumnName="pav", insertable=false, updatable=false)
    private Gyvunai gyvunai;    


	public Gyvunai getGyvunai() {
		return gyvunai;
	}

	public void setGyvunai(Gyvunai gyvunai) {
		this.gyvunai = gyvunai;
	}*/

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer Id;

    private String pav;	

    private String kilmes_salis;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}

	public String getKilmes_salis() {
		return kilmes_salis;
	}

	public void setKilmes_salis(String kilmes_salis) {
		this.kilmes_salis = kilmes_salis;
	}


	}
