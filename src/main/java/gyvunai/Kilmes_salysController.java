package gyvunai;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Kilmes_salysController {


	@Autowired
	private Kilmes_salisRepository kilmes_salisRepository;	


	@RequestMapping(path="/kilmes_salys", method={ RequestMethod.GET, RequestMethod.POST })
    public String miestai(@RequestParam(name="id", required=false, defaultValue="0") Integer id 
			, @RequestParam(name="pav", required=false, defaultValue="") String pav
			, @RequestParam(name="kilmes_salis", required=false, defaultValue="") String kilmes_salis
			, @RequestParam(name="saugoti", required=false, defaultValue="nesaugoti") String saugoti			
			, Model model) {

		String res = "Neatlikta";

		Kilmes_salis kilmes_salys = new Kilmes_salis();

		if ( saugoti.equals( "saugoti" ) ) {

			if (id > 0) {

				Optional <Kilmes_salis> found = kilmes_salisRepository.findById( id );

				// variantas trynimuiui
				// uzsakymaiRepository.deleteById(id);

				if ( found.isPresent() ) {

					kilmes_salys = found.get();
					kilmes_salys.setId ( id );

				} else {

					res = "Klaida įrašas galėjoi būti pašalintas";
				}
			}	

			kilmes_salys.setPav( pav );
			kilmes_salys.setKilmes_salis(kilmes_salis);


			kilmes_salisRepository.save ( kilmes_salys );
		    res = "Saugota";

		}
    	model.addAttribute("salys", kilmes_salisRepository.findAll() );
    	model.addAttribute("res", res );		

		return "kilmes_salys";	
	}		
}