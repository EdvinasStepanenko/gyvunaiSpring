package gyvunai;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@Entity
public class Gyvunai implements Serializable {
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer Id;

	    private String pav;
	    
	    private Integer narvo_nr;
	    
	    private String atgabentas;
	    
	    private String atgabentas_is;
	    
	    private Integer maitinimo_id;

	    public Integer getMaitinimo_id() {
			return maitinimo_id;
		}

		public void setMaitinimo_id(Integer maitinimo_id) {
			this.maitinimo_id = maitinimo_id;
		}

		@ManyToOne
	    @JoinColumn(name="pav", referencedColumnName="pav", insertable=false, updatable=false)
	    @JsonIgnoreProperties(value = {"gyvunai"}, allowSetters=true)
	    private Kilmes_salis kilmes_salis;    


		public Kilmes_salis getKilmes_salis() {
			return kilmes_salis;
		}

		public void setKilmes_salis(Kilmes_salis kilmes_salis) {
			this.kilmes_salis = kilmes_salis;
		}
		
	    @ManyToOne
	    @JoinColumn(name="maitinimo_id", referencedColumnName="id", insertable=false, updatable=false)
	    private Maitinimas maitinimas;    

		
		public Maitinimas getMaitinimas() {
			return maitinimas;
		}

		public void setMaitinimas(Maitinimas maitinimas) {
			this.maitinimas = maitinimas;
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

		public Integer getNarvo_nr() {
			return narvo_nr;
		}

		public void setNarvo_nr(Integer narvo_nr) {
			this.narvo_nr = narvo_nr;
		}

		public String getAtgabentas() {
			return atgabentas;
		}

		public void setAtgabentas(String atgabentas) {
			this.atgabentas = atgabentas;
		}

		public String getAtgabentas_is() {
			return atgabentas_is;
		}

		public void setAtgabentas_is(String atgabentas_is) {
			this.atgabentas_is = atgabentas_is;
		}

}