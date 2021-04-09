package gyvunai;

import java.util.List;

import org.hibernate.Session;
// import org.hibernate.query.Query;
import javax.persistence.*;

public class UzduotisAtaskaita {

	  protected Session em;	

	  public UzduotisAtaskaita(  Session em  ) {

		    this.em = em;
	  }	

	  public List<Ataskaita> kiekKokiosDietos ( int ivedimas ) {

		  	String qw_kiek_kokios_dietos =
		  			
				"SELECT\r\n"
				+ "	`maitinimas`.*\r\n"
				+ "	, COUNT(`gyvunai`.`maitinimo_id`)  AS `kiek_kokios_dietos`\r\n"
				+ "	FROM `maitinimas`\r\n"
				+ "	LEFT JOIN `gyvunai` ON (`maitinimas`.`id`=`gyvunai`.`maitinimo_id`)\r\n"
				+ "	WHERE 1\r\n"
				+ "	GROUP BY `maitinimas`.`dieta`\r\n"
				+ "	HAVING `kiek_kokios_dietos` = "+ ivedimas +""
				+ ";";

		  		
		  	System.out.println ( qw_kiek_kokios_dietos );
		    Query query = em.createNativeQuery ( qw_kiek_kokios_dietos );
		    return (List<Ataskaita>) query.getResultList();
	  }	  	  

}