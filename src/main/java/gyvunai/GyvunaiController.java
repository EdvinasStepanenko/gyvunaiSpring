package gyvunai;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GyvunaiController {
	
	@Autowired
	private GyvunasRepository gyvunai_repository;	

	
	@RequestMapping(path="/gyvunai", method={ RequestMethod.GET, RequestMethod.POST })
    public String gyvunai(@RequestParam(name="id", required=false, defaultValue="0") Integer id 
			, @RequestParam(name="pav", required=false, defaultValue="") String pav
			, @RequestParam(name="narvo_nr", required=false, defaultValue="") Integer narvo_nr
			, @RequestParam(name="atgabentas", required=false, defaultValue="") String atgabentas
			, @RequestParam(name="atgabentas_is", required=false, defaultValue="0") String atgabentas_is
			, @RequestParam(name="add", required=false, defaultValue="nesaugoti") String add			
			, Model model) {

		String res = "Neatlikta";

		Gyvunai gyvunai = new Gyvunai();
		
		if ( add.equals( "add" ) ) {
			if (id > 0) {

				Optional <Gyvunai> found = gyvunai_repository.findById( id );

				// variantas trynimuiui
				// uzsakymaiRepository.deleteById(id);

				if ( found.isPresent() ) {

					gyvunai = found.get();
					gyvunai.setId ( id );

				} else {

					res = "Klaida įrašas galėjoi būti pašalintas";
				}
			}	

			gyvunai.setPav( pav );
			gyvunai.setNarvo_nr( narvo_nr );
			gyvunai.setAtgabentas( atgabentas );
			gyvunai.setAtgabentas_is ( atgabentas_is );


		    gyvunai_repository.save ( gyvunai );
		    res = "Saugota";

		}
    	model.addAttribute("gyvunai", gyvunai_repository.findAll() );
    	model.addAttribute("res", res );		

		return "gyvunai";	
	}	

	@RequestMapping(path="/gyvunas")	
	public @ResponseBody Gyvunai gyvunuDuom(@RequestParam(name="id", required=true, defaultValue="0") Integer id ) throws IOException {

		String res = "Bandom ieškoti \n";

		Gyvunai gyvunai123 = new Gyvunai();

		if (id > 0) {

			Optional <Gyvunai> found = gyvunai_repository.findById( id );

			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);

			if ( found.isPresent() ) {

			   gyvunai123 = found.get();
			   gyvunai123.setId ( id );
			   res += "Įrašas surastas \n";

			} else {

				res += "Klaida įrašas galėjoi būti pašalintas \n";
			}
		}		
		System.out.println(res);
		return gyvunai123;
	}


	@GetMapping(path="/salinti-gyvuna") 
	public @ResponseBody String salintiGyvuna (@RequestParam Integer id 
			) {
		
		Gyvunai gyvunai321 = new Gyvunai();
		
		Optional <Gyvunai> found = gyvunai_repository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   gyvunai321 = found.get();
			   gyvunai_repository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}
	

}