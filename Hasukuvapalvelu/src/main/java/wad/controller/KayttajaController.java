
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.repository.FileObjectRepository;
import wad.repository.KayttajaRepository;

@RequestMapping("/kayttaja")
@Controller
public class KayttajaController {
    
    @Autowired
    private KayttajaRepository kayttajaRepo;
    @Autowired
    private FileObjectRepository foRepo;
    
    @RequestMapping(value="/{id}" ,method = RequestMethod.GET)
    public String getKayttaja(Model model, @PathVariable Long id) {
        model.addAttribute("kayttaja", kayttajaRepo.findOne(id));
        model.addAttribute("kuvat", foRepo.findByLisaaja(kayttajaRepo.findOne(id)));
        return "kayttaja";
    }
}
