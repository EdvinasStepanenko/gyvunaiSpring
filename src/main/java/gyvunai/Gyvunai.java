package gyvunai;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Gyvunai {
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer Id;

	    private String pav;
	    
	    private Integer narvo_nr;
	    
	    private String atgabentas;
	    
	    private String atgabentas_is;

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