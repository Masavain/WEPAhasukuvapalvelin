package wad.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Kayttaja;
import wad.repository.KayttajaRepository;
import wad.repository.KuvaRepository;

@Controller
@RequestMapping("/*")
public class DefaultController {

    @Autowired
    private KayttajaRepository kayttajaRepo;
    @Autowired
    private KuvaRepository kuvaRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        Kayttaja k = new Kayttaja();
        k.setNimimerkki("masa");
        k.setSalasana(passwordEncoder.encode("huhhuh"));
        k.setEmail("asdasd@asdasd.com");
        kayttajaRepo.save(k);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String redirect(Model model) {
        return "redirect:/etusivu";
    }

    @RequestMapping(value="/etusivu", method = RequestMethod.GET)
    public String etusivu(Model model){
        model.addAttribute("kuvat", kuvaRepo.findAll());
        return "index";
    }



}
