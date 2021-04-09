package gyvunai;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MaitinimasController {


	@Autowired
	private MaitinimasRepository maitinimas_repository;	


	@RequestMapping(path="/maitinimas", method={ RequestMethod.GET, RequestMethod.POST })
    public String maitinimas(@RequestParam(name="id", required=false, defaultValue="0") Integer id 
			, @RequestParam(name="dieta", required=false, defaultValue="") String dieta
			, @RequestParam(name="saugoti", required=false, defaultValue="nesaugoti") String saugoti			
			, Model model) {

		String res = "Neatlikta";

		Maitinimas maitinimas = new Maitinimas();

		if ( saugoti.equals( "saugoti" ) ) {

			if (id > 0) {

				Optional <Maitinimas> found = maitinimas_repository.findById( id );

				// variantas trynimuiui
				// uzsakymaiRepository.deleteById(id);

				if ( found.isPresent() ) {

					maitinimas = found.get();
					maitinimas.setId ( id );

				} else {

					res = "Klaida įrašas galėjoi būti pašalintas";
				}
			}	

			//maitinimas.setSalis( pav );
			//maitinimas.setSalies_kodas(salies_kodas);


			maitinimas_repository.save ( maitinimas );
		    res = "Saugota";

		}
    	model.addAttribute("maitinimas", maitinimas_repository.findAll() );
    	model.addAttribute("res", res );		

		return "maitinimas";	
	}		
}