package gyvunai;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
	public class Kilmes_salis implements Serializable {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer Id;

    private String pav;	

    private String kilmes_salis;
    
    @OneToMany(/*mappedBy = "Miestas",*/cascade = CascadeType.ALL)
    @JoinColumn(name="pav", referencedColumnName="pav", insertable=false, updatable=false)    
    private List<Gyvunai> gyvunai;     

	public List<Gyvunai> getGyvunai() {
		return gyvunai;
	}

	public void setGyvunai(List<Gyvunai> gyvunai) {
		this.gyvunai = gyvunai;
	}

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
