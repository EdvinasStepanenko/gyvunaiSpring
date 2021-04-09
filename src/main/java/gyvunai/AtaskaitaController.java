package gyvunai;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Controller
public class AtaskaitaController {

	@Autowired 
	EntityManagerFactory factory;	

	// @Bean
	public SessionFactory sessionFactory() {


	        if (factory.unwrap(SessionFactory.class) == null) {
	            throw new NullPointerException("factory is not a hibernate factory");
	        }
	        return factory.unwrap(SessionFactory.class);
	}	


	@RequestMapping(path="/kas_ka_valgo", method={ RequestMethod.GET, RequestMethod.POST })
    public String miestai( @RequestParam(name="ivedimas", required=false, defaultValue="") Integer ivedimas 
			, @RequestParam(name="ieskoti", required=false, defaultValue="neieskoti") String ieskoti			
			, Model model) {

		String rez = "Neatlikta";

		Gyvunai gyvunai = new Gyvunai();

		if ( ivedimas == null ) {

			ivedimas = 3;


		    rez = "Saugoti";

		}

		Session session = this.sessionFactory().openSession();

		UzduotisAtaskaita valgytojai_ataskaita =  new UzduotisAtaskaita( session );
        model.addAttribute("valgytojai", valgytojai_ataskaita.kiekKokiosDietos( ivedimas ) ); 		
		return "ataskaita";
	}	
	
}
